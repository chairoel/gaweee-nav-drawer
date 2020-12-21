package com.ebc.gaweeeandroidapps.ui.mapsreport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ebc.gaweeeandroidapps.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Calendar;

public class MapsReportFragment extends Fragment {

    private MapsReportViewModel mapsReportViewModel;

    private int mDateStar, mMonthStart, mYearStart;
    private int mDateEnd, mMonthEnd, mYearEnd;
    TextView dateStart;
    TextView dateEnd;
    FragmentManager fm;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mapsReportViewModel = new ViewModelProvider(this).get(MapsReportViewModel.class);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maps_report, container, false);
        dateStart = view.findViewById(R.id.tvDatePickerStart2);
        dateEnd = view.findViewById(R.id.tvDatePickerEnd2);

        // get fragment manager so we can launch from fragment
        fm = getActivity().getSupportFragmentManager();

        /*checkPermission();*/
        showCalendar();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    private void showCalendar() {
        dateStart.setOnClickListener(v -> {
            final Calendar calendar = Calendar.getInstance();
            mDateStar = calendar.get(Calendar.DATE);
            mMonthStart = calendar.get(Calendar.MONTH);
            mYearStart = calendar.get(Calendar.YEAR);
            @SuppressLint("SetTextI18n") DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                    android.R.style.Theme_Material_Dialog_Alert, (view, year, month, dayOfMonth) ->
                    dateStart.setText(dayOfMonth + "-" + month + "-" + year),
                    mYearStart, mMonthStart, mDateStar);
            datePickerDialog.show();
        });

        dateEnd.setOnClickListener(v -> {
            final Calendar calendar = Calendar.getInstance();
            mDateEnd = calendar.get(Calendar.DATE);
            mMonthEnd = calendar.get(Calendar.MONTH);
            mYearEnd = calendar.get(Calendar.YEAR);
            @SuppressLint("SetTextI18n") DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                    android.R.style.Theme_Material_Dialog_Alert, (view, year, month, dayOfMonth) ->
                    dateEnd.setText(dayOfMonth + "-" + month + "-" + year),
                    mYearEnd, mMonthEnd, mDateEnd);
            datePickerDialog.show();
        });
    }
}