package com.example.retrofitproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private static final String TAG = "MyAdapter";
    private List<RetroSong> dataList;
    private Context mContext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
    holder.artist.setText(dataList.get(position).getArtists());
        holder.songName.setText(dataList.get(position).getSong());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Uri songURI= Uri.parse(dataList.get(position).getUrl());
//                Intent intent =new Intent(Intent.ACTION_VIEW,songURI);
                Toast.makeText(mContext, dataList.get(position).getUrl(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public MyAdapter(List<RetroSong> dataList, Context context) {
        this.dataList=dataList;
        mContext=context;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

//        ImageView image;
        TextView songName;
        TextView artist;
       CardView parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            image=itemView.findViewById(R.id.image);
            artist=itemView.findViewById(R.id.singer);
            songName=itemView.findViewById(R.id.song_name);
         parentLayout=itemView.findViewById(R.id.card);
        }
    }
}
