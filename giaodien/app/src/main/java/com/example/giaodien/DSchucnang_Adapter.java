package com.example.giaodien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DSchucnang_Adapter extends RecyclerView.Adapter<DSchucnang_Adapter.DsViewHolder>{

    private Context context;
    private List<DSchucnang> dSchucnangs;

    public DSchucnang_Adapter(Context context) {
        this.context = context;
    }

    public void setData(List<DSchucnang> list){
        this.dSchucnangs = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dschucnang,parent,false);
        return new DsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DsViewHolder holder, int position) {
        DSchucnang ds_chucnang = dSchucnangs.get(position);
        if(ds_chucnang==null){
            return;
        }

        holder.ten_ds.setText(ds_chucnang.getTenChucnang());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);
        holder.rcv_chucnang.setLayoutManager(linearLayoutManager);

        Chucnang_Adapter chucnang_adapter = new Chucnang_Adapter();
        chucnang_adapter.setData(ds_chucnang.getChucnangs());
        holder.rcv_chucnang.setAdapter(chucnang_adapter);
    }

    @Override
    public int getItemCount() {
        if(dSchucnangs!=null){
            return dSchucnangs.size();
        }
        return 0;
    }

    public class DsViewHolder extends RecyclerView.ViewHolder{

        private TextView ten_ds;
        private RecyclerView rcv_chucnang;

        public DsViewHolder(@NonNull View itemView) {
            super(itemView);

            ten_ds=itemView.findViewById(R.id.tv_ten_chucnang);
            rcv_chucnang=itemView.findViewById(R.id.rcv_dschucnang);
        }
    }
}
