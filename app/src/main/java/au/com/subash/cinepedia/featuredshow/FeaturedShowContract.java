package au.com.subash.cinepedia.featuredshow;

import au.com.subash.cinepedia.movie.MovieModel;
import au.com.subash.cinepedia.presenter.BasePresenter;
import au.com.subash.cinepedia.view.component.LoadDataView;

public interface FeaturedShowContract {

  interface View extends LoadDataView {

    void renderFeaturedShow(MovieModel movieModel);

    void viewFeaturedShow(MovieModel movieModel);
  }

  interface Presenter extends BasePresenter {

  }

  interface Listener {
    void onMovieClicked(MovieModel movieModel);
  }
}
