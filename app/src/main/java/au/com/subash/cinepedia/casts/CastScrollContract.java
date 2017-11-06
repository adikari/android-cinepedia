package au.com.subash.cinepedia.casts;

import au.com.subash.cinepedia.presenter.BasePresenter;
import au.com.subash.cinepedia.view.component.LoadDataView;
import java.util.List;

public class CastScrollContract {

  public interface View extends LoadDataView {
    void renderCasts(List<CastModel> castModelList);
    void viewCast(CastModel castModel);
  }

  public interface Presenter extends BasePresenter {

  }

  public interface Listener {
    void onCastClicked(CastModel castModel);
  }
}
