package au.com.subash.cinepedia.moviecardlist;

import au.com.subash.cinepedia.movie.MovieModel;
import au.com.subash.cinepedia.presenter.BasePresenter;
import au.com.subash.cinepedia.view.component.LoadDataView;
import java.util.List;

public interface MovieCardListContract {

  interface View extends LoadDataView {
    void renderMovies(List<MovieModel> movieModelList);
    void viewMovieDetail(MovieModel movieModel);
    Presenter getPresenter();
  }

  interface Presenter extends BasePresenter {
    void setView(MovieCardListContract.View view);
    void onMovieClicked(MovieModel movieModel);
  }

  interface Listener {
    void onMovieClicked(MovieModel movieModel);
  }
}
