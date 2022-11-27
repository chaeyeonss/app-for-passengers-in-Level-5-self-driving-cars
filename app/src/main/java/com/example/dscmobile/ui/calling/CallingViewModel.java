package com.example.dscmobile.ui.calling;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CallingViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CallingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("출발지");
    }

    public LiveData<String> getText() {
        return mText;
    }
}