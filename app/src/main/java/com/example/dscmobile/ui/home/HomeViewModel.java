package com.example.dscmobile.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("가장 가까운 맛집\n여기 다 모여 있어요!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}