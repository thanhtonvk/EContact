package com.example.giaodien;

import android.hardware.lights.LightState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Chucnang_Adapter extends RecyclerView.Adapter<Chucnang_Adapter.ChucnangViewHolder>{

    private List<Chucnang> chucnangs;

    public void setData(List<Chucnang>list){
        this.chucnangs=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChucnangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chucnang, parent,false);
        return new ChucnangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChucnangViewHolder holder, int position) {
        Chucnang chuc_nang = chucnangs.get(position);
        if(chuc_nang==null){
            return;
        }

        holder.img_chucnang.setImageResource(chuc_nang.getTainguyen());
        holder.tv_ten.setText(chuc_nang.getTen());
    }

    @Override
    public int getItemCount() {
        if(chucnangs!=null){
            return chucnangs.size();
        }
        return 0;
    }

    public class ChucnangViewHolder extends RecyclerView.ViewHolder{

        private ImageButton img_chucnang;
        private TextView tv_ten;

        public ChucnangViewHolder(@NonNull View itemView) {
            super(itemView);

            img_chucnang=itemView.findViewById(R.id.imgbt_tt);
            tv_ten=itemView.findViewById(R.id.tv_tt);
        }
    }
}
