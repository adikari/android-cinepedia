package au.com.subash.cinepedia.nowplayingmovies;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.movie.MovieModel;
import au.com.subash.cinepedia.view.activity.MainActivityComponent;
import au.com.subash.cinepedia.view.fragment.BaseFragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.List;
import javax.inject.Inject;

public class NowPlayingMoviesFragment extends BaseFragment implements NowPlayingContract.View {

  @Inject NowPlayingMoviesPresenter presenter;

  private Unbinder unbinder;

  public NowPlayingMoviesFragment() {
    setRetainInstance(true);
  }

  public static NowPlayingMoviesFragment getInstance() {
    return new NowPlayingMoviesFragment();
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent(MainActivityComponent.class).inject(this);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.nowplaying_list_frag, container, false);

    unbinder = ButterKnife.bind(this, view);
    setupRecyclerView();

    return view;
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    presenter.setView(this);

    if (null != savedInstanceState) {
      loadNowPlayingMovies();
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

  @Override public void renderNowPlayingMovies(List<MovieModel> movieModelList) {

  }

  @Override public void viewMovieDetail(MovieModel movieModel) {

  }

  @Override public void showLoading() { }

  @Override public void hideLoading() { }

  @Override public void showRetry() { }

  @Override public void hideRetry() { }

  @Override public void showError(String message) {

  }

  @Override public Context context() {
    return getActivity().getApplicationContext();
  }

  private void loadNowPlayingMovies() {
    presenter.initialize();
  }

  private void setupRecyclerView() {

  }
}
