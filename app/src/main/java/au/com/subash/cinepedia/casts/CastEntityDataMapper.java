package au.com.subash.cinepedia.casts;

import java.util.ArrayList;
import java.util.List;

public class CastEntityDataMapper {

  public static Cast transform(CastEntity castEntity) {
    Cast cast = null;

    if (null != castEntity) {
      cast = new Cast(castEntity.getId());
      cast.setCastId(castEntity.getCastId());
      cast.setCharacter(castEntity.getCharacter());
      cast.setCreditId(castEntity.getCreditId());
      cast.setGender(castEntity.getGender());
      cast.setName(castEntity.getName());
      cast.setImage(castEntity.getImage());
    }

    return cast;
  }

  public static List<Cast> transform(List<CastEntity> castEntityList) {
    List<Cast> castList = new ArrayList<>();

    if (castEntityList != null && !castEntityList.isEmpty()) {
      for (CastEntity castEntity : castEntityList) {
        castList.add(transform(castEntity));
      }
    }

    return castList;
  }
}
