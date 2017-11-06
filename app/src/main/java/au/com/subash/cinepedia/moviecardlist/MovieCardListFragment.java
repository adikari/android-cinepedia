package au.com.subash.cinepedia.moviecardlist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.movie.MovieModel;
import au.com.subash.cinepedia.view.fragment.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.List;
import javax.inject.Inject;

public abstract class MovieCardListFragment extends BaseFragment implements MovieCardListContract.View {

  @Inject MovieCardListLayoutManager layoutManager;
  @Inject MovieCardListAdapter movieCardListAdapter;

  @BindView(R.id.rv_card_list) RecyclerView recyclerView;
  @BindView(R.id.tv_card_list_title) TextView titleView;
  @BindView(R.id.tv_card_view_all) TextView viewAllView;

  protected static final String PARAM_TITLE = "com.au.subash.cinepedia.CARD_LIST_FRAG_TITLE_PARAM";

  private Unbinder unbinder;
  private String fragmentTitle;

  private MovieCardListContract.Listener listener;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Bundle args = getArguments();
    fragmentTitle = args.getString(PARAM_TITLE, "");
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.card_list_frag, container, false);

    unbinder = ButterKnife.bind(this, view);

    titleView.setText(fragmentTitle);

    viewAllView.setOnClickListener(v -> getPresenter().onViewAllClicked());

    movieCardListAdapter.setItemClickListener(
        movieModel -> getPresenter().onMovieClicked(movieModel)
    );

    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(movieCardListAdapter);

    return view;
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    getPresenter().setView(this);

    if (null == savedInstanceState) {
      loadComingSoonMovies();
    }
  }

  @Override public void onResume() {
    super.onResume();
    getPresenter().resume();
  }

  @Override public void onPause() {
    super.onPause();
    getPresenter().pause();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    getPresenter().destroy();
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);

    if (context instanceof MovieCardListContract.Listener) {
      listener = (MovieCardListContract.Listener) context;
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
    getPresenter().initialize();
  }
}
