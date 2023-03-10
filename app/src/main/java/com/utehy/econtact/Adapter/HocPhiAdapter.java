package com.utehy.econtact.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utehy.econtact.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class HocPhiAdapter extends RecyclerView.Adapter<HocPhiAdapter.ViewHolder> {
    List<Map<String, Object>> listHocPhi;
    Context context;

    public HocPhiAdapter(List<Map<String, Object>> listHocPhi, Context context) {
        this.listHocPhi = listHocPhi;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_hoc_phi, parent, false));
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Map<String, Object> hocPhi = listHocPhi.get(position);
        holder.tvNamHoc.setText(hocPhi.get("academy_year").toString());
        holder.tvHocKi.setText(hocPhi.get("semester").toString());
        double tuition_fee = (double) hocPhi.get("tuition_fee_paid");


        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String phi = numberFormat.format(tuition_fee);

        holder.tvHocPhi.setText(phi);
        String isPaid = (String) hocPhi.get("note");
        if (isPaid.equals("TH")) {
            holder.tvTrangThai.setText("Đã thanh toán");
            holder.imgTrangThai.setImageResource(R.drawable.checked);
        } else {
            holder.tvTrangThai.setTextColor(Color.RED);
            holder.tvTrangThai.setText("Chưa thanh toán");
            holder.imgTrangThai.setImageResource(R.drawable.cancel);
        }
    }

    @Override
    public int getItemCount() {
        return listHocPhi.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamHoc, tvHocKi, tvHocPhi, tvTrangThai;
        ImageView imgTrangThai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamHoc = itemView.findViewById(R.id.tv_nam_hoc);
            tvHocKi = itemView.findViewById(R.id.tv_hoc_ki);
            tvHocPhi = itemView.findViewById(R.id.tv_hoc_phi);
            tvTrangThai = itemView.findViewById(R.id.tv_trang_thai);
            imgTrangThai = itemView.findViewById(R.id.img_trang_thai);
        }
    }
}
