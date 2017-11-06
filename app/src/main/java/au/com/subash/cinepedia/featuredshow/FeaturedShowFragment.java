package au.com.subash.cinepedia.featuredshow;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.movies.MovieModel;
import au.com.subash.cinepedia.util.TmdImage;
import au.com.subash.cinepedia.view.activity.MainActivityComponent;
import au.com.subash.cinepedia.view.fragment.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

public class FeaturedShowFragment extends BaseFragment implements FeaturedShowContract.View {

  @Inject FeaturedShowPresenter presenter;

  @BindView(R.id.iv_featured_image) ImageView featuredImage;
  @BindView(R.id.tv_featured_title) TextView title;

  private Unbinder unbinder;
  private FeaturedShowContract.Listener listener;

  public FeaturedShowFragment() {
    setRetainInstance(true);
  }

  public static Fragment getInstance() {
    return new FeaturedShowFragment();
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.getComponent(MainActivityComponent.class).inject(this);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.featured_frag, container, false);

    unbinder = ButterKnife.bind(this, view);

    return view;
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    presenter.setView(this);

    if (null == savedInstanceState) {
      loadFeaturedShow();
    }
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  @Override public void onResume() {
    super.onResume();
    presenter.resume();
  }

  @Override public void onPause() {
    super.onPause();
    presenter.pause();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    presenter.destroy();
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);

    if (context instanceof FeaturedShowContract.Listener) {
      listener = (FeaturedShowContract.Listener) context;
    }
  }

  @Override public void onDetach() {
    super.onDetach();
    listener = null;
  }

  @Override public void renderFeaturedShow(MovieModel movieModel) {
    if (null == movieModel) { return; }

    String imageUrl = TmdImage.getImageUrl(movieModel.getImageUrl(), 185);

    Picasso.with(context())
        .load(imageUrl)
        .into(featuredImage);

    title.setText(movieModel.getTitle());

    featuredImage.setOnClickListener(v -> presenter.onMovieClicked(movieModel));
  }

  @Override public void viewFeaturedShow(MovieModel movieModel) {
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

  private void loadFeaturedShow() {
    presenter.initialize();
  }
}
