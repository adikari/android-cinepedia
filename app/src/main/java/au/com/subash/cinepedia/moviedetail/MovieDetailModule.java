package au.com.subash.cinepedia.moviedetail;

import au.com.subash.cinepedia.casts.CastRepository;
import au.com.subash.cinepedia.casts.GetTopBilledCasts;
import au.com.subash.cinepedia.core.di.PerActivity;
import au.com.subash.cinepedia.core.executor.PostExecutionThread;
import au.com.subash.cinepedia.core.executor.ThreadExecutor;
import au.com.subash.cinepedia.interactor.UseCase;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
class MovieDetailModule {
  private int movieId = -1;

  MovieDetailModule(int movieId) {
    this.movieId = movieId;
  }

  @Provides @PerActivity @Named("getMovieDetail") UseCase
  provideGetMovieDetailUseCase(MovieDetailRepository repository,
      ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    return new GetMovieDetail(movieId, repository, threadExecutor, postExecutionThread);
  }

  @Provides @PerActivity @Named("getTopBilledCasts") UseCase
  provideGetTopBilledCastUseCase(CastRepository repository,
      ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    return new GetTopBilledCasts(movieId, repository, threadExecutor, postExecutionThread);
  }
}
