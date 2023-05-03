package edu.utsa.cs3443.campusmapper;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.campusmapper.controller.SwitchActivity;
import edu.utsa.cs3443.campusmapper.model.Student;

public class StudentListActivity extends AppCompatActivity {
    private String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        LinearLayout linearLayout = findViewById(R.id.linear_layout);

        Button button;
        for(Student stud : Student.getStudents()) {
            button = new Button(this);
            button.setText(stud.getName());

            button.setOnClickListener(v -> {
                data = new String[stud.getCourses().size() + 1];
                data[0] = stud.getId();
                System.arraycopy(stud.getRoomCodes(), 0, data, 1, stud.getCourses().size());
                findViewById(R.id.list_map_btn).setOnClickListener(new SwitchActivity(StudentListActivity.this, MapActivity.class, data));
            });

            linearLayout.addView(button);

            Spinner spinner = new Spinner(this);
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stud.getCoursesNames());
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(spinnerAdapter);
            linearLayout.addView(spinner);
        }

        findViewById(R.id.list_map_btn).setOnClickListener(view -> Toast.makeText(StudentListActivity.this, "No Student Selected", Toast.LENGTH_SHORT).show());
    }
}
