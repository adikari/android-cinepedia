package au.com.subash.cinepedia.nowplayingmovies;

import au.com.subash.cinepedia.cardview.CardListContract;
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

public class NowPlayingMoviesPresenter implements CardListContract.Presenter {

  private CardListContract.View view;

  private final UseCase getNowPlayingMovies;
  private final MovieModelDataMapper mapper;

  @Inject
  public NowPlayingMoviesPresenter(@Named("getNowPlayingMovies")UseCase getNowPlayingMovies,
      MovieModelDataMapper mapper) {
    this.getNowPlayingMovies = getNowPlayingMovies;
    this.mapper = mapper;
  }

  public void setView(CardListContract.View view) {
    this.view = view;
  }

  @Override public void resume() { }

  @Override public void pause() { }

  @Override public void destroy() {
    getNowPlayingMovies.unsubscribe();
    view = null;
  }

  @Override public void initialize() {
    getNowPlayingMovies.execute(new NowPlayingMoviesSubscriber());
  }

  private void showErrorMessage(ErrorBundle errorBundle) {
    String message = ErrorMessageFactory.create(view.context(), errorBundle.getException());
    view.showError(message);
  }

  private void showNowPlayingMoviesInView(List<Movie> movies) {
    view.renderMovies(mapper.transform(movies));
  }

  private class NowPlayingMoviesSubscriber extends DefaultSubscriber<List<Movie>> {
    @Override public void onError(Throwable e) {
      NowPlayingMoviesPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
    }

    @Override public void onNext(List<Movie> movies) {
      NowPlayingMoviesPresenter.this.showNowPlayingMoviesInView(movies);
    }
  }
}
