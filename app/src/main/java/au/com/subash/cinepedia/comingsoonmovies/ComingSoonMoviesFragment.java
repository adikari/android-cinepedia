package au.com.subash.cinepedia.comingsoonmovies;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.movie.MovieModel;
import au.com.subash.cinepedia.view.activity.MainActivityComponent;
import au.com.subash.cinepedia.view.fragment.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.List;
import javax.inject.Inject;

public class ComingSoonMoviesFragment extends BaseFragment implements ComingSoonMoviesContract.View {

  @Inject ComingSoonMoviesAdapter movieCardListAdapter;
  @Inject ComingSoonMoviesPresenter presenter;

  @BindView(R.id.rv_card_list) RecyclerView recyclerView;
  @BindView(R.id.tv_card_view_all) TextView viewAllView;

  private Unbinder unbinder;

  private ComingSoonMoviesContract.Listener listener;

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

    viewAllView.setOnClickListener(v -> presenter.onViewAllClicked());

    movieCardListAdapter.setItemClickListener(
        movieModel -> presenter.onMovieClicked(movieModel)
    );

    recyclerView.setLayoutManager(new ComingSoonMoviesLayoutManager(context()));
    recyclerView.setAdapter(movieCardListAdapter);

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

  @Override public void onAttach(Context context) {
    super.onAttach(context);

    if (context instanceof ComingSoonMoviesContract.Listener) {
      listener = (ComingSoonMoviesContract.Listener) context;
    }
  }

  @Override public void onDetach() {
    super.onDetach();
    listener = null;
  }

  @Override public void renderMovies(List<MovieModel> movieModelList) {
    movieCardListAdapter.setMovieModelList(movieModelList);
  }

  @Override public void viewMovieDetail(MovieModel movieModel) {
    if (null != listener) {
      listener.onMovieClicked(movieModel);
    }
  }

  @Override public void viewAllMovies() {
    if (null != listener) {
      listener.onViewAllComingSoonClicked();
    }
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
