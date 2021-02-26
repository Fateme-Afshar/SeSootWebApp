package com.sesootweb.sesootwebapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;

import com.sesootweb.sesootwebapp.R;
import com.sesootweb.sesootwebapp.databinding.SplashPageBinding;

public class SplashActivity extends AppCompatActivity {
    SplashPageBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.splash_page);

        mBinding.imvLogo.setAnimation(AnimationUtils.loadAnimation(this,R.anim.from_top_corner));
        mBinding.tvTitle.setAnimation(AnimationUtils.loadAnimation(this,R.anim.from_right_to_left));
        mBinding.tvUrl.setAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_to_right));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.start(SplashActivity.this);

                SplashActivity.this.finish();
            }
        },4000);

    }
}