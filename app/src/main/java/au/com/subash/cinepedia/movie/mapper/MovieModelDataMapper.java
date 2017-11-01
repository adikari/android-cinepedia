package au.com.subash.cinepedia.movie.mapper;

import au.com.subash.cinepedia.movie.Movie;
import au.com.subash.cinepedia.movie.MovieModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class MovieModelDataMapper {

  @Inject
  MovieModelDataMapper() { }

  public List<MovieModel> transform(List<Movie> movies) {
    List<MovieModel> movieModelsCollection = new ArrayList<>();

    if (movies != null && !movies.isEmpty()) {
      for (Movie user : movies) {
        movieModelsCollection.add(transform(user));
      }
    }

    return movieModelsCollection;
  }

  public MovieModel transform(Movie movie) {
    MovieModel movieModel = null;

    if (null != movie) {
      movieModel = new MovieModel(movie.getId());
      movieModel.setTitle(movie.getTitle());
      movieModel.setTagline(movie.getTagline());
      movieModel.setImageUrl(movie.getImageUrl());
    }

    return movieModel;
  }
}