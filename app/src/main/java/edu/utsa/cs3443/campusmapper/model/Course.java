package edu.utsa.cs3443.campusmapper.model;

import androidx.annotation.NonNull;

public class Course {
    private final String code;
    private final int number;
    private String name;
    private final Room room;

    public Course(String code, String number, String name, String room) {
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

    public int getNumber() {
        return number;
    }

    public Room getRoom() {
        return room;
    }

    @NonNull
    public String toString() {
        return code + ", " + number + ", " + name + ", " + room.toString();
    }

}
