package edu.utsa.cs3443.campusmapper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.utsa.cs3443.campusmapper.controller.EnterCourse;
import edu.utsa.cs3443.campusmapper.controller.SwitchActivity;
import edu.utsa.cs3443.campusmapper.model.Student;

public class CoursesActivity extends AppCompatActivity
{

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        Intent intent = getIntent();
        String[] data = intent.getStringArrayExtra("data");

        Student student = new Student(data[0], data[1]);

        TextView welcomeLbl = findViewById(R.id.welcome_lbl);
        TextView abcLbl = findViewById(R.id.abc123_lbl);

        welcomeLbl.setText(String.format("Welcome %s", data[0]));
        abcLbl.setText(data[1]);

        EditText[] course_info = new EditText[4];
        course_info[0] = findViewById(R.id.dept_code_text);
        course_info[1] = findViewById(R.id.course_num_text);
        course_info[2] = findViewById(R.id.name_text);
        course_info[3] = findViewById(R.id.room_text);

        String[] data_to_transfer = new String[student.getCourses().size() + 1];
        SwitchActivity switchController = new SwitchActivity(this, MapActivity.class, data_to_transfer);

        Button enter_course_btn = findViewById(R.id.enter_course_btn);
        enter_course_btn.setOnClickListener(new EnterCourse(course_info, student, switchController));

        Button go_to_map_btn = findViewById(R.id.to_map_btn);
        go_to_map_btn.setOnClickListener(switchController);

        Button view_students_btn = findViewById(R.id.view_student_list_btn);
        view_students_btn.setOnClickListener(new SwitchActivity(CoursesActivity.this, StudentListActivity.class, null));

    }
}