package com.example.kings.sample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class UserSessionManager {

    private Editor editor2;
    private static final String PREFER_NAME = "tvally";
    public static final String INTRO_SLIDE = "intorslide";
    public static final String ISFIRTTIMEAPP = "isfirsttime";

    @SuppressLint("CommitPrefEdits")
    public UserSessionManager(Context context){
        int PRIVATE_MODE = 0;
        SharedPreferences preferences = context.getSharedPreferences(INTRO_SLIDE, PRIVATE_MODE);
        editor2 = preferences.edit();

        SharedPreferences pref = context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        Editor editor = pref.edit();

    }

    public void createIsFirstTimeAppLunch()
    {
        editor2.putBoolean(ISFIRTTIMEAPP, true);
        editor2.apply();
    }

}