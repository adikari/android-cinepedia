package au.com.subash.cinepedia.view.activity;

import android.os.Bundle;
import au.com.subash.cinepedia.featuredshow.FeaturedShowFragment;
import butterknife.ButterKnife;
import au.com.subash.cinepedia.R;

/**
 * Main application screen. This is the app entry point.
 */
public class MainActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_layout);

    addFragment(R.id.fragmentContainer, new FeaturedShowFragment());

    ButterKnife.bind(this);
  }
}
