package com.xvalue.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllVideoResponse {

    @SerializedName("status_code")
    @Expose
    private String statusCode;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("service_name")
    @Expose
    private String serviceName;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * No args constructor for use in serialization
     *
     */
    public AllVideoResponse() {
    }

    /**
     *
     * @param data
     * @param serviceName
     * @param statusCode
     * @param status
     */
    public AllVideoResponse(String statusCode, String status, String serviceName, Data data) {
        super();
        this.statusCode = statusCode;
        this.status = status;
        this.serviceName = serviceName;
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Data {

        @SerializedName("videos")
        @Expose
        private List<Video> videos = null;
        @SerializedName("message ")
        @Expose
        private String message;

        /**
         * No args constructor for use in serialization
         *
         */
        public Data() {
        }

        /**
         *
         * @param videos
         * @param message
         */
        public Data(List<Video> videos, String message) {
            super();
            this.videos = videos;
            this.message = message;
        }

        public List<Video> getVideos() {
            return videos;
        }

        public void setVideos(List<Video> videos) {
            this.videos = videos;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }


    public class Video {

        @SerializedName("playlist_id")
        @Expose
        private Integer playlistId;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("language")
        @Expose
        private Integer language;
        @SerializedName("media_id")
        @Expose
        private String mediaId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("video_url_low")
        @Expose
        private String videoUrlLow;
        @SerializedName("video_url_high")
        @Expose
        private String videoUrlHigh;
        @SerializedName("video_url_veryhigh")
        @Expose
        private String videoUrlVeryhigh;
        @SerializedName("thumbnail_url")
        @Expose
        private String thumbnailUrl;
        @SerializedName("video_duration")
        @Expose
        private String videoDuration;
        @SerializedName("category_id")
        @Expose
        private Integer categoryId;
        @SerializedName("isDeleted")
        @Expose
        private Integer isDeleted;
        @SerializedName("demo_flag")
        @Expose
        private Integer demoFlag;
        @SerializedName("created_datetime")
        @Expose
        private String createdDatetime;
        @SerializedName("modified_datetime")
        @Expose
        private String modifiedDatetime;
        @SerializedName("total_viewed ")
        @Expose
        private Integer totalViewed;
        @SerializedName("like_dislike ")
        @Expose
        private Integer likeDislike;
        @SerializedName("isFavourite ")
        @Expose
        private Integer isFavourite;

        /**
         * No args constructor for use in serialization
         *
         */
        public Video() {
        }

        /**
         *
         * @param playlistId
         * @param videoUrlHigh
         * @param demoFlag
         * @param modifiedDatetime
         * @param likeDislike
         * @param language
         * @param mediaId
         * @param title
         * @param totalViewed
         * @param videoDuration
         * @param videoUrlLow
         * @param isDeleted
         * @param videoUrlVeryhigh
         * @param createdDatetime
         * @param id
         * @param isFavourite
         * @param categoryId
         * @param thumbnailUrl
         */
        public Video(Integer playlistId, Integer id, Integer language, String mediaId, String title, String videoUrlLow, String videoUrlHigh, String videoUrlVeryhigh, String thumbnailUrl, String videoDuration, Integer categoryId, Integer isDeleted, Integer demoFlag, String createdDatetime, String modifiedDatetime, Integer totalViewed, Integer likeDislike, Integer isFavourite) {
            super();
            this.playlistId = playlistId;
            this.id = id;
            this.language = language;
            this.mediaId = mediaId;
            this.title = title;
            this.videoUrlLow = videoUrlLow;
            this.videoUrlHigh = videoUrlHigh;
            this.videoUrlVeryhigh = videoUrlVeryhigh;
            this.thumbnailUrl = thumbnailUrl;
            this.videoDuration = videoDuration;
            this.categoryId = categoryId;
            this.isDeleted = isDeleted;
            this.demoFlag = demoFlag;
            this.createdDatetime = createdDatetime;
            this.modifiedDatetime = modifiedDatetime;
            this.totalViewed = totalViewed;
            this.likeDislike = likeDislike;
            this.isFavourite = isFavourite;
        }

        public Integer getPlaylistId() {
            return playlistId;
        }

        public void setPlaylistId(Integer playlistId) {
            this.playlistId = playlistId;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getLanguage() {
            return language;
        }

        public void setLanguage(Integer language) {
            this.language = language;
        }

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideoUrlLow() {
            return videoUrlLow;
        }

        public void setVideoUrlLow(String videoUrlLow) {
            this.videoUrlLow = videoUrlLow;
        }

        public String getVideoUrlHigh() {
            return videoUrlHigh;
        }

        public void setVideoUrlHigh(String videoUrlHigh) {
            this.videoUrlHigh = videoUrlHigh;
        }

        public String getVideoUrlVeryhigh() {
            return videoUrlVeryhigh;
        }

        public void setVideoUrlVeryhigh(String videoUrlVeryhigh) {
            this.videoUrlVeryhigh = videoUrlVeryhigh;
        }

        public String getThumbnailUrl() {
            return thumbnailUrl;
        }

        public void setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
        }

        public String getVideoDuration() {
            return videoDuration;
        }

        public void setVideoDuration(String videoDuration) {
            this.videoDuration = videoDuration;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public Integer getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(Integer isDeleted) {
            this.isDeleted = isDeleted;
        }

        public Integer getDemoFlag() {
            return demoFlag;
        }

        public void setDemoFlag(Integer demoFlag) {
            this.demoFlag = demoFlag;
        }

        public String getCreatedDatetime() {
            return createdDatetime;
        }

        public void setCreatedDatetime(String createdDatetime) {
            this.createdDatetime = createdDatetime;
        }

        public String getModifiedDatetime() {
            return modifiedDatetime;
        }

        public void setModifiedDatetime(String modifiedDatetime) {
            this.modifiedDatetime = modifiedDatetime;
        }

        public Integer getTotalViewed() {
            return totalViewed;
        }

        public void setTotalViewed(Integer totalViewed) {
            this.totalViewed = totalViewed;
        }

        public Integer getLikeDislike() {
            return likeDislike;
        }

        public void setLikeDislike(Integer likeDislike) {
            this.likeDislike = likeDislike;
        }

        public Integer getIsFavourite() {
            return isFavourite;
        }

        public void setIsFavourite(Integer isFavourite) {
            this.isFavourite = isFavourite;
        }

    }




}