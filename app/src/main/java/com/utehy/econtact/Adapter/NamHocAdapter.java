package com.utehy.econtact.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.utehy.econtact.Activity.HocKiActivity;
import com.utehy.econtact.Models.NamHoc;
import com.utehy.econtact.R;

import java.util.List;

public class NamHocAdapter extends RecyclerView.Adapter<NamHocAdapter.ViewHolder> {

    List<NamHoc> namHocs;
    Context context;

    public NamHocAdapter(List<NamHoc> namHocs, Context context) {
        this.namHocs = namHocs;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_academy_year, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NamHoc namHoc = namHocs.get(position);
        long animDuration = 1000;
        holder.circularProgressBar.setProgressWithAnimation(100f, animDuration);
        holder.circularProgressBar.setProgressBarColor(Color.BLUE);
// or with gradient
        holder.circularProgressBar.setProgressBarColor(Color.rgb(51,153,255));
       // holder.circularProgressBar.setProgressBarColorStart(Color.argb(100, 51, 153, 255));

        //holder.circularProgressBar.setProgressBarColorEnd(Color.argb(100, 51, 153, 255));
        //holder.circularProgressBar.setProgressBarColorDirection(CircularProgressBar.GradientDirection.TOP_TO_BOTTOM);
        holder.tvSoKiHoc.setText((position + 1) + "");
        holder.tvNamHoc.setText("Năm học: " + namHoc.getNamHoc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NamHoc.NAM_HOC = namHoc;
                context.startActivity(new Intent(context, HocKiActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return namHocs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CircularProgressBar circularProgressBar;
        TextView tvNamHoc, tvKiHoc, tvSoKiHoc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circularProgressBar = itemView.findViewById(R.id.cicular);
            tvSoKiHoc = itemView.findViewById(R.id.tv_num_hocki);
            tvNamHoc = itemView.findViewById(R.id.tv_namhoc);
            tvKiHoc = itemView.findViewById(R.id.tv_hocki);
        }
    }
}
