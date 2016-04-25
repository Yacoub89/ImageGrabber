package y3.com.imagegrabber;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Yacoub on 4/22/2016.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<FeedItem> feedItemList;
    private Context mContext;

    public MyRecyclerAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        FeedItem feedItem = feedItemList.get(i);

        //Download image using picasso library
        Picasso.with(mContext).load(feedItem.getThumbnail())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(customViewHolder.imageView);

        //Setting text view title
        customViewHolder.textView.setText(Html.fromHtml(feedItem.getTitle()));

        //Handle click event on both title and image click
        customViewHolder.textView.setOnClickListener(clickListener);
        customViewHolder.imageView.setOnClickListener(clickListener);

        customViewHolder.textView.setTag(customViewHolder);
        customViewHolder.imageView.setTag(customViewHolder);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CustomViewHolder holder = (CustomViewHolder) view.getTag();
            int position = holder.getPosition();

            FeedItem feedItem = feedItemList.get(position);
            Toast.makeText(mContext, feedItem.getTitle(), Toast.LENGTH_SHORT).show();

           // Intent fullScreenIntent = new Intent(view.getContext(),FullImageActivity.class);
            //fullScreenIntent.putExtra(FullImageActivity.class.getName(),position) ;
            //FullImageActivity.getActivity().startActivity(fullScreenIntent);


        }
    };

    @Override

    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }
}
