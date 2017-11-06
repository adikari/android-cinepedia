package au.com.subash.cinepedia.moviedetail;

import au.com.subash.cinepedia.core.executor.PostExecutionThread;
import au.com.subash.cinepedia.core.executor.ThreadExecutor;
import au.com.subash.cinepedia.interactor.UseCase;
import io.reactivex.Observable;
import javax.inject.Inject;

public class GetMovieDetail extends UseCase {

  private final int movieId;
  private final MovieDetailRepository movieDetailRepository;

  protected GetMovieDetail(int movieId, MovieDetailRepository movieDetailRepository,
      ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.movieDetailRepository = movieDetailRepository;
    this.movieId = movieId;
  }

  @Override protected Observable buildUseCaseObservable() {
    return movieDetailRepository.movieDetail(movieId);
  }
}
