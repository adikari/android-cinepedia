package au.com.subash.cinepedia.moviedetail;

import io.reactivex.Observable;

public interface TmdMovieDetailService {

  Observable<TmdMovieDetailApiResponse> movieDetail();
}
