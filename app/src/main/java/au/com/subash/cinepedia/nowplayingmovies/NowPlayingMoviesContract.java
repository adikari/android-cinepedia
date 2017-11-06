package au.com.subash.cinepedia.nowplayingmovies;

import au.com.subash.cinepedia.moviecardlist.MovieCardListContract;

public interface NowPlayingMoviesContract {

  interface View extends MovieCardListContract.View {

  }

  interface Presenter extends MovieCardListContract.Presenter {

  }

  interface Listener extends MovieCardListContract.Listener {
    void onViewAllNowPlayingClicked();
  }
}
