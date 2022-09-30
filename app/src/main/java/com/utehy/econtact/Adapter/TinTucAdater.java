package com.utehy.econtact.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.utehy.econtact.Models.TinTuc;
import com.utehy.econtact.R;

import java.util.List;

public class TinTucAdater extends RecyclerView.Adapter<TinTucAdater.ViewHolder> {
    Context context;
    List<TinTuc> tinTucList;

    public TinTucAdater(Context context, List<TinTuc> tinTucList) {
        this.context = context;
        this.tinTucList = tinTucList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tin_tuc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TinTuc tinTuc = tinTucList.get(position);
        Glide.with(context).load(tinTuc.getHinhAnh()).error(R.drawable.anh_ic_logo_khoa_cntt).into(holder.imgHinhAnh);
        holder.tvTieuDe.setText(tinTuc.getTieuDe());

    }

    @Override
    public int getItemCount() {
        return tinTucList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTieuDe;
        ImageView imgHinhAnh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTieuDe = itemView.findViewById(R.id.tv_tieu_de);
            imgHinhAnh = itemView.findViewById(R.id.img_hinh_anh);
        }
    }
}
