package com.sesootweb.sesootwebapp.helper;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.sesootweb.sesootwebapp.R;

public class BindingHelper {
    @BindingAdapter("loadImage")
    public static void loadImage(ImageView imageView,int imgRes){
        Glide.with(imageView.getContext()).
                load(imgRes).
                placeholder(R.drawable.ic_placeholder).
                into(imageView);
    }
}
