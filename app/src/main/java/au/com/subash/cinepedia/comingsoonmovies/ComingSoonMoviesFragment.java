package au.com.subash.cinepedia.comingsoonmovies;

import android.os.Bundle;
import au.com.subash.cinepedia.cardview.CardListContract;
import au.com.subash.cinepedia.cardview.CardListFragment;
import au.com.subash.cinepedia.view.activity.MainActivityComponent;
import javax.inject.Inject;

public class ComingSoonMoviesFragment extends CardListFragment implements CardListContract.View {

  @Inject ComingSoonMoviesPresenter presenter;

  public static ComingSoonMoviesFragment getInstance() {
    return new ComingSoonMoviesFragment();
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent(MainActivityComponent.class).inject(this);
  }

  @Override public CardListContract.Presenter getPresenter() {
    return presenter;
  }
}
