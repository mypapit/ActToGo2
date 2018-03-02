package net.mypapit.mobile.acttogo.adapter;

import android.content.Context;
import android.graphics.Typeface;
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

public class VideoAdapter extends ArrayAdapter<ContentItem> {

    Context ctx;
    List<ContentItem> nlist;


    private VideoAdapter(@NonNull Context context, int resource, @NonNull List<ContentItem> objects) {
        super(context, 0, objects);


    }


    public VideoAdapter(Context ctx, @NonNull List<ContentItem> nlist) {
        this(ctx, 0, nlist);

        this.ctx = ctx;
        this.nlist = nlist;

    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if (listItem == null) {

            listItem = LayoutInflater.from(ctx).inflate(R.layout.item_notes, parent, false);


        }

        ContentItem notes = nlist.get(position);


        TextView tvTitle = listItem.findViewById(R.id.tvtitle);
        TextView tvSubtitle = listItem.findViewById(R.id.tvsubtitle);
        ImageView iv = listItem.findViewById(R.id.ivnotes);

        tvTitle.setText(notes.getTitle());
        tvSubtitle.setText(notes.getSubtitle());


        ColorGenerator generator = ColorGenerator.MATERIAL;
        int color = generator.getColor(notes);

        Typeface fontFamily = Typeface.createFromAsset(ctx.getAssets(), "fonts/fa.ttf");


        TextDrawable drawable = TextDrawable.builder().beginConfig().useFont(fontFamily).withBorder(1).endConfig()
                .buildRound("\uf03d", color);

        iv.setImageDrawable(drawable);


        return listItem;
    }
}
