package au.com.subash.cinepedia.movies.nowplaying;

import au.com.subash.cinepedia.core.di.PerActivity;
import au.com.subash.cinepedia.interactor.UseCase;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
public class NowPlayingModule {

  @Provides @PerActivity @Named("getNowPlayingMovies") UseCase
  provideGetNowPlayingMovies(GetNowPlayingMovies getNowPlayingMovies) {
    return getNowPlayingMovies;
  }
}
