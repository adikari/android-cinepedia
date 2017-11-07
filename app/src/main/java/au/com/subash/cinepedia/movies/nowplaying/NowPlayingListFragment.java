package au.com.subash.cinepedia.movies.nowplaying;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.movies.MovieModel;
import au.com.subash.cinepedia.view.fragment.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.List;
import javax.inject.Inject;

public class NowPlayingListFragment extends BaseFragment implements NowPlayingListContract.View {

  @Inject NowPlayingListPresenter presenter;
  @Inject NowPlayingListAdapter adapter;

  @BindView(R.id.rv_now_playing_list) RecyclerView recyclerView;

  private NowPlayingListContract.Listener listener;
  private Unbinder unbinder;

  public static NowPlayingListFragment getInstance() {
    return new NowPlayingListFragment();
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent(NowPlayingComponent.class).inject(this);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.now_playing_list_frag, container, false);

    unbinder = ButterKnife.bind(this, view);

    adapter.setItemClickListener(movieModel -> presenter.onMovieClicked(movieModel));

    recyclerView.setLayoutManager(new NowPlayingListLayoutManager(context()));
    recyclerView.setAdapter(adapter);

    return view;
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    presenter.setView(this);

    if (null == savedInstanceState) {
      loadMovies();
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

  @Override public void onAttach(Context context) {
    super.onAttach(context);

    if (context instanceof NowPlayingListContract.Listener) {
      listener = (NowPlayingListContract.Listener)  context;
    }
  }

  @Override public void onDetach() {
    super.onDetach();
    listener = null;
  }

  @Override public void renderNowPlayingMovies(List<MovieModel> movieModelList) {
    adapter.setMovieModelList(movieModelList);
  }

  @Override public void viewMovieDetail(MovieModel movieModel) {
    if (null != listener) {
      listener.onMovieClicked(movieModel);
    }
  }

  @Override public void showLoading() { }

  @Override public void hideLoading() { }

  @Override public void showRetry() { }

  @Override public void hideRetry() { }

  @Override public void showError(String message) { }

  @Override public Context context() {
    return getActivity().getApplicationContext();
  }

  private void loadMovies() {
    presenter.initialize();
  }
}
