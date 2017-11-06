package au.com.subash.cinepedia.casts;

import au.com.subash.cinepedia.exception.ErrorBundle;
import au.com.subash.cinepedia.exception.ErrorMessageFactory;
import au.com.subash.cinepedia.interactor.DefaultSubscriber;
import au.com.subash.cinepedia.interactor.UseCase;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

public class CastScrollPresenter implements CastScrollContract.Presenter {

  private final UseCase getCasts;
  private final CastModelDataMapper mapper;

  private CastScrollContract.View view;

  @Inject
  CastScrollPresenter(@Named("getCasts") UseCase getCasts, CastModelDataMapper mapper) {
    this.getCasts = getCasts;
    this.mapper = mapper;
  }

  void setView(CastScrollContract.View view) {
    this.view = view;
  }

  void onCastClicked(CastModel castModel) {
    view.viewCast(castModel);
  }

  @Override public void resume() { }

  @Override public void pause() { }

  @Override public void destroy() {
    view = null;
    getCasts.unsubscribe();
  }

  @Override public void initialize() {
    hideViewRetry();
    showViewLoading();
    getCasts.execute(new GetCastSubscriber());
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
      CastScrollPresenter.this.hideViewRetry();
      CastScrollPresenter.this.showViewLoading();
    }

    @Override public void onError(Throwable e) {
      CastScrollPresenter.this.hideViewLoading();
      CastScrollPresenter.this.showViewRetry();
    }

    @Override public void onComplete() {
      CastScrollPresenter.this.hideViewLoading();
    }

    @Override public void onNext(List<Cast> casts) {
      CastScrollPresenter.this.showCastsInView(casts);
    }
  }
}



















