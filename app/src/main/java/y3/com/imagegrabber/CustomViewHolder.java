package y3.com.imagegrabber;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    protected ImageView imageView;
    protected TextView textView;

    protected CardView cardView;

    public CustomViewHolder(View view) {
        super(view);
        this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
        this.textView = (TextView) view.findViewById(R.id.title);
    }
}