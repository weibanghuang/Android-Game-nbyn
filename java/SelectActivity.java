package com.example.nbyn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.icu.text.IDNA;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

import pl.droidsonroids.gif.GifImageView;


public class SelectActivity extends AppCompatActivity {
    private ImageView back_img;
    private ImageView music_img;
    private ImageView camera_img1;
    private ImageView camera_img2;
    private GifImageView turn_on_camera1;
    private GifImageView turn_on_camera2;
    private ImageView n3_img;
    private ImageView n4_img;
    private ImageView n5_img;
    private ImageView n6_img;
    private ImageView n7_img;
    private ImageView n8_img;
    private ImageView n9_img;
    private ImageView n10_img;
    private EditText personName1;
    private EditText personName2;
    private String personName1_str;
    private String personName2_str;
    // 1 -> music on. 0 -> music off.
    private int select_music_counter =1;
    private MediaPlayer select_activity_music;
    // 1 -> camera 1, 2 -> camera 2
    private int camera_counter =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        back_img = (ImageView) findViewById(R.id.back_img);
        music_img = (ImageView) findViewById(R.id.music_img);
        camera_img1 = (ImageView) findViewById(R.id.camera_img1);
        camera_img2 = (ImageView) findViewById(R.id.camera_img2);
        turn_on_camera1 = (GifImageView) findViewById(R.id.turn_on_camera1);
        turn_on_camera2 = (GifImageView) findViewById(R.id.turn_on_camera2);
        n3_img = (ImageView) findViewById(R.id.n3_img);
        n4_img = (ImageView) findViewById(R.id.n4_img);
        n5_img = (ImageView) findViewById(R.id.n5_img);
        n6_img = (ImageView) findViewById(R.id.n6_img);
        n7_img = (ImageView) findViewById(R.id.n7_img);
        n8_img = (ImageView) findViewById(R.id.n8_img);
        n9_img = (ImageView) findViewById(R.id.n9_img);
        n10_img = (ImageView) findViewById(R.id.n10_img);
        personName1 = (EditText) findViewById(R.id.personName1);
        personName2 = (EditText) findViewById(R.id.personName2);



        //check if select activity came from n3-n10 activity, set edittext text to player name
        //check if select activity came from n3-n10 activity, set image array to bitmap to drawable to camera image
        //I do this because (input name in select activity) -> (display input name in n3-n10 activity) -> (go back to select activity, all data disappears)
        Intent intent = getIntent();
        Bundle extra= intent.getExtras();
        if(intent.hasExtra("personName1_str")){
            personName1_str=extra.getString("personName1_str");
            personName1.setText(personName1_str);
        }
        if(intent.hasExtra("personName2_str")){
            personName2_str=extra.getString("personName2_str");
            personName2.setText(personName2_str);
        }
        if(intent.hasExtra("camera_img1")){
            byte[] byteArray1 = extra.getByteArray("camera_img1");
            Bitmap bmp1 = BitmapFactory.decodeByteArray(byteArray1, 0, byteArray1.length);
            Drawable drawable_1 = new BitmapDrawable(getResources(), bmp1);
            camera_img1.setImageDrawable(drawable_1);
        }else{
            //convert ImageView camera_img1/2 picture to drawable to standardize everything to drawable.
            Bitmap human_bit = BitmapFactory.decodeResource(getResources(), R.drawable.human);
            Drawable drawable1 = new BitmapDrawable(getResources(), human_bit);
            camera_img1.setImageDrawable(drawable1);
        }
        if(intent.hasExtra("camera_img2")){
            byte[] byteArray2 = extra.getByteArray("camera_img2");
            Bitmap bmp2 = BitmapFactory.decodeByteArray(byteArray2, 0, byteArray2.length);
            Drawable drawable_2 = new BitmapDrawable(getResources(), bmp2);
            camera_img2.setImageDrawable(drawable_2);
        }else{
            //convert ImageView camera_img1/2 picture to drawable to standardize everything to drawable.
            Bitmap player_bit = BitmapFactory.decodeResource(getResources(), R.drawable.player);
            Drawable drawable2 = new BitmapDrawable(getResources(), player_bit);
            camera_img2.setImageDrawable(drawable2);
        }

        // play music
        select_activity_music = MediaPlayer.create(this, R.raw.select_sound);
        select_activity_music.start();
        select_activity_music.setLooping(true);




