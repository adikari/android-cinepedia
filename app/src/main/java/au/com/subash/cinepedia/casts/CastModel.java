package au.com.subash.cinepedia.casts;

public class CastModel {

  private int id;
  private int castId;
  private String character;
  private String creditId;
  private Gender gender;
  private String name;
  private String image;

  public CastModel(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
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
