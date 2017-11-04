package au.com.subash.cinepedia.nowplayingmovies;

import android.os.Bundle;
import au.com.subash.cinepedia.moviecardlist.MovieCardListContract;
import au.com.subash.cinepedia.moviecardlist.MovieCardListFragment;
import au.com.subash.cinepedia.view.activity.MainActivityComponent;
import javax.inject.Inject;

public class NowPlayingMoviesFragmentMovie extends MovieCardListFragment implements MovieCardListContract.View {

  @Inject NowPlayingMoviesPresenter presenter;

  public NowPlayingMoviesFragmentMovie() {
    setRetainInstance(true);
  }

  public static NowPlayingMoviesFragmentMovie getInstance() {
    return new NowPlayingMoviesFragmentMovie();
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent(MainActivityComponent.class).inject(this);
  }

  @Override public MovieCardListContract.Presenter getPresenter() {
    return presenter;
  }
}