        // request camera
        if (ContextCompat.checkSelfPermission(SelectActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //granted, turns on camera button
            ActivityCompat.requestPermissions(SelectActivity.this, new String[]{
                    Manifest.permission.CAMERA
            }, 100);
        }

        //camera button is off until permission to use camera is granted.
        //this avoids app quitting when camera button is pressed when permission is denied.
        if (PackageManager.PERMISSION_GRANTED== SelectActivity.this.checkCallingOrSelfPermission(android.Manifest.permission.CAMERA)) {
            turn_on_camera1.setEnabled(true);
            turn_on_camera2.setEnabled(true);
            turn_on_camera1.setImageResource(R.drawable.camera_gif);
            turn_on_camera2.setImageResource(R.drawable.camera_gif);
        }else{
            turn_on_camera1.setEnabled(false);
            turn_on_camera2.setEnabled(false);
            turn_on_camera1.setImageResource(R.drawable.camera_off);
            turn_on_camera2.setImageResource(R.drawable.camera_off);
        }


        // use camera1 if permission granted
        turn_on_camera1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                turn_on_camera1.startAnimation(animation);
                camera_counter=1;
                Intent camera_intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, 100);
            }
        });

        // use camera2 if permission granted
        turn_on_camera2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                turn_on_camera2.startAnimation(animation);
                camera_counter=2;
                Intent camera_intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, 100);
            }
        });

        // click on back_img -> go to line activity
        back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                back_img.startAnimation(animation);
                Intent line_intent= new Intent(v.getContext(), LineActivity.class);
                startActivity(line_intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });


        //play pause music
        music_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                music_img.startAnimation(animation);
                if (select_music_counter==1){
                    music_img.setBackgroundResource(R.drawable.nomusic);
                    if (select_activity_music.isPlaying()){
                        select_activity_music.pause();
                    }
                    select_music_counter=0;

                }else{
                    music_img.setBackgroundResource(R.drawable.yesmusic);
                    select_activity_music.start();
                    select_activity_music.setLooping(true);
                    select_music_counter=1;

                }
            }
        });

        // click on camera img 1 -> change back to human png.
        camera_img1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                camera_img1.startAnimation(animation);
                Bitmap human_bit = BitmapFactory.decodeResource(getResources(), R.drawable.human);
                Drawable drawable = new BitmapDrawable(getResources(), human_bit);
                camera_img1.setImageDrawable(drawable);
            }
        });

        // click on camera img 2 -> change back to player png.
        camera_img2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                camera_img2.startAnimation(animation);
                Bitmap player_bit = BitmapFactory.decodeResource(getResources(), R.drawable.player);
                Drawable drawable = new BitmapDrawable(getResources(), player_bit);
                camera_img2.setImageDrawable(drawable);
            }
        });

        // go to n3 activity
        n3_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                n3_img.startAnimation(animation);
                go2activity(n3Activity.class);
            }
        });


        // go to n4 activity
        n4_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                n4_img.startAnimation(animation);
                go2activity(n4Activity.class);
            }
        });

        // go to n5 activity
        n5_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                n5_img.startAnimation(animation);
                go2activity(n5Activity.class);

            }
        });


        // go to n6 activity
        n6_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                n6_img.startAnimation(animation);
                go2activity(n6Activity.class);
            }
        });

        // go to n7 activity
        n7_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                n7_img.startAnimation(animation);
                go2activity(n7Activity.class);
            }
        });

        // go to n8 activity
        n8_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                n8_img.startAnimation(animation);
                go2activity(n8Activity.class);
            }
        });

        // go to n9 activity
        n9_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                n9_img.startAnimation(animation);
                go2activity(n9Activity.class);
            }
        });

        // go to n10 activity
        n10_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                n10_img.startAnimation(animation);
                go2activity(n10Activity.class);
            }
        });

    }

    //take in activity.class parameter, go to the activity
    public void go2activity(Class class1){

        Intent n_intent= new Intent(SelectActivity.this , class1);

        n_intent.putExtra("personName1", personName1.getText().toString());
        n_intent.putExtra("personName2", personName2.getText().toString());

        n_intent.putExtra("camera_img1", convert2array(camera_img1));
        n_intent.putExtra("camera_img2", convert2array(camera_img2));

        startActivityForResult(n_intent,10);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public byte[] convert2array(ImageView imageview){
        Bitmap bmp1 = ((BitmapDrawable) imageview.getDrawable()).getBitmap();
        ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
        bmp1.compress(Bitmap.CompressFormat.PNG, 100, stream1);
        byte[] byteArray1 = stream1.toByteArray();
        return byteArray1;
    }

    // set camera image to bitmap
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super .onActivityResult(requestCode, resultCode, data);
        if (requestCode==100){
            try{
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                // crop bitmap into square aspect ratio
                if (bitmap.getWidth() >= bitmap.getHeight()){

                    bitmap = Bitmap.createBitmap(
                            bitmap,
                            bitmap.getWidth()/2 - bitmap.getHeight()/2,
                            0,
                            bitmap.getHeight(),
                            bitmap.getHeight()
                    );

                }else{

                    bitmap = Bitmap.createBitmap(
                            bitmap,
                            0,
                            bitmap.getHeight()/2 - bitmap.getWidth()/2,
                            bitmap.getWidth(),
                            bitmap.getWidth()
                    );
                }
                if (camera_counter==1) {
                    camera_img1.setImageDrawable(pixel(bitmap));
                }else{
                    camera_img2.setImageDrawable(pixel(bitmap));
                }
            }catch (NullPointerException e) {
                //if no picture taken, do nothing lol
            }
        }
    }

    // take in camera input, convert to bit map, then convert to drawable pixel
    public Drawable pixel(Bitmap src) {
        int pixel_size=20;
        // create output bitmap
        Bitmap bmOut = Bitmap.createBitmap(pixel_size,pixel_size,src.getConfig());
        // color information
        int pixel;
        int red;
        int blue;
        int green;
        int alpha=255;
        // scan through all pixels
        for(int x = 0; x < pixel_size; ++x) {
            for(int y = 0; y < pixel_size; ++y) {
                // get pixel color
                pixel = src.getPixel((x*(src.getWidth()/pixel_size))+(src.getWidth()/(2*pixel_size)), (y*(src.getWidth()/pixel_size))+(src.getWidth()/(2*pixel_size)));
                red=Color.red(pixel);
                blue=Color.blue(pixel);
                green=Color.green(pixel);
                bmOut.setPixel(x, y, Color.argb(alpha, red, green, blue));
            }
        }
        Drawable drawable = new BitmapDrawable(getResources(), bmOut);
        drawable.setFilterBitmap(false);
        // return final image
        return drawable;
    }

    // turns select_activity_music off if app is under android tabs, or if app is exited out.
    @Override
    public void onPause() {
        super.onPause();
        select_activity_music.pause();
    }
    @Override
    protected void onResume() {
        if(select_activity_music != null && !select_activity_music.isPlaying()&& select_music_counter==1)
            select_activity_music.start();
        super.onResume();
    }

    //disable back button
    @Override
    public void onBackPressed() {

    }
}