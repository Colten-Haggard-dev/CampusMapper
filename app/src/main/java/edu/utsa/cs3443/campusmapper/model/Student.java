package edu.utsa.cs3443.campusmapper.model;

import java.util.ArrayList;

public class Student {
    private String name;
    private String id;
    private ArrayList<Course> courses;
    private static ArrayList<Student> students = new ArrayList<>();

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static void addStudent(Student student)
    {
        students.add(student);
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses()
    {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public String[] getCoursesNames()
    {
        int n = courses.size();
        String[] course_names = new String[n];
        for(int i = 0; i < n; i++)
        {
            course_names[i] = courses.get(i).getName();
        }

        return course_names;
    }

}
