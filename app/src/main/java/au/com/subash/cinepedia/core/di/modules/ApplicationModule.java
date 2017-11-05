package au.com.subash.cinepedia.core.di.modules;

import android.content.Context;
import au.com.subash.cinepedia.core.executor.ThreadExecutor;
import au.com.subash.cinepedia.core.executor.JobExecutor;
import au.com.subash.cinepedia.core.executor.PostExecutionThread;
import au.com.subash.cinepedia.AndroidApplication;
import au.com.subash.cinepedia.core.executor.UIThread;
import au.com.subash.cinepedia.movie.data.MovieDataRepository;
import au.com.subash.cinepedia.movie.data.MovieDataStore;
import au.com.subash.cinepedia.movie.data.TmdDataRepository;
import au.com.subash.cinepedia.movie.domain.MovieRepository;
import au.com.subash.cinepedia.moviedetail.MovieDetailDataRepository;
import au.com.subash.cinepedia.moviedetail.MovieDetailDataStore;
import au.com.subash.cinepedia.moviedetail.MovieDetailRepository;
import au.com.subash.cinepedia.moviedetail.TmdMovieDetailStore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
  private final AndroidApplication application;

  private static final String API_BASE_URL = "https://api.themoviedb.org/3/";
  private static final String API_KEY = "78af8f82a9b6b6f6dbf3a39e60f38983";

  public ApplicationModule(AndroidApplication application) {
    this.application = application;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }

  @Provides @Singleton MovieRepository provideMovieRepository(MovieDataRepository movieDataRepository) {
    return movieDataRepository;
  }

  @Provides @Singleton MovieDetailRepository
  provideMovieDetailRepository(MovieDetailDataRepository movieDetailDataRepository) {
    return movieDetailDataRepository;
  }

  @Provides @Singleton MovieDataStore provideMovieDataStore(TmdDataRepository tmdDataRepository) {
    return tmdDataRepository;
  }

  @Provides @Singleton MovieDetailDataStore provideMovieDetailDataStore(TmdMovieDetailStore tmdMovieDetailStore) {
    return tmdMovieDetailStore;
  }

  @Provides @Singleton Gson provideGson() {
    return new GsonBuilder().create();
  }

  @Provides @Singleton Cache provideOkHttpCache() {
    int cacheSize = 10 * 1024 * 1024; // 10 MiB

    return new Cache(application.getCacheDir(), cacheSize);
  }

  @Provides @Singleton OkHttpClient provideOkHttpClient(Cache cache) {
    Interceptor requestInterceptor = chain -> {
      Request original = chain.request();
      HttpUrl originalHttpUrl = original.url();

      HttpUrl url = originalHttpUrl.newBuilder()
          .addQueryParameter("api_key", API_KEY)
          .build();

      Request request = chain.request().newBuilder()
          .url(url)
          .addHeader("Content-Type", "application/json; charset=utf-8")
          .build();

       return chain.proceed(request);
    };

    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);

    return new OkHttpClient.Builder()
       .readTimeout(10000, TimeUnit.MILLISECONDS)
       .connectTimeout(15000, TimeUnit.MILLISECONDS)
       .cache(cache)
       .addInterceptor(requestInterceptor)
       .addInterceptor(loggingInterceptor)
       .build();
  }

  @Provides @Singleton Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
    return new Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }
}
