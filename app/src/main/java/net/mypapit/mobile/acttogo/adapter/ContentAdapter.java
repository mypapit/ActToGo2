package net.mypapit.mobile.acttogo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import net.mypapit.mobile.acttogo.R;
import net.mypapit.mobile.acttogo.model.ContentItem;

import java.util.List;

/**
 * Created by Admin on 21/2/2018.
 */

public class ContentAdapter extends ArrayAdapter<ContentItem> {

    protected TextView tvTitle, tvSubtitle;
    protected ImageView iv;
    Context ctx;
    List<ContentItem> contentItems;
    View listItem = null;
    ContentItem item;


    protected  ContentAdapter(@NonNull Context context, int resource, @NonNull List<ContentItem> objects) {
        super(context, 0, objects);
        this.ctx = ctx;
        this.contentItems = contentItems;

    }


    public ContentAdapter(Context ctx, @NonNull List<ContentItem> contentItems) {
        this(ctx, 0, contentItems);

        this.ctx = ctx;
        this.contentItems = contentItems;

    }

    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if (listItem == null) {

            listItem = LayoutInflater.from(ctx).inflate(R.layout.item_notes, parent, false);


        }

        item = contentItems.get(position);


        tvTitle = listItem.findViewById(R.id.tvtitle);
        tvSubtitle = listItem.findViewById(R.id.tvsubtitle);
        iv = listItem.findViewById(R.id.ivnotes);

        tvTitle.setText(item.getTitle());
        tvSubtitle.setText(item.getSubtitle());


        //iv.setImageDrawable(drawable);

        setDrawable(item.getSubtitle());


        return listItem;
    }

    public TextDrawable setDrawable(String text) {

        ColorGenerator generator = ColorGenerator.MATERIAL;
        int color = generator.getColor(item);
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(text, color);

        iv.setImageDrawable(drawable);

        return drawable;

    }

    protected ContentItem getItem() {
        return item;


    }

}
