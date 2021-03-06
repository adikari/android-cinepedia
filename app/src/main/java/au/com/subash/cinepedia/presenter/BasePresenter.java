package au.com.subash.cinepedia.presenter;

/**
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 */
public interface BasePresenter {
  /**
   * Method that control the lifecycle of the view. It should be called in the view's
   * (Activity or Fragment) onResume() method.
   */
  void resume();

  /**
   * Method that control the lifecycle of the view. It should be called in the view's
   * (Activity or Fragment) onPause() method.
   */
  void pause();

  /**
   * Method that control the lifecycle of the view. It should be called in the view's
   * (Activity or Fragment) onDestroy() method.
   */
  void destroy();

  /**
   * Method to initialize the presenter. It should be called in view's
   * (Activity or Fragment) viewCreated() method
   */
  void initialize();
}
