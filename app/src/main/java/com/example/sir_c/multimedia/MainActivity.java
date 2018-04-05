package com.example.sir_c.multimedia;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView vvVideo;
    ImageButton ibtnPlay, ibtnStop, ibtnPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uPath = Uri.parse("android.resource://"+ getPackageName() + "/" + R.raw.video);
        vvVideo = (VideoView)findViewById(R.id.vvVideo);
        vvVideo.setVideoURI(uPath);
        MediaController mcControl = new MediaController(this);
        mcControl.setAnchorView(vvVideo);
        vvVideo.setMediaController(mcControl);


        final MediaPlayer mpMusica = MediaPlayer.create(this,R.raw.cancion);

        ibtnPlay = (ImageButton)findViewById(R.id.ibtnPlay);
        ibtnPause = (ImageButton)findViewById(R.id.ibtnPause);
        ibtnStop = (ImageButton)findViewById(R.id.ibtnStop);

        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mpMusica.isPlaying()){
                    mpMusica.start();
                } else {
                    Toast.makeText(getApplicationContext(), "Ya se esta reproduciendo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ibtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mpMusica.isPlaying()){
                    mpMusica.seekTo(0);
                    mpMusica.pause();
                } else {
                    Toast.makeText(getApplicationContext(), "Ya esta detenido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ibtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mpMusica.isPlaying()){
                    mpMusica.pause();
                } else {
                    Toast.makeText(getApplicationContext(), "Reanudando", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
