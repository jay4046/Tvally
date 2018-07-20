package com.example.kings.sample;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    ImageView close_img;
    TextView help_txt;
    WebView web_home;
    ProgressDialog progressDialog;
    private Boolean exit = false;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this, R.style.DialogTheme);
        progressDialog.setMessage("Please wait......");
        progressDialog.show();

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

        CookieManager.getInstance().setAcceptCookie(true);

        web_home.loadUrl("https://tvally.in/");
        //web_home.loadUrl("https://www.amazon.in/");

        web_home.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                progressDialog.dismiss();

            }
        });

    }

    @Override
    public void onClick(View v) {

        if (v == help_txt) {
            //deleteCache(MainActivity.this);

            Intent intent = new Intent(MainActivity.this, IntroActivity.class);
            startActivity(intent);
        }

        if (v == close_img) {
            toolbar.setVisibility(View.GONE);
        }

    }

    /*public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if (dir != null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }*/

    @Override
    public void onBackPressed() {

        if (exit) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            moveTaskToBack(true);
        } else {
            Toast.makeText(getApplicationContext(), "Press Back again to Exit.", Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 2 * 1000);
        }

    }
}
