package com.example.nbyn;

import android.graphics.Bitmap;

import java.util.List;

public class OnlineActivityHelper {
    private int x_move, y_move;
    private String player_name_str, room_name_str;

    public OnlineActivityHelper() {
    }

    public OnlineActivityHelper(String player_name_str, String room_name_str, int x_move, int y_move) {
        this.player_name_str = player_name_str;
        this.room_name_str = room_name_str;
        this.x_move=x_move;
        this.y_move=y_move;
    }

    public String getPlayer_name_str() {
        return player_name_str;
    }

    public void setPlayer_name_str(String player_name_str) {
        this.player_name_str = player_name_str;
    }

    public String getRoom_name_str() {
        return room_name_str;
    }

    public void setRoom_name_str(String room_name_str) {
        this.room_name_str = room_name_str;
    }

    public int getX_move() {
        return x_move;
    }

    public void setX_move(int X_move) {
        this.x_move = x_move;
    }

    public int getY_move() {
        return y_move;
    }

    public void setY_move(int y_move) {
        this.y_move = y_move;
    }
}
