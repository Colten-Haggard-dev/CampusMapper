package edu.utsa.cs3443.campusmapper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import edu.utsa.cs3443.campusmapper.controller.SwitchActivity;
import edu.utsa.cs3443.campusmapper.model.Building;
import edu.utsa.cs3443.campusmapper.model.Course;
import edu.utsa.cs3443.campusmapper.model.Student;


public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SwitchActivity controller = new SwitchActivity(MainActivity.this, CoursesActivity.class, new String[2]);

        EditText user_name_text = findViewById(R.id.user_name_text);
        EditText abc123_text = findViewById(R.id.abc123_text);

        try {
            Building.loadBuildings(MainActivity.this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        user_name_text.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        String[] data = controller.getData();

                        data[0] = user_name_text.getText().toString();

                        controller.setData(data);
                    }
                }
        );

        abc123_text.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        String[] data = controller.getData();

                        data[1] = abc123_text.getText().toString();

                        controller.setData(data);
                    }
                }
        );

        Student.addStudent(new Student("Colten Haggard", "ybv663"));
        Student student = Student.getStudentFromMap("ybv663");

        student.addCourse(new Course("BS", "1234", "Bullshit", "MH 1.2.3"));
        student.addCourse(new Course("PP", "1234", "Penis", "BB 1.2.3"));
        student.addCourse(new Course("CS", "1234", "Cringe Science", "FLN 1.2.3"));
        student.addCourse(new Course("PS", "1234", "Pull Shit", "ART 1.2.3"));

        String[] temp_data = {"ybv663", "MH", "BB", "FLN", "ART"};

        Button add_courses_btn = findViewById(R.id.add_courses_btn);
        Button view_students_btn = findViewById(R.id.view_students_btn);
        Button test_map_btn = findViewById(R.id.map_test_btn);

        add_courses_btn.setOnClickListener(controller);
        view_students_btn.setOnClickListener(new SwitchActivity(MainActivity.this, StudentListActivity.class, null));
        test_map_btn.setOnClickListener(new SwitchActivity(MainActivity.this, MapActivity.class, temp_data));
    }
}