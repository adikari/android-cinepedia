package au.com.subash.cinepedia.comingsoonmovies;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.cardview.CardListAdapter;
import au.com.subash.cinepedia.cardview.CardListDecoration;
import au.com.subash.cinepedia.cardview.CardListLayoutManager;
import au.com.subash.cinepedia.movie.MovieModel;
import au.com.subash.cinepedia.view.activity.MainActivityComponent;
import au.com.subash.cinepedia.view.fragment.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.List;
import javax.inject.Inject;

public class ComingSoonMoviesFragment extends BaseFragment implements ComingSoonMoviesContract.View {

  @Inject ComingSoonMoviesPresenter presenter;
  @Inject CardListLayoutManager layoutManager;
  @Inject CardListAdapter cardListAdapter;

  @BindView(R.id.rv_coming_soon_list) RecyclerView recyclerView;

  private Unbinder unbinder;

  public static ComingSoonMoviesFragment getInstance() {
    return new ComingSoonMoviesFragment();
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent(MainActivityComponent.class).inject(this);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.coming_soon_movies_frag, container, false);

    unbinder = ButterKnife.bind(this, view);

    recyclerView.setLayoutManager(layoutManager);
    recyclerView.addItemDecoration(new CardListDecoration(2, 16, true));
    recyclerView.setAdapter(cardListAdapter);

    return view;
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    presenter.setView(this);

    if (null == savedInstanceState) {
      loadComingSoonMovies();
    }
  }

  @Override public void onResume() {
    super.onResume();
    presenter.resume();
  }

  @Override public void onPause() {
    super.onPause();
    presenter.pause();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    presenter.destroy();
  }

  @Override public void onDetach() {
    super.onDetach();
  }

  @Override public void renderComingSoonMovies(List<MovieModel> movieModelList) {
    cardListAdapter.setMovieModelList(movieModelList);
  }

  @Override public void viewMovie(MovieModel movieModel) {

  }

  @Override public void showLoading() { }

  @Override public void hideLoading() { }

  @Override public void showRetry() { }

  @Override public void hideRetry() { }

  @Override public void showError(String message) {
    showToastMessage(message);
  }

  @Override public Context context() {
    return getActivity().getApplicationContext();
  }

  private void loadComingSoonMovies() {
    presenter.initialize();
  }
}
