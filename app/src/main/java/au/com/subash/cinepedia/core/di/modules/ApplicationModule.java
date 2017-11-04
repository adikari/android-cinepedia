package au.com.subash.cinepedia.core.di.modules;

import android.content.Context;
import au.com.subash.cinepedia.core.executor.ThreadExecutor;
import au.com.subash.cinepedia.core.executor.JobExecutor;
import au.com.subash.cinepedia.core.executor.PostExecutionThread;
import au.com.subash.cinepedia.AndroidApplication;
import au.com.subash.cinepedia.core.executor.UIThread;
import au.com.subash.cinepedia.movie.data.CloudMovieDataStore;
import au.com.subash.cinepedia.movie.data.MovieDataRepository;
import au.com.subash.cinepedia.movie.data.MovieDataStore;
import au.com.subash.cinepedia.movie.domain.MovieRepository;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
  private final AndroidApplication application;

  public ApplicationModule(AndroidApplication application) {
    this.application = application;
  }

  @Provides @Singleton
  Context provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton
  ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton
  PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }

  @Provides @Singleton MovieRepository provideMovieRepository(
      MovieDataRepository movieDataRepository) {
    return movieDataRepository;
  }

  @Provides @Singleton MovieDataStore provideMovieDataStore(
      CloudMovieDataStore cloudMovieDataStore) {
    return cloudMovieDataStore;
  }

  @Provides @Singleton Cache provideOkHttpCache(AndroidApplication application) {
    int cacheSize = 10 * 1024 * 1024; // 10 MiB

    return new Cache(application.getCacheDir(), cacheSize);
  }

  @Provides @Singleton Interceptor provideOkHttpInterceptor() {
    return chain -> {
      Request request = chain.request()
          .newBuilder()
          .addHeader("Content-Type", "application/json; charset=utf-8")
          .build();

      return chain.proceed(request);
    };
  }

  @Provides @Singleton OkHttpClient provideOkHttpClient(Cache cache, Interceptor interceptor) {
    return new OkHttpClient.Builder()
        .cache(cache)
        .readTimeout(10000, TimeUnit.MILLISECONDS)
        .connectTimeout(15000, TimeUnit.MILLISECONDS)
        .addInterceptor(interceptor)
        .build();
  }

  @Provides @Singleton Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
    return new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://api.themoviedb.org/3")
            .client(okHttpClient)
            .build();
  }
}
