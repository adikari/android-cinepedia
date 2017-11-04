package au.com.subash.cinepedia.interactor;

import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Default subscriber base class to be used whenever you want default error handling.
 */
public class DefaultSubscriber<T> extends DisposableSubscriber<T> {

  @Override public void onError(Throwable e) {
    // no-op by default.
  }

  @Override public void onComplete() {

  }

  @Override public void onNext(T t) {
    // no-op by default.
  }
}
