package au.com.subash.cinepedia.movies.nowplaying;

import au.com.subash.cinepedia.exception.DefaultErrorBundle;
import au.com.subash.cinepedia.exception.ErrorBundle;
import au.com.subash.cinepedia.exception.ErrorMessageFactory;
import au.com.subash.cinepedia.interactor.DefaultSubscriber;
import au.com.subash.cinepedia.interactor.UseCase;
import au.com.subash.cinepedia.movies.Movie;
import au.com.subash.cinepedia.movies.MovieModel;
import au.com.subash.cinepedia.movies.MovieModelDataMapper;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

public class NowPlayingListPresenter implements NowPlayingListContract.Presenter {

  private NowPlayingListContract.View view;

  private final MovieModelDataMapper mapper;
  private final UseCase getNowPlayingMovies;

  @Inject
  NowPlayingListPresenter(@Named("getNowPlayingMovies") UseCase getNowPlayingMovies,
      MovieModelDataMapper mapper) {
    this.getNowPlayingMovies = getNowPlayingMovies;
    this.mapper = mapper;
  }

  void setView(NowPlayingListContract.View view) {
    this.view = view;
  }

  void onMovieClicked(MovieModel movieModel) {
    view.viewMovieDetail(movieModel);
  }

  @Override public void resume() { }

  @Override public void pause() { }

  @Override public void destroy() {
    getNowPlayingMovies.unsubscribe();
  }

  @Override public void initialize() {
    getNowPlayingMovies.execute(new NowPlayingListSubscriber());
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

  private void showError(ErrorBundle errorBundle) {
    String message = ErrorMessageFactory.create(view.context(), errorBundle.getException());
    view.showError(message);
  }

  private void showMoviesInView(List<Movie> movieList) {
    view.renderNowPlayingMovies(mapper.transform(movieList));
  }

  private class NowPlayingListSubscriber extends DefaultSubscriber<List<Movie>> {
    @Override public void onStart() {
      NowPlayingListPresenter.this.hideViewRetry();
      NowPlayingListPresenter.this.showViewLoading();
    }

    @Override public void onError(Throwable e) {
      NowPlayingListPresenter.this.hideViewLoading();
      NowPlayingListPresenter.this.showError(new DefaultErrorBundle((Exception) e));
      NowPlayingListPresenter.this.showViewRetry();
    }

    @Override public void onComplete() {
      NowPlayingListPresenter.this.hideViewLoading();
    }

    @Override public void onNext(List<Movie> movies) {
      NowPlayingListPresenter.this.showMoviesInView(movies);
    }
  }
}
