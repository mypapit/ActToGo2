package net.mypapit.mobile.acttogo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import net.mypapit.mobile.acttogo.model.MenuModel;

import java.security.SecureRandom;
import java.util.ArrayList;

public class ActToGo extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_to_go);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int[] intTopBg = {R.drawable.top_bg1, R.drawable.top_bg2, R.drawable.top_bg3, R.drawable.top_bg4,
                R.drawable.top_bg5, R.drawable.top_bg6, R.drawable.top_bg7};

        SecureRandom random = new SecureRandom();


        ImageView imageView = findViewById(R.id.topbg);

        imageView.setImageResource(intTopBg[random.nextInt(intTopBg.length)]);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), ContactActivity.class);
                startActivity(intent);
            }
        });

        int[] mThumbIds = {
                android.R.drawable.ic_menu_slideshow, android.R.drawable.ic_menu_camera, android.R.drawable.ic_menu_directions, android.R.drawable.ic_menu_recent_history,
                android.R.drawable.ic_menu_gallery, android.R.drawable.ic_menu_compass
        };


        ArrayList<MenuModel> list = new ArrayList<>();

        list.add(new MenuModel(R.drawable.ic_notes, "Notes", ""));
        list.add(new MenuModel(R.drawable.ic_video, "Video", ""));
        list.add(new MenuModel(R.drawable.ic_dictionary, "Dictionary", ""));
        list.add(new MenuModel(R.drawable.ic_issues, "Issues", ""));
        list.add(new MenuModel(R.drawable.ic_photos, "Related Photos", ""));
        list.add(new MenuModel(R.drawable.ic_blog, "Blog", ""));
        list.add(new MenuModel(R.drawable.ic_review, "Review", ""));
        list.add(new MenuModel(R.drawable.ic_about, "About Us", ""));
        list.add(new MenuModel(R.drawable.ic_contact, "Contact Us", ""));


        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new MainMenuAdapter(this, list));

        gridview.setOnItemClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act_to_go, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent();
        switch (position) {
            case 0:
                intent.setClass(this, NotesActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent.setClass(this, VideoActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent.setClass(this, DictionaryActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent.setClass(this, IssuesActivity.class);
                startActivity(intent);
                break;


            case 5:

                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://actuarialonthego.blogspot.my"));

                startActivity(intent);
                break;

            case 6:
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=net.mypapit.mobile.acttogo"));
                startActivity(intent);
                break;

                case 7:
                intent.setClass(this, AboutActivity.class);
                startActivity(intent);
                break;

            case 8:
                intent.setClass(this, ContactActivity.class);
                startActivity(intent);
                break;


        }


    }
}
