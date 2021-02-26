package com.sesootweb.sesootwebapp.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sesootweb.sesootwebapp.R;
import com.sesootweb.sesootwebapp.databinding.FragmentAppInformationBinding;
import com.sesootweb.sesootwebapp.sliderSetting.adapter.SliderShowAdapter;
import com.sesootweb.sesootwebapp.viewModel.AppInformationViewModel;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;

public class AppInformationFragment extends Fragment {
    private FragmentAppInformationBinding mBinding;
    private AppInformationViewModel mViewModel;

    private AppInfFragmentCallback mCallback;

    public AppInformationFragment() {
        // Required empty public constructor
    }

    public static AppInformationFragment newInstance() {
        AppInformationFragment fragment = new AppInformationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof  AppInfFragmentCallback)
            mCallback= (AppInfFragmentCallback) context;
        else
            throw new ClassCastException("At first must implementation AppInfFragmentCallback");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel=new AppInformationViewModel();

        mViewModel.getOnNextStepBtnClickState().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean)
                    mCallback.onNextBtnClickListener();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding= DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_app_information,
                container,
                false);
        mBinding.setViewModel(mViewModel);
        setupSlider();
        return mBinding.getRoot();
    }

    private void setupSlider() {
        mBinding.slider.setSliderAdapter(new SliderShowAdapter(getContext()));
        mBinding.slider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        mBinding.slider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        mBinding.slider.startAutoCycle();
    }

    public interface AppInfFragmentCallback{
        void onNextBtnClickListener();
    }
}