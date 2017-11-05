package au.com.subash.cinepedia.movie.data;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface TmdMovieService {

  /**
   * Get an {@link Observable} which will emit a List of now playing {@link MovieEntity}
   */
  @GET("movie/now_playing")
  Observable<TmdMovieResponse> nowPlayingMovies();

  /**
   * Get an {@link Observable} which will emit a List of coming soon {@link MovieEntity}
   */
  @GET("movie/upcoming")
  Observable<TmdMovieResponse> upcomingMovies();
}
