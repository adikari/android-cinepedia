package au.com.subash.cinepedia.comingsoonmovies;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

public class ComingSoonMoviesLayoutManager extends GridLayoutManager {

  public ComingSoonMoviesLayoutManager(Context context) {
    super(context, 1, GridLayoutManager.HORIZONTAL, false);
  }
}
