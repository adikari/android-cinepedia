package au.com.subash.cinepedia.movie.nowplaying;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

public class NowPlayingMoviesLayoutManager extends GridLayoutManager {

  public NowPlayingMoviesLayoutManager(Context context) {
    super(context, 1, GridLayoutManager.HORIZONTAL, false);
  }
}
