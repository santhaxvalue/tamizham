package com.xvalue.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserResponse implements Serializable {


    private String Status;
    private String select_sub_msg_str;



    private String Message;

    private List<UserDatas> data;

    private String count;

    private String status_code;

    private ArrayList<String> overall_subject_ids;

    public ArrayList<String> getOverall_subject_ids() {
        return overall_subject_ids;
    }

    @SerializedName("video_time_limits")
    @Expose
    private VideoTimeLimits videoTimeLimits;


    @SerializedName("external_browser_view")
    @Expose
    private String externalBrowserView;
    public void setOverall_subject_ids(ArrayList<String> overall_subject_ids) {
        this.overall_subject_ids = overall_subject_ids;
    }

    public String getStatusCode() {
        return status_code;
    }

    public void setStatusCode(String status_code) {
        this.status_code = status_code;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public List<UserDatas> getData() {
        return data;
    }

    public void setData(List<UserDatas> data) {
        this.data = data;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSelect_sub_msg_str() {
        return select_sub_msg_str;
    }

    public void setSelect_sub_msg_str(String select_sub_msg_str) {
        this.select_sub_msg_str = select_sub_msg_str;
    }



    @Override
    public String toString() {
        return "ClassPojo [Status = " + Status + ", Message = " + Message + ", data = " + data + ", count = " + count + ", select_sub_msg_str = " + select_sub_msg_str + "]";
    }


    public VideoTimeLimits getVideoTimeLimits() {
        return videoTimeLimits;
    }

    public void setVideoTimeLimits(VideoTimeLimits videoTimeLimits) {
        this.videoTimeLimits = videoTimeLimits;
    }

    public String getExternalBrowserView() {
        return externalBrowserView;
    }

    public void setExternalBrowserView(String externalBrowserView) {
        this.externalBrowserView = externalBrowserView;
    }

}



