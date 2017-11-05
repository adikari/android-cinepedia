package au.com.subash.cinepedia.moviedetail;

import au.com.subash.cinepedia.core.di.PerActivity;
import au.com.subash.cinepedia.exception.DefaultErrorBundle;
import au.com.subash.cinepedia.exception.ErrorBundle;
import au.com.subash.cinepedia.exception.ErrorMessageFactory;
import au.com.subash.cinepedia.interactor.DefaultSubscriber;
import au.com.subash.cinepedia.interactor.UseCase;
import javax.inject.Inject;
import javax.inject.Named;

@PerActivity
public class MovieDetailPresenter implements MovieDetailContract.Presenter {

  private MovieDetailContract.View view;

  private final UseCase getMovieDetail;
  private final MovieDetailModelDataMapper mapper;

  @Inject
  MovieDetailPresenter(@Named("getMovieDetail") UseCase getMovieDetail,
      MovieDetailModelDataMapper mapper) {
    this.getMovieDetail = getMovieDetail;
    this.mapper = mapper;
  }

  public void setView(MovieDetailContract.View view) {
    this.view = view;
  }

  @Override public void resume() { }

  @Override public void pause() { }

  @Override public void destroy() {
    view = null;
    getMovieDetail.unsubscribe();
  }

  @Override public void initialize() {
    this.hideViewRetry();
    this.showViewLoading();
    getMovieDetail.execute(new GetMovieDetailSubscriber());
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

  private void showErrorMessage(ErrorBundle errorBundle) {
    String message = ErrorMessageFactory.create(view.context(), errorBundle.getException());
    view.showError(message);
  }

  private void showMovieDetailInView(MovieDetail movieDetail) {
    view.renderMovieDetail(mapper.transform(movieDetail));
  }

  private class GetMovieDetailSubscriber extends DefaultSubscriber<MovieDetail> {
    @Override public void onStart() {
      MovieDetailPresenter.this.hideViewRetry();
      MovieDetailPresenter.this.showViewLoading();
    }

    @Override public void onComplete() {
      MovieDetailPresenter.this.hideViewLoading();
    }

    @Override public void onError(Throwable e) {
      MovieDetailPresenter.this.hideViewLoading();
      MovieDetailPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
      MovieDetailPresenter.this.showViewRetry();
    }

    @Override public void onNext(MovieDetail movieDetail) {
      MovieDetailPresenter.this.showMovieDetailInView(movieDetail);
    }
  }
}
