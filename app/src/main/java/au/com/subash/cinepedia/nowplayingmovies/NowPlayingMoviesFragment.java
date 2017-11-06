package au.com.subash.cinepedia.nowplayingmovies;

import android.os.Bundle;
import au.com.subash.cinepedia.moviecardlist.MovieCardListContract;
import au.com.subash.cinepedia.moviecardlist.MovieCardListFragment;
import au.com.subash.cinepedia.view.activity.MainActivityComponent;
import javax.inject.Inject;

public class NowPlayingMoviesFragment extends MovieCardListFragment implements MovieCardListContract.View {

  @Inject NowPlayingMoviesPresenter presenter;

  public NowPlayingMoviesFragment() {
    setRetainInstance(true);
  }

  public static NowPlayingMoviesFragment getInstance() {
    return new NowPlayingMoviesFragment();
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent(MainActivityComponent.class).inject(this);
  }

  @Override public MovieCardListContract.Presenter getPresenter() {
    return presenter;
  }
}
