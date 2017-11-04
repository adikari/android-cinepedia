package au.com.subash.cinepedia.nowplayingmovies;

import au.com.subash.cinepedia.movie.MovieModel;
import au.com.subash.cinepedia.presenter.BasePresenter;
import au.com.subash.cinepedia.view.component.LoadDataView;
import java.util.List;

interface NowPlayingContract {
  interface View extends LoadDataView {
    void renderNowPlayingMovies(List<MovieModel> movieModelList);
    void viewMovieDetail(MovieModel movieModel);
  }

  interface Presenter extends BasePresenter {

  }
}