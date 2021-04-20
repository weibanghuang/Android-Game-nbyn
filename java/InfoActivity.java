package com.example.nbyn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class InfoActivity extends AppCompatActivity {
    private ImageView back_img;
    private ImageView weibang_img;
    private ImageView anthony_img;
    private MediaPlayer info_activity_music;
    private MediaPlayer anthony_sound;
    private MediaPlayer weibang_sound;
    private ImageView music_img;
    private int music_counter =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        back_img = (ImageView) findViewById(R.id.back_img);
        music_img = (ImageView) findViewById(R.id.music_img);
        weibang_img = (ImageView) findViewById(R.id.weibang_img);
        anthony_img = (ImageView) findViewById(R.id.anthony_img);
        info_activity_music = MediaPlayer.create(this, R.raw.main_sound);
        weibang_sound = MediaPlayer.create(this, R.raw.weibang_sound);
        anthony_sound = MediaPlayer.create(this, R.raw.anthony_sound);
        info_activity_music.start();
        info_activity_music.setLooping(true);
        back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent main_intent= new Intent(v.getContext(), MainActivity.class);
                startActivity(main_intent);
                overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
            }
        });
        music_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                music_img.startAnimation(animation);
                if (music_counter==1){
                    music_img.setBackgroundResource(R.drawable.nomusic);
                    if (info_activity_music.isPlaying()){
                        info_activity_music.pause();
                    }
                    music_counter=0;

                }else{
                    music_img.setBackgroundResource(R.drawable.yesmusic);
                    info_activity_music.start();
                    info_activity_music.setLooping(true);
                    music_counter=1;

                }
            }
        });
        weibang_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                weibang_img.startAnimation(animation);
                weibang_sound.start();
            }
        });
        anthony_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                anthony_img.startAnimation(animation);
                anthony_sound.start();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        info_activity_music.pause();
    }
    @Override
    protected void onResume() {
        if(info_activity_music != null && !info_activity_music.isPlaying()&& music_counter==1)
            info_activity_music.start();
        super.onResume();
    }

    //disable back button
    @Override
    public void onBackPressed() {

    }
}