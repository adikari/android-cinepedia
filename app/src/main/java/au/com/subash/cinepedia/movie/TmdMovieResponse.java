package au.com.subash.cinepedia.movie;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TmdMovieResponse {

  @SerializedName("page")
  private int page;

  @SerializedName("results")
  private List<MovieEntity> results;

  @SerializedName("total_pages")
  private int totalPages;

  @SerializedName("total_results")
  private int totalResults;

  public TmdMovieResponse() { }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public List<MovieEntity> getResults() {
    return results;
  }

  public void setResults(List<MovieEntity> results) {
    this.results = results;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  public int getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(int totalResults) {
    this.totalResults = totalResults;
  }
}
