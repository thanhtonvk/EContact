package com.utehy.econtact.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.utehy.econtact.R;
import com.utehy.econtact.Tools.Common;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class DiemAdapter extends RecyclerView.Adapter<DiemAdapter.ViewHolder> {
    Context context;
    List<Map<String, Object>> diems;

    public DiemAdapter(Context context, List<Map<String, Object>> diems) {
        this.context = context;
        this.diems = diems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_diem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Map<String, Object> obj = diems.get(position);
        long animationDuration = 2500;
        float score = Float.parseFloat(obj.get("score").toString());
        holder.circularProgressBar.setProgressWithAnimation((score / 10 * 100), animationDuration);
        holder.circularProgressBar.setProgressBarColor(Common.colors[new Random().nextInt(7)]);
// or with gradient
        holder.circularProgressBar.setProgressBarColorStart(Common.colors[new Random().nextInt(7)]);
        holder.circularProgressBar.setProgressBarColorEnd(Common.colors[new Random().nextInt(7)]);
        holder.circularProgressBar.setProgressBarColorDirection(CircularProgressBar.GradientDirection.TOP_TO_BOTTOM);
        holder.tvSoTC.setText("Số tín chỉ: "+obj.get("number_credits").toString());
        holder.tvMonHoc.setText(obj.get("subject_name").toString());
        holder.tvDiem.setText(obj.get("score").toString());
    }

    @Override
    public int getItemCount() {
        return diems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        CircularProgressBar circularProgressBar;
        TextView tvMonHoc, tvDiem, tvSoTC;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circularProgressBar = itemView.findViewById(R.id.cicular);
            tvMonHoc = itemView.findViewById(R.id.tv_ten_mon);
            tvDiem = itemView.findViewById(R.id.tv_diem);
            tvSoTC = itemView.findViewById(R.id.tv_so_tc);
        }
    }
}
