package edu.utsa.cs3443.campusmapper;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import edu.utsa.cs3443.campusmapper.model.Building;
import edu.utsa.cs3443.campusmapper.model.Course;
import edu.utsa.cs3443.campusmapper.model.Student;

public class BuildingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);

        LinearLayout main_layout = findViewById(R.id.building_layout);

        // {building code, student id}
        String[] data = getIntent().getStringArrayExtra("data");

        Building b = Building.getBuilding(data[0]);
        if (b == null)
            return;

        Student s = Student.getStudentFromMap(data[1]);
        if (s == null)
            return;

        ArrayList<Course> courses = s.getCourses();
        Course course = new Course("NULL", "0", "NULL", "NULL 1.2.3");

        for (int i = 0; i < courses.size(); ++i) {
            Course temp = courses.get(i);

            if (temp.getRoom().getCode().equals(b.getCode())) {
                course = temp;
                break;
            }
        }

        float text_size = 24;

        ((TextView) findViewById(R.id.building_name_lbl)).setText(b.getName());
        ((TextView) findViewById(R.id.building_code_lbl)).setText(b.getCode());

        TextView course_name_lbl = new TextView(BuildingActivity.this);

        course_name_lbl.setText(String.format("Course Name: %s", course.getName()));
        course_name_lbl.setTextSize(text_size);

        main_layout.addView(course_name_lbl);

        TextView course_code_lbl = new TextView(BuildingActivity.this);

        course_code_lbl.setText(String.format("Course Number: %s %d", course.getCode(), course.getNumber()));
        course_code_lbl.setTextSize(text_size);

        main_layout.addView(course_code_lbl);

        TextView course_room_lbl = new TextView(BuildingActivity.this);

        course_room_lbl.setText(String.format("Course Room: %s", course.getRoom().toString()));
        course_room_lbl.setTextSize(text_size);

        main_layout.addView(course_room_lbl);
    }
}