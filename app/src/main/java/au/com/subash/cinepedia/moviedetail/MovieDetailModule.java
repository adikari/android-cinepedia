package au.com.subash.cinepedia.moviedetail;

import au.com.subash.cinepedia.core.di.PerActivity;
import au.com.subash.cinepedia.interactor.UseCase;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
class MovieDetailModule {
  @Provides @PerActivity @Named("getMovieDetail") UseCase
  provideGetMovieDetailUserCase(GetMovieDetail getMovieDetail) {
    return getMovieDetail;
  }
}
