package com.emerat.sesootwebapp.view;

import androidx.fragment.app.Fragment;

public class MainActivity extends SingleFragmentActivity {


    @Override
    protected Fragment getFragment() {
        return ShowWebFragment.newInstance();
    }
}