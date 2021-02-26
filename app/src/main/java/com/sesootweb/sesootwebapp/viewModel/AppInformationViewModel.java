package com.sesootweb.sesootwebapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AppInformationViewModel extends ViewModel {
    private MutableLiveData<Boolean> mOnNextStepBtnClickState=new MutableLiveData<>();
    public void onNextStepBtnClickListener(){
        mOnNextStepBtnClickState.setValue(true);
    }

    public LiveData<Boolean> getOnNextStepBtnClickState() {
        return mOnNextStepBtnClickState;
    }
}
