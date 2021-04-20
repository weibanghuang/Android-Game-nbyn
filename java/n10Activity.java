package com.example.nbyn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class n10Activity extends AppCompatActivity {

    //who goes first
    private int first_counter=(int) Math.round(Math.random());
    //whose turn is it
    private int turn_counter=1;
    //player name
    private String personName1_str;
    private String personName2_str;
    //player image bitmap
    private Bitmap bmp1;
    private Bitmap bmp2;
    //player image bitmap array
    private byte[] byteArray1;
    private byte[] byteArray2;
    //keep track of where the player click in tic tac toe
    int[][] arr_1 = new int[10][10];
    int[][] arr_2 = new int[10][10];
    //win by connect 3,4...
    int win_by = 3;
    //win by helper
    int win_by_counter=0;
    //size of tic tac toe
    int dim = arr_1.length;

    //initialize all components
    private TextView display_name;
    private ImageView back_img;
    private ImageView win_by_img;
    private ImageView button00;
    private ImageView button01;
    private ImageView button02;
    private ImageView button03;
    private ImageView button04;
    private ImageView button05;
    private ImageView button06;
    private ImageView button07;
    private ImageView button08;
    private ImageView button09;
    private ImageView button10;
    private ImageView button11;
    private ImageView button12;
    private ImageView button13;
    private ImageView button14;
    private ImageView button15;
    private ImageView button16;
    private ImageView button17;
    private ImageView button18;
    private ImageView button19;
    private ImageView button20;
    private ImageView button21;
    private ImageView button22;
    private ImageView button23;
    private ImageView button24;
    private ImageView button25;
    private ImageView button26;
    private ImageView button27;
    private ImageView button28;
    private ImageView button29;
    private ImageView button30;
    private ImageView button31;
    private ImageView button32;
    private ImageView button33;
    private ImageView button34;
    private ImageView button35;
    private ImageView button36;
    private ImageView button37;
    private ImageView button38;
    private ImageView button39;
    private ImageView button40;
    private ImageView button41;
    private ImageView button42;
    private ImageView button43;
    private ImageView button44;
    private ImageView button45;
    private ImageView button46;
    private ImageView button47;
    private ImageView button48;
    private ImageView button49;
    private ImageView button50;
    private ImageView button51;
    private ImageView button52;
    private ImageView button53;
    private ImageView button54;
    private ImageView button55;
    private ImageView button56;
    private ImageView button57;
    private ImageView button58;
    private ImageView button59;
    private ImageView button60;
    private ImageView button61;
    private ImageView button62;
    private ImageView button63;
    private ImageView button64;
    private ImageView button65;
    private ImageView button66;
    private ImageView button67;
    private ImageView button68;
    private ImageView button69;
    private ImageView button70;
    private ImageView button71;
    private ImageView button72;
    private ImageView button73;
    private ImageView button74;
    private ImageView button75;
    private ImageView button76;
    private ImageView button77;
    private ImageView button78;
    private ImageView button79;
    private ImageView button80;
    private ImageView button81;
    private ImageView button82;
    private ImageView button83;
    private ImageView button84;
    private ImageView button85;
    private ImageView button86;
    private ImageView button87;
    private ImageView button88;
    private ImageView button89;
    private ImageView button90;
    private ImageView button91;
    private ImageView button92;
    private ImageView button93;
    private ImageView button94;
    private ImageView button95;
    private ImageView button96;
    private ImageView button97;
    private ImageView button98;
    private ImageView button99;

    private ImageView music_img;
    private MediaPlayer n_15_16_music;
    private int music_counter=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n10);

        //connect initialized components to their respective xml components
        win_by_img = (ImageView) findViewById(R.id.win_by_img);
        back_img = (ImageView) findViewById(R.id.back_img);
        display_name = (TextView) findViewById(R.id.textView);
        button00 = (ImageView) findViewById(R.id.button00);
        button01 = (ImageView) findViewById(R.id.button01);
        button02 = (ImageView) findViewById(R.id.button02);
        button03 = (ImageView) findViewById(R.id.button03);
        button04 = (ImageView) findViewById(R.id.button04);
        button05 = (ImageView) findViewById(R.id.button05);
        button06 = (ImageView) findViewById(R.id.button06);
        button07 = (ImageView) findViewById(R.id.button07);
        button08 = (ImageView) findViewById(R.id.button08);
        button09 = (ImageView) findViewById(R.id.button09);
        button10 = (ImageView) findViewById(R.id.button10);
        button11 = (ImageView) findViewById(R.id.button11);
        button12 = (ImageView) findViewById(R.id.button12);
        button13 = (ImageView) findViewById(R.id.button13);
        button14 = (ImageView) findViewById(R.id.button14);
        button15 = (ImageView) findViewById(R.id.button15);
        button16 = (ImageView) findViewById(R.id.button16);
        button17 = (ImageView) findViewById(R.id.button17);
        button18 = (ImageView) findViewById(R.id.button18);
        button19 = (ImageView) findViewById(R.id.button19);
        button20 = (ImageView) findViewById(R.id.button20);
        button21 = (ImageView) findViewById(R.id.button21);
        button22 = (ImageView) findViewById(R.id.button22);
        button23 = (ImageView) findViewById(R.id.button23);
        button24 = (ImageView) findViewById(R.id.button24);
        button25 = (ImageView) findViewById(R.id.button25);
        button26 = (ImageView) findViewById(R.id.button26);
        button27 = (ImageView) findViewById(R.id.button27);
        button28 = (ImageView) findViewById(R.id.button28);
        button29 = (ImageView) findViewById(R.id.button29);
        button30 = (ImageView) findViewById(R.id.button30);
        button31 = (ImageView) findViewById(R.id.button31);
        button32 = (ImageView) findViewById(R.id.button32);
        button33 = (ImageView) findViewById(R.id.button33);
        button34 = (ImageView) findViewById(R.id.button34);
        button35 = (ImageView) findViewById(R.id.button35);
        button36 = (ImageView) findViewById(R.id.button36);
        button37 = (ImageView) findViewById(R.id.button37);
        button38 = (ImageView) findViewById(R.id.button38);
        button39 = (ImageView) findViewById(R.id.button39);
        button40 = (ImageView) findViewById(R.id.button40);
        button41 = (ImageView) findViewById(R.id.button41);
        button42 = (ImageView) findViewById(R.id.button42);
        button43 = (ImageView) findViewById(R.id.button43);
        button44 = (ImageView) findViewById(R.id.button44);
        button45 = (ImageView) findViewById(R.id.button45);
        button46 = (ImageView) findViewById(R.id.button46);
        button47 = (ImageView) findViewById(R.id.button47);
        button48 = (ImageView) findViewById(R.id.button48);
        button49 = (ImageView) findViewById(R.id.button49);
        button50 = (ImageView) findViewById(R.id.button50);
        button51 = (ImageView) findViewById(R.id.button51);
        button52 = (ImageView) findViewById(R.id.button52);
        button53 = (ImageView) findViewById(R.id.button53);
        button54 = (ImageView) findViewById(R.id.button54);
        button55 = (ImageView) findViewById(R.id.button55);
        button56 = (ImageView) findViewById(R.id.button56);
        button57 = (ImageView) findViewById(R.id.button57);
        button58 = (ImageView) findViewById(R.id.button58);
        button59 = (ImageView) findViewById(R.id.button59);
        button60 = (ImageView) findViewById(R.id.button60);
        button61 = (ImageView) findViewById(R.id.button61);
        button62 = (ImageView) findViewById(R.id.button62);
        button63 = (ImageView) findViewById(R.id.button63);
        button64 = (ImageView) findViewById(R.id.button64);
        button65 = (ImageView) findViewById(R.id.button65);
        button66 = (ImageView) findViewById(R.id.button66);
        button67 = (ImageView) findViewById(R.id.button67);
        button68 = (ImageView) findViewById(R.id.button68);
        button69 = (ImageView) findViewById(R.id.button69);
        button70 = (ImageView) findViewById(R.id.button70);
        button71 = (ImageView) findViewById(R.id.button71);
        button72 = (ImageView) findViewById(R.id.button72);
        button73 = (ImageView) findViewById(R.id.button73);
        button74 = (ImageView) findViewById(R.id.button74);
        button75 = (ImageView) findViewById(R.id.button75);
        button76 = (ImageView) findViewById(R.id.button76);
        button77 = (ImageView) findViewById(R.id.button77);
        button78 = (ImageView) findViewById(R.id.button78);
        button79 = (ImageView) findViewById(R.id.button79);
        button80 = (ImageView) findViewById(R.id.button80);
        button81 = (ImageView) findViewById(R.id.button81);
        button82 = (ImageView) findViewById(R.id.button82);
        button83 = (ImageView) findViewById(R.id.button83);
        button84 = (ImageView) findViewById(R.id.button84);
        button85 = (ImageView) findViewById(R.id.button85);
        button86 = (ImageView) findViewById(R.id.button86);
        button87 = (ImageView) findViewById(R.id.button87);
        button88 = (ImageView) findViewById(R.id.button88);
        button89 = (ImageView) findViewById(R.id.button89);
        button90 = (ImageView) findViewById(R.id.button90);
        button91 = (ImageView) findViewById(R.id.button91);
        button92 = (ImageView) findViewById(R.id.button92);
        button93 = (ImageView) findViewById(R.id.button93);
        button94 = (ImageView) findViewById(R.id.button94);
        button95 = (ImageView) findViewById(R.id.button95);
        button96 = (ImageView) findViewById(R.id.button96);
        button97 = (ImageView) findViewById(R.id.button97);
        button98 = (ImageView) findViewById(R.id.button98);
        button99 = (ImageView) findViewById(R.id.button99);

        music_img = (ImageView) findViewById(R.id.music_img);
        n_15_16_music = MediaPlayer.create(this, R.raw.sound_15_16);
        n_15_16_music.start();
        n_15_16_music.setLooping(true);

        music_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                music_img.startAnimation(animation);
                if (music_counter==1){
                    music_img.setBackgroundResource(R.drawable.nomusic);
                    if (n_15_16_music.isPlaying()){
                        n_15_16_music.pause();
                    }
                    music_counter=0;

                }else{
                    music_img.setBackgroundResource(R.drawable.yesmusic);
                    n_15_16_music.start();
                    n_15_16_music.setLooping(true);
                    music_counter=1;

                }
            }
        });

        //extract player name input from select_activity. If player name is empty or space, change to Player 1/2
        Intent intent = getIntent();
        Bundle extra= intent.getExtras();
        personName1_str=extra.getString("personName1");
        personName2_str=extra.getString("personName2");
        if (personName1_str.trim().isEmpty()){
            personName1_str="Player 1";
        }
        if (personName2_str.trim().isEmpty()){
            personName2_str="Player 2";
        }
        if (first_counter==0){
            display_name.setText(personName1_str+" goes first");
        }else{
            display_name.setText(personName2_str+" goes first");
        }



        Bundle extras = getIntent().getExtras();
        //extract player image array input from select_activity.
        byteArray1 = extras.getByteArray("camera_img1");
        byteArray2 = extras.getByteArray("camera_img2");
        //convert array to bitmap
        bmp1 = BitmapFactory.decodeByteArray(byteArray1, 0, byteArray1.length);
        bmp2 = BitmapFactory.decodeByteArray(byteArray2, 0, byteArray2.length);


        // click on back_img -> go to select activity
        back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent select_intent= new Intent(v.getContext(), SelectActivity.class);
                select_intent.putExtra("personName1_str", personName1_str);
                select_intent.putExtra("personName2_str", personName2_str);
                select_intent.putExtra("camera_img1", byteArray1);
                select_intent.putExtra("camera_img2", byteArray2);
                startActivityForResult(select_intent, 10);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        //click to change image
        // let player select 3,4,...
        win_by_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                win_by_counter=win_by_counter+1;
                if (win_by_counter%8==0){
                        win_by_img.setImageResource(R.drawable.n3);
                        win_by=3;
                }else if(win_by_counter%8==1){
                    win_by_img.setImageResource(R.drawable.n4);
                    win_by=4;
                }else if(win_by_counter%8==2){
                    win_by_img.setImageResource(R.drawable.n5);
                    win_by=5;
                }else if(win_by_counter%8==3){
                    win_by_img.setImageResource(R.drawable.n6);
                    win_by=6;
                }else if(win_by_counter%8==4){
                    win_by_img.setImageResource(R.drawable.n7);
                    win_by=7;
                }else if(win_by_counter%8==5){
                    win_by_img.setImageResource(R.drawable.n8);
                    win_by=8;
                }else if(win_by_counter%8==6){
                    win_by_img.setImageResource(R.drawable.n9);
                    win_by=9;
                }else if(win_by_counter%8==7){
                    win_by_img.setImageResource(R.drawable.n10);
                    win_by=10;
                }
            }
        });

        //imageview button listener go to setImage method
        button00.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button00);
            }
        });
        button01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button01);
            }
        });
        button02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button02);
            }
        });
        button03.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button03);
            }
        });
        button04.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button04);
            }
        });
        button05.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button05);
            }
        });
        button06.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button06);
            }
        });
        button07.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button07);
            }
        });
        button08.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button08);
            }
        });
        button09.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button09);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button10);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button11);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button12);
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button13);
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button14);
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button15);
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button16);
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button17);
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button18);
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button19);
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button20);
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button21);
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button22);
            }
        });
        button23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button23);
            }
        });
        button24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button24);
            }
        });
        button25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button25);
            }
        });
        button26.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button26);
            }
        });
        button27.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button27);
            }
        });
        button28.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button28);
            }
        });
        button29.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button29);
            }
        });
        button30.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button30);
            }
        });
        button31.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button31);
            }
        });
        button32.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button32);
            }
        });
        button33.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button33);
            }
        });
        button34.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button34);
            }
        });
        button35.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button35);
            }
        });
        button36.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button36);
            }
        });
        button37.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button37);
            }
        });
        button38.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button38);
            }
        });
        button39.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button39);
            }
        });
        button40.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button40);
            }
        });
        button41.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button41);
            }
        });
        button42.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button42);
            }
        });
        button43.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button43);
            }
        });
        button44.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button44);
            }
        });
        button45.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button45);
            }
        });
        button46.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button46);
            }
        });
        button47.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button47);
            }
        });
        button48.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button48);
            }
        });
        button49.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button49);
            }
        });
        button50.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button50);
            }
        });
        button51.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button51);
            }
        });
        button52.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button52);
            }
        });
        button53.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button53);
            }
        });
        button54.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button54);
            }
        });
        button55.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button55);
            }
        });
        button56.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button56);
            }
        });
        button57.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button57);
            }
        });
        button58.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button58);
            }
        });
        button59.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button59);
            }
        });
        button60.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button60);
            }
        });
        button61.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button61);
            }
        });
        button62.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button62);
            }
        });
        button63.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button63);
            }
        });
        button64.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button64);
            }
        });
        button65.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button65);
            }
        });
        button66.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button66);
            }
        });
        button67.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button67);
            }
        });
        button68.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button68);
            }
        });
        button69.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button69);
            }
        });
        button70.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button70);
            }
        });
        button71.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button71);
            }
        });
        button72.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button72);
            }
        });
        button73.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button73);
            }
        });
        button74.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button74);
            }
        });
        button75.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button75);
            }
        });
        button76.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button76);
            }
        });
        button77.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button77);
            }
        });
        button78.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button78);
            }
        });
        button79.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button79);
            }
        });
        button80.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button80);
            }
        });
        button81.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button81);
            }
        });
        button82.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button82);
            }
        });
        button83.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button83);
            }
        });
        button84.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button84);
            }
        });
        button85.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button85);
            }
        });
        button86.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button86);
            }
        });
        button87.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button87);
            }
        });
        button88.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button88);
            }
        });
        button89.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button89);
            }
        });
        button90.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button90);
            }
        });
        button91.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button91);
            }
        });
        button92.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button92);
            }
        });
        button93.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button93);
            }
        });
        button94.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button94);
            }
        });
        button95.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button95);
            }
        });
        button96.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button96);
            }
        });
        button97.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button97);
            }
        });
        button98.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button98);
            }
        });
        button99.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setImage(button99);
            }
        });


    }

    //click on imageview, change image to player's image
    //keep track of first_counter and turn_counter
    //change 2darray corresponding to which image is clicked
    //every setImage method go to check4winner method
    public void setImage(ImageView imageview){
        win_by_img.setEnabled(false);
        if (first_counter==0){
            if (turn_counter==1){
                Drawable drawable = new BitmapDrawable(getResources(), bmp1);
                imageview.setImageDrawable(drawable);
                arr_1[button_position(imageview)[0]][button_position(imageview)[1]]=1;
                display_name.setText(personName2_str+" 's turn");
                turn_counter=2;
            }else{
                Drawable drawable = new BitmapDrawable(getResources(), bmp2);
                imageview.setImageDrawable(drawable);
                arr_2[button_position(imageview)[0]][button_position(imageview)[1]]=10;
                display_name.setText(personName1_str+" 's turn");
                turn_counter=1;
            }
        }else{
            if (turn_counter==1){
                Drawable drawable = new BitmapDrawable(getResources(), bmp2);
                imageview.setImageDrawable(drawable);
                arr_1[button_position(imageview)[0]][button_position(imageview)[1]]=10;
                display_name.setText(personName1_str+" 's turn");
                turn_counter=2;
            }else{
                Drawable drawable = new BitmapDrawable(getResources(), bmp1);
                imageview.setImageDrawable(drawable);
                arr_2[button_position(imageview)[0]][button_position(imageview)[1]]=1;
                display_name.setText(personName2_str+" 's turn");
                turn_counter=1;
            }
        }
        imageview.setEnabled(false);
        check4winner(imageview);
    }

    //input a button imageview, return its postion
    public static int[] button_position(ImageView imageview){
        String button_name = (String) imageview.getResources().getResourceName(imageview.getId());
        int a=button_name.charAt(button_name.length()-2)-'0';
        int b=button_name.charAt(button_name.length()-1)-'0';
        return new int[]{a,b};
    }


    //check for winner
    public void check4winner(ImageView imageview){
        int a = button_position(imageview)[0];
        int b = button_position(imageview)[1];
        //positive diagonal
        int pos_diag=0;
        for (int i = 1; i < dim; i++) {
            if (a-i>-1&&b+i<dim){
                if (turn_counter==2){
                    if(arr_1[a-i][b+i]!=0){
                        pos_diag=pos_diag+1;
                    }else{
                        break;
                    }
                }else{
                    if(arr_2[a-i][b+i]!=0){
                        pos_diag=pos_diag+1;
                    }else{
                        break;
                    }
                }

            }
        }
        for (int i = 1; i < dim; i++) {
            if (a+i<dim&&b-i>-1){
                if (turn_counter==2){
                    if(arr_1[a+i][b-i]!=0){
                        pos_diag=pos_diag+1;
                    }else{
                        break;
                    }
                }else{
                    if(arr_2[a+i][b-i]!=0){
                        pos_diag=pos_diag+1;
                    }else{
                        break;
                    }
                }

            }
        }
        //negative diagonal
        int neg_diag=0;
        for (int i = 1; i < dim; i++) {
            if (a+i<dim&&b+i<dim){
                if (turn_counter==2){
                    if(arr_1[a+i][b+i]!=0){
                        neg_diag=neg_diag+1;
                    }else{
                        break;
                    }
                }else{
                    if(arr_2[a+i][b+i]!=0){
                        neg_diag=neg_diag+1;
                    }else{
                        break;
                    }
                }

            }
        }
        for (int i = 1; i < dim; i++) {
            if (a-i>-1&&b-i>-1){
                if (turn_counter==2){
                    if(arr_1[a-i][b-i]!=0){
                        neg_diag=neg_diag+1;
                    }else{
                        break;
                    }
                }else{
                    if(arr_2[a-i][b-i]!=0){
                        neg_diag=neg_diag+1;
                    }else{
                        break;
                    }
                }

            }
        }
        //vertical
        int vert=0;
        for (int i = 1; i < dim; i++) {
            if (a+i<dim){
                if (turn_counter==2){
                    if(arr_1[a+i][b]!=0){
                        vert=vert+1;
                    }else{
                        break;
                    }
                }else{
                    if(arr_2[a+i][b]!=0){
                        vert=vert+1;
                    }else{
                        break;
                    }
                }

            }
        }
        for (int i = 1; i < dim; i++) {
            if (a-i>-1){
                if (turn_counter==2){
                    if(arr_1[a-i][b]!=0){
                        vert=vert+1;
                    }else{
                        break;
                    }
                }else{
                    if(arr_2[a-i][b]!=0){
                        vert=vert+1;
                    }else{
                        break;
                    }
                }

            }
        }
        //horizontal
        int hori=0;
        for (int i = 1; i < dim; i++) {
            if (b+i<dim){
                if (turn_counter==2){
                    if(arr_1[a][b+i]!=0){
                        hori=hori+1;
                    }else{
                        break;
                    }
                }else{
                    if(arr_2[a][b+i]!=0){
                        hori=hori+1;
                    }else{
                        break;
                    }
                }

            }
        }
        for (int i = 1; i < dim; i++) {
            if (b-i>-1){
                if (turn_counter==2){
                    if(arr_1[a][b-i]!=0){
                        hori=hori+1;
                    }else{
                        break;
                    }
                }else{
                    if(arr_2[a][b-i]!=0){
                        hori=hori+1;
                    }else{
                        break;
                    }
                }

            }
        }
        if (neg_diag==win_by-1||pos_diag==win_by-1||vert==win_by-1||hori==win_by-1){
            Intent pop_intent= new Intent(n10Activity.this , PopActivity.class);
            if (first_counter==0){
                if (turn_counter==1){
                    pop_intent.putExtra("personName", personName2_str);
                    pop_intent.putExtra("camera_img", byteArray2);
                }else{
                    pop_intent.putExtra("personName", personName1_str);
                    pop_intent.putExtra("camera_img", byteArray1);
                }
            }else{
                if (turn_counter==1){
                    pop_intent.putExtra("personName", personName1_str);
                    pop_intent.putExtra("camera_img", byteArray1);
                }else{
                    pop_intent.putExtra("personName", personName2_str);
                    pop_intent.putExtra("camera_img", byteArray2);
                }
            }



            startActivityForResult(pop_intent,10);
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        n_15_16_music.pause();
    }
    @Override
    protected void onResume() {
        if(n_15_16_music != null && !n_15_16_music.isPlaying()&& music_counter==1)
            n_15_16_music.start();
        super.onResume();
    }
    //disable back button
    @Override
    public void onBackPressed() {

    }

}