package au.com.subash.cinepedia.moviedetail;

import au.com.subash.cinepedia.core.executor.PostExecutionThread;
import au.com.subash.cinepedia.core.executor.ThreadExecutor;
import au.com.subash.cinepedia.interactor.UseCase;
import io.reactivex.Observable;

public class GetMovieDetail extends UseCase {

  private MovieDetailRepository movieDetailRepository;

  protected GetMovieDetail(MovieDetailRepository movieDetailRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.movieDetailRepository = movieDetailRepository;
  }

  @Override protected Observable buildUseCaseObservable() {
    return null;
  }
}
