package au.com.subash.cinepedia.movie.data;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of movie in Data layer
 */
public class MovieEntity {

  @SerializedName("id")
  private int id;

  @SerializedName("title")
  private String title;

  @SerializedName("tagline")
  private String tagline;

  @SerializedName("status")
  private String status;

  @SerializedName("poster_path")
  private String imageUrl;

  @SerializedName("popularity")
  private int popularity;

  MovieEntity() {
    // Empty
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

  public int getPopularity() {
    return popularity;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }
}