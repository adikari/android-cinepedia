package au.com.subash.cinepedia.movies;

import io.reactivex.Observable;
import java.util.List;

public interface MovieDataStore {

  /**
   * Get an {@link io.reactivex.Observable} which will emit a List of {@link MovieEntity}.
   */
  Observable<List<MovieEntity>> movieEntityList();

  /**
   * Get an {@link Observable} which will emit a List of now playing {@link MovieEntity}
   */
  Observable<List<MovieEntity>> nowPlayingMovieEntityList();

  /**
   * Get an {@link Observable} which will emit a List of coming soon {@link MovieEntity}
   */
  Observable<List<MovieEntity>> comingSoonMovieEntityList();

  /**
   * Get an {@link Observable} which will emit a featured show {@link MovieEntity}
   */
  Observable<MovieEntity> featuredShowMovieEntity();

  /**
   * Get an {@link Observable} which will emit a {@link MovieEntity} by its id.
   *
   * @param id The id to retrieve user data.
   */
  Observable<MovieEntity> movieEntityDetails(final int id);
}
