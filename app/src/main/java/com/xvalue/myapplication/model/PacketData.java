package com.xvalue.myapplication.model;

import java.io.Serializable;

public class PacketData implements Serializable {
    private String subject_id;

    private String video_name;

    private String thumb_image;

    private String demo_flag;

    private String description;

    private String type;

    private String title;

    private String duration;

    private String vp_subject_name;

    private String course_type;

    private String video_path_low;

    private String video_path_veryhigh;

    private String viewed;

    private String video_path_high;

    private String orig_duration;

    private String watched_duration;

    private String video_id;

    private String sub_category1;

    private String sub_category2;

    private String img_from_admin;

    private String is_note_available;

    private String is_video_liked;

    private String is_ezdrm_url;

    public String getSeek_bar_thumb_url() {
        return seek_bar_thumb_url;
    }

    public void setSeek_bar_thumb_url(String seek_bar_thumb_url) {
        this.seek_bar_thumb_url = seek_bar_thumb_url;
    }

    private String seek_bar_thumb_url;

    public String getIs_ezdrm_url() {
        return is_ezdrm_url;
    }

    public void setIs_ezdrm_url(String is_ezdrm_url) {
        this.is_ezdrm_url = is_ezdrm_url;
    }

    public String getEzdrm_android_video_url() {
        return ezdrm_android_video_url;
    }

    public void setEzdrm_android_video_url(String ezdrm_android_video_url) {
        this.ezdrm_android_video_url = ezdrm_android_video_url;
    }

    private String ezdrm_android_video_url;

    public String getIs_video_liked() {
        return is_video_liked;
    }

    public void setIs_video_liked(String is_video_liked) {
        this.is_video_liked = is_video_liked;
    }




    public String getCatId1_id ()
    {
        return sub_category1;
    }

    public void setCatId1_id (String sub_category1)
    {
        this.sub_category1 = sub_category1;
    }

    public String getCatId2_id ()
    {
        return sub_category2;
    }

    public void setCatId2_id (String sub_category2)
    {
        this.sub_category2 = sub_category2;
    }

    public String getSubject_id ()
    {
        return subject_id;
    }

    public void setSubject_id (String subject_id)
    {
        this.subject_id = subject_id;
    }

    public String getVideo_name ()
    {
        return video_name;
    }

    public void setVideo_name (String video_name)
    {
        this.video_name = video_name;
    }

    public String getThumb_image ()
    {
        return thumb_image;
    }

    public void setThumb_image (String thumb_image)
    {
        this.thumb_image = thumb_image;
    }

    public String getDemo_flag ()
    {
        return demo_flag;
    }

    public void setDemo_flag (String demo_flag)
    {
        this.demo_flag = demo_flag;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getVp_subject_name ()
    {
        return vp_subject_name;
    }

    public void setVp_subject_name (String vp_subject_name)
    {
        this.vp_subject_name = vp_subject_name;
    }

    public String getCourse_type ()
    {
        return course_type;
    }

    public void setCourse_type (String course_type)
    {
        this.course_type = course_type;
    }

    public String getVideo_path_low ()
    {
        return video_path_low;
    }

    public void setVideo_path_low (String video_path_low)
    {
        this.video_path_low = video_path_low;
    }

    public String getVideo_path_veryhigh ()
    {
        return video_path_veryhigh;
    }

    public void setVideo_path_veryhigh (String video_path_veryhigh)
    {
        this.video_path_veryhigh = video_path_veryhigh;
    }

    public String getViewed ()
    {
        return viewed;
    }

    public void setViewed (String viewed)
    {
        this.viewed = viewed;
    }

    public String getVideo_path_high ()
    {
        return video_path_high;
    }

    public void setVideo_path_high (String video_path_high)
    {
        this.video_path_high = video_path_high;
    }

    public String getOrig_duration ()
    {
        return orig_duration;
    }

    public void setOrig_duration (String orig_duration)
    {
        this.orig_duration = orig_duration;
    }

    public String getWatched_duration ()
    {
        return watched_duration;
    }

    public void setWatched_duration (String watched_duration)
    {
        this.watched_duration = watched_duration;
    }

    public String getVideo_id ()
    {
        return video_id;
    }

    public void setVideo_id (String video_id)
    {
        this.video_id = video_id;
    }

    public String getImg_from_admin ()
    {
        return img_from_admin;
    }

    public void setImg_from_admin (String img_from_admin)
    {
        this.img_from_admin = img_from_admin;
    }

    public String getIs_note_available ()
    {
        return is_note_available;
    }

    public void setIs_note_available (String is_note_available)
    {
        this.is_note_available = is_note_available;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [subject_id = "+subject_id+", video_name = "+video_name+", thumb_image = "+thumb_image+", demo_flag = "+demo_flag+", description = "+description+", type = "+type+", title = "+title+", duration = "+duration+", vp_subject_name = "+vp_subject_name+", course_type = "+course_type+", video_path_low = "+video_path_low+", video_path_veryhigh = "+video_path_veryhigh+", viewed = "+viewed+", video_path_high = "+video_path_high+", orig_duration = "+orig_duration+", watched_duration = "+watched_duration+", video_id = "+video_id+", img_from_admin = "+img_from_admin+", is_note_available = "+is_note_available+", is_video_liked = "+is_video_liked+", is_ezdrm_url = "+is_ezdrm_url+", ezdrm_android_video_url = "+ezdrm_android_video_url+", seek_bar_thumb_url = "+seek_bar_thumb_url+"]";
    }
}