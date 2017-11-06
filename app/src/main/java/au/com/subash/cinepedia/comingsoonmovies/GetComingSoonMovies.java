package au.com.subash.cinepedia.comingsoonmovies;

import au.com.subash.cinepedia.core.executor.PostExecutionThread;
import au.com.subash.cinepedia.core.executor.ThreadExecutor;
import au.com.subash.cinepedia.interactor.UseCase;
import au.com.subash.cinepedia.movie.MovieRepository;
import io.reactivex.Observable;
import javax.inject.Inject;

public class GetComingSoonMovies extends UseCase {

  private MovieRepository movieRepository;

  @Inject
  protected GetComingSoonMovies(MovieRepository movieRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.movieRepository = movieRepository;
  }

  @Override protected Observable buildUseCaseObservable() {
    return movieRepository.comingSoonMovies();
  }
}
