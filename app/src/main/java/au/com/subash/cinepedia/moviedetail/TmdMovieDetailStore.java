package au.com.subash.cinepedia.moviedetail;

import io.reactivex.Observable;
import javax.inject.Inject;
import retrofit2.Retrofit;

public class TmdMovieDetailStore implements MovieDetailDataStore {

  TmdMovieDetailService serivce;

  @Inject
  public TmdMovieDetailStore(Retrofit retrofit) {
    serivce = retrofit.create(TmdMovieDetailService.class);
  }

  @Override public Observable<MovieDetailEntity> movieDetailEntity() {
    return null;
    // return serivce.movieDetail().map();
  }
}
