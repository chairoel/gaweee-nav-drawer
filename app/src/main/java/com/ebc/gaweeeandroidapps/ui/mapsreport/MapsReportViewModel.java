package com.ebc.gaweeeandroidapps.ui.mapsreport;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MapsReportViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public MapsReportViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Check In fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}