package com.example.dscmobile.ui.indoorsetting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IndoorSettingViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public IndoorSettingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("실내 설정 페이지");
    }

    public LiveData<String> getText() {
        return mText;
    }
}