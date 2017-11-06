package au.com.subash.cinepedia.casts;

import au.com.subash.cinepedia.presenter.BasePresenter;
import au.com.subash.cinepedia.view.component.LoadDataView;
import java.util.List;

class CastScrollContract {

  interface View extends LoadDataView {
    void renderCasts(List<CastModel> castModelList);
    void viewCast(CastModel castModel);
  }

  interface Presenter extends BasePresenter {

  }

  interface Listener {

  }
}
