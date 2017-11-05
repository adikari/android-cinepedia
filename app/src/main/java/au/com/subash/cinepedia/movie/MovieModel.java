package au.com.subash.cinepedia.movie;

/**
 * Representation of movie in Presentation layer
 */
public class MovieModel {
  private final int id;
  private String title;
  private String tagline;
  private String status;
  private String imageUrl;
  private double popularity;
  private double rating;

  public MovieModel(int id) {
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

  public String getTagline() {
    return tagline;
  }

  public void setTagline(String tagline) {
    this.tagline = tagline;
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
}