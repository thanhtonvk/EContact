package com.utehy.econtact.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utehy.econtact.Models.Thongbao;
import com.utehy.econtact.R;

import java.util.List;

public class ThongbaoAdapter extends RecyclerView.Adapter<ThongbaoAdapter.ThongbaoViewHolder> {

    private List<Thongbao> mListThongbao;

    public ThongbaoAdapter(List<Thongbao> mListThongbao) {
        this.mListThongbao = mListThongbao;
    }

    @NonNull
    @Override
    public ThongbaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thongbao, parent, false);
        return new ThongbaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThongbaoViewHolder holder, int position) {
        Thongbao thongbao = mListThongbao.get(position);
        if (thongbao == null){
            return;
        }

        holder.img_thongbao.setImageResource(thongbao.getId());
        holder.tv_tenthongbao.setText(thongbao.getTenthongbao());
        holder.tv_noidung.setText(thongbao.getNoidung());
    }

    @Override
    public int getItemCount() {
        if (mListThongbao != null){
            return mListThongbao.size();
        }
        return 0;
    }

    public class ThongbaoViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_thongbao;
        private TextView tv_tenthongbao;
        private TextView tv_noidung;


        public ThongbaoViewHolder(@NonNull View itemView) {
            super(itemView);
            img_thongbao = itemView.findViewById(R.id.img_thongbao);
            tv_tenthongbao = itemView.findViewById(R.id.tv_item_thongbao);
            tv_noidung = itemView.findViewById(R.id.tv_item_noidung);
        }
    }
}


