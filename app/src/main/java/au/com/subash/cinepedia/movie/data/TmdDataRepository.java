package au.com.subash.cinepedia.movie.data;

import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Retrofit;

public class TmdDataRepository implements MovieDataStore {

  private MovieService movieService;

  @Inject
  public TmdDataRepository(Retrofit retrofit) {
    movieService = retrofit.create(MovieService.class);
  }

  @Override public Observable<List<MovieEntity>> movieEntityList() {
    return null;
  }

  @Override public Observable<List<MovieEntity>> nowPlayingMovieEntityList() {
    return null;
  }

  @Override public Observable<List<MovieEntity>> comingSoonMovieEntityList() {
    return null;
  }

  @Override public Observable<MovieEntity> getFeaturedShow() {
    Observable<MovieResponse> response = movieService.getFeaturedShow();

    return null;
  }

  @Override public Observable<MovieEntity> movieEntityDetails(int id) {
    return null;
  }
}
