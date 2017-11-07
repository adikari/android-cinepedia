package au.com.subash.cinepedia.movies.nowplaying;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

class NowPlayingListLayoutManager extends GridLayoutManager {

  NowPlayingListLayoutManager(Context context) {
    super(context, 2);
  }
}
