package au.com.subash.cinepedia.navigation;

import android.content.Context;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class used to navigate through the application.
 */
@Singleton
public class Navigator {

  @Inject
  public Navigator() {
    //empty
  }

  /**
   * Navigate to movie list screen
   *
   * @param context Application context needed to open destiny activity
   */
  public void navigateToMovieList(Context context) {
    if (context != null) {
      // Intent intentToLaunch = MovieListActivity.getCallingIntent(context);
      // context.startActivity(intentToLaunch);
    }
  }
}
