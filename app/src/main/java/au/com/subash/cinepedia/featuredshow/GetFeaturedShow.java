package au.com.subash.cinepedia.featuredshow;

import au.com.subash.cinepedia.core.executor.PostExecutionThread;
import au.com.subash.cinepedia.core.executor.ThreadExecutor;
import au.com.subash.cinepedia.interactor.UseCase;
import au.com.subash.cinepedia.movie.domain.MovieRepository;
import io.reactivex.Observable;
import javax.inject.Inject;

public class GetFeaturedShow extends UseCase {

  private MovieRepository movieRepository;

  @Inject
  protected GetFeaturedShow(MovieRepository movieRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.movieRepository = movieRepository;
  }

  @Override protected Observable buildUseCaseObservable() {
    return movieRepository.featuredShow();
  }
}
