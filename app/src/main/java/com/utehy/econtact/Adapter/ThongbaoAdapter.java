package com.utehy.econtact.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utehy.econtact.R;

import java.util.List;
import java.util.Map;

public class ThongbaoAdapter extends RecyclerView.Adapter<ThongbaoAdapter.ThongbaoViewHolder> {

    private List<Map<String, Object>> mListThongbao;

    public ThongbaoAdapter(List<Map<String, Object>> mListThongbao) {
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
        Map<String, Object> thongbao = mListThongbao.get(position);
        if (thongbao == null) {
            return;
        }

        holder.tv_tenthongbao.setText(thongbao.get("notification_title").toString());
        String noiDung = thongbao.get("notification_content").toString();
        if (noiDung.length() > 80) {
            holder.tv_noidung.setText(noiDung.substring(0, 80) + " ...");
            holder.tvXemThem.setVisibility(View.VISIBLE);
            holder.tvXemThem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.tv_noidung.setText(noiDung);
                    holder.tvXemThem.setVisibility(View.INVISIBLE);
                }
            });
        } else {
            holder.tv_noidung.setText(noiDung);
        }

    }

    @Override
    public int getItemCount() {
        if (mListThongbao != null) {
            return mListThongbao.size();
        }
        return 0;
    }

    public class ThongbaoViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_thongbao;
        private TextView tv_tenthongbao;
        private TextView tv_noidung;
        private TextView tvXemThem;

        public ThongbaoViewHolder(@NonNull View itemView) {
            super(itemView);
            img_thongbao = itemView.findViewById(R.id.img_thongbao);
            tv_tenthongbao = itemView.findViewById(R.id.tv_item_thongbao);
            tv_noidung = itemView.findViewById(R.id.tv_item_noidung);
            tvXemThem = itemView.findViewById(R.id.tv_xem_them);
        }
    }
}


