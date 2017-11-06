package au.com.subash.cinepedia.movie;

import io.reactivex.Observable;
import java.util.List;

/**
 * Interface that represents a Repository for getting {@link Movie} related data.
 */
public interface MovieRepository {

  /**
   * Get an {@link Observable} which will emit a List of {@link Movie}.
   */
  Observable<List<Movie>> movies();

  /**
   * Get an {@link Observable} which will emit a List of now playing {@link Movie}.
   */
  Observable<List<Movie>> nowPlayingMovies();

  /**
   * Get an {@link Observable} which will emit a List of coming soon playing {@link Movie}.
   */
  Observable<List<Movie>> comingSoonMovies();

  /**
   * Get an {@link Observable} which will emit a featured show {@link Movie}
   *
   * @return {@link Observable}
   */
  Observable<Movie> featuredShow();

  /**
   * Get an {@link Observable} which will emit a {@link Movie}.
   *
   * @param id The movie id used to retrieve movie data.
   */
  Observable<Movie> movie(final int id);
}
