package au.com.subash.cinepedia.casts;

import io.reactivex.Observable;
import java.util.List;

public interface CastDataStore {

  Observable<List<CastEntity>> casts(int movieId);
}
