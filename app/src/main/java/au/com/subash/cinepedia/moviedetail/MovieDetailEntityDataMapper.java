package au.com.subash.cinepedia.moviedetail;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MovieDetailEntityDataMapper {

  @Inject
  public MovieDetailEntityDataMapper() { }

  List<MovieDetail> transform(List<MovieDetailEntity> movieDetailEntities) {

    List<MovieDetail> movieDetails = new ArrayList<>();

    if (movieDetailEntities != null && !movieDetailEntities.isEmpty()) {
      for (MovieDetailEntity movieDetail : movieDetailEntities) {
        movieDetails.add(transform(movieDetail));
      }
    }

    return movieDetails;
  }

  MovieDetail transform(MovieDetailEntity movieDetailEntity) {
    MovieDetail movieDetail = null;

    if (null != movieDetailEntity) {
      movieDetail = new MovieDetail(movieDetailEntity.getId());
      movieDetail.setBudget(movieDetailEntity.getBudget());
      movieDetail.setHomepage(movieDetailEntity.getHomepage());
      movieDetail.setOverview(movieDetailEntity.getOverview());
      movieDetail.setPopularity(movieDetailEntity.getPopularity());
      movieDetail.setImageUrl(movieDetailEntity.getImageUrl());
      movieDetail.setStatus(movieDetailEntity.getStatus());
      movieDetail.setRating(movieDetailEntity.getRating());
      movieDetail.setReleaseDate(movieDetailEntity.getReleaseDate());
      movieDetail.setRevenue(movieDetailEntity.getRevenue());
      movieDetail.setRuntime(movieDetailEntity.getRuntime());
      movieDetail.setTitle(movieDetailEntity.getTitle());
      movieDetail.setTagline(movieDetailEntity.getTagline());
    }

    return  movieDetail;
  }
}
