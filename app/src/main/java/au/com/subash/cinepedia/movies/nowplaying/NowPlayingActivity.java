package au.com.subash.cinepedia.movies.nowplaying;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.core.di.HasComponent;
import au.com.subash.cinepedia.core.di.modules.ActivityModule;
import au.com.subash.cinepedia.movies.MovieModel;
import au.com.subash.cinepedia.view.activity.BaseActivity;
import javax.inject.Inject;

public class NowPlayingActivity extends BaseActivity implements HasComponent<NowPlayingComponent>,
  NowPlayingListContract.Listener {

  @Inject NowPlayingComponent nowPlayingComponent;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, NowPlayingActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.now_playing_list_act);

    initializeInjector();

    if (null == savedInstanceState) {
      initializeUI();
    }
  }

  @Override protected ActivityModule getActivityModule() {
    return super.getActivityModule();
  }

  @Override public NowPlayingComponent getComponent() {
    return nowPlayingComponent;
  }

  private void initializeUI() {
    addFragment(R.id.fl_now_playing_list, NowPlayingListFragment.getInstance());
  }

  private void initializeInjector() {
    nowPlayingComponent = DaggerNowPlayingComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .nowPlayingModule(new NowPlayingModule())
        .build();
  }

  @Override public void onMovieClicked(MovieModel movieModel) {

  }
}
