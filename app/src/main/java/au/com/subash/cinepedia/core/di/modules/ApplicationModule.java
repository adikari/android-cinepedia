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
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

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

  @Provides @Singleton MovieRepository
  provideMovieRepository(MovieDataRepository movieDataRepository) {
    return movieDataRepository;
  }

  @Provides @Singleton MovieDataStore
  provideMovieDataStore(CloudMovieDataStore cloudMovieDataStore) {
    return cloudMovieDataStore;
  }
}
