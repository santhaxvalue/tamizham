package com.xvalue.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoTimeLimits {

    @SerializedName("trial_video_timelimit")
    @Expose
    private Integer trialVideoTimelimit;
    @SerializedName("total_play_duration")
    @Expose
    private Integer totalPlayDuration;

    public Integer getTrialVideoTimelimit() {
        return trialVideoTimelimit;
    }

    public void setTrialVideoTimelimit(Integer trialVideoTimelimit) {
        this.trialVideoTimelimit = trialVideoTimelimit;
    }

    public Integer getTotalPlayDuration() {
        return totalPlayDuration;
    }

    public void setTotalPlayDuration(Integer totalPlayDuration) {
        this.totalPlayDuration = totalPlayDuration;
    }

}
