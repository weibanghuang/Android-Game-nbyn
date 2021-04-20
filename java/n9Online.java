package com.example.nbyn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class n9Online extends AppCompatActivity {
    int[][] arr_1=new int[9][9];
    int[][] arr_2=new int[9][9];
    private int win_by;
    private int turn_counter;
    private String personName1_str;
    private String personName2_str;
    private byte[] byteArray1a;
    private byte[] byteArray2a;
    private int dim = 9;
    private byte[] byteArray1;
    private Bitmap bmp1;
    private Drawable drawable;
    private ImageView back_img;
    private ImageView music_img;
    private ImageView win_by_img;
    private TextView room_name;
    private TextView textView;
    private ImageView button00;
    private ImageView button01;
    private ImageView button02;
    private ImageView button03;
    private ImageView button04;
    private ImageView button05;
    private ImageView button06;
    private ImageView button07;
    private ImageView button08;
    private ImageView button10;
    private ImageView button11;
    private ImageView button12;
    private ImageView button13;
    private ImageView button14;
    private ImageView button15;
    private ImageView button16;
    private ImageView button17;
    private ImageView button18;
    private ImageView button20;
    private ImageView button21;
    private ImageView button22;
    private ImageView button23;
    private ImageView button24;
    private ImageView button25;
    private ImageView button26;
    private ImageView button27;
    private ImageView button28;
    private ImageView button30;
    private ImageView button31;
    private ImageView button32;
    private ImageView button33;
    private ImageView button34;
    private ImageView button35;
    private ImageView button36;
    private ImageView button37;
    private ImageView button38;
    private ImageView button40;
    private ImageView button41;
    private ImageView button42;
    private ImageView button43;
    private ImageView button44;
    private ImageView button45;
    private ImageView button46;
    private ImageView button47;
    private ImageView button48;
    private ImageView button50;
    private ImageView button51;
    private ImageView button52;
    private ImageView button53;
    private ImageView button54;
    private ImageView button55;
    private ImageView button56;
    private ImageView button57;
    private ImageView button58;
    private ImageView button60;
    private ImageView button61;
    private ImageView button62;
    private ImageView button63;
    private ImageView button64;
    private ImageView button65;
    private ImageView button66;
    private ImageView button67;
    private ImageView button68;
    private ImageView button70;
    private ImageView button71;
    private ImageView button72;
    private ImageView button73;
    private ImageView button74;
    private ImageView button75;
    private ImageView button76;
    private ImageView button77;
    private ImageView button78;
    private ImageView button80;
    private ImageView button81;
    private ImageView button82;
    private ImageView button83;
    private ImageView button84;
    private ImageView button85;
    private ImageView button86;
    private ImageView button87;
    private ImageView button88;
    private MediaPlayer n_15_16_music;
    private int music_counter=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n9_online);

        back_img = (ImageView) findViewById(R.id.back_img);
        music_img = (ImageView) findViewById(R.id.music_img);
        win_by_img = (ImageView) findViewById(R.id.win_by_img);
        textView = (TextView) findViewById(R.id.textView);
        room_name = (TextView) findViewById(R.id.room_name);
        button00 = (ImageView) findViewById(R.id.button00);
        button01 = (ImageView) findViewById(R.id.button01);
        button02 = (ImageView) findViewById(R.id.button02);
        button03 = (ImageView) findViewById(R.id.button03);
        button04 = (ImageView) findViewById(R.id.button04);
        button05 = (ImageView) findViewById(R.id.button05);
        button06 = (ImageView) findViewById(R.id.button06);
        button07 = (ImageView) findViewById(R.id.button07);
        button08 = (ImageView) findViewById(R.id.button08);
        button10 = (ImageView) findViewById(R.id.button10);
        button11 = (ImageView) findViewById(R.id.button11);
        button12 = (ImageView) findViewById(R.id.button12);
        button13 = (ImageView) findViewById(R.id.button13);
        button14 = (ImageView) findViewById(R.id.button14);
        button15 = (ImageView) findViewById(R.id.button15);
        button16 = (ImageView) findViewById(R.id.button16);
        button17 = (ImageView) findViewById(R.id.button17);
        button18 = (ImageView) findViewById(R.id.button18);
        button20 = (ImageView) findViewById(R.id.button20);
        button21 = (ImageView) findViewById(R.id.button21);
        button22 = (ImageView) findViewById(R.id.button22);
        button23 = (ImageView) findViewById(R.id.button23);
        button24 = (ImageView) findViewById(R.id.button24);
        button25 = (ImageView) findViewById(R.id.button25);
        button26 = (ImageView) findViewById(R.id.button26);
        button27 = (ImageView) findViewById(R.id.button27);
        button28 = (ImageView) findViewById(R.id.button28);
        button30 = (ImageView) findViewById(R.id.button30);
        button31 = (ImageView) findViewById(R.id.button31);
        button32 = (ImageView) findViewById(R.id.button32);
        button33 = (ImageView) findViewById(R.id.button33);
        button34 = (ImageView) findViewById(R.id.button34);
        button35 = (ImageView) findViewById(R.id.button35);
        button36 = (ImageView) findViewById(R.id.button36);
        button37 = (ImageView) findViewById(R.id.button37);
        button38 = (ImageView) findViewById(R.id.button38);
        button40 = (ImageView) findViewById(R.id.button40);
        button41 = (ImageView) findViewById(R.id.button41);
        button42 = (ImageView) findViewById(R.id.button42);
        button43 = (ImageView) findViewById(R.id.button43);
        button44 = (ImageView) findViewById(R.id.button44);
        button45 = (ImageView) findViewById(R.id.button45);
        button46 = (ImageView) findViewById(R.id.button46);
        button47 = (ImageView) findViewById(R.id.button47);
        button48 = (ImageView) findViewById(R.id.button48);
        button50 = (ImageView) findViewById(R.id.button50);
        button51 = (ImageView) findViewById(R.id.button51);
        button52 = (ImageView) findViewById(R.id.button52);
        button53 = (ImageView) findViewById(R.id.button53);
        button54 = (ImageView) findViewById(R.id.button54);
        button55 = (ImageView) findViewById(R.id.button55);
        button56 = (ImageView) findViewById(R.id.button56);
        button57 = (ImageView) findViewById(R.id.button57);
        button58 = (ImageView) findViewById(R.id.button58);
        button60 = (ImageView) findViewById(R.id.button60);
        button61 = (ImageView) findViewById(R.id.button61);
        button62 = (ImageView) findViewById(R.id.button62);
        button63 = (ImageView) findViewById(R.id.button63);
        button64 = (ImageView) findViewById(R.id.button64);
        button65 = (ImageView) findViewById(R.id.button65);
        button66 = (ImageView) findViewById(R.id.button66);
        button67 = (ImageView) findViewById(R.id.button67);
        button68 = (ImageView) findViewById(R.id.button68);
        button70 = (ImageView) findViewById(R.id.button70);
        button71 = (ImageView) findViewById(R.id.button71);
        button72 = (ImageView) findViewById(R.id.button72);
        button73 = (ImageView) findViewById(R.id.button73);
        button74 = (ImageView) findViewById(R.id.button74);
        button75 = (ImageView) findViewById(R.id.button75);
        button76 = (ImageView) findViewById(R.id.button76);
        button77 = (ImageView) findViewById(R.id.button77);
        button78 = (ImageView) findViewById(R.id.button78);
        button80 = (ImageView) findViewById(R.id.button80);
        button81 = (ImageView) findViewById(R.id.button81);
        button82 = (ImageView) findViewById(R.id.button82);
        button83 = (ImageView) findViewById(R.id.button83);
        button84 = (ImageView) findViewById(R.id.button84);
        button85 = (ImageView) findViewById(R.id.button85);
        button86 = (ImageView) findViewById(R.id.button86);
        button87 = (ImageView) findViewById(R.id.button87);
        button88 = (ImageView) findViewById(R.id.button88);

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
        Intent intent = getIntent();
        Bundle extra= intent.getExtras();
        Bundle extras = getIntent().getExtras();

        win_by=extra.getInt("win_by");
        byteArray1 = extras.getByteArray("camera_img");
        bmp1 = BitmapFactory.decodeByteArray(byteArray1, 0, byteArray1.length);
        drawable = new BitmapDrawable(getResources(), bmp1);
        // setting up textView on CONSTANT event listener
        FirebaseDatabase.getInstance().getReference("room").orderByChild("room_name_str").equalTo(extra.getString("room_name_str")).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    room_name.setText("Player 1:\n"+snapshot.child(extra.getString("room_name_str")).child("player_name_str1").getValue(String.class) + "\n"
                            + "Player 2:\n" +snapshot.child(extra.getString("room_name_str")).child("player_name_str2").getValue(String.class) + "\n"
                            + "Room Name:\n" + snapshot.child(extra.getString("room_name_str")).child("room_name_str").getValue(String.class));
                    personName1_str=snapshot.child(extra.getString("room_name_str")).child("player_name_str1").getValue(String.class);
                    personName2_str=snapshot.child(extra.getString("room_name_str")).child("player_name_str2").getValue(String.class);
                    win_by_image(Integer.parseInt(snapshot.child(extra.getString("room_name_str")).child("win_by").getValue(Long.class).toString()));
                    if (snapshot.child(extra.getString("room_name_str")).child("turn_counter").getValue(Long.class).toString().equals("0")){
                        textView.setText(snapshot.child(extra.getString("room_name_str")).child("player_name_str1").getValue(String.class)+"'s turn");
                    }else{
                        textView.setText(snapshot.child(extra.getString("room_name_str")).child("player_name_str2").getValue(String.class)+"'s turn");
                    }
                    turn_counter= Integer.parseInt(snapshot.child(extra.getString("room_name_str")).child("turn_counter").getValue(Long.class).toString())+1;
                    //regestier the OTHER button click
                    if (snapshot.child(extra.getString("room_name_str")).child("turn_counter").getValue(Long.class).toString().equals("0")){
                        //if it is 0 turn,  look at player2
                        FirebaseDatabase.getInstance().getReference("user").orderByChild("player_name_str").equalTo(snapshot.child(extra.getString("room_name_str")).child("player_name_str2").getValue(String.class)).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot_user) {
                                if (snapshot_user.child(snapshot.child(extra.getString("room_name_str")).child("player_name_str2").getValue(String.class)).child("button_position").exists()){
                                    String button_position = snapshot_user.child(snapshot.child(extra.getString("room_name_str")).child("player_name_str2").getValue(String.class)).child("button_position").getValue(Long.class).toString();
                                    //textView.setText("player2 "+button_position);
                                    ImageView online_imageView = (ImageView) findViewById(Integer.parseInt(button_position));
                                    if (snapshot.child(extra.getString("room_name_str")).child("player_name_str2").getValue(String.class).equals(extra.getString("player_name"))){
                                        online_imageView.setImageDrawable(drawable);
                                        byteArray2a=convert2array(online_imageView);
                                        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ny);
                                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                        byteArray1a = stream.toByteArray();
                                        System.out.println("a-------");
                                        System.out.println(online_imageView.getId());
                                    }else{
                                        String uri = "@drawable/ny";  // where myresource (without the extension) is the file
                                        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                                        Drawable res = getResources().getDrawable(imageResource);
                                        online_imageView.setImageDrawable(res);
                                        byteArray1a=convert2array(online_imageView);
                                        byteArray2a= byteArray1;
                                        System.out.println("b-------");
                                        System.out.println(online_imageView.getId());
                                    }

                                    online_imageView.setEnabled(false);
                                    int x=Integer.parseInt(snapshot_user.child(snapshot.child(extra.getString("room_name_str")).child("player_name_str2").getValue(String.class)).child("x_move").getValue(Long.class).toString());
                                    int y=Integer.parseInt(snapshot_user.child(snapshot.child(extra.getString("room_name_str")).child("player_name_str2").getValue(String.class)).child("y_move").getValue(Long.class).toString());
                                    if (x!=11 || y!=11){
                                        arr_2[x][y]=1;
                                    }
                                    check4winner(online_imageView,x,y, Integer.parseInt(snapshot.child(extra.getString("room_name_str")).child("turn_counter").getValue(Long.class).toString())+1);
                                    System.out.println("arr1-----------");
                                    System.out.println(Arrays.deepToString(arr_1));
                                    System.out.println("arr2-----------");
                                    System.out.println(Arrays.deepToString(arr_2));

                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }else{
                        //if it is 1 turn, look at player1
                        FirebaseDatabase.getInstance().getReference("user").orderByChild("player_name_str").equalTo(snapshot.child(extra.getString("room_name_str")).child("player_name_str1").getValue(String.class)).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot_user) {
                                if (snapshot_user.child(snapshot.child(extra.getString("room_name_str")).child("player_name_str1").getValue(String.class)).child("button_position").exists()){
                                    String button_position = snapshot_user.child(snapshot.child(extra.getString("room_name_str")).child("player_name_str1").getValue(String.class)).child("button_position").getValue(Long.class).toString();
                                    //textView.setText("player1 "+button_position);
                                    ImageView online_imageView = (ImageView) findViewById(Integer.parseInt(button_position));
                                    if (snapshot.child(extra.getString("room_name_str")).child("player_name_str1").getValue(String.class).equals(extra.getString("player_name"))){
                                        online_imageView.setImageDrawable(drawable);
                                        byteArray1a=convert2array(online_imageView);
                                        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ny);
                                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                        byteArray2a = stream.toByteArray();
                                        System.out.println("c-------");
                                        System.out.println(online_imageView.getId());
                                    }else{
                                        String uri = "@drawable/ny";  // where myresource (without the extension) is the file
                                        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                                        Drawable res = getResources().getDrawable(imageResource);
                                        online_imageView.setImageDrawable(res);
                                        byteArray2a=convert2array(online_imageView);
                                        byteArray1a=byteArray1;
                                        System.out.println("d-------");
                                        System.out.println(online_imageView.getId());
                                    }

                                    online_imageView.setEnabled(false);
                                    int x=Integer.parseInt(snapshot_user.child(snapshot.child(extra.getString("room_name_str")).child("player_name_str1").getValue(String.class)).child("x_move").getValue(Long.class).toString());
                                    int y=Integer.parseInt(snapshot_user.child(snapshot.child(extra.getString("room_name_str")).child("player_name_str1").getValue(String.class)).child("y_move").getValue(Long.class).toString());
                                    if (x!=11 || y!=11){
                                        arr_1[x][y]=1;
                                    }
                                    check4winner(online_imageView,x,y, Integer.parseInt(snapshot.child(extra.getString("room_name_str")).child("turn_counter").getValue(Long.class).toString())+1);
                                    System.out.println("arr1-----------");
                                    System.out.println(Arrays.deepToString(arr_1));
                                    System.out.println("arr2-----------");
                                    System.out.println(Arrays.deepToString(arr_2));
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                    }

                }else{
                    arr_1=new int[9][9];
                    arr_2=new int[9][9];
                    //go back to online activity
                    Intent online_intent= new Intent(n9Online.this, OnlineActivity.class);
                    startActivity(online_intent);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference("room").orderByChild("room_name_str").equalTo(extra.getString("room_name_str")).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            if (snapshot.child(extra.getString("room_name_str")).child("room_counter").getValue(Long.class).toString().equals("2")){
                                FirebaseDatabase.getInstance().getReference("user").child(snapshot.child(extra.getString("room_name_str")).child("player_name_str1").getValue(String.class)).removeValue();
                                FirebaseDatabase.getInstance().getReference("user").child(snapshot.child(extra.getString("room_name_str")).child("player_name_str2").getValue(String.class)).removeValue();
                            }else if(snapshot.child(extra.getString("room_name_str")).child("room_counter").getValue(Long.class).toString().equals("1")){
                                FirebaseDatabase.getInstance().getReference("user").child(extra.getString("player_name")).removeValue();
                            }
                            FirebaseDatabase.getInstance().getReference("room").child(extra.getString("room_name_str")).removeValue();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                arr_1=new int[9][9];
                arr_2=new int[9][9];
                //go back to online activity
                Intent online_intent= new Intent(v.getContext(), OnlineActivity.class);
                startActivity(online_intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });
    }
    public void setImage(ImageView imageView){
        System.out.println("e------");
        System.out.println(imageView.getId());
        Intent intent = getIntent();
        Bundle extra= intent.getExtras();
        Bundle extras = getIntent().getExtras();
        byte[] byteArray1 = extras.getByteArray("camera_img");
        Bitmap bmp1 = BitmapFactory.decodeByteArray(byteArray1, 0, byteArray1.length);
        Drawable drawable = new BitmapDrawable(getResources(), bmp1);
        String button_position= imageView.getResources().getResourceEntryName(imageView.getId());
        int x = Character.getNumericValue(button_position.charAt(button_position.length()-2));
        int y = Character.getNumericValue(button_position.charAt(button_position.length()-1));
        FirebaseDatabase.getInstance().getReference("room").orderByChild("room_name_str").equalTo(extra.getString("room_name_str")).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //whose turn is it?
                //if it's 0, player 1 should go, then change turn_counter to 1.
                //if it's 1, player 2 should go, then change turn_counter to 0.
                if (snapshot.child(extra.getString("room_name_str")).child("turn_counter").getValue(Long.class).toString().equals("0")){
                    if (snapshot.child(extra.getString("room_name_str")).child("player_name_str1").getValue(String.class).equals(extra.getString("player_name"))){
                        FirebaseDatabase.getInstance().getReference("room").child(extra.getString("room_name_str")).child("turn_counter").setValue(1);
                        FirebaseDatabase.getInstance().getReference("user").child(extra.getString("player_name")).child("button_position").setValue(imageView.getId());
                        FirebaseDatabase.getInstance().getReference("user").child(extra.getString("player_name")).child("x_move").setValue(x);
                        FirebaseDatabase.getInstance().getReference("user").child(extra.getString("player_name")).child("y_move").setValue(y);
                        imageView.setImageDrawable(drawable);
                        imageView.setEnabled(false);
                    }
                }else{
                    if (snapshot.child(extra.getString("room_name_str")).child("player_name_str2").getValue(String.class).equals(extra.getString("player_name"))){
                        FirebaseDatabase.getInstance().getReference("room").child(extra.getString("room_name_str")).child("turn_counter").setValue(0);
                        FirebaseDatabase.getInstance().getReference("user").child(extra.getString("player_name")).child("button_position").setValue(imageView.getId());
                        FirebaseDatabase.getInstance().getReference("user").child(extra.getString("player_name")).child("x_move").setValue(x);
                        FirebaseDatabase.getInstance().getReference("user").child(extra.getString("player_name")).child("y_move").setValue(y);
                        imageView.setImageDrawable(drawable);
                        imageView.setEnabled(false);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }



    //check for winner
    public void check4winner(ImageView imageview, int x, int y, int turn_counter){

        int a = x;
        int b = y;
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
            Intent intent = getIntent();
            Bundle extra= intent.getExtras();
            if (turn_counter==2){
                if (extra.getString("player_name").equals(personName1_str)){
                    Intent pop_intent= new Intent(n9Online.this , PopActivity.class);
                    pop_intent.putExtra("personName", personName1_str);
                    pop_intent.putExtra("camera_img", byteArray1a);
                    startActivityForResult(pop_intent,10);
                }else{
                    Intent pop_intent= new Intent(n9Online.this , PopActivity.class);
                    pop_intent.putExtra("personName", personName2_str);
                    pop_intent.putExtra("camera_img", byteArray2a);
                    startActivityForResult(pop_intent,10);
                }

            }else{
                if (extra.getString("player_name").equals(personName1_str)){
                    Intent pop_intent= new Intent(n9Online.this , PopActivity.class);
                    pop_intent.putExtra("personName", personName1_str);
                    pop_intent.putExtra("camera_img", byteArray1a);
                    startActivityForResult(pop_intent,10);
                }else{
                    Intent pop_intent= new Intent(n9Online.this , PopActivity.class);
                    pop_intent.putExtra("personName", personName2_str);
                    pop_intent.putExtra("camera_img", byteArray2a);
                    startActivityForResult(pop_intent,10);
                }

            }

        }
    }
    public void win_by_image(int a){
        if (a==3){
            win_by_img.setImageResource(R.drawable.n3);
        }else if (a==4){
            win_by_img.setImageResource(R.drawable.n4);
        }else if (a==5){
            win_by_img.setImageResource(R.drawable.n5);
        }else if (a==6){
            win_by_img.setImageResource(R.drawable.n6);
        }else if (a==7){
            win_by_img.setImageResource(R.drawable.n7);
        }else if (a==8){
            win_by_img.setImageResource(R.drawable.n8);
        }else if (a==9){
            win_by_img.setImageResource(R.drawable.n9);
        }
    }
    public byte[] convert2array(ImageView imageview){
        Bitmap bmp1 = ((BitmapDrawable) imageview.getDrawable()).getBitmap();
        ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
        bmp1.compress(Bitmap.CompressFormat.PNG, 100, stream1);
        byte[] byteArray1 = stream1.toByteArray();
        return byteArray1;
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