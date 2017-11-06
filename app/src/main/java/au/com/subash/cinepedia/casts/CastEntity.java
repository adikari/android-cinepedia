package au.com.subash.cinepedia.casts;

import com.google.gson.annotations.SerializedName;

public class CastEntity {

  @SerializedName("id")
  private int id;

  @SerializedName("cast_id")
  private int castId;

  @SerializedName("character")
  private String character;

  @SerializedName("credit_id")
  private String creditId;

  @SerializedName("gender")
  private Gender gender;

  @SerializedName("name")
  private String name;

  @SerializedName("profile_path")
  private String image;


  public CastEntity() { }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCastId() {
    return castId;
  }

  public void setCastId(int castId) {
    this.castId = castId;
  }

  public String getCharacter() {
    return character;
  }

  public void setCharacter(String character) {
    this.character = character;
  }

  public String getCreditId() {
    return creditId;
  }

  public void setCreditId(String creditId) {
    this.creditId = creditId;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
