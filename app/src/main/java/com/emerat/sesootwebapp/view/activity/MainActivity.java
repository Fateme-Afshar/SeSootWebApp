package com.emerat.sesootwebapp.view.activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.emerat.sesootwebapp.view.fragment.ShowWebFragment;

public class MainActivity extends SingleFragmentActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        //starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected Fragment getFragment() {
        return ShowWebFragment.newInstance();
    }

}