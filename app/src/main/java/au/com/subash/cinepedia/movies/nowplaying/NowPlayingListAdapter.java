package au.com.subash.cinepedia.movies.nowplaying;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.movies.MovieModel;
import au.com.subash.cinepedia.util.TmdImage;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import java.util.List;
import javax.inject.Inject;

public class NowPlayingListAdapter extends RecyclerView.Adapter<NowPlayingListAdapter.ViewHolder> {

  public interface OnItemClickListener {
    void onItemClicked(MovieModel movieModel);
  }

  private List<MovieModel> movieModelList;

  private Context context;
  private LayoutInflater inflater;
  private OnItemClickListener listener;

  @Inject
  NowPlayingListAdapter(Context context) {
    this.context = context;
    this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  void setItemClickListener(OnItemClickListener listener) {
    this.listener = listener;
  }

  void setMovieModelList(List<MovieModel> movieModelList) {
    if (null == movieModelList) {
      throw new IllegalArgumentException("Movie list must not be null");
    }

    this.movieModelList = movieModelList;
    notifyDataSetChanged();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view = inflater.inflate(R.layout.now_playing_list_frag_thumb, parent, false);

    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    final MovieModel movieModel = movieModelList.get(position);

    String imageUrl = TmdImage.getImageUrl(movieModel.getImageUrl(), 185);

    Picasso.with(context).load(imageUrl).into(holder.thumbnail);
    holder.title.setText(movieModel.getTitle());

    holder.itemView.setOnClickListener(v -> {
      if (null != listener) {
        listener.onItemClicked(movieModel);
      }
    });
  }

  @Override public int getItemCount() {
    return (null != movieModelList) ? movieModelList.size() : 0;
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_now_playing_list_thumbnail) ImageView thumbnail;
    @BindView(R.id.tv_now_playing_thumb_title) TextView title;

    ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
