package au.com.subash.cinepedia.movie.nowplaying;

import au.com.subash.cinepedia.core.executor.PostExecutionThread;
import au.com.subash.cinepedia.core.executor.ThreadExecutor;
import au.com.subash.cinepedia.interactor.UseCase;
import au.com.subash.cinepedia.movie.MovieRepository;
import io.reactivex.Observable;
import javax.inject.Inject;

public class GetNowPlayingMovies extends UseCase {

  private MovieRepository movieRepository;

  @Inject
  protected GetNowPlayingMovies(MovieRepository movieRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.movieRepository = movieRepository;
  }

  @Override protected Observable buildUseCaseObservable() {
    return movieRepository.nowPlayingMovies();
  }
}
