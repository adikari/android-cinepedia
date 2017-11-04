package au.com.subash.cinepedia.core.di.modules;

import au.com.subash.cinepedia.AndroidApplication;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

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
