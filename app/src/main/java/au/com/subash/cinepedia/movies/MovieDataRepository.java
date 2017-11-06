package au.com.subash.cinepedia.movies;

import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

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
    return dataStore.featuredShowMovieEntity().map(mapper::transform);
  }

  @Override public Observable<Movie> movie(int id) {
    return movies().map(list -> list.get(0));
  }
}
