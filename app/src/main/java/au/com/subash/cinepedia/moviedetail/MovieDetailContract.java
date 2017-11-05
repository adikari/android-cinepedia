package au.com.subash.cinepedia.moviedetail;

import au.com.subash.cinepedia.presenter.BasePresenter;
import au.com.subash.cinepedia.view.component.LoadDataView;

interface MovieDetailContract {
  interface View extends LoadDataView {
    void renderMovieDetail(MovieDetailModel movieDetailModel);
  }

  interface Presenter extends BasePresenter {

  }
}
