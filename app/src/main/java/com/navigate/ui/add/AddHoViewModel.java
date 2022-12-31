package com.navigate.ui.add;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddHoViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private final MutableLiveData<String> mText;

    public AddHoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is add hotel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}