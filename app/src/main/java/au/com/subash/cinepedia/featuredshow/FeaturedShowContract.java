package au.com.subash.cinepedia.featuredshow;

import au.com.subash.cinepedia.movie.MovieModel;
import au.com.subash.cinepedia.presenter.BasePresenter;
import au.com.subash.cinepedia.view.component.LoadDataView;

public interface FeaturedShowContract {

  interface View extends LoadDataView {

    public void renderFeaturedShow(MovieModel movieModel);

    public void viewFeaturedShow(MovieModel movieModel);
  }

  public interface Presenter extends BasePresenter {

  }
}
