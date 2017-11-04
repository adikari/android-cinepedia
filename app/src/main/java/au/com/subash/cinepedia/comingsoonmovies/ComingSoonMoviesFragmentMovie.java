package au.com.subash.cinepedia.comingsoonmovies;

import android.os.Bundle;
import au.com.subash.cinepedia.moviecardlist.MovieCardListContract;
import au.com.subash.cinepedia.moviecardlist.MovieCardListFragment;
import au.com.subash.cinepedia.view.activity.MainActivityComponent;
import javax.inject.Inject;

public class ComingSoonMoviesFragmentMovie extends MovieCardListFragment implements MovieCardListContract.View {

  @Inject ComingSoonMoviesPresenter presenter;

  public static ComingSoonMoviesFragmentMovie getInstance() {
    return new ComingSoonMoviesFragmentMovie();
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent(MainActivityComponent.class).inject(this);
  }

  @Override public MovieCardListContract.Presenter getPresenter() {
    return presenter;
  }
}
