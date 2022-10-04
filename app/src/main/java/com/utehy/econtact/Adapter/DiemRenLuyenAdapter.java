package com.utehy.econtact.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.utehy.econtact.R;

import java.util.List;
import java.util.Map;

public class DiemRenLuyenAdapter extends RecyclerView.Adapter<DiemRenLuyenAdapter.ViewHolder> {

    List<Map<String, Object>> diemRenLuyenList;
    Context context;

    public DiemRenLuyenAdapter(Context context, List<Map<String, Object>> diemRenLuyenList) {
        this.diemRenLuyenList = diemRenLuyenList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_diem_rl, parent, false);
        return new DiemRenLuyenAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Map<String, Object> diemRL = diemRenLuyenList.get(position);
        long animDuration = 1000;
        float score = Float.parseFloat(diemRL.get("point").toString());
        holder.circularProgressBar.setProgressWithAnimation(score, animDuration);

        if (score < 50) {
            holder.circularProgressBar.setProgressBarColor(Color.rgb(95,158,160));
        } else if (score >= 50 && score < 70) {
            holder.circularProgressBar.setProgressBarColor(Color.rgb(70,130,180));
        } else if (score >= 7 && score < 80) {
            holder.circularProgressBar.setProgressBarColor(Color.rgb(100,149,237));
        } else if (score >= 80 && score < 90) {
            holder.circularProgressBar.setProgressBarColor(Color.rgb(0,191,255));
        } else {
            holder.circularProgressBar.setProgressBarColor(Color.rgb(30,144,255));
        }
        holder.tvDiem.setText(((int) score) + "");
        holder.tvKiHoc.setText("Học kì: " + diemRL.get("semester"));
        holder.tvNamHoc.setText("Năm học: " + diemRL.get("academy_year"));

    }

    @Override
    public int getItemCount() {
        return diemRenLuyenList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CircularProgressBar circularProgressBar;
        TextView tvNamHoc, tvKiHoc, tvDiem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circularProgressBar = itemView.findViewById(R.id.cicular);
            tvDiem = itemView.findViewById(R.id.tv_diem_rl);
            tvNamHoc = itemView.findViewById(R.id.tv_namhoc);
            tvKiHoc = itemView.findViewById(R.id.tv_hocki);
        }
    }
}
