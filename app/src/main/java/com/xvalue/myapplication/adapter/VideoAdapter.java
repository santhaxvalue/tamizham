package com.xvalue.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.xvalue.myapplication.R;
import com.xvalue.myapplication.model.PacketData;
import com.xvalue.myapplication.model.UserResponse;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> implements Filterable {

    private Context mContext;
    private ArrayList<PacketData> list;
    SimpleExoPlayer simpleExoplayer;


    private OnPacketlickListner onPacketlickListner;
    public UserResponse userResponseDataInLesson;

    public VideoAdapter(ArrayList<PacketData> data_list, UserResponse userResponseDataInLesson, OnPacketlickListner onPacketlickListner) {
        this.mContext = mContext;
        this.list = data_list;

//        this.onPacketlickListner = onPacketlickListner;
//        this.userResponseDataInLesson = userResponseDataInLesson;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_adapter, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.subName.setText(list.get(position).getCourse_type()+ " \u2022 " +list.get(position).getVp_subject_name());
        viewHolder.tct = list.get(position).getVideo_name();
        viewHolder.tct=viewHolder.tct.replace("\r","").replace("\n","");
        viewHolder.title.setText(viewHolder.tct);
        String st = list.get(position).getDuration();
        //String   NewString = st.replaceAll("00:", "");

        String s = st;
        int indexOfLast = s.lastIndexOf("min");
        String newString = s;
        if (indexOfLast >= 0) newString = s.substring(0, indexOfLast);
        Log.e("Seconds0", newString + "min");

        if (list.get(position).getDuration() != null)
            viewHolder.timer_.setText(/*packetData.getDuration()*/newString + "min");

        // viewHolder.timer_.setText(NewString);

        Log.d("dur_paii", "onBindViewHolder: " + list.get(position).getOrig_duration());
        //  viewHolder.image_back.setColorFilter(Color.parseColor("#6F000000"));

        PacketData packetData = list.get(position);

//        String Baseurl = ApiClient.Imageurl() + packetData.getVp_subject_name();

       /* Glide.with(viewHolder.mContext).load(Baseurl + "/" + packetData.getThumb_image())
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA).error(R.color.white).placeholder(R.color.white).centerCrop())
                .into(viewHolder.image_back);*/


//        if (packetData.getImg_from_admin().contains("N")) {
//            Glide.with(viewHolder.mContext).load(Baseurl + "/" + packetData.getThumb_image())
//                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA).error(R.color.white).placeholder(R.color.white).centerCrop())
//                    .into(viewHolder.image_back);
//        } else {
//            Glide.with(viewHolder.mContext).load(ApiClient.url()+"betas3d/admin_live/" + packetData.getThumb_image())
//                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA).centerCrop())
//                    .into(viewHolder.image_back);
//        }
        try {


            viewHolder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Boolean isLocked = false;
                    Boolean isDemo = false;
//                    if (HomeFragment.userResponseData.getData() != null) {
//                        if (HomeFragment.userResponseData.getData().get(0).getExp_status().equals("0") && HomeFragment.userResponseData.getOverall_subject_ids().contains(packetData.getSubject_id())) {
//                            isLocked = false;
//                            isDemo = false;
//                        } else if (packetData.getDemo_flag().equals("1")) {
//                            isLocked = true;
//                            isDemo = true;
//                        } else if (!HomeFragment.userResponseData.getOverall_subject_ids().contains(packetData.getSubject_id()) && packetData.getDemo_flag().equals("0")) {
//                            isLocked = true;
//                            isDemo = false;
//                        }
//                    }
                    onPacketlickListner.onClick(packetData, position, isLocked, isDemo);
                }
            });

        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }

        try {
           /* if (HomeFragment.userResponseData.getData() != null) {
                if (HomeFragment.userResponseData.getData().get(0).getExp_status().equals("0")) {
                    viewHolder.lockView.setVisibility(View.GONE);
                    viewHolder.playView.setVisibility(View.VISIBLE);
                } else {
                    viewHolder.lockView.setVisibility(View.VISIBLE);
                    viewHolder.playView.setVisibility(View.GONE);
                }
            }*/

//            if (HomeFragment.userResponseData.getData() != null) {
//                if (HomeFragment.userResponseData.getData().get(0).getExp_status().equals("0") && HomeFragment.userResponseData.getOverall_subject_ids().contains(packetData.getSubject_id())) {
//                    viewHolder.lockView.setVisibility(View.GONE);
//                    viewHolder.playView.setVisibility(View.VISIBLE);
//                } else if (packetData.getDemo_flag().equals("1")) {
//                    viewHolder.lockView.setVisibility(View.GONE);
//                    viewHolder.playView.setVisibility(View.VISIBLE);
//                } else if (!HomeFragment.userResponseData.getOverall_subject_ids().contains(packetData.getSubject_id()) && packetData.getDemo_flag().equals("0")) {
//                    if (HomeFragment.userResponseData.getOverall_subject_ids().size() != 0) {
//                        viewHolder.lockView.setVisibility(View.VISIBLE);
//                        viewHolder.playView.setVisibility(View.GONE);
//                    } else if (HomeFragment.userResponseData.getData().get(0).getExp_status().equals("1")) {
//                        viewHolder.lockView.setVisibility(View.VISIBLE);
//                        viewHolder.playView.setVisibility(View.GONE);
//                    }
//                }
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView subName, timer_, title;
        private String tct;
        public CardView card;
        ImageView image_back;
        private LinearLayout lockView;
        ImageView playView;
        private Context mContext;


        public ViewHolder(View view) {
            super(view);
            /*float scale = mContext.getResources().getConfiguration().fontScale;
            float sizeNeeded = 16;*/
            mContext = view.getContext();
            subName = view.findViewById(R.id.subName);
            timer_ = view.findViewById(R.id.timer_);
            title = view.findViewById(R.id.title);
            lockView = view.findViewById(R.id.lock_view);

            card = view.findViewById(R.id.card);

            /*subName.setTextSize(sizeNeeded/scale);
            timer_.setTextSize(sizeNeeded/scale);
            title.setTextSize(sizeNeeded/scale);*/

            image_back = view.findViewById(R.id.image_back);
            playView = view.findViewById(R.id.playIcon);
//


        }
    }


    public interface OnPacketlickListner {

        void onClick(PacketData packetData, int position, Boolean isLocked, Boolean isDemo);
    }


}
