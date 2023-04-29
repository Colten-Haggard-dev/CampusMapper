package edu.utsa.cs3443.campusmapper.model;

public class Course {
    private String code;
    private int number;
    private String name;
    private Room room;

    public Course(String code, String number, String name, String room) {
        this.code = code;
        this.number = Integer.parseInt(number);
        this.name = name;
        this.room = new Room(room);
    }
}
