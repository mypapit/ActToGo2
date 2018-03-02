package net.mypapit.mobile.acttogo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.mypapit.mobile.acttogo.model.MenuModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 20/2/2018.
 */

public class MainMenuAdapter extends ArrayAdapter<MenuModel> {

    List<MenuModel> list;

    public MainMenuAdapter(@NonNull Context context, int resource, @NonNull List<MenuModel> objects) {
        super(context, 0, objects);

        this.list = objects;
    }

    public MainMenuAdapter(Context ctx, List<MenuModel> objects) {
        this(ctx,0,objects);



    }

    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        MenuModel menu = list.get(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mainmenu_grid,parent,false);

        }

        TextView title = convertView.findViewById(R.id.item_title);
        TextView subtitle = convertView.findViewById(R.id.item_subtitle);
        ImageView image = convertView.findViewById(R.id.item_image);

        title.setText(menu.getTitle());
        subtitle.setText(menu.getSubtitle());
        image.setImageResource(menu.getmImageResource());





        return convertView;
    }

}