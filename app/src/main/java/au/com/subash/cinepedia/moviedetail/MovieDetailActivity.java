package au.com.subash.cinepedia.moviedetail;

import android.os.Bundle;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.core.di.HasComponent;
import au.com.subash.cinepedia.view.activity.BaseActivity;
import javax.inject.Inject;

public class MovieDetailActivity extends BaseActivity implements HasComponent<MovieDetailComponent> {

  @Inject MovieDetailComponent movieDetailComponent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.movie_detail_act);

    initializeInjector();

    if (null == savedInstanceState) {
      addFragment(R.id.fl_movie_detail, MovieDetailFragment.getInstance());
    }

  }

  private void initializeInjector() {
    int movieId = 550;

    movieDetailComponent = DaggerMovieDetailComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .movieDetailModule(new MovieDetailModule(movieId))
        .build();
  }

  @Override public MovieDetailComponent getComponent() {
    return movieDetailComponent;
  }
}
