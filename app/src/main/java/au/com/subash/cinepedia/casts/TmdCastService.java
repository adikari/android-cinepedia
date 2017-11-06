package au.com.subash.cinepedia.casts;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TmdCastService {

  @GET("movie/{movieId}/credits")
  Observable<TmdCastResponse> getCasts(@Query("movieId") int movieId);
}
