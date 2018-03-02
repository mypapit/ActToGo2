package net.mypapit.mobile.acttogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import net.mypapit.mobile.acttogo.adapter.VideoAdapter;
import net.mypapit.mobile.acttogo.model.ContentItem;
import net.mypapit.mobile.acttogo.model.Video;

import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<ContentItem> nlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes2);

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        nlist = new ArrayList<>();

        nlist.add(new Video("Longevity 1", "Longevity Forum Part 1", "o0-QG6U3DzU"));
        nlist.add(new Video("Longevity 2", "Longevity Forum Part 2", "UAshYJJL7po"));
        nlist.add(new Video("Longevity 3", "Longevity Forum Part 3", "hiMdkFRvJfM"));
        nlist.add(new Video("Longevity 4", "Longevity Forum Part 4", "hVZHrw33qPA"));
        nlist.add(new Video("Nature of Insurance & Takaful", "UITM MOOC : Nature of Insurance and Takaful", "ZTtCDYzPCGw"));
        nlist.add(new Video("Legal Aspect of Insurance & Takaful", "UITM MOOC : Legal Aspect of Insurance and Takaful\n", "WUdGcE--GRw"));

        VideoAdapter adapter = new VideoAdapter(this, nlist);

        ListView lv = findViewById(R.id.lvNotes);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ContentItem notes = nlist.get(position);

        String videourl = notes.getUrl();

        Bundle bundle = new Bundle();

        bundle.putString("url", videourl);
        bundle.putString("title", notes.getTitle());

        Intent intent = new Intent();
        intent.setClass(this, PlayerActivity.class);
        intent.putExtras(bundle);


        startActivity(intent);


    }
}
