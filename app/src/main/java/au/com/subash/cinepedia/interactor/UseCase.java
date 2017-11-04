package au.com.subash.cinepedia.interactor;

import au.com.subash.cinepedia.core.executor.ThreadExecutor;
import au.com.subash.cinepedia.core.executor.PostExecutionThread;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import org.reactivestreams.Subscriber;

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a {@link Subscriber}
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
public abstract class UseCase {

  private final ThreadExecutor threadExecutor;
  private final PostExecutionThread postExecutionThread;

  private Disposable subscription = Disposables.empty();

  protected UseCase(ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    this.threadExecutor = threadExecutor;
    this.postExecutionThread = postExecutionThread;
  }

  /**
   * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
   */
  protected abstract Observable buildUseCaseObservable();

  /**
   * Executes the current use case.
   *
   * @param useCaseSubscriber The guy who will be listen to the observable build
   * with {@link #buildUseCaseObservable()}.
   */
  @SuppressWarnings("unchecked")
  public void execute(DisposableSubscriber useCaseSubscriber) {
    this.subscription = this.buildUseCaseObservable()
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.getScheduler())
        .subscribe(
            useCaseSubscriber::onNext,
            throwable -> useCaseSubscriber.onError((Throwable) throwable),
            useCaseSubscriber::onComplete
        );
  }

  /**
   * Unsubscribes from current {@link Disposable}.
   */
  public void unsubscribe() {
    if (!subscription.isDisposed()) {
      subscription.dispose();
    }
  }
}
