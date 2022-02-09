package com.ahmed.sharelogger.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        getmText().setValue("This is home fragment");
    }

    public MutableLiveData<String> getmText() {
        return mText;
    }
}