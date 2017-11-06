package au.com.subash.cinepedia.casts;

import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit2.Retrofit;

@Singleton
public class TmdCastDataStore implements CastDataStore {

  private final TmdCastService service;

  @Inject
  TmdCastDataStore(Retrofit retrofit) {
    service = retrofit.create(TmdCastService.class);
  }

  @Override public Observable<List<CastEntity>> casts(int movieId) {
    return service.getCasts(movieId).map(TmdCastResponse::getCasts);
  }
}
