package com.example.busappver13.ui.subway;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SubwayViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SubwayViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is subway fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}