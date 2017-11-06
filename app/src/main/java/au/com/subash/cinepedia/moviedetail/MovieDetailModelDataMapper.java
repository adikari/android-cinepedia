package au.com.subash.cinepedia.moviedetail;

import au.com.subash.cinepedia.core.di.PerActivity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@PerActivity
class MovieDetailModelDataMapper {

  @Inject
  MovieDetailModelDataMapper() { }

  List<MovieDetailModel> transform(List<MovieDetail> movieDetailList) {
    ArrayList<MovieDetailModel> movieDetailModelList = new ArrayList<>();

    if (movieDetailList != null && !movieDetailList.isEmpty()) {
      for (MovieDetail movieDetail : movieDetailList) {
        movieDetailModelList.add(transform(movieDetail));
      }
    }

    return movieDetailModelList;
  }

  MovieDetailModel transform(MovieDetail movieDetail) {
    MovieDetailModel movieDetailModel = null;

    if (null != movieDetail) {
      movieDetailModel = new MovieDetailModel(movieDetail.getId());
      movieDetailModel.setBudget(movieDetail.getBudget());
      movieDetailModel.setHomepage(movieDetail.getHomepage());
      movieDetailModel.setOverview(movieDetail.getOverview());
      movieDetailModel.setPopularity(movieDetail.getPopularity());
      movieDetailModel.setImageUrl(movieDetail.getImageUrl());
      movieDetailModel.setStatus(movieDetail.getStatus());
      movieDetailModel.setRating(movieDetail.getRating());
      movieDetailModel.setReleaseDate(movieDetail.getReleaseDate());
      movieDetailModel.setRevenue(movieDetail.getRevenue());
      movieDetailModel.setRuntime(movieDetail.getRuntime());
      movieDetailModel.setTitle(movieDetail.getTitle());
      movieDetailModel.setTagline(movieDetail.getTagline());
    }

    return movieDetailModel;
  }
}
