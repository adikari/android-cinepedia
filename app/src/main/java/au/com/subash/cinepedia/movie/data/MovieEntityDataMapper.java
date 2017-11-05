package au.com.subash.cinepedia.movie.data;

import au.com.subash.cinepedia.movie.domain.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class MovieEntityDataMapper {

  private static final String imageUrl = "https://image.tmdb.org/t/p/w500/";
  @Inject MovieEntityDataMapper() { }

  List<Movie> transform(List<MovieEntity> movieEntities) {
    List<Movie> movies = new ArrayList<>();

    if (movieEntities != null && !movieEntities.isEmpty()) {
      for (MovieEntity movie : movieEntities) {
        movies.add(transform(movie));
      }
    }

    return movies;
  }

  Movie transform(MovieEntity movieEntity) {
    Movie movie = null;

    if (null != movieEntity) {
      movie = new Movie(movieEntity.getId());
      movie.setTitle(movieEntity.getTitle());
      movie.setTagline(movieEntity.getTagline());
      movie.setImageUrl(imageUrl + movieEntity.getImageUrl());
      movie.setPopularity((int) movieEntity.getPopularity());
    }

    return movie;
  }
}