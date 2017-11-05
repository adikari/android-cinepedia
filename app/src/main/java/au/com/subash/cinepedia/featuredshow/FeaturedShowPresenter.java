package au.com.subash.cinepedia.featuredshow;

import au.com.subash.cinepedia.exception.DefaultErrorBundle;
import au.com.subash.cinepedia.exception.ErrorBundle;
import au.com.subash.cinepedia.exception.ErrorMessageFactory;
import au.com.subash.cinepedia.interactor.DefaultSubscriber;
import au.com.subash.cinepedia.interactor.UseCase;
import au.com.subash.cinepedia.movie.MovieModelDataMapper;
import au.com.subash.cinepedia.movie.domain.Movie;
import javax.inject.Inject;
import javax.inject.Named;

public class FeaturedShowPresenter implements FeaturedShowContract.Presenter {

  private FeaturedShowContract.View view;

  private final UseCase getFeaturedShowUseCase;
  private final MovieModelDataMapper mapper;

  @Inject
  public FeaturedShowPresenter(@Named("getFeaturedShow") UseCase getFeaturedShowUseCase,
      MovieModelDataMapper mapper) {
    this.getFeaturedShowUseCase = getFeaturedShowUseCase;
    this.mapper = mapper;
  }

  public void setView(FeaturedShowContract.View view) {
    this.view = view;
  }

  @Override public void resume() { }

  @Override public void pause() { }

  @Override public void destroy() {
    getFeaturedShowUseCase.unsubscribe();
    view = null;
  }

  @Override public void initialize() {
    getFeaturedShowUseCase.execute(new FeaturedShowSubscriber());
  }

  private void showFeaturedMovieInView(Movie movie) {
    view.renderFeaturedShow(mapper.transform(movie));
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
    String errorMessage = ErrorMessageFactory.create(view.context(), errorBundle.getException());
    view.showError(errorMessage);
  }

  private class FeaturedShowSubscriber extends DefaultSubscriber<Movie> {
    @Override public void onStart() {
      FeaturedShowPresenter.this.hideViewRetry();
      FeaturedShowPresenter.this.showViewLoading();
    }

    @Override public void onComplete() {
      FeaturedShowPresenter.this.hideViewLoading();
    }

    @Override public void onError(Throwable e) {
      FeaturedShowPresenter.this.hideViewLoading();
      FeaturedShowPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
      FeaturedShowPresenter.this.showViewRetry();
    }

    @Override public void onNext(Movie movie) {
      FeaturedShowPresenter.this.showFeaturedMovieInView(movie);
    }
  }
}
