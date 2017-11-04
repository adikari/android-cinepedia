package au.com.subash.cinepedia.view.activity;

import android.os.Bundle;
import au.com.subash.cinepedia.core.di.HasComponent;
import au.com.subash.cinepedia.featuredshow.FeaturedShowFragment;
import au.com.subash.cinepedia.R;
import butterknife.ButterKnife;
import javax.inject.Inject;

/**
 * Main application screen. This is the app entry point.
 */
public class MainActivity extends BaseActivity implements HasComponent<MainActivityComponent> {

  @Inject MainActivityComponent mainActivityComponent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_layout);

    initializeInjector();

    if (null == savedInstanceState) {
      addFragment(R.id.fragmentContainer, FeaturedShowFragment.getInstance());
    }

    ButterKnife.bind(this);
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
