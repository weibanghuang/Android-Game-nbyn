package com.example.nbyn;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class OnlineActivity extends AppCompatActivity {
    private GifImageView turn_on_camera;
    private ImageView camera_img;
    private EditText player_name;
    private EditText room_name;
    private ImageView create_img;
    private ImageView join_img;
    private ImageView back_img;
    private ImageView music_img;
    private int camera_counter=0;
    private ImageView nbyn_img;
    private ImageView win_by_img;
    private int nbyn_counter=0;
    private int nbyn=3;
    private int win_by_counter=0;
    private int win_by=3;
    private int turn_counter=(int) Math.round(Math.random());
    private int room_counter=1;
    private String player_name_str="";
    private String room_name_str;
    private byte[] byteArray;
    private int x_move=11;
    private int y_move=11;
    private int music_counter=1;
    private MediaPlayer online_activity_music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);

        //initialize
        turn_on_camera = (GifImageView) findViewById(R.id.turn_on_camera);
        camera_img = (ImageView) findViewById(R.id.camera_img);
        player_name = (EditText) findViewById(R.id.player_name);
        room_name = (EditText) findViewById(R.id.room_name);
        create_img = (ImageView) findViewById(R.id.create_img);
        join_img = (ImageView) findViewById(R.id.join_img);
        back_img = (ImageView) findViewById(R.id.back_img);
        win_by_img = (ImageView) findViewById(R.id.winby_img);
        nbyn_img = (ImageView) findViewById(R.id.nbyn_img);
        music_img = (ImageView) findViewById(R.id.music_img);

        //music
        online_activity_music = MediaPlayer.create(this,R.raw.select_sound);
        online_activity_music.start();
        online_activity_music.setLooping(true);

        // click on music -> turn on/off
        music_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                music_img.startAnimation(animation);
                if (music_counter==1){
                    music_img.setBackgroundResource(R.drawable.nomusic);
                    if (online_activity_music.isPlaying()){
                        online_activity_music.pause();
                    }
                    music_counter=0;

                }else{
                    music_img.setBackgroundResource(R.drawable.yesmusic);
                    online_activity_music.start();
                    online_activity_music.setLooping(true);
                    music_counter=1;

                }
            }
        });


        //click to change image
        // let player select 3,4,...
        nbyn_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                nbyn_img.startAnimation(animation);
                nbyn_counter=((nbyn_counter+1)%8);
                if (nbyn_counter==0){
                    nbyn_img.setImageResource(R.drawable.n3);
                    nbyn=3;
                }else if (nbyn_counter==1){
                    nbyn_img.setImageResource(R.drawable.n4);
                    nbyn=4;
                }else if (nbyn_counter==2){
                    nbyn_img.setImageResource(R.drawable.n5);
                    nbyn=5;
                }else if (nbyn_counter==3){
                    nbyn_img.setImageResource(R.drawable.n6);
                    nbyn=6;
                }else if (nbyn_counter==4){
                    nbyn_img.setImageResource(R.drawable.n7);
                    nbyn=7;
                }else if (nbyn_counter==5){
                    nbyn_img.setImageResource(R.drawable.n8);
                    nbyn=8;
                }else if (nbyn_counter==6){
                    nbyn_img.setImageResource(R.drawable.n9);
                    nbyn=9;
                }else if (nbyn_counter==7){
                    nbyn_img.setImageResource(R.drawable.n10);
                    nbyn=10;
                }
                if (nbyn<win_by){
                    win_by_img.setImageResource(R.drawable.n3);
                    win_by=3;
                    win_by_counter=0;
                }
            }
        });

        //click to change image
        // let player select 3,4,...
        win_by_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                win_by_img.startAnimation(animation);
                win_by_counter=(win_by_counter+1)%(nbyn_counter+1);
                if (win_by_counter==0){
                    win_by_img.setImageResource(R.drawable.n3);
                    win_by=3;
                }else if (win_by_counter==1){
                    win_by_img.setImageResource(R.drawable.n4);
                    win_by=4;
                }else if (win_by_counter==2){
                    win_by_img.setImageResource(R.drawable.n5);
                    win_by=5;
                }else if (win_by_counter==3){
                    win_by_img.setImageResource(R.drawable.n6);
                    win_by=6;
                }else if (win_by_counter==4){
                    win_by_img.setImageResource(R.drawable.n7);
                    win_by=7;
                }else if (win_by_counter==5){
                    win_by_img.setImageResource(R.drawable.n8);
                    win_by=8;
                }else if (win_by_counter==6){
                    win_by_img.setImageResource(R.drawable.n9);
                    win_by=9;
                }else if (win_by_counter==7){
                    win_by_img.setImageResource(R.drawable.n10);
                    win_by=10;
                }

            }
        });

        back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                back_img.startAnimation(animation);
                Intent line_intent= new Intent(v.getContext(), LineActivity.class);
                startActivity(line_intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        create_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //animation
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                create_img.startAnimation(animation);
                player_name_str = player_name.getText().toString();
                room_name_str = room_name.getText().toString();
                if (camera_counter==0||status()){
                    if(camera_counter==0){
                        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                        camera_img.startAnimation(animation1);
                    }
                    //Take a picture or tap to use default image.
                    //Room/Player names can only be letter(s) and/or number(s).
                    name_toast();
                }else{
                    //after camera and name are all good
                    //check user name duplicate and then check for room counter
                    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();

                    //get connection to user node
                    DatabaseReference reference_name = rootNode.getReference("user");

                    //get connection to room node
                    DatabaseReference reference_room = rootNode.getReference("room");
                    Query checkName = reference_name.orderByChild("player_name_str").equalTo(player_name_str);

                    //check if name is duplicate
                    checkName.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //user name already exists
                            if(snapshot.exists()){
                                Toast.makeText(OnlineActivity.this, "Name already exists.",
                                        Toast.LENGTH_SHORT).show();
                            }else{
                                //if user name doesn't exists, check if room exists
                                Query checkRoom = reference_room.orderByChild("room_name_str").equalTo(room_name_str);
                                checkRoom.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        //room already exists
                                        if (snapshot.exists()){
                                            Toast.makeText(OnlineActivity.this, "Room already exists.",
                                                    Toast.LENGTH_SHORT).show();
                                        }else{
                                            //create room and create user into database
                                            //create room, create_user is player name 1. join_ser is player name 2.
                                            OnlineActivityRoom room_helper = new OnlineActivityRoom(room_counter,room_name_str,player_name_str, "", win_by, nbyn, turn_counter);
                                            reference_room.child(room_name_str).setValue(room_helper);
                                            //create player
                                            OnlineActivityHelper user_helper = new OnlineActivityHelper(player_name_str, room_name_str, x_move, y_move);
                                            reference_name.child(player_name_str).setValue(user_helper);
                                            //go to the game
                                            createActivity();
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        Toast.makeText(OnlineActivity.this, "Error: @ create_img checkRoom",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(OnlineActivity.this, "Error: @ create_img checkName",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


        join_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //animation
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                join_img.startAnimation(animation);
                player_name_str = player_name.getText().toString();
                room_name_str = room_name.getText().toString();
                if (camera_counter==0||status()){
                    if(camera_counter==0){
                        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                        camera_img.startAnimation(animation1);
                    }
                    //Take a picture or tap to use default image.
                    //Room/Player names can only be letter(s) and/or number(s).
                    name_toast();
                }else{
                    //after camera and name are all good
                    //check user name duplicate and then check for room counter
                    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();

                    //get connection to user node
                    DatabaseReference reference_name = rootNode.getReference("user");

                    //get connection to room node
                    DatabaseReference reference_room = rootNode.getReference("room");
                    Query checkName = reference_name.orderByChild("player_name_str").equalTo(player_name_str);

                    //connection to user node
                    checkName.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //name already exists
                            if (snapshot.exists()){
                                Toast.makeText(OnlineActivity.this, "Name already exists.",
                                        Toast.LENGTH_SHORT).show();
                            }else{
                                //name doesn't exists yet
                                //check if room exists
                                Query checkRoom = reference_room.orderByChild("room_name_str").equalTo(room_name_str);

                                //connection to room node
                                checkRoom.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        if (snapshot.exists()){
                                            //room exists
                                            //check how many people are in there
                                            String room_counter_online = snapshot.child(room_name_str).child("room_counter").getValue(Long.class).toString();
                                            win_by = Integer.parseInt(snapshot.child(room_name_str).child("win_by").getValue(Long.class).toString());
                                            nbyn = Integer.parseInt(snapshot.child(room_name_str).child("nbyn").getValue(Long.class).toString());
                                            turn_counter = Integer.parseInt(snapshot.child(room_name_str).child("turn_counter").getValue(Long.class).toString());
                                            //who is the creator
                                            String creator_name = snapshot.child(room_name_str).child("player_name_str1").getValue(String.class);
                                            String joiner_name = snapshot.child(room_name_str).child("player_name_str2").getValue(String.class);
                                            if(room_counter_online.equals("1")){
                                                //add one to the room counter
                                                //join player with the room's nbyn and winby.
                                                if (player_name_str.equals(creator_name)){
                                                    OnlineActivityRoom room_helper = new OnlineActivityRoom(Integer.parseInt(room_counter_online)+1, room_name_str, player_name_str, joiner_name, win_by, nbyn,turn_counter);
                                                    reference_room.child(room_name_str).setValue(room_helper);
                                                }else {
                                                    OnlineActivityRoom room_helper = new OnlineActivityRoom(Integer.parseInt(room_counter_online) + 1, room_name_str, creator_name, player_name_str, win_by, nbyn, turn_counter);
                                                    reference_room.child(room_name_str).setValue(room_helper);
                                                }

                                                OnlineActivityHelper user_helper = new OnlineActivityHelper(player_name_str, room_name_str, x_move, y_move);
                                                reference_name.child(player_name_str).setValue(user_helper);

                                                //go to the game
                                                createActivity();
                                            }else{
                                                Toast.makeText(OnlineActivity.this, "Room is full.",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        }else{
                                            //room doesn't exists therefore can not join
                                            Toast.makeText(OnlineActivity.this, "Room does not exist.",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        Toast.makeText(OnlineActivity.this, "Error @ join_img checkRoom",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(OnlineActivity.this, "Error @ join_img checkName",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });


                }
            }
        });

        camera_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                camera_img.startAnimation(animation);
                camera_img.setImageResource(R.drawable.bird);
                camera_counter=1;
            }
        });

        // request camera
        if (ContextCompat.checkSelfPermission(OnlineActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //granted, turns on camera button
            ActivityCompat.requestPermissions(OnlineActivity.this, new String[]{
                    Manifest.permission.CAMERA
            }, 100);
        }

        //camera button is off until permission to use camera is granted.
        //this avoids app quitting when camera button is pressed when permission is denied.
        if (PackageManager.PERMISSION_GRANTED== OnlineActivity.this.checkCallingOrSelfPermission(android.Manifest.permission.CAMERA)) {
            turn_on_camera.setEnabled(true);
            turn_on_camera.setImageResource(R.drawable.camera_gif);
        }else{
            turn_on_camera.setEnabled(false);
            turn_on_camera.setImageResource(R.drawable.camera_off);
        }


        // use camera1 if permission granted
        turn_on_camera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent camera_intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, 100);
            }
        });


        }
    // set camera image to bitmap
    //take picture, then user can create/join room
    //doesn't take picture, then user can not create/join room
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

                camera_img.setImageDrawable(pixel(bitmap));
                camera_counter=1;


            }catch (NullPointerException e) {
                //if no picture taken, do nothing lol
                camera_counter=0;

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
                red= Color.red(pixel);
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
    public byte[] convert2array(ImageView imageview){
        Bitmap bmp1 = ((BitmapDrawable) imageview.getDrawable()).getBitmap();
        ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
        bmp1.compress(Bitmap.CompressFormat.PNG, 100, stream1);
        byte[] byteArray1 = stream1.toByteArray();
        return byteArray1;
    }

    public boolean status(){
        if (player_name_str.trim().isEmpty()||(!player_name_str.matches("[a-zA-Z0-9]*"))||room_name_str.trim().isEmpty()||(!room_name_str.matches("[a-zA-Z0-9]*"))){
            return true;
        }else{
            return false;
        }
    }

    public void name_toast(){
        if (camera_counter==0){
            Toast.makeText(OnlineActivity.this, "Take a picture using camera or tap to use default image.",
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(OnlineActivity.this, "Room/Player names can only be letter(s) and/or number(s).",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void createActivity(){
        if (nbyn==3){
            Intent nOnline_intent= new Intent(OnlineActivity.this, n3Online.class);
            nOnline_intent.putExtra("player_name", player_name.getText().toString());
            nOnline_intent.putExtra("camera_img", convert2array(camera_img));
            nOnline_intent.putExtra("win_by", win_by);
            nOnline_intent.putExtra("turn_counter", turn_counter);
            nOnline_intent.putExtra("room_name_str", room_name.getText().toString());
            startActivity(nOnline_intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if (nbyn==4){
            Intent nOnline_intent= new Intent(OnlineActivity.this, n4Online.class);
            nOnline_intent.putExtra("player_name", player_name.getText().toString());
            nOnline_intent.putExtra("camera_img", convert2array(camera_img));
            nOnline_intent.putExtra("win_by", win_by);
            nOnline_intent.putExtra("turn_counter", turn_counter);
            nOnline_intent.putExtra("room_name_str", room_name.getText().toString());
            startActivity(nOnline_intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if (nbyn==5){
            Intent nOnline_intent= new Intent(OnlineActivity.this, n5Online.class);
            nOnline_intent.putExtra("player_name", player_name.getText().toString());
            nOnline_intent.putExtra("camera_img", convert2array(camera_img));
            nOnline_intent.putExtra("win_by", win_by);
            nOnline_intent.putExtra("turn_counter", turn_counter);
            nOnline_intent.putExtra("room_name_str", room_name.getText().toString());
            startActivity(nOnline_intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if (nbyn==6){
            Intent nOnline_intent= new Intent(OnlineActivity.this, n6Online.class);
            nOnline_intent.putExtra("player_name", player_name.getText().toString());
            nOnline_intent.putExtra("camera_img", convert2array(camera_img));
            nOnline_intent.putExtra("win_by", win_by);
            nOnline_intent.putExtra("turn_counter", turn_counter);
            nOnline_intent.putExtra("room_name_str", room_name.getText().toString());
            startActivity(nOnline_intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if (nbyn==7){
            Intent nOnline_intent= new Intent(OnlineActivity.this, n7Online.class);
            nOnline_intent.putExtra("player_name", player_name.getText().toString());
            nOnline_intent.putExtra("camera_img", convert2array(camera_img));
            nOnline_intent.putExtra("win_by", win_by);
            nOnline_intent.putExtra("turn_counter", turn_counter);
            nOnline_intent.putExtra("room_name_str", room_name.getText().toString());
            startActivity(nOnline_intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if (nbyn==8){
            Intent nOnline_intent= new Intent(OnlineActivity.this, n8Online.class);
            nOnline_intent.putExtra("player_name", player_name.getText().toString());
            nOnline_intent.putExtra("camera_img", convert2array(camera_img));
            nOnline_intent.putExtra("win_by", win_by);
            nOnline_intent.putExtra("turn_counter", turn_counter);
            nOnline_intent.putExtra("room_name_str", room_name.getText().toString());
            startActivity(nOnline_intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if (nbyn==9){
            Intent nOnline_intent= new Intent(OnlineActivity.this, n9Online.class);
            nOnline_intent.putExtra("player_name", player_name.getText().toString());
            nOnline_intent.putExtra("camera_img", convert2array(camera_img));
            nOnline_intent.putExtra("win_by", win_by);
            nOnline_intent.putExtra("turn_counter", turn_counter);
            nOnline_intent.putExtra("room_name_str", room_name.getText().toString());
            startActivity(nOnline_intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if (nbyn==10){
            Intent nOnline_intent= new Intent(OnlineActivity.this, n10Online.class);
            nOnline_intent.putExtra("player_name", player_name.getText().toString());
            nOnline_intent.putExtra("camera_img", convert2array(camera_img));
            nOnline_intent.putExtra("win_by", win_by);
            nOnline_intent.putExtra("turn_counter", turn_counter);
            nOnline_intent.putExtra("room_name_str", room_name.getText().toString());
            startActivity(nOnline_intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        online_activity_music.pause();
    }
    @Override
    protected void onResume() {
        if(online_activity_music != null && !online_activity_music.isPlaying()&& music_counter==1)
            online_activity_music.start();
        super.onResume();
    }

    //disable back button
    @Override
    public void onBackPressed() {

    }
    }