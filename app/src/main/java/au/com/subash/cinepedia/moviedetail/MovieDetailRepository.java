package au.com.subash.cinepedia.moviedetail;

import io.reactivex.Observable;

public interface MovieDetailRepository {

  Observable<MovieDetail> movieDetail(int movieId);
}
