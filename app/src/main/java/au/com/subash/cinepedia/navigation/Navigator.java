package au.com.subash.cinepedia.navigation;

import android.content.Context;
import android.content.Intent;
import au.com.subash.cinepedia.moviedetail.MovieDetailActivity;
import au.com.subash.cinepedia.movies.nowplaying.NowPlayingActivity;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class used to navigate through the application.
 */
@Singleton
public class Navigator {

  @Inject
  public Navigator() { }

  public void navigateToNowPlayingList(Context context) {
    if (null != context) {
      Intent intentToLaunch = NowPlayingActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Navigate to movie detail screen
   *
   * @param context Application context needed to open destiny activity
   */
  public void navigateToMovieDetail(Context context, int movieId) {
    if (context != null) {
      Intent intentToLaunch = MovieDetailActivity.getCallingIntent(context, movieId);
      context.startActivity(intentToLaunch);
    }
  }
}
