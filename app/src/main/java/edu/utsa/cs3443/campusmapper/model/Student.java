package edu.utsa.cs3443.campusmapper.model;

import java.util.ArrayList;

public class Student {
    private String name;
    private String id;
    private ArrayList<Course> courses;

    public Student(String name, String id, ArrayList<Course> courses) {
        this.name = name;
        this.id = id;
        this.courses = courses;
    }


}
