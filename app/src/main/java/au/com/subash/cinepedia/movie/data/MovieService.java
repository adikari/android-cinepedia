package au.com.subash.cinepedia.movie.data;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MovieService {

  /**
   * Get an {@link io.reactivex.Observable} which will emit a List of {@link MovieEntity}.
   */
  Observable<MovieResponse> movieEntityList();

  /**
   * Get an {@link Observable} which will emit a List of now playing {@link MovieEntity}
   */
  @GET("movie/now_playing")
  Observable<MovieResponse> nowPlayingMovieEntityList();

  /**
   * Get an {@link Observable} which will emit a List of coming soon {@link MovieEntity}
   */
  @GET("movie/upcoming")
  Observable<MovieResponse> comingSoonMovieEntityList();

  /**
   * Get an {@link Observable} which will emit a featured show {@link MovieEntity}
   */
  Observable<MovieResponse> getFeaturedShow();

  /**
   * Get an {@link Observable} which will emit a {@link MovieEntity} by its id.
   *
   * @param id The id to retrieve user data.
   */
  Observable<MovieResponse> movieEntityDetails(final int id);
}
