package edu.utsa.cs3443.campusmapper.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String id;
    private final ArrayList<Course> courses;
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Map<String, Student> students_id_map = new HashMap<>();

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
        students_id_map.put(student.getId(), student);
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static Map<String, Student> getStudentsIdMap() {
        return students_id_map;
    }

    public static Student getStudentFromMap(String key) {
        return students_id_map.get(key);
    }

    public ArrayList<Course> getCourses()
    {
        return courses;
    }

    public String[] getCoursesNames()
    {
        int n = courses.size();
        String[] course_names = new String[n];

        for(int i = 0; i < n; ++i)
        {
            course_names[i] = courses.get(i).getName();
        }

        return course_names;
    }

    public String[] getRoomCodes() {
        int n = courses.size();
        String[] room_codes = new String[n];

        for (int i = 0; i < n; ++i) {
            room_codes[i] = courses.get(i).getRoom().getCode();
        }

        return room_codes;
    }
}
