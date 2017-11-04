package au.com.subash.cinepedia.comingsoonmovies;

import au.com.subash.cinepedia.exception.DefaultErrorBundle;
import au.com.subash.cinepedia.exception.ErrorBundle;
import au.com.subash.cinepedia.exception.ErrorMessageFactory;
import au.com.subash.cinepedia.interactor.DefaultSubscriber;
import au.com.subash.cinepedia.interactor.UseCase;
import au.com.subash.cinepedia.movie.MovieModelDataMapper;
import au.com.subash.cinepedia.movie.domain.Movie;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

public class ComingSoonMoviesPresenter implements ComingSoonMoviesContract.Presenter {

  private ComingSoonMoviesContract.View view;

  private final UseCase getComingSoonMovies;
  private final MovieModelDataMapper mapper;

  @Inject
  public ComingSoonMoviesPresenter(@Named("getComingSoonMovies")UseCase getComingSoonMovies,
      MovieModelDataMapper mapper) {
    this.getComingSoonMovies = getComingSoonMovies;
    this.mapper = mapper;
  }

  public void setView(ComingSoonMoviesContract.View view) {
    this.view = view;
  }

  @Override public void resume() { }

  @Override public void pause() { }

  @Override public void destroy() {
    view = null;
    getComingSoonMovies.unsubscribe();
  }

  @Override public void initialize() {
    getComingSoonMovies.execute(new GetComingSoonMoviesSubscriber());
  }

  private void showErrorMessage(ErrorBundle errorBundle) {
    String message = ErrorMessageFactory.create(view.context(), (Exception) errorBundle);

    view.showError(message);
  }

  private void showMoviesInView(List<Movie> movies) {
    view.renderComingSoonMovies(mapper.transform(movies));
  }

  private class GetComingSoonMoviesSubscriber extends DefaultSubscriber<List<Movie>> {
    @Override public void onError(Throwable e) {
      ComingSoonMoviesPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
    }

    @Override public void onNext(List<Movie> movies) {
      ComingSoonMoviesPresenter.this.showMoviesInView(movies);
    }
  }
}
