package com.example.nbyn;

import android.text.style.UpdateLayout;

public class OnlineActivityRoom {
    private int room_counter, win_by, nbyn, turn_counter;
    private String player_name_str1, player_name_str2, room_name_str;

    public OnlineActivityRoom() {
    }

    public OnlineActivityRoom(int room_counter, String room_name_str, String player_name_str1, String player_name_str2, int win_by, int nbyn, int turn_counter) {
        this.room_counter= room_counter;
        this.room_name_str = room_name_str;
        this.player_name_str1= player_name_str1;
        this.player_name_str2= player_name_str2;
        this.win_by=win_by;
        this.nbyn=nbyn;
        this.turn_counter=turn_counter;
    }


    public int getRoom_counter() {
        return room_counter;
    }
    public void setRoom_counter(int room_counter) { this.room_counter = room_counter; }

    public String getRoom_name_str() {
        return room_name_str;
    }
    public void setRoom_name_str(String room_name_str) {
        this.room_name_str = room_name_str;
    }

    public String getPlayer_name_str1() {
        return player_name_str1;
    }
    public void setPlayer_name_str1(String player_name_str) {
        this.player_name_str1 = player_name_str1;
    }

    public String getPlayer_name_str2() {
        return player_name_str2;
    }
    public void setPlayer_name_str2(String player_name_str2) {
        this.player_name_str2 = player_name_str2;
    }

    public int getWin_by() {
        return win_by;
    }
    public void setWin_by(int win_by) { this.win_by = win_by; }

    public int getNbyn() {
        return nbyn;
    }
    public void setNbyn(int nbyn) { this.nbyn = nbyn; }

    public int getTurn_counter() {
        return turn_counter;
    }
    public void setTurn_counter(int turn_counter) { this.turn_counter = turn_counter; }

}
