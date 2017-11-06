package au.com.subash.cinepedia.core.di.components;

import android.content.Context;
import au.com.subash.cinepedia.casts.CastRepository;
import au.com.subash.cinepedia.core.di.modules.ApplicationModule;
import au.com.subash.cinepedia.core.executor.ThreadExecutor;
import au.com.subash.cinepedia.movies.MovieRepository;
import au.com.subash.cinepedia.moviedetail.MovieDetailRepository;
import au.com.subash.cinepedia.view.activity.BaseActivity;
import au.com.subash.cinepedia.core.executor.PostExecutionThread;
import dagger.Component;
import javax.inject.Singleton;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
  void inject(BaseActivity baseActivity);

  //Exposed to sub-graphs.
  Context context();
  ThreadExecutor threadExecutor();
  PostExecutionThread postExecutionThread();
  MovieRepository movieRepository();
  MovieDetailRepository movieDetailRepository();
  CastRepository castRepository();
}
