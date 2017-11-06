package au.com.subash.cinepedia.casts;

import au.com.subash.cinepedia.core.di.PerActivity;
import au.com.subash.cinepedia.core.executor.PostExecutionThread;
import au.com.subash.cinepedia.core.executor.ThreadExecutor;
import au.com.subash.cinepedia.interactor.UseCase;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
class CastModule {

  private int movieId = -1;

  CastModule(int movieId) {
    this.movieId = movieId;
  }

  @Provides @PerActivity @Named("getCasts") UseCase
  provideGetCastUseCase(CastRepository repository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    return new GetCasts(movieId, repository, threadExecutor, postExecutionThread);
  }

}
