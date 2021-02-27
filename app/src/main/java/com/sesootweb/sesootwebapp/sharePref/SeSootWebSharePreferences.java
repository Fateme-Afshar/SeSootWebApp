package com.sesootweb.sesootwebapp.sharePref;

import android.content.Context;
import android.content.SharedPreferences;

public class SeSootWebSharePreferences {
    public static final String KEY_SHOW_FIRST_TIME="showingFragmentFirstTime";

    public static void isFragmentShow(Context context,boolean isShow){
        getSharePreferences(context.getApplicationContext()).
                edit().
                putBoolean(KEY_SHOW_FIRST_TIME,isShow).
                apply();
    }

    public static boolean getShowFirstTime(Context context){
        return getSharePreferences(context.getApplicationContext()).getBoolean(KEY_SHOW_FIRST_TIME,false);
    }

    private static SharedPreferences getSharePreferences(Context context){
        return context.getSharedPreferences("com.sesootweb.sesootwebapp",Context.MODE_PRIVATE);
    }
}
