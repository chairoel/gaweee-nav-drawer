package com.ebc.gaweeeandroidapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ebc.gaweeeandroidapps.R;
import com.ebc.gaweeeandroidapps.model.ReportTable;

import java.util.List;

public class RvTableAdapter extends RecyclerView.Adapter<RvTableAdapter.TableAdapterViewHolder>{

    Context context;
    List<ReportTable> reportTables;

    public RvTableAdapter(Context context, List<ReportTable> reportTables) {
        this.context = context;
        this.reportTables = reportTables;
    }

    @NonNull
    @Override
    public RvTableAdapter.TableAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_presence,
                parent, false);
        return new TableAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RvTableAdapter.TableAdapterViewHolder holder, int position) {
        if (reportTables != null && reportTables.size() > 0) {
            ReportTable reportTable = reportTables.get(position);
            holder.tvDate.setText(reportTable.getDate());
            holder.tvCheckIn.setText(reportTable.getCheckIn());
            holder.tvCheckOut.setText(reportTable.getCheckOut());

        } else {
            return;
        }

    }

    @Override
    public int getItemCount() {
        return reportTables.size();
    }

    public class TableAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView tvDate;
        TextView tvCheckIn;
        TextView tvCheckOut;

        public TableAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tvDate);
            tvCheckIn = itemView.findViewById(R.id.tvCheckIn);
            tvCheckOut = itemView.findViewById(R.id.tvCheckOut);

        }
    }
}
