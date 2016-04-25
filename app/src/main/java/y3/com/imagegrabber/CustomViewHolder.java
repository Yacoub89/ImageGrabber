package y3.com.imagegrabber;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    protected ImageView imageView;
    protected TextView textView;
    protected View thumb1View;

    public CustomViewHolder(View view) {
        super(view);
        this.imageView = (ImageView) view.findViewById(R.id.expanded_image);
        this.thumb1View.findViewById(R.id.thumb_button_1);
        //this.textView = (TextView) view.findViewById(R.id.title);
    }
}