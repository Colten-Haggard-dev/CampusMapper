package edu.utsa.cs3443.campusmapper.model;

public class Course {
    private String code;
    private int number;
    private String name;
    private Room room;

    public Course(String code, int number, String name, String room) {
        this.code = code;
        this.number = number;
        this.name = name;
        this.room = new Room(room);
    }
}
