package com.example.se;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Makanan> mData;

    public RecyclerViewAdapter(Context mContext, List<Makanan> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_makanan,parent,false);
        
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_makanan.setText(mData.get(position).getNamaMakanan());
        holder.iv_gambar_makanan.setImageResource(mData.get(position).getFoto());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext,Makanan_Activity.class);


                i.putExtra("namaMakanan",mData.get(position).getNamaMakanan());
                i.putExtra("kategoriMakanan",mData.get(position).getKategori());
                i.putExtra("kaloriMakanan",mData.get(position).getJumlahKalori());
                i.putExtra("thumbnailMakanan",mData.get(position).getFoto());
                i.putExtra("qtyMakanan",mData.get(position).getQty());
                i.putExtra("deskripsiMakanan",mData.get(position).getDeskripsi());
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_makanan;
        ImageView iv_gambar_makanan;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);

            tv_makanan = (TextView) itemView.findViewById(R.id.id_nama_makanan);
            iv_gambar_makanan = (ImageView) itemView.findViewById(R.id.id_foto_makanan);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);

        }
    }
}
