package au.com.subash.cinepedia.movie.data;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface TmdMovieService {

  /**
   * Get an {@link io.reactivex.Observable} which will emit a List of {@link MovieEntity}.
   */
  Observable<TmdMovieResponse> movieEntityList();

  /**
   * Get an {@link Observable} which will emit a List of now playing {@link MovieEntity}
   */
  @GET("movie/now_playing")
  Observable<TmdMovieResponse> nowPlayingMovieEntityList();

  /**
   * Get an {@link Observable} which will emit a List of coming soon {@link MovieEntity}
   */
  @GET("movie/upcoming")
  Observable<TmdMovieResponse> comingSoonMovieEntityList();

  /**
   * Get an {@link Observable} which will emit a featured show {@link MovieEntity}
   */
  Observable<TmdMovieResponse> getFeaturedShow();

  /**
   * Get an {@link Observable} which will emit a {@link MovieEntity} by its id.
   *
   * @param id The id to retrieve user data.
   */
  Observable<TmdMovieResponse> movieEntityDetails(final int id);
}
