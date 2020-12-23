package com.ebc.gaweeeandroidapps.ui.checkout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ebc.gaweeeandroidapps.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

public class CheckOutFragment extends Fragment {

    private CheckOutViewModel       checkOutViewModel;
    private ConstraintLayout        mCustomBottomSheet;
    MaterialButton                  buttonCheckOut;
    MaterialButton                  buttonSubmit;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        checkOutViewModel = new ViewModelProvider(this).get(CheckOutViewModel.class);
        View view = inflater.inflate(R.layout.fragment_check_out, container, false);

        buttonCheckOut = view.findViewById(R.id.btn_checkout);
        mCustomBottomSheet = view.findViewById(R.id.custom_bottom_sheet_co);

        showDialogSubmitCO();
        return view;
    }


    private void showDialogSubmitCO() {
        buttonCheckOut.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog( getContext(),
                    R.style.ButtomSheetDialogTheme);
            View bottomSheetView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_bottom_sheet_co, mCustomBottomSheet);

            bottomSheetView.findViewById(R.id.button_submitCO).setOnClickListener(v1 -> {
                Toast.makeText(getContext(), "Submit!!!", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            });
            bottomSheetDialog.setContentView(bottomSheetView);
            bottomSheetDialog.show();
        });


    }
}