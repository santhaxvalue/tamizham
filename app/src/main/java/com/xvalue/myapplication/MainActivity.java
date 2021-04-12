package com.xvalue.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

public class MainActivity extends AppCompatActivity {

    static SimpleExoPlayer simpleExoPlayer;
    PlayerView simpleExoPlayerView;
    int trackIndex = 0;
    long stopPosition = 0;
    MediaSource mediaSource = null;

    // String videoLink ="https://ezdrm-aws-vinformax.s3.ap-south-1.amazonaws.com/output/BigBuckBunny_320x180.mpd";
    String videoLink ="https://bitmovin-a.akamaihd.net/content/playhouse-vr/m3u8s/105560.m3u8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleExoPlayerView = findViewById(R.id.videoView);
        /*DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "ExoPlayer"));
        Uri uri = Uri.parse("https://bitmovin-a.akamaihd.net/content/MI201109210084_1/mpds/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.mpd");
        DashMediaSource dashMediaSource = new DashMediaSource(uri, dataSourceFactory,
                new DefaultDashChunkSource.Factory(dataSourceFactory), null, null);

        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));

        SimpleExoPlayer simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);

        simpleExoPlayerView.setPlayer(simpleExoPlayer);
        simpleExoPlayer.prepare(dashMediaSource);*/

        initLiveExoplayer();
    }


    private void initLiveExoplayer() {
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(getApplicationContext());
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getApplicationContext(),
                Util.getUserAgent(getApplicationContext(), getApplicationContext().getString(R.string.app_name)));

        //String videoLink = "";

        ConcatenatingMediaSource concatenatingMediaSource = new ConcatenatingMediaSource();


        Uri videoURI = Uri.parse(videoLink);

        if (!videoLink.contains("m3u8")) {

            mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(videoURI);
            Log.d("Video_Play_url1", videoURI + "");
        } else {
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource videoSource = new ExtractorMediaSource(videoURI,
                    dataSourceFactory, extractorsFactory, null, null);
            com.google.android.exoplayer2.util.Log.d("Audio", videoURI + "");
            Log.e("HLS", videoURI + "");
            simpleExoPlayer.prepare(videoSource);
        }

        //HLS Video
        if (videoLink.contains("m3u8")) {
            mediaSource = new HlsMediaSource.Factory(dataSourceFactory)
                    .setAllowChunklessPreparation(true)
                    .createMediaSource(videoURI);
            Log.d("Video_Play_url2", videoURI + "");
        } else {
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource videoSource = new ExtractorMediaSource(videoURI,
                    dataSourceFactory, extractorsFactory, null, null);
            com.google.android.exoplayer2.util.Log.d("Audio", videoURI + "");

            simpleExoPlayer.prepare(videoSource);
        }

        concatenatingMediaSource.addMediaSource(mediaSource);

        //playerListner();


        simpleExoPlayerView.setPlayer(simpleExoPlayer);
        //simpleExoPlayer.prepare(mediaSource);
        simpleExoPlayer.prepare(concatenatingMediaSource);
        simpleExoPlayer.seekTo(trackIndex, C.TIME_UNSET);


       /* String[] units = dataString.getWatched_duration().split(":"); //will break the string up into an array
        int Hours = Integer.parseInt(units[0]); //first element
        int minutes = Integer.parseInt(units[1]); //second element
        int seconds = Integer.parseInt(units[2]); //Third element
        long O_duration = (60 * 60 * Hours) + (60 * minutes) + seconds; //add up our values
        seekPlayer(O_duration);*/
        simpleExoPlayer.setPlayWhenReady(true);
        videoresume();
    }

    public void videoresume() {
        try {
            Log.e("resumw", "videoresume");
            //  if (simpleExoPlayer != null) {
            Intent intent = getIntent();
            String duration = intent.getStringExtra("duration");

            if (stopPosition == 0) {
                simpleExoPlayer.seekTo(0);


            }


            //  }


            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}