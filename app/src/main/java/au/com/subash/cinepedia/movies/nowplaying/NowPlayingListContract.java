package au.com.subash.cinepedia.movies.nowplaying;

import au.com.subash.cinepedia.movies.MovieModel;
import au.com.subash.cinepedia.presenter.BasePresenter;
import au.com.subash.cinepedia.view.component.LoadDataView;
import java.util.List;

public interface NowPlayingListContract {

  public interface View extends LoadDataView {
    void renderNowPlayingMovies(List<MovieModel> movieModelList);
    void viewMovieDetail(MovieModel movieModel);
  }

  public interface Presenter extends BasePresenter {

  }

  public interface Listener {
    void onMovieClicked(MovieModel movieModel);
  }
}
