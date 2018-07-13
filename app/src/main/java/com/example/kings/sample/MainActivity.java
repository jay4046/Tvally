package com.example.kings.sample;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    ImageView close_img;
    TextView help_txt;
    WebView web_home;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        close_img = findViewById(R.id.close_img);
        close_img.setOnClickListener(this);
        help_txt = findViewById(R.id.help_txt);
        help_txt.setOnClickListener(this);

        web_home = findViewById(R.id.web_home);

        web_home.setInitialScale(1);
        web_home.getSettings().setJavaScriptEnabled(true);
        web_home.getSettings().setLoadWithOverviewMode(true);
        web_home.getSettings().setUseWideViewPort(true);
        web_home.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        web_home.setScrollbarFadingEnabled(false);
        web_home.setWebViewClient(new WebViewClient());
        web_home.loadUrl("https://tvally.in/");

        web_home.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {


            }
        });

    }

    @Override
    public void onClick(View v) {

        if (v == help_txt){

        }

        if (v == close_img){
            toolbar.setVisibility(View.GONE);
        }

    }
}
