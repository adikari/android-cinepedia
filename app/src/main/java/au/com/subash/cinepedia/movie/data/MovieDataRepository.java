package au.com.subash.cinepedia.movie.data;

import au.com.subash.cinepedia.movie.domain.Movie;
import au.com.subash.cinepedia.movie.domain.MovieRepository;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

public class MovieDataRepository implements MovieRepository {

  private MovieDataStore dataStore;
  private MovieEntityDataMapper mapper;

  @Inject
  public MovieDataRepository(MovieDataStore dataStore, MovieEntityDataMapper mapper) {
    this.dataStore = dataStore;
    this.mapper = mapper;
  }

  @Override public Observable<List<Movie>> movies() {
    return dataStore.movieEntityList().map(mapper::transform);
  }

  @Override public Observable<List<Movie>> nowPlayingMovies() {
    return dataStore.nowPlayingMovieEntityList().map(mapper::transform);
  }

  @Override public Observable<List<Movie>> comingSoonMovies() {
    return dataStore.comingSoonMovieEntityList().map(mapper::transform);
  }

  @Override public Observable<Movie> featuredShow() {
    return dataStore.getFeaturedShow().map(mapper::transform);
  }

  @Override public Observable<Movie> movie(int id) {
    return movies().map(list -> list.get(0));
  }
}
