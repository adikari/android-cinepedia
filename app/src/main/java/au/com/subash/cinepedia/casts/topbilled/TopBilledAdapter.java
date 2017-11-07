package au.com.subash.cinepedia.casts.topbilled;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import au.com.subash.cinepedia.R;
import au.com.subash.cinepedia.casts.CastModel;
import au.com.subash.cinepedia.util.TmdImage;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import java.util.List;
import javax.inject.Inject;

public class TopBilledAdapter extends RecyclerView.Adapter<TopBilledAdapter.ViewHolder> {

  public interface ItemClickListener {
    void onCastClicked(CastModel castModel);
  }

  private final Context context;
  private final LayoutInflater inflater;

  private List<CastModel> castList;
  private ItemClickListener listener;

  @Inject
  public TopBilledAdapter(Context context) {
    this.context = context;
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  public void setCastsList(List<CastModel> castList) {
    if (null == castList)  {
      throw new IllegalArgumentException("Cast list cannot be null");
    }

    this.castList = castList;
    notifyDataSetChanged();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.top_billed_frag_thumb, parent, false);

    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    final CastModel castModel = castList.get(position);

    String imageUrl = TmdImage.getImageUrl(castModel.getImage(), 185);

    Picasso
        .with(context)
        .load(imageUrl)
        .into(holder.thumbnail);

    holder.castName.setText(castModel.getCharacter());
    holder.artistName.setText(castModel.getName());

    holder.itemView.setOnClickListener(v -> {
      if (null != listener) {
        listener.onCastClicked(castModel);
      }
    });
  }

  @Override public int getItemCount() {
    return (null != castList) ? castList.size() : 0;
  }

  @Override public long getItemId(int position) {
    return position;
  }

  void setItemClickListener(ItemClickListener listener) {
    this.listener = listener;
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_top_billed_thumbnail) ImageView thumbnail;
    @BindView(R.id.tv_top_billed_artist_name) TextView artistName;
    @BindView(R.id.tv_top_billed_cast_name) TextView castName;

    ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
