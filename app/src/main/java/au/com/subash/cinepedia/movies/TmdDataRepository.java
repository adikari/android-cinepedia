package au.com.subash.cinepedia.movies;

import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Retrofit;

public class TmdDataRepository implements MovieDataStore {

  private TmdMovieService tmdMovieService;

  @Inject
  public TmdDataRepository(Retrofit retrofit) {
    tmdMovieService = retrofit.create(TmdMovieService.class);
  }

  @Override public Observable<List<MovieEntity>> movieEntityList() {
    throw new UnsupportedOperationException("movieEntityList method is not implemented");
  }

  @Override public Observable<List<MovieEntity>> nowPlayingMovieEntityList() {
    return tmdMovieService.nowPlayingMovies().map(TmdMovieResponse::getResults);
  }

  @Override public Observable<List<MovieEntity>> comingSoonMovieEntityList() {
    return tmdMovieService.upcomingMovies().map(TmdMovieResponse::getResults);
  }

  @Override public Observable<MovieEntity> featuredShowMovieEntity() {
    return tmdMovieService.upcomingMovies().map(response -> response.getResults().get(0));
  }

  @Override public Observable<MovieEntity> movieEntityDetails(int id) {
    throw new UnsupportedOperationException("movieEntityDetails method is not implemented");
  }
}
