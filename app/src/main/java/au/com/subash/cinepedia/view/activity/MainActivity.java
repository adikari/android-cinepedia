package au.com.subash.cinepedia.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import au.com.subash.cinepedia.movies.comingsoon.ComingSoonMoviesContract;
import au.com.subash.cinepedia.movies.comingsoon.ComingSoonMoviesFragment;
import au.com.subash.cinepedia.core.di.HasComponent;
import au.com.subash.cinepedia.featuredshow.FeaturedShowContract;
import au.com.subash.cinepedia.featuredshow.FeaturedShowFragment;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.movies.MovieModel;
import au.com.subash.cinepedia.movies.nowplaying.NowPlayingMoviesContract;
import au.com.subash.cinepedia.movies.nowplaying.NowPlayingMoviesFragment;
import javax.inject.Inject;

/**
 * Main application screen. This is the app entry point.
 */
public class MainActivity extends BaseActivity implements HasComponent<MainActivityComponent>,
    FeaturedShowContract.Listener, ComingSoonMoviesContract.Listener, NowPlayingMoviesContract.Listener {

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

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main_menu, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.main_menu_more:
        navigator.navigateToNowPlayingList(this);
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  private void initializeUI() {
    addFragment(R.id.fl_featured_show, FeaturedShowFragment.getInstance());
    addFragment(R.id.fl_now_playing_movies, NowPlayingMoviesFragment.getInstance());
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

  @Override public void onMovieClicked(MovieModel movieModel) {
    navigator.navigateToMovieDetail(this, movieModel.getId());
  }

  @Override public void onViewAllComingSoonClicked() {

  }

  @Override public void onViewAllNowPlayingClicked() {
    navigator.navigateToNowPlayingList(this);
  }
}
