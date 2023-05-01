package edu.utsa.cs3443.campusmapper.model;

import android.util.Log;

public class Course {
    private String code;
    private int number;
    private String name;
    private Room room;

    public Course(String code, String number, String name, String room) {
        Log.d("CampusDebugger", code);
        Log.d("CampusDebugger", number);
        Log.d("CampusDebugger", name);
        Log.d("CampusDebugger", room);

        this.code = code;
        this.number = Integer.parseInt(number);
        this.name = name;
        this.room = new Room(room);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String toString() {
        return code + ", " + number + ", " + name + ", " + room.toString();
    }

}
