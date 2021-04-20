package com.example.nbyn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class PopActivity extends AppCompatActivity {
    private String personName_str;
    private TextView display_name;
    private Bitmap bmp;
    private byte[] byteArray;
    private ImageView winner_img;
    private MediaPlayer winning_sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*0.6),(int)(height*0.5));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        winning_sound= MediaPlayer.create(this, R.raw.winning_sound);
        winning_sound.start();
        params.gravity= Gravity.CENTER;
        params.x=0;
        params.y=-20;
        getWindow().setAttributes(params);
        display_name = (TextView) findViewById(R.id.winner_text);
        winner_img = (ImageView) findViewById(R.id.winner_img);


        Intent intent = getIntent();
        Bundle extra= intent.getExtras();
        personName_str=extra.getString("personName");
        display_name.setText(personName_str+" wins");

        //extract player image input from select_activity.
        Bundle extras = getIntent().getExtras();
        byteArray = extras.getByteArray("camera_img");
        bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        Drawable drawable = new BitmapDrawable(getResources(), bmp);
        winner_img.setImageDrawable(drawable);
    }
    @Override
    public void onBackPressed() {

    }
}