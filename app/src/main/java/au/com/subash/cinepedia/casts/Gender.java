package au.com.subash.cinepedia.casts;

import com.google.gson.annotations.SerializedName;

public enum Gender {
  @SerializedName("1")
  FEMALE(1),

  @SerializedName("2")
  MALE(2);

  private final int genderId;

  Gender(int genderId) {
    this.genderId = genderId;
  }

  public int getGenderId() {
    return genderId;
  }
}
