package com.sesootweb.sesootwebapp.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.sesootweb.sesootwebapp.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        if (fragment==null)
            getSupportFragmentManager().
                    beginTransaction().
                    add(R.id.fragment_container,getFragment()).
                    commit();
    }

    protected abstract Fragment getFragment();
}
