package au.com.subash.cinepedia.view.activity;

import au.com.subash.cinepedia.core.di.PerActivity;
import au.com.subash.cinepedia.featuredshow.GetFeaturedShow;
import au.com.subash.cinepedia.interactor.UseCase;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
class MainActivityModule {

  @Provides @PerActivity @Named("getFeaturedShow")
  UseCase provideGetFeaturedShowUseCase(GetFeaturedShow getFeaturedShowUseCase) {
    return getFeaturedShowUseCase;
  }
}
