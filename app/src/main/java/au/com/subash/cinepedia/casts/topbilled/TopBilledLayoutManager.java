package au.com.subash.cinepedia.casts.topbilled;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

class TopBilledLayoutManager extends GridLayoutManager {

  TopBilledLayoutManager(Context context) {
    super(context, 1, GridLayoutManager.HORIZONTAL, false);
  }
}
