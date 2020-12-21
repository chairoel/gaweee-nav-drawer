package com.ebc.gaweeeandroidapps.ui.checkin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ebc.gaweeeandroidapps.R;

public class CheckInFragment extends Fragment {

    private CheckInViewModel checkInViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        checkInViewModel =
                new ViewModelProvider(this).get(CheckInViewModel.class);
        View view = inflater.inflate(R.layout.fragment_check_in, container, false);
        /*final TextView textView = root.findViewById(R.id.text_check_in);
        checkInViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return view;
    }
}