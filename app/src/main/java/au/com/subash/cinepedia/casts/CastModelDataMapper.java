package au.com.subash.cinepedia.casts;

import java.util.ArrayList;
import java.util.List;

public class CastModelDataMapper {

  public static CastModel transform(Cast cast) {
    CastModel castModel = null;

    if (null != cast) {
      castModel = new CastModel(cast.getId());

      castModel.setCastId(cast.getCastId());
      castModel.setCharacter(cast.getCharacter());
      castModel.setCreditId(cast.getCreditId());
      castModel.setGender(cast.getGender());
      castModel.setName(cast.getName());
      castModel.setImage(cast.getImage());
    }

    return castModel;
  }

  public static List<CastModel> transform(List<Cast> castList) {
    List<CastModel> castModelList = new ArrayList<>();

    if (castList != null && !castList.isEmpty()) {
      for (Cast cast : castList) {
        castModelList.add(transform(cast));
      }
    }

    return castModelList;
  }
}