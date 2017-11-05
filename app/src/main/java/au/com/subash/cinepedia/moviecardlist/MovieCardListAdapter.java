package au.com.subash.cinepedia.moviecardlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.movie.MovieModel;
import au.com.subash.cinepedia.util.TmdImage;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import java.util.List;
import javax.inject.Inject;

public class MovieCardListAdapter extends RecyclerView.Adapter<MovieCardListAdapter.ViewHolder> {

  private final LayoutInflater inflater;
  private final Context context;

  private List<MovieModel> movieModelList;

  public interface ItemClickListener {
    void onMovieClicked(MovieModel movieModel);
  }

  private ItemClickListener listener;

  @Inject
  public MovieCardListAdapter(Context context) {
    this.context = context;
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view = inflater.inflate(R.layout.thumb_card, parent, false);

    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    final MovieModel movieModel = movieModelList.get(position);

    holder.title.setText(movieModel.getTitle());
    holder.popularity.setText(String.valueOf(movieModel.getRating()));

    String imageUrl = TmdImage.getImageUrl(movieModel.getImageUrl(), 185);

    // TODO: use image loader instead of picasso
    Picasso
        .with(context)
        .load(imageUrl)
        .into(holder.thumbnail);

    holder.itemView.setOnClickListener(v -> {
      if (null != listener) {
        listener.onMovieClicked(movieModel);
      }
    });
  }

  @Override public int getItemCount() {
    return (null != movieModelList) ? movieModelList.size() : 0;
  }

  @Override public long getItemId(int position) {
    return position;
  }

  void setMovieModelList(List<MovieModel> movieModelList) {
    if (null == movieModelList) {
      throw new IllegalArgumentException("Movie list cannot be empty");
    }

    this.movieModelList = movieModelList;
    notifyDataSetChanged();
  }

  void setItemClickListener(ItemClickListener listener) {
    this.listener = listener;
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.title) TextView title;
    @BindView(R.id.popularity) TextView popularity;
    @BindView(R.id.thumbnail) ImageView thumbnail;

    ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
