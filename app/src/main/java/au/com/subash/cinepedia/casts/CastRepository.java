package au.com.subash.cinepedia.casts;

import io.reactivex.Observable;
import java.util.List;

public interface CastRepository {

  Observable<List<Cast>> casts(int movieId);
}
