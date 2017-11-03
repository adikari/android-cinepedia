package au.com.subash.cinepedia.featuredshow;

import au.com.subash.cinepedia.interactor.UseCase;
import javax.inject.Inject;
import javax.inject.Named;

public class FeaturedShowPresenter implements FeaturedShowContract.Presenter {

  private FeaturedShowContract.View view;

  private final UseCase getFeaturedShowUseCase;

  @Inject
  public FeaturedShowPresenter(@Named("getFeaturedShow") UseCase getFeaturedShowUseCase) {
    this.getFeaturedShowUseCase = getFeaturedShowUseCase;
  }

  public void setView(FeaturedShowContract.View view) {
    this.view = view;
  }

  @Override public void resume() { }

  @Override public void pause() { }

  @Override public void destroy() {
    view = null;
  }

  @Override public void initialize() {

  }
}
