package au.com.subash.cinepedia.nowplayingmovies;

import android.os.Bundle;
import au.com.subash.cinepedia.cardview.CardListContract;
import au.com.subash.cinepedia.cardview.CardListFragment;
import au.com.subash.cinepedia.view.activity.MainActivityComponent;
import javax.inject.Inject;

public class NowPlayingMoviesFragment extends CardListFragment implements CardListContract.View {

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

  @Override public CardListContract.Presenter getPresenter() {
    return presenter;
  }
}
