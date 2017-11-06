package au.com.subash.cinepedia.moviedetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.casts.CastScrollFragment;
import au.com.subash.cinepedia.core.di.HasComponent;
import au.com.subash.cinepedia.view.activity.BaseActivity;
import javax.inject.Inject;

public class MovieDetailActivity extends BaseActivity implements HasComponent<MovieDetailComponent> {

  @Inject MovieDetailComponent movieDetailComponent;

  private static final String INTENT_EXTRA_PARAM_MOVIE_ID = "au.com.subash.cinepedia.INTENT_PARAM_MOVIE_ID";
  private static final String INSTANCE_STATE_PARAM_MOVIE_ID = "au.com.subash.cinepedia.STATE_PARAM_MOVIE_ID";

  private int movieId;

  public static Intent getCallingIntent(Context context, int movieId) {
    Intent callingIntent = new Intent(context, MovieDetailActivity.class);
    callingIntent.putExtra(INTENT_EXTRA_PARAM_MOVIE_ID, movieId);
    return callingIntent;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.movie_detail_act);

    initializeActivity(savedInstanceState);
    initializeInjector();
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    if (outState != null) {
      outState.putInt(INSTANCE_STATE_PARAM_MOVIE_ID, movieId);
    }

    super.onSaveInstanceState(outState);
  }

  private void initializeActivity(Bundle savedInstanceState) {
    if (null == savedInstanceState) {
      movieId = getIntent().getIntExtra(INTENT_EXTRA_PARAM_MOVIE_ID, -1);

      addFragment(R.id.fl_movie_detail, MovieDetailFragment.getInstance());
      //addFragment(R.id.fl_cast_scroll, CastScrollFragment.getInstance());
    } else {
      movieId = savedInstanceState.getInt(INSTANCE_STATE_PARAM_MOVIE_ID);
    }

    movieId = 550;
  }

  private void initializeInjector() {
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
