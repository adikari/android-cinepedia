package au.com.subash.cinepedia.featuredshow;

import au.com.subash.cinepedia.core.executor.PostExecutionThread;
import au.com.subash.cinepedia.core.executor.ThreadExecutor;
import au.com.subash.cinepedia.interactor.UseCase;
import javax.inject.Inject;
import rx.Observable;

public class GetFeaturedShow extends UseCase {

  @Inject
  protected GetFeaturedShow(ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
  }

  @Override protected Observable buildUseCaseObservable() {
    return null;
  }
}
