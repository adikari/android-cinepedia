package au.com.subash.cinepedia.nowplayingmovies;

import au.com.subash.cinepedia.movie.MovieModel;
import au.com.subash.cinepedia.presenter.BasePresenter;
import au.com.subash.cinepedia.view.component.LoadDataView;
import java.util.List;

public interface NowPlayingMoviesContract {

  interface View extends LoadDataView {
    void renderMovies(List<MovieModel> movieModelList);
    void viewMovieDetail(MovieModel movieModel);
    void viewAllMovies();
  }

  interface Presenter extends BasePresenter {
    void onMovieClicked(MovieModel movieModel);
    void onViewAllClicked();
  }

  interface Listener {
    void onMovieClicked(MovieModel movieModel);
    void onViewAllNowPlayingClicked();
  }
}
