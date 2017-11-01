package au.com.subash.cinepedia.core.di.components;

import android.support.v7.app.AppCompatActivity;
import au.com.subash.cinepedia.core.di.PerActivity;
import au.com.subash.cinepedia.core.di.modules.ActivityModule;
import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation:
 * {@link PerActivity}
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  //Exposed to sub-graphs.
  AppCompatActivity activity();
}
