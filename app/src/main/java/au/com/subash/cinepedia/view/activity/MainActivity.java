package au.com.subash.cinepedia.view.activity;

import android.os.Bundle;
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


    ButterKnife.bind(this);
  }
}
