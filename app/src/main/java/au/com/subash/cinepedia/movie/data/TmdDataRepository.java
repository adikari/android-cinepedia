package au.com.subash.cinepedia.movie.data;

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
    return null;
  }

  @Override public Observable<List<MovieEntity>> nowPlayingMovieEntityList() {
    return null;
  }

  @Override public Observable<List<MovieEntity>> comingSoonMovieEntityList() {
    return null;
  }

  @Override public Observable<MovieEntity> getFeaturedShow() {
    Observable<TmdMovieResponse> response = tmdMovieService.getFeaturedShow();

    return null;
  }

  @Override public Observable<MovieEntity> movieEntityDetails(int id) {
    return null;
  }
}
