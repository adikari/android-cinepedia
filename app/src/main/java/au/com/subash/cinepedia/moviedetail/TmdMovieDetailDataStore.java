package au.com.subash.cinepedia.moviedetail;

import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit2.Retrofit;

@Singleton
public class TmdMovieDetailDataStore implements MovieDetailDataStore {

  TmdMovieDetailService serivce;

  @Inject
  public TmdMovieDetailDataStore(Retrofit retrofit) {
    serivce = retrofit.create(TmdMovieDetailService.class);
  }

  @Override public Observable<MovieDetailEntity> movieDetailEntity(int movieId) {
    return serivce.movieDetail(movieId);
  }
}
