package au.com.subash.cinepedia.cardview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import javax.inject.Inject;

public class CardListLayoutManager extends GridLayoutManager {

  @Inject
  public CardListLayoutManager(Context context) {
    // TODO: set span count this configurable
    super(context, 2);
  }
}
