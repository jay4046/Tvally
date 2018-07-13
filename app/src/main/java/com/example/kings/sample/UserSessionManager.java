package com.example.kings.sample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class UserSessionManager {

    private SharedPreferences pref,preferences;
    private Editor editor,editor2;
    private Context _context;
    private static final String PREFER_NAME = "tvally";
    public static final String INTRO_SLIDE = "intorslide";
    public static final String ISFIRTTIMEAPP = "isfirsttime";

    @SuppressLint("CommitPrefEdits")
    public UserSessionManager(Context context){
        this._context = context;
        int PRIVATE_MODE = 0;
        preferences = context.getSharedPreferences(INTRO_SLIDE, PRIVATE_MODE);
        editor2 = preferences.edit();

        pref = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = pref.edit();

    }

    public void createIsFirstTimeAppLunch()
    {
        editor2.putBoolean(ISFIRTTIMEAPP, true);
        editor2.apply();
    }

}