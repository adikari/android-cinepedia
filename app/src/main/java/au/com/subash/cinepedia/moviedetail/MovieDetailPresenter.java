package au.com.subash.cinepedia.moviedetail;

import au.com.subash.cinepedia.interactor.UseCase;
import javax.inject.Inject;
import javax.inject.Named;

public class MovieDetailPresenter implements MovieDetailContract.Presenter {

  private MovieDetailContract.View view;

  private final UseCase getMovieDetail;

  @Inject
  MovieDetailPresenter(@Named("getMovieDetail") UseCase getMovieDetail) {
    this.getMovieDetail = getMovieDetail;
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

  }
}
