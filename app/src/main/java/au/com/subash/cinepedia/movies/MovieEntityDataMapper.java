package au.com.subash.cinepedia.movies;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

class MovieEntityDataMapper {

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
      movie.setOverview(movieEntity.getOverview());
      movie.setImageUrl(movieEntity.getImageUrl());
      movie.setPopularity(movieEntity.getPopularity());
      movie.setRating(movieEntity.getRating());
      movie.setReleaseDate(movieEntity.getReleaseDate());
    }

    return movie;
  }
}