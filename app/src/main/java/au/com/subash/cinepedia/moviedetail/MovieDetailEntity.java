package au.com.subash.cinepedia.moviedetail;

import com.google.gson.annotations.SerializedName;

public class MovieDetailEntity {

  @SerializedName("id")
  private int id;

  @SerializedName("budget")
  private int budget;

  @SerializedName("homepage")
  private String homepage;

  private String overview;

  private double popularity;

  @SerializedName("poster_path")
  private String imageUrl;

  @SerializedName("status")
  private String status;

  @SerializedName("vote_average")
  private double rating;

  @SerializedName("release_date")
  private String releaseDate;

  @SerializedName("revenue")
  private int revenue;

  @SerializedName("runtime")
  private int runtime;

  @SerializedName("title")
  private String title;

  @SerializedName("tagline")
  private String tagline;

  @SerializedName("backdrop_path")
  private String backdropPath;

  public MovieDetailEntity() { }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getBudget() {
    return budget;
  }

  public void setBudget(int budget) {
    this.budget = budget;
  }

  public String getHomepage() {
    return homepage;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public double getPopularity() {
    return popularity;
  }

  public void setPopularity(double popularity) {
    this.popularity = popularity;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public int getRevenue() {
    return revenue;
  }

  public void setRevenue(int revenue) {
    this.revenue = revenue;
  }

  public int getRuntime() {
    return runtime;
  }

  public void setRuntime(int runtime) {
    this.runtime = runtime;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTagline() {
    return tagline;
  }

  public void setTagline(String tagline) {
    this.tagline = tagline;
  }

  public String getBackdropPath() {
    return backdropPath;
  }

  public void setBackdropPath(String backdropPath) {
    this.backdropPath = backdropPath;
  }
}
