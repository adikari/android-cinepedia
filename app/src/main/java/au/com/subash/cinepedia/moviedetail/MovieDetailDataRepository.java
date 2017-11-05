package au.com.subash.cinepedia.moviedetail;

import io.reactivex.Observable;
import javax.inject.Inject;

public class MovieDetailDataRepository implements MovieDetailRepository {

  @Inject
  MovieDetailDataRepository() {

  }

  @Override public Observable<MovieDetail> movieDetail() {
    return null;
  }
}
