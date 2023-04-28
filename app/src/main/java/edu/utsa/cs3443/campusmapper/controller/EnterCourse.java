package edu.utsa.cs3443.campusmapper.controller;

import android.view.View;
import android.widget.EditText;

import edu.utsa.cs3443.campusmapper.model.Course;
import edu.utsa.cs3443.campusmapper.model.Student;

public class EnterCourse implements View.OnClickListener {
    private EditText[] course_info;
    private Student student;

    public EnterCourse(EditText[] course_info, Student student) {
        this.course_info = course_info;
        this.student = student;
    }

    @Override
    public void onClick(View view) {
        student.addCourse(new Course(course_info[0].getText().toString(), course_info[1].getText().toString(), course_info[2].getText().toString(), course_info[3].getText().toString()));
    }
}
