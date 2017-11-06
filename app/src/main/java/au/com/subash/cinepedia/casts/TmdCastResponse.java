package au.com.subash.cinepedia.casts;

import com.google.gson.annotations.SerializedName;
import java.util.List;

class TmdCastResponse {
  @SerializedName("id")
  private int id;

  @SerializedName("cast")
  private List<CastEntity> casts;

  public int getId() {
    return id;
  }

  public List<CastEntity> getCasts() {
    return casts;
  }
}
