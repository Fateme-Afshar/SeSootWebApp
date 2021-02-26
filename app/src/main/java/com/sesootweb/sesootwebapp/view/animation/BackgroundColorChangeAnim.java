package com.sesootweb.sesootwebapp.view.animation;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.view.View;

public class BackgroundColorChangeAnim {

    public static void changeBGColorAnimation(View view,int colorFrom,int colorTo){
        ObjectAnimator changeBGAnimator=ObjectAnimator.
                ofInt(view,"backgroundColor",colorFrom,colorTo).
                setDuration(3000);

        changeBGAnimator.setEvaluator(new ArgbEvaluator());
        changeBGAnimator.start();
    }
}
