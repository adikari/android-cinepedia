package au.com.subash.cinepedia.movies;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of movie in Data layer
 */
public class MovieEntity {

  @SerializedName("id")
  private int id;

  @SerializedName("title")
  private String title;

  @SerializedName("overview")
  private String overview;

  @SerializedName("status")
  private String status;

  @SerializedName("poster_path")
  private String imageUrl;

  @SerializedName("popularity")
  private double popularity;

  @SerializedName("vote_average")
  private double rating;

  @SerializedName("release_date")
  private String releaseDate;

  @SerializedName("backdrop_path")
  private String backdropPath;

  MovieEntity() { }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public double getPopularity() {
    return popularity;
  }

  public void setPopularity(double popularity) {
    this.popularity = popularity;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getBackdropPath() {
    return backdropPath;
  }

  public void setBackdropPath(String backdropPath) {
    this.backdropPath = backdropPath;
  }
}