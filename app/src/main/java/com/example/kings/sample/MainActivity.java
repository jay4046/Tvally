package com.example.kings.sample;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView web_home;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
