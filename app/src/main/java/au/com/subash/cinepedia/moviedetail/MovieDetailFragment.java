package au.com.subash.cinepedia.moviedetail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.view.fragment.BaseFragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import javax.inject.Inject;

public class MovieDetailFragment extends BaseFragment implements MovieDetailContract.View {

  @Inject MovieDetailPresenter presenter;

  private Unbinder unbinder;

  public MovieDetailFragment() {
    setRetainInstance(true);
  }

  public static MovieDetailFragment getInstance() {
    return new MovieDetailFragment();
  }


  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent(MovieDetailComponent.class).inject(this);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.movie_detail_frag, container, false);

    unbinder = ButterKnife.bind(this, view);

    return view;
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    presenter.setView(this);

    if (null != savedInstanceState) {
      loadMovieDetail();
    }
  }

  private void loadMovieDetail() {
    presenter.initialize();
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
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

  @Override public void renderMovieDetail(MovieDetailModel movieDetailModel) {

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
}
