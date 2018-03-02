package net.mypapit.mobile.acttogo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import net.mypapit.mobile.acttogo.adapter.NotesAdapter;
import net.mypapit.mobile.acttogo.model.ContentItem;
import net.mypapit.mobile.acttogo.model.Notes;

import java.util.ArrayList;

public class IssuesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
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

        nlist.add(new Notes("Retirement Issue","Loshana K Shagar, The Star ","https://www.thestar.com.my/news/nation/2016/05/04/malaysians-not-saving-enough-for-retirement/"));
        nlist.add(new Notes("Population Ageing","Khazanah Research Institute","http://www.krinstitute.org/kris_publication_Population_Ageing_Can_We_Live_Long_and_Prosper.aspx"));
        nlist.add(new Notes("Can we Afford to live long?","Charon Wardini Mokhzani, The Star","https://www.thestar.com.my/business/business-news/2016/12/03/can-we-afford-to-live-long/"));
        nlist.add(new Notes("EPF - Reckless Spending by Retirees","The Star","https://www.thestar.com.my/news/nation/2016/12/28/epf-some-retirees-spending-all-their-withdrawals-in-30-days/"));
        nlist.add(new Notes("Employee's Retrenchment","Free Malaysia Today","http://www.freemalaysiatoday.com/category/nation/2016/07/21/employers-body-more-to-be-retrenched-in-next-3-years/"));
        nlist.add(new Notes("Takaful vs Conventional Insurance","Desiree Nair, Ringgit Plus","https://ringgitplus.com/en/blog/Insurance/Takaful-vs-Conventional-Insurance-Whats-the-Difference.html"));


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

        String url = notes.getUrl();

        Bundle bundle = new Bundle();

        bundle.putString("url", url);




        Intent browserIntent = new Intent(this,IssuesWebviewActivity.class);

        browserIntent.putExtras(bundle);
        browserIntent.setData(Uri.parse(url));

        //Intent chooser = Intent.createChooser(browserIntent, getString(R.string.dialog_title_notes));


        startActivity(browserIntent);



    }
}
