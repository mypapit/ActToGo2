package net.mypapit.mobile.acttogo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

/**
 * Created by Admin on 13/2/2018.
 */

class ImageAdapter extends BaseAdapter {

    private Integer[] mThumbIds = {
           android.R.drawable.ic_menu_slideshow,android.R.drawable.ic_menu_camera,android.R.drawable.ic_menu_directions,android.R.drawable.ic_menu_recent_history,
            android.R.drawable.ic_menu_gallery,android.R.drawable.ic_menu_compass
    };

    Context context;
    public ImageAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);

        return imageView;    }


}
