package com.example.nbyn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView music_img;
    private ImageView info_img;
    private ImageView play_img;
    private MediaPlayer main_activity_music;
    private GifImageView toe_img;
    private ImageView how_to_play_img;
    // 1 music on. 0 music off.
    private int music_counter =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        how_to_play_img = (ImageView) findViewById(R.id.how_to_play_img);
        play_img = (ImageView) findViewById(R.id.play);
        info_img = (ImageView) findViewById(R.id.info);
        music_img = (ImageView) findViewById(R.id.music);
        toe_img = (GifImageView) findViewById(R.id.gifImageView);

        main_activity_music = MediaPlayer.create(this, R.raw.tiktok);
        main_activity_music.start();
        main_activity_music.setLooping(true);

        // on click listeners VVVVVVVVV--------------------------------
        // click on music -> turn on/off
        music_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                music_img.startAnimation(animation);
                if (music_counter==1){
                    music_img.setBackgroundResource(R.drawable.nomusic);
                    if (main_activity_music.isPlaying()){
                        main_activity_music.pause();
                    }
                    music_counter=0;

                }else{
                    music_img.setBackgroundResource(R.drawable.yesmusic);
                    main_activity_music.start();
                    main_activity_music.setLooping(true);
                    music_counter=1;

                }
            }
        });

        // click on creative info -> go to info activity
        info_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                info_img.startAnimation(animation);
                Intent info_intent= new Intent(v.getContext(), InfoActivity.class);
                startActivity(info_intent);
                overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
            }
        });
        // click on play -> go to select activity
        play_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                play_img.startAnimation(animation);
                Intent line_intent= new Intent(v.getContext(), LineActivity.class);
                startActivity(line_intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        how_to_play_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                how_to_play_img.startAnimation(animation);
                Intent how_to_play_intent= new Intent(v.getContext(), PlayActivity.class);
                startActivity(how_to_play_intent);
                overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
            }
        });

        toe_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                toe_img.startAnimation(animation);
                Intent select_intent= new Intent(v.getContext(), SelectActivity.class);
                startActivity(select_intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        // on Click Listeners ^^^^^^^^^^^^^^------------------
    }

    // turns main_activity_music off if app is under android tabs, or if app is exited out.
    @Override
    public void onPause() {
        super.onPause();
        main_activity_music.pause();
    }
    @Override
    protected void onResume() {
        if(main_activity_music != null && !main_activity_music.isPlaying()&& music_counter==1)
            main_activity_music.start();
        super.onResume();
    }

    //disable back button
    @Override
    public void onBackPressed() {

    }

}