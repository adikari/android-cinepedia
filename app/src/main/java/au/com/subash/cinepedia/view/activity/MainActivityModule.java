package au.com.subash.cinepedia.view.activity;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import au.com.subash.cinepedia.comingsoonmovies.GetComingSoonMovies;
import au.com.subash.cinepedia.core.di.PerActivity;
import au.com.subash.cinepedia.featuredshow.GetFeaturedShow;
import au.com.subash.cinepedia.interactor.UseCase;
import au.com.subash.cinepedia.cardview.CardListLayoutManager;
import au.com.subash.cinepedia.nowplayingmovies.GetNowPlayingMovies;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
class MainActivityModule {

  @Provides @PerActivity @Named("getNowPlayingMovies") UseCase
  provideGetNowPlayingMovies(GetNowPlayingMovies getNowPlayingMovies) {
    return getNowPlayingMovies;
  }

  @Provides @PerActivity @Named("getFeaturedShow") UseCase
  provideGetFeaturedShowUseCase(GetFeaturedShow getFeaturedShowUseCase) {
    return getFeaturedShowUseCase;
  }

  @Provides @PerActivity @Named("getComingSoonMovies") UseCase
  provideGetComingSoonMoviesUseCase(GetComingSoonMovies getComingSoonMovies) {
    return getComingSoonMovies;
  }

  @Provides @PerActivity GridLayoutManager
  providedCardListLayoutManager(Context context) {
    return new CardListLayoutManager(context);
  }
}
