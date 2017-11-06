package au.com.subash.cinepedia.moviecardlist;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import javax.inject.Inject;

public class MovieCardListLayoutManager extends GridLayoutManager {

  @Inject
  public MovieCardListLayoutManager(Context context) {
    super(context, 1, GridLayoutManager.HORIZONTAL, false);
  }
}
