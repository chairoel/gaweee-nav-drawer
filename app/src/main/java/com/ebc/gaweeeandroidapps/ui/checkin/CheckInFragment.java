package com.ebc.gaweeeandroidapps.ui.checkin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ebc.gaweeeandroidapps.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

public class CheckInFragment extends Fragment {

    private CheckInViewModel checkInViewModel;
    private ConstraintLayout mCustomBottomSheet;
    MaterialButton buttonCheckIn;
    MaterialButton buttonSubmit;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        checkInViewModel = new ViewModelProvider(this).get(CheckInViewModel.class);
        View view = inflater.inflate(R.layout.fragment_check_in, container, false);

        buttonCheckIn = view.findViewById(R.id.btn_checkin);
        mCustomBottomSheet = view.findViewById(R.id.custom_bottom_sheet_ci);

        showDialogSubmitCI();
        return view;
    }

    private void showDialogSubmitCI() {
        buttonCheckIn.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog( getContext(),
                    R.style.ButtomSheetDialogTheme);
            View bottomSheetView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_bottom_sheet_ci, mCustomBottomSheet);

            bottomSheetView.findViewById(R.id.button_submitCI).setOnClickListener(v1 -> {
                Toast.makeText(getContext(), "Submit!!!", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            });
            bottomSheetDialog.setContentView(bottomSheetView);
            bottomSheetDialog.show();
        });
    }
}