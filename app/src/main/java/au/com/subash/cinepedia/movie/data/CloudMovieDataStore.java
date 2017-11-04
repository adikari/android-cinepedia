package au.com.subash.cinepedia.movie.data;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

public class CloudMovieDataStore implements MovieDataStore {

  @Inject
  public CloudMovieDataStore() { }

  @Override public Observable<List<MovieEntity>> movieEntityList() {
    ArrayList<MovieEntity> lists = new ArrayList<>();

    MovieEntity movieEntity = new MovieEntity();
    movieEntity.setTitle("movie 1");
    movieEntity.setImageUrl("https://placeimg.com/640/480/any");
    movieEntity.setPopularity(1);
    movieEntity.setTagline("awesome movie");

    MovieEntity movieEntity1 = new MovieEntity();
    movieEntity1.setTitle("movie 2");
    movieEntity1.setImageUrl("https://placeimg.com/640/480/any");
    movieEntity1.setPopularity(2);
    movieEntity1.setTagline("awesome movie 2");

    lists.add(movieEntity);
    lists.add(movieEntity1);

    return Observable.just(lists);
  }

  @Override public Observable<List<MovieEntity>> nowPlayingMovieEntityList() {
    return movieEntityList();
  }

  @Override public Observable<MovieEntity> movieEntityDetails(int id) {
    MovieEntity movieEntity = new MovieEntity();

    return Observable.just(movieEntity);
  }
}
