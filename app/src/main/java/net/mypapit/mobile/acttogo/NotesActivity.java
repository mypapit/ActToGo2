package net.mypapit.mobile.acttogo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import net.mypapit.mobile.acttogo.adapter.NotesAdapter;
import net.mypapit.mobile.acttogo.model.ContentItem;
import net.mypapit.mobile.acttogo.model.Notes;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<Notes> nlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes2);

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        nlist = new ArrayList<>();

        nlist.add(new Notes("Chapter 1","Definition of Risk and Insurance","https://bukupanduan.com/act2go/chapter-01-risk.pdf"));
        nlist.add(new Notes("Chapter 1","Characteristic of Insurance","https://bukupanduan.com/act2go/chapter-01-insurance.pdf"));
        nlist.add(new Notes("Chapter 2","Risk Management","https://bukupanduan.com/act2go/chapter-02.pdf"));
        nlist.add(new Notes("Chapter 3","Risk Management","https://bukupanduan.com/act2go/chapter-01-insurance.pdf"));
        nlist.add(new Notes("Chapter 4","Legal Principles in Insurance Contract","https://bukupanduan.com/act2go/chapter-04.pdf"));
        nlist.add(new Notes("Chapter 5","Fundamentals of Life Insurance","https://bukupanduan.com/act2go/chapter-05.pdf"));
        nlist.add(new Notes("Chapter 6","Fundamentals of General Insurance","https://bukupanduan.com/act2go/chapter-06.pdf"));
        nlist.add(new Notes("Chapter 7","Fundamentals of Takaful","https://bukupanduan.com/act2go/chapter-07.pdf"));

        NotesAdapter adapter = new NotesAdapter(this,nlist);

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

        String pdfurl = notes.getUrl();

        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setDataAndType(Uri.parse(pdfurl), "application/pdf");

        Intent chooser = Intent.createChooser(browserIntent, getString(R.string.dialog_title_notes));


        startActivity(chooser );



    }
}
