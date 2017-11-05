package au.com.subash.cinepedia.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import au.com.subash.cinepedia.comingsoonmovies.ComingSoonMoviesFragment;
import au.com.subash.cinepedia.core.di.HasComponent;
import au.com.subash.cinepedia.featuredshow.FeaturedShowFragment;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.nowplayingmovies.NowPlayingMoviesFragmentMovie;
import javax.inject.Inject;

/**
 * Main application screen. This is the app entry point.
 */
public class MainActivity extends BaseActivity implements HasComponent<MainActivityComponent> {

  @Inject MainActivityComponent mainActivityComponent;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, MainActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_layout);

    initializeInjector();

    if (null == savedInstanceState) {
      initializeUI();
    }

  }

  private void initializeUI() {
    addFragment(R.id.fl_featured_show, FeaturedShowFragment.getInstance());
    addFragment(R.id.fl_now_playing_movies, NowPlayingMoviesFragmentMovie.getInstance());
    addFragment(R.id.fl_coming_soon_movies, ComingSoonMoviesFragment.getInstance());
  }

  private void initializeInjector() {
    mainActivityComponent = DaggerMainActivityComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .mainActivityModule(new MainActivityModule())
        .build();
  }

  @Override public MainActivityComponent getComponent() {
    return mainActivityComponent;
  }


}
