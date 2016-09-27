package com.example.my.video;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    String TAG = "com.example.my.video";
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
         videoView =
                (VideoView) findViewById(R.id.videoView1);


        MediaController mediaController = new
                MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        String uriPath = "android.resource://com.example.my.video/"+R.raw.p;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()  {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i(TAG, "Duration = " +
                        videoView.getDuration());
            }
        });

        videoView.start();
    }
}
