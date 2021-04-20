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

public class n4Activity extends AppCompatActivity {

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
    int[][] arr_1 = new int[7][7];
    int[][] arr_2 = new int[7][7];
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
    private ImageView button10;
    private ImageView button11;
    private ImageView button12;
    private ImageView button13;
    private ImageView button20;
    private ImageView button21;
    private ImageView button22;
    private ImageView button23;
    private ImageView button30;
    private ImageView button31;
    private ImageView button32;
    private ImageView button33;
    private ImageView music_img;
    private MediaPlayer n_15_16_music;
    private int music_counter=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n4);

        //connect initialized components to their respective xml components
        win_by_img = (ImageView) findViewById(R.id.win_by_img);
        back_img = (ImageView) findViewById(R.id.back_img);
        display_name = (TextView) findViewById(R.id.textView);
        button00 = (ImageView) findViewById(R.id.button00);
        button01 = (ImageView) findViewById(R.id.button01);
        button02 = (ImageView) findViewById(R.id.button02);
        button03 = (ImageView) findViewById(R.id.button03);
        button10 = (ImageView) findViewById(R.id.button10);
        button11 = (ImageView) findViewById(R.id.button11);
        button12 = (ImageView) findViewById(R.id.button12);
        button13 = (ImageView) findViewById(R.id.button13);
        button20 = (ImageView) findViewById(R.id.button20);
        button21 = (ImageView) findViewById(R.id.button21);
        button22 = (ImageView) findViewById(R.id.button22);
        button23 = (ImageView) findViewById(R.id.button23);
        button30 = (ImageView) findViewById(R.id.button30);
        button31 = (ImageView) findViewById(R.id.button31);
        button32 = (ImageView) findViewById(R.id.button32);
        button33 = (ImageView) findViewById(R.id.button33);

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
            display_name.setText(personName1_str+" goes first.");
        }else{
            display_name.setText(personName2_str+" goes first.");
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
                if (win_by_counter%2==0){
                    win_by_img.setImageResource(R.drawable.n3);
                    win_by=3;
                }else if(win_by_counter%2==1){
                    win_by_img.setImageResource(R.drawable.n4);
                    win_by=4;
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
            Intent pop_intent= new Intent(n4Activity.this , PopActivity.class);
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