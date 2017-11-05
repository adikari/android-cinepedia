package au.com.subash.cinepedia.moviedetail;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TmdMovieDetailService {

  @GET("movie/{movieId}")
  Observable<MovieDetailEntity> movieDetail(@Path("movieId") int movieId);
}
