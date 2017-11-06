package au.com.subash.cinepedia.comingsoonmovies;

import android.os.Bundle;
import au.com.subash.cinepedia.moviecardlist.MovieCardListContract;
import au.com.subash.cinepedia.moviecardlist.MovieCardListFragment;
import au.com.subash.cinepedia.view.activity.MainActivityComponent;
import javax.inject.Inject;

public class ComingSoonMoviesFragment extends MovieCardListFragment implements MovieCardListContract.View {

  @Inject ComingSoonMoviesPresenter presenter;

  public static ComingSoonMoviesFragment getInstance(String fragmentTitle) {
    ComingSoonMoviesFragment fragment = new ComingSoonMoviesFragment();

    Bundle args = new Bundle();
    args.putString(PARAM_TITLE, fragmentTitle);
    fragment.setArguments(args);

    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent(MainActivityComponent.class).inject(this);
  }

  @Override public MovieCardListContract.Presenter getPresenter() {
    return presenter;
  }

  @Override public void viewAllMovies() {
    showToastMessage("view all coming soon movies");
  }
}
