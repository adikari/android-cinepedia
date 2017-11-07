package au.com.subash.cinepedia.moviedetail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.util.TmdImage;
import au.com.subash.cinepedia.view.fragment.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

public class MovieDetailFragment extends BaseFragment implements MovieDetailContract.View {

  @Inject MovieDetailPresenter presenter;

  @BindView(R.id.tv_movie_detail_title) TextView title;
  @BindView(R.id.iv_movie_detail_image) ImageView backdropImage;
  @BindView(R.id.tv_movie_detail_overview) TextView tvOverview;
  @BindView(R.id.tv_movie_release_date) TextView releaseDate;
  @BindView(R.id.tv_movie_runtime) TextView runtime;
  @BindView(R.id.tv_movie_status) TextView status;
  @BindView(R.id.tv_movie_rating) TextView rating;

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

    if (null == savedInstanceState) {
      loadMovieDetail();
    }
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
    if (null == movieDetailModel) {
      return;
    }

    String imageUrl = TmdImage.getImageUrl(movieDetailModel.getBackdropPath(), 500);

    Picasso.with(context()).load(imageUrl).into(backdropImage);

    title.setText(movieDetailModel.getTitle());
    tvOverview.setText(movieDetailModel.getOverview());
    status.setText(movieDetailModel.getStatus());
    rating.setText(String.valueOf(movieDetailModel.getRating()));
    runtime.setText(movieDetailModel.getRuntime());
    releaseDate.setText(movieDetailModel.getReleaseDate());
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

  private void loadMovieDetail() {
    presenter.initialize();
  }

}
