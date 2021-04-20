package com.example.nbyn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LineActivity extends AppCompatActivity {
    private ImageView offline_img;
    private ImageView online_img;
    private ImageView back_img;
    private ImageView music_img;
    private MediaPlayer line_music;
    private int music_counter =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);

        offline_img = (ImageView) findViewById(R.id.offline_img);
        online_img = (ImageView) findViewById(R.id.online_img);
        back_img = (ImageView) findViewById(R.id.back_img);
        music_img = (ImageView) findViewById(R.id.music_img);
        line_music = MediaPlayer.create(this, R.raw.line);
        line_music.start();
        line_music.setLooping(true);

        // click on back_img -> go to main activity
        back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                back_img.startAnimation(animation);
                Intent main_intent= new Intent(v.getContext(), MainActivity.class);
                startActivity(main_intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        // click on offline_img -> go to select activity
        offline_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                offline_img.startAnimation(animation);
                Intent select_intent= new Intent(v.getContext(), SelectActivity.class);
                startActivity(select_intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    // click on online_img -> go to online activity
        online_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                online_img.startAnimation(animation);
                Intent online_intent= new Intent(v.getContext(), OnlineActivity.class);
                startActivity(online_intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        music_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                music_img.startAnimation(animation);
                if (music_counter==1){
                    music_img.setBackgroundResource(R.drawable.nomusic);
                    if (line_music.isPlaying()){
                        line_music.pause();
                    }
                    music_counter=0;

                }else{
                    music_img.setBackgroundResource(R.drawable.yesmusic);
                    line_music.start();
                    line_music.setLooping(true);
                    music_counter=1;

                }
            }
        });
    }
    @Override
    public void onPause() {
        super.onPause();
        line_music.pause();
    }
    @Override
    protected void onResume() {
        if(line_music != null && !line_music.isPlaying())
            line_music.start();
        super.onResume();
    }
    //disable back button
    @Override
    public void onBackPressed() {

    }
}