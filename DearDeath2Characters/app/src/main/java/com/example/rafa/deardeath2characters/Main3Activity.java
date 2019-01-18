package com.example.rafa.deardeath2characters;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;



public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        VideoView videoView = (VideoView)findViewById(R.id.video_view);
        String vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.entry;
        videoView.setVideoURI(Uri.parse(vidAddress));
        videoView.setZOrderOnTop(true);
        videoView.start();

    }

    public void empezar(View v){

        Intent intent = new Intent(v.getContext(), Principal.class);
        startActivity(intent,null);

    }
}

