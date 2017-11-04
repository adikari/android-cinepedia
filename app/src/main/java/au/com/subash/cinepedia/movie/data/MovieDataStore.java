package au.com.subash.cinepedia.movie.data;

import java.util.List;
import rx.Observable;

public interface MovieDataStore {

  /**
   * Get an {@link rx.Observable} which will emit a List of {@link MovieEntity}.
   */
  Observable<List<MovieEntity>> movieEntityList();

  /**
   * Get an {@link rx.Observable} which will emit a List of now playing {@link MovieEntity}
   */
  Observable<List<MovieEntity>> nowPlayingMovieEntityList();

  /**
   * Get an {@link rx.Observable} which will emit a List of coming soon {@link MovieEntity}
   */
  Observable<List<MovieEntity>> comingSoonMovieEntityList();

  /**
   * Get an {@link rx.Observable} which will emit a featured show {@link MovieEntity}
   */
  Observable<MovieEntity> getFeaturedShow();

  /**
   * Get an {@link rx.Observable} which will emit a {@link MovieEntity} by its id.
   *
   * @param id The id to retrieve user data.
   */
  Observable<MovieEntity> movieEntityDetails(final int id);
}
