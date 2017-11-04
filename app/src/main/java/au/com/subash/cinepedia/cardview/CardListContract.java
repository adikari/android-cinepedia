package au.com.subash.cinepedia.cardview;

import au.com.subash.cinepedia.movie.MovieModel;
import au.com.subash.cinepedia.presenter.BasePresenter;
import au.com.subash.cinepedia.view.component.LoadDataView;
import java.util.List;

public interface CardListContract {

  interface View extends LoadDataView {
    void renderMovies(List<MovieModel> movieModelList);
    void viewMovieDetail(MovieModel movieModel);
    Presenter getPresenter();
  }

  interface Presenter extends BasePresenter {
    void setView(CardListContract.View view);
  }
}
