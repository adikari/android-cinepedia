package au.com.subash.cinepedia.movies;

/**
 * Representation of movie in domain layer
 */
public class Movie {

  private final int id;
  private String title;
  private String overview;
  private String status;
  private String imageUrl;
  private double popularity;
  private double rating;
  private String releaseDate;

  public Movie(int id) {
    this.id = id;
  }

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
}