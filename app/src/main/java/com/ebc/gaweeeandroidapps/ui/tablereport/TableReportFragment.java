package com.ebc.gaweeeandroidapps.ui.tablereport;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ebc.gaweeeandroidapps.R;
import com.ebc.gaweeeandroidapps.adapter.RvTableAdapter;
import com.ebc.gaweeeandroidapps.model.ReportTable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TableReportFragment extends Fragment {

    private TableReportViewModel tableReportViewModel;

    private int mDateStar, mMonthStart, mYearStart;
    private int mDateEnd, mMonthEnd, mYearEnd;
    TextView dateStart;
    TextView dateEnd;
    ImageView ivCalendar;
    RecyclerView recyclerView;
    RvTableAdapter tableAdapter;


    public static TableReportFragment newInstance() {
        return new TableReportFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_table_report, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        dateStart = view.findViewById(R.id.tvDatePickerStart);
        dateEnd = view.findViewById(R.id.tvDatePickerEnd);

        showCalendar();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tableReportViewModel = new ViewModelProvider(this).get(TableReportViewModel.class);
        // TODO: Use the ViewModel
        setRecyclerView();

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

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        tableAdapter = new RvTableAdapter(getContext(), getList());
        recyclerView.setAdapter(tableAdapter);
    }

    private List<ReportTable> getList() {
        List<ReportTable> reportTables = new ArrayList<>();
        reportTables.add(new ReportTable("31-12-2020", "09:00", "17:00"));
        reportTables.add(new ReportTable("30-12-2020", "12:00", "18:00"));
        reportTables.add(new ReportTable("29-12-2020", "09:00", "17:00"));
        reportTables.add(new ReportTable("28-12-2020", "11:00", "19:00"));
        reportTables.add(new ReportTable("25-12-2020", "09:00", "17:00"));
        reportTables.add(new ReportTable("24-12-2020", "10:50", "18:50"));
        reportTables.add(new ReportTable("23-12-2020", "10:45", "19:45"));
        reportTables.add(new ReportTable("22-12-020", "09:00", "17:00"));
        reportTables.add(new ReportTable("21-12-2020", "11:10", "18:10"));
        reportTables.add(new ReportTable("18-12-2020", "11:10", "18:10"));
        reportTables.add(new ReportTable("17-12-2020", "11:10", "18:10"));
        reportTables.add(new ReportTable("16-12-2020", "11:10", "18:10"));
        reportTables.add(new ReportTable("15-12-2020", "11:10", "18:10"));
        reportTables.add(new ReportTable("14-12-2020", "11:10", "18:10"));
        reportTables.add(new ReportTable("11-12-2020", "11:10", "18:10"));
        reportTables.add(new ReportTable("10-12-2020", "11:10", "18:10"));
        reportTables.add(new ReportTable(" 9-12-2020", "11:10", "18:10"));
        reportTables.add(new ReportTable(" 8-12-2020", "11:10", "18:10"));
        reportTables.add(new ReportTable(" 4-12-2020", "11:10", "18:10"));
        reportTables.add(new ReportTable(" 3-12-2020", "11:10", "18:10"));
        reportTables.add(new ReportTable(" 2-12-2020", "11:10", "18:10"));
        reportTables.add(new ReportTable(" 1-12-2020", "11:10", "18:10"));
        return reportTables;
    }




}