package com.example.nbyn;

import androidx.appcompat.app.AppCompatActivity;

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

public class n3Online extends AppCompatActivity {
    int[][] arr_1=new int[3][3];
    int[][] arr_2=new int[3][3];
    private int win_by;
    private int turn_counter;
    private String personName1_str;
    private String personName2_str;
    private byte[] byteArray1a;
    private byte[] byteArray2a;
    private int dim = 3;
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
    private ImageView button10;
    private ImageView button11;
    private ImageView button12;
    private ImageView button20;
    private ImageView button21;
    private ImageView button22;
    private MediaPlayer n_15_16_music;
    private int music_counter=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_n3_online);
        back_img = (ImageView) findViewById(R.id.back_img);
        music_img = (ImageView) findViewById(R.id.music_img);
        win_by_img = (ImageView) findViewById(R.id.win_by_img);
        textView = (TextView) findViewById(R.id.textView);
        room_name = (TextView) findViewById(R.id.room_name);
        button00 = (ImageView) findViewById(R.id.button00);
        button01 = (ImageView) findViewById(R.id.button01);
        button02 = (ImageView) findViewById(R.id.button02);
        button10 = (ImageView) findViewById(R.id.button10);
        button11 = (ImageView) findViewById(R.id.button11);
        button12 = (ImageView) findViewById(R.id.button12);
        button20 = (ImageView) findViewById(R.id.button20);
        button21 = (ImageView) findViewById(R.id.button21);
        button22 = (ImageView) findViewById(R.id.button22);

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
                    arr_1=new int[3][3];
                    arr_2=new int[3][3];
                    //go back to online activity
                    Intent online_intent= new Intent(n3Online.this, OnlineActivity.class);
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
                arr_1=new int[3][3];
                arr_2=new int[3][3];
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
                    Intent pop_intent= new Intent(n3Online.this , PopActivity.class);
                    pop_intent.putExtra("personName", personName1_str);
                    pop_intent.putExtra("camera_img", byteArray1a);
                    startActivityForResult(pop_intent,10);
                }else{
                    Intent pop_intent= new Intent(n3Online.this , PopActivity.class);
                    pop_intent.putExtra("personName", personName2_str);
                    pop_intent.putExtra("camera_img", byteArray2a);
                    startActivityForResult(pop_intent,10);
                }

            }else{
                if (extra.getString("player_name").equals(personName1_str)){
                    Intent pop_intent= new Intent(n3Online.this , PopActivity.class);
                    pop_intent.putExtra("personName", personName1_str);
                    pop_intent.putExtra("camera_img", byteArray1a);
                    startActivityForResult(pop_intent,10);
                }else{
                    Intent pop_intent= new Intent(n3Online.this , PopActivity.class);
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