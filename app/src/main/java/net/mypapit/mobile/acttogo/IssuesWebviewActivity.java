package net.mypapit.mobile.acttogo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;

public class IssuesWebviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issues_webview);

        Bundle bundle = getIntent().getExtras();

        String url = "https://uitm.edu.my";
        String title ="Issues";
        if (bundle != null) {
            url = bundle.getString("url");
            title = bundle.getString("title","Issue");
        }

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(title);
        }





        WebView webView = findViewById(R.id.webview);

        webView.loadUrl(url);



    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
