package edu.utsa.cs3443.campusmapper;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import edu.utsa.cs3443.campusmapper.controller.SwitchActivity;
import edu.utsa.cs3443.campusmapper.model.Course;
import edu.utsa.cs3443.campusmapper.model.Room;
import edu.utsa.cs3443.campusmapper.model.Student;

public class StudentListActivity extends AppCompatActivity
{
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        LinearLayout linearLayout = findViewById(R.id.linear_layout);
        CheckBox checkBox;
        for(Student stud : Student.getStudents())
        {
            checkBox = new CheckBox(this);
            checkBox.setText(stud.getName());
            linearLayout.addView(checkBox);

            Spinner spinner = new Spinner(this);
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stud.getCoursesNames());
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(spinnerAdapter);
            linearLayout.addView(spinner);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                {
                    student = stud;
                }
            });
        }

        String[] data = new String[student.getCourses().size()];
        for(int i = 0; i < student.getCourses().size(); i++)
        {
            data[i] = student.getCourses().get(i).getRoom().toString();
        }

        Button map_btn = findViewById(R.id.list_map_btn);
        map_btn.setOnClickListener(new SwitchActivity(this, MapActivity.class,data));
    }
}