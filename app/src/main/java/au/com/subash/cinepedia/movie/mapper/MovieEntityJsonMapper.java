package au.com.subash.cinepedia.movie.mapper;

import com.google.gson.Gson;
import javax.inject.Inject;

class MovieEntityJsonMapper  {
  private Gson gson;

  @Inject
  MovieEntityJsonMapper(Gson gson) {
    this.gson = gson;
  }
}