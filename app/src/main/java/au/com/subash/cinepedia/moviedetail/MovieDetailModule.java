package au.com.subash.cinepedia.moviedetail;

import au.com.subash.cinepedia.core.di.PerActivity;
import au.com.subash.cinepedia.core.executor.PostExecutionThread;
import au.com.subash.cinepedia.core.executor.ThreadExecutor;
import au.com.subash.cinepedia.interactor.UseCase;
import au.com.subash.cinepedia.movie.domain.MovieRepository;
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
  provideGetMovieDetailUserCase(MovieDetailRepository repository,
      ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    return new GetMovieDetail(movieId, repository, threadExecutor, postExecutionThread);
  }
}
