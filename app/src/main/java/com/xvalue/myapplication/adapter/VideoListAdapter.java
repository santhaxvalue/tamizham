package com.xvalue.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.xvalue.myapplication.R;
import com.xvalue.myapplication.activity.DetailViewActivity;
import com.xvalue.myapplication.model.HomePageResponse;
import com.xvalue.myapplication.model.HomePageSingleResponse;

import java.util.List;

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ViewHolder> {

    private Context context;
    private List<HomePageResponse.Data.Trending> homepagesingleresponse;
    private HomePageResponse.Data.Trending pu;

    public VideoListAdapter(Context context, List<HomePageResponse.Data.Trending> homepagesingleresponse) {
        this.context = context;
        this.homepagesingleresponse = homepagesingleresponse;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(homepagesingleresponse.get(position));

         pu = homepagesingleresponse.get(position);

//        holder.pName.setText(pu.getVideoUrlHigh());
//        holder.pJobProfile.setText(pu.getVideoUrlLow());

        holder.title.setText(pu.getTitle());

        String st = pu.getVideoDuration();
        String s = st;
        int indexOfLast = s.lastIndexOf("min");
        String newString = s;
        if (indexOfLast >= 0) newString = s.substring(0, indexOfLast);
        Log.e("Seconds0", newString + "min");

        if (pu.getVideoDuration() != null)
            holder.timer_.setText(/*packetData.getDuration()*/newString + "min");

    }

    @Override
    public int getItemCount() {
        return homepagesingleresponse.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView timer_,title;
        private CardView card_new;
//        public TextView pName;
//        public TextView pJobProfile;

        public ViewHolder(View itemView) {
            super(itemView);

//            pName = (TextView) itemView.findViewById(R.id.pNametxt);
//            pJobProfile = (TextView) itemView.findViewById(R.id.pJobProfiletxt);
            title = (TextView) itemView.findViewById(R.id.title);
            timer_ = (TextView) itemView.findViewById(R.id.timer_);
            card_new = (CardView) itemView.findViewById(R.id.card);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                    HomePageResponse.Data.Trending cpu = (HomePageResponse.Data.Trending) view.getTag();

                    Intent intent = new Intent(VideoListAdapter.this.context, DetailViewActivity.class);
                    intent.putExtra("title", pu.getTitle());
                    intent.putExtra("time", pu.getVideoDuration());
                    VideoListAdapter.this.context.startActivity(intent);

//                    Toast.makeText(view.getContext(), cpu.getPersonName()+" is "+ cpu.getJobProfile(), Toast.LENGTH_SHORT).show();

                }
            });


        }
    }

}