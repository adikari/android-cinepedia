package au.com.subash.cinepedia.casts;

import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

public class CastDataRepository implements CastRepository {

  private final CastDataStore store;
  private final CastEntityDataMapper mapper;

  @Inject
  public CastDataRepository(CastDataStore store, CastEntityDataMapper mapper) {
    this.store = store;
    this.mapper = mapper;
  }

  @Override public Observable<List<Cast>> casts(int movieId) {
    return store.casts(movieId).map(mapper::transform);
  }
}
