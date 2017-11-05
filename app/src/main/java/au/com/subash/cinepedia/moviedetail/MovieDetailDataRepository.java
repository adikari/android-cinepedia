package au.com.subash.cinepedia.moviedetail;

import io.reactivex.Observable;
import javax.inject.Inject;

public class MovieDetailDataRepository implements MovieDetailRepository {

  private final MovieDetailDataStore store;
  private final MovieDetailEntityDataMapper mapper;

  @Inject
  MovieDetailDataRepository(MovieDetailDataStore movieDetailDataStore,
      MovieDetailEntityDataMapper mapper) {
    store = movieDetailDataStore;
    this.mapper = mapper;
  }

  @Override public Observable<MovieDetail> movieDetail(int movieId) {
    return store.movieDetailEntity(movieId).map(mapper::transform);
  }
}
