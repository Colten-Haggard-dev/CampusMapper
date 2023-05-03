package edu.utsa.cs3443.campusmapper.controller;

import android.view.View;
import android.widget.EditText;

import edu.utsa.cs3443.campusmapper.model.Course;
import edu.utsa.cs3443.campusmapper.model.Student;

public class EnterCourse implements View.OnClickListener {
    private final EditText[] course_info;
    private final Student student;
    private final SwitchActivity listener;

    public EnterCourse(EditText[] course_info, Student student, SwitchActivity listener) {
        this.course_info = course_info;
        this.student = student;
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (!Student.getStudents().contains(student))
            Student.addStudent(student);
        student.addCourse(new Course(course_info[0].getText().toString(), course_info[1].getText().toString(), course_info[2].getText().toString(), course_info[3].getText().toString()));

        String[] room_codes = student.getRoomCodes();
        int course_length = room_codes.length;

        String[] data = new String[course_length + 1];

        data[0] = student.getId();
        System.arraycopy(room_codes, 0, data, 1, course_length);

        listener.setData(data);

        for (EditText e: course_info) {
            e.setText("");
        }
    }
}
