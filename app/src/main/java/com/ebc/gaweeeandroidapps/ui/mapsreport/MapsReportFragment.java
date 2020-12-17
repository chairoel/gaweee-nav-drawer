package com.ebc.gaweeeandroidapps.ui.mapsreport;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ebc.gaweeeandroidapps.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class MapsReportFragment extends Fragment {

    private MapsReportViewModel mapsReportViewModel;

    /*public static MapsReportFragment newInstance() {
        return new MapsReportFragment();
    }*/

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        mapsReportViewModel = new ViewModelProvider(this).get(MapsReportViewModel.class);
        View root = inflater.inflate(R.layout.fragment_maps_report, container, false);
        final TextView textView = root.findViewById(R.id.text_check_in);
        mapsReportViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mapsReportViewModel = new ViewModelProvider(this).get(MapsReportViewModel.class);
        // TODO: Use the ViewModel
    }*/
}