package com.sesootweb.sesootwebapp.view.activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.sesootweb.sesootwebapp.R;
import com.sesootweb.sesootwebapp.view.fragment.AppInformationFragment;
import com.sesootweb.sesootwebapp.view.fragment.ShowWebFragment;

public class MainActivity extends SingleFragmentActivity
        implements AppInformationFragment.AppInfFragmentCallback {

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        //starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected Fragment getFragment() {
        return AppInformationFragment.newInstance();
    }

    @Override
    public void onNextBtnClickListener() {
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container,ShowWebFragment.newInstance()).
                commit();
    }
}