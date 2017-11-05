package au.com.subash.cinepedia.moviedetail;

import io.reactivex.Observable;

public interface MovieDetailDataStore {
  Observable<MovieDetailEntity> movieDetailEntity(int movieId);
}
