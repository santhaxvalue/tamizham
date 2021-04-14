package com.xvalue.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.xvalue.myapplication.R;
import com.xvalue.myapplication.activity.DetailViewActivity;
import com.xvalue.myapplication.model.HomePageResponse;

import java.util.List;

public class TrendingVideoListAdapter extends RecyclerView.Adapter<TrendingVideoListAdapter.ViewHolder> {

    private Context context;
    private List<HomePageResponse.Data.Trending> homepagesingleresponseTrend;

    private HomePageResponse.Data.Trending pu;

    public TrendingVideoListAdapter(Context context, List<HomePageResponse.Data.Trending> homepagesingleresponseTrend) {
        this.context = context;
        this.homepagesingleresponseTrend = homepagesingleresponseTrend;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(homepagesingleresponseTrend.get(position));

        pu = homepagesingleresponseTrend.get(position);

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
        return homepagesingleresponseTrend.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView timer_,title;
//        public TextView pName;
//        public TextView pJobProfile;

        public ViewHolder(View itemView) {
            super(itemView);

//            pName = (TextView) itemView.findViewById(R.id.pNametxt);
//            pJobProfile = (TextView) itemView.findViewById(R.id.pJobProfiletxt);
            title = (TextView) itemView.findViewById(R.id.title);
            timer_ = (TextView) itemView.findViewById(R.id.timer_);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                    HomePageResponse.Data.Trending cpu = (HomePageResponse.Data.Trending) view.getTag();

                    Intent intent = new Intent(TrendingVideoListAdapter.this.context, DetailViewActivity.class);
                    intent.putExtra("title", pu.getTitle());
                    intent.putExtra("time", pu.getVideoDuration());
                    TrendingVideoListAdapter.this.context.startActivity(intent);

//                    Toast.makeText(view.getContext(), cpu.getPersonName()+" is "+ cpu.getJobProfile(), Toast.LENGTH_SHORT).show();

                }
            });

        }
    }

}
