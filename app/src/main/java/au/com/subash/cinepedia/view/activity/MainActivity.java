package au.com.subash.cinepedia.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import au.com.subash.cinepedia.comingsoonmovies.ComingSoonMoviesFragment;
import au.com.subash.cinepedia.core.di.HasComponent;
import au.com.subash.cinepedia.featuredshow.FeaturedShowContract;
import au.com.subash.cinepedia.featuredshow.FeaturedShowFragment;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.movie.MovieModel;
import au.com.subash.cinepedia.moviecardlist.MovieCardListContract;
import au.com.subash.cinepedia.nowplayingmovies.NowPlayingMoviesFragment;
import javax.inject.Inject;

/**
 * Main application screen. This is the app entry point.
 */
public class MainActivity extends BaseActivity implements HasComponent<MainActivityComponent>,
    FeaturedShowContract.Listener, MovieCardListContract.Listener {

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
    initializeFeaturedShowFragment();
    initializeNowPlayingFragment();
    initializeComingSoonFragment();
  }

  private void initializeFeaturedShowFragment() {
    addFragment(R.id.fl_featured_show, FeaturedShowFragment.getInstance());
  }

  private void initializeComingSoonFragment() {
    String title = getResources().getString(R.string.comingsoon_frag_title);
    addFragment(R.id.fl_coming_soon_movies, ComingSoonMoviesFragment.getInstance(title));
  }

  private void initializeNowPlayingFragment() {
    String title = getResources().getString(R.string.nowplaying_frag_title);
    addFragment(R.id.fl_now_playing_movies, NowPlayingMoviesFragment.getInstance(title));
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
}
