package com.sesootweb.sesootwebapp.view.activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.sesootweb.sesootwebapp.R;
import com.sesootweb.sesootwebapp.SeSootWebApplication;
import com.sesootweb.sesootwebapp.view.fragment.AppInformationFragment;
import com.sesootweb.sesootwebapp.view.fragment.ShowWebFragment;

public class MainActivity extends SingleFragmentActivity
        implements AppInformationFragment.AppInfFragmentCallback {

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected Fragment getFragment() {
        if (SeSootWebApplication.mFlagShowAppInformationFragment)
            return ShowWebFragment.newInstance();
        else {
            SeSootWebApplication.mFlagShowAppInformationFragment=true;
            return AppInformationFragment.newInstance();
        }
    }

    @Override
    public void onNextBtnClickListener() {
        getSupportFragmentManager().
                beginTransaction().
                setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).
                replace(R.id.fragment_container,ShowWebFragment.newInstance()).
                commit();
    }
}