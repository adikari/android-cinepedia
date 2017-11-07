package au.com.subash.cinepedia.casts.topbilled;

import au.com.subash.cinepedia.casts.Cast;
import au.com.subash.cinepedia.casts.CastModel;
import au.com.subash.cinepedia.casts.CastModelDataMapper;
import au.com.subash.cinepedia.exception.ErrorBundle;
import au.com.subash.cinepedia.exception.ErrorMessageFactory;
import au.com.subash.cinepedia.interactor.DefaultSubscriber;
import au.com.subash.cinepedia.interactor.UseCase;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

public class TopBilledPresenter implements TopBilledContract.Presenter {

  private final UseCase getTopBilledCasts;
  private final CastModelDataMapper mapper;

  private TopBilledContract.View view;

  @Inject TopBilledPresenter(@Named("getTopBilledCasts") UseCase getTopBilledCasts,
      CastModelDataMapper mapper) {
    this.getTopBilledCasts = getTopBilledCasts;
    this.mapper = mapper;
  }

  void setView(TopBilledContract.View view) {
    this.view = view;
  }

  void onCastClicked(CastModel castModel) {
    view.viewCast(castModel);
  }

  @Override public void resume() { }

  @Override public void pause() { }

  @Override public void destroy() {
    view = null;
    getTopBilledCasts.unsubscribe();
  }

  @Override public void initialize() {
    hideViewRetry();
    showViewLoading();
    getTopBilledCasts.execute(new GetCastSubscriber());
  }

  private void showViewLoading() {
    view.showLoading();
  }

  private void hideViewLoading() {
    view.hideLoading();
  }

  private void showViewRetry() {
    view.showRetry();
  }

  private void hideViewRetry() {
    view.hideRetry();
  }

  private void showCastsInView(List<Cast> casts) {
    view.renderCasts(mapper.transform(casts));
  }

  private void showError(ErrorBundle errorBundle) {
    String message = ErrorMessageFactory.create(view.context(), errorBundle.getException());

    view.showError(message);
  }

  private class GetCastSubscriber extends DefaultSubscriber<List<Cast>> {
    @Override public void onStart() {
      TopBilledPresenter.this.hideViewRetry();
      TopBilledPresenter.this.showViewLoading();
    }

    @Override public void onError(Throwable e) {
      TopBilledPresenter.this.hideViewLoading();
      TopBilledPresenter.this.showViewRetry();
    }

    @Override public void onComplete() {
      TopBilledPresenter.this.hideViewLoading();
    }

    @Override public void onNext(List<Cast> casts) {
      TopBilledPresenter.this.showCastsInView(casts);
    }
  }
}



















