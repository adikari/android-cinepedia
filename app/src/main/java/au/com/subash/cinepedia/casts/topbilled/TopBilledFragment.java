package au.com.subash.cinepedia.casts.topbilled;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.casts.CastModel;
import au.com.subash.cinepedia.moviedetail.MovieDetailComponent;
import au.com.subash.cinepedia.view.fragment.BaseFragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.List;
import javax.inject.Inject;

public class TopBilledFragment extends BaseFragment implements TopBilledContract.View {

  @Inject TopBilledPresenter presenter;

  private TopBilledContract.Listener listener;
  private Unbinder unbinder;

  public static TopBilledFragment getInstance() {
    return new TopBilledFragment();
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);

    if (context instanceof TopBilledContract.Listener) {
      listener = (TopBilledContract.Listener) context;
    } else {
      throw new ClassCastException("Must implement TopBilledContract.Listener");
    }
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    getComponent(MovieDetailComponent.class).inject(this);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.top_billed_cast_frag, container, false);

    unbinder = ButterKnife.bind(this, view);

    // set up adapter here

    return view;
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    presenter.setView(this);

    if (null == savedInstanceState) {
      loadCasts();
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
    listener = null;
  }

  @Override public void renderCasts(List<CastModel> castModelList) {

  }

  @Override public void viewCast(CastModel castModel) {
    if (null != listener) {
      listener.onCastClicked(castModel);
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

  private void loadCasts() {
    presenter.initialize();
  }
}
