package com.xvalue.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.xvalue.myapplication.R;
import com.xvalue.myapplication.model.ImageList;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    List<ImageList> imageLists;
    Context context;

    public ImageAdapter(List<ImageList> imageLists, Context context) {
        this.imageLists = imageLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageList imageList=imageLists.get(position);
        holder.tvname.setText(imageList.getName());
        Picasso.with(context)
                .load(imageList.getImageurl())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return imageLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvname;
        private ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            tvname=(TextView)itemView.findViewById(R.id.txt_name);
            img=(ImageView)itemView.findViewById(R.id.image_view);
        }
    }
}