package au.com.subash.cinepedia.casts;

import au.com.subash.cinepedia.core.executor.PostExecutionThread;
import au.com.subash.cinepedia.core.executor.ThreadExecutor;
import au.com.subash.cinepedia.interactor.UseCase;
import io.reactivex.Observable;

public class GetCasts extends UseCase {

  private final CastRepository repository;
  private final int movieId;

  GetCasts(int movieId, CastRepository repository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);

    this.repository = repository;
    this.movieId = movieId;
  }

  @Override protected Observable buildUseCaseObservable() {
    return repository.casts(movieId);
  }
}
