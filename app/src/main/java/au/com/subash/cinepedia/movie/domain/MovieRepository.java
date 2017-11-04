package au.com.subash.cinepedia.movie.domain;

import java.util.List;
import rx.Observable;

/**
 * Interface that represents a Repository for getting {@link Movie} related data.
 */
public interface MovieRepository {

  /**
   * Get an {@link rx.Observable} which will emit a List of {@link Movie}.
   */
  Observable<List<Movie>> movies();

  /**
   * Get an {@link rx.Observable} which will emit a List of now playing {@link Movie}.
   */
  Observable<List<Movie>> nowPlayingMovies();

  /**
   * Get an {@link rx.Observable} which will emit a List of coming soon playing {@link Movie}.
   */
  Observable<List<Movie>> comingSoonMovies();

  /**
   * Get an {@link rx.Observable} which will emit a featured show {@link Movie}
   *
   * @return {@link rx.Observable}
   */
  Observable<Movie> featuredShow();

  /**
   * Get an {@link rx.Observable} which will emit a {@link Movie}.
   *
   * @param id The movie id used to retrieve movie data.
   */
  Observable<Movie> movie(final int id);
}
