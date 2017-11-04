package au.com.subash.cinepedia.comingsoonmovies;

import au.com.subash.cinepedia.movie.MovieModel;
import au.com.subash.cinepedia.presenter.BasePresenter;
import au.com.subash.cinepedia.view.component.LoadDataView;
import java.util.List;

interface ComingSoonMoviesContract {

  interface View extends LoadDataView {
    void renderComingSoonMovies(List<MovieModel> movieModelList);
    void viewMovie(MovieModel movieModel);
  }

  interface Presenter extends BasePresenter {

  }
}
