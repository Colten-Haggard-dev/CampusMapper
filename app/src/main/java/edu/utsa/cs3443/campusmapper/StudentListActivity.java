package edu.utsa.cs3443.campusmapper;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

import edu.utsa.cs3443.campusmapper.controller.SwitchActivity;
import edu.utsa.cs3443.campusmapper.model.Course;
import edu.utsa.cs3443.campusmapper.model.Room;
import edu.utsa.cs3443.campusmapper.model.Student;

public class StudentListActivity extends AppCompatActivity
{
    private Student student;
    private String[] data;;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);



        LinearLayout linearLayout = findViewById(R.id.linear_layout);
        Button button;
        for(Student stud : Student.getStudents())
        {
            button = new Button(this);
            button.setText(stud.getName());

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    student = stud;
                    data = new String[student.getCourses().size() + 1];
                    data[0] = student.getId();
                    System.arraycopy(student.getRoomCodes(), 1, data, 0, student.getCourses().size());
                }
            });

            linearLayout.addView(button);

            Spinner spinner = new Spinner(this);
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stud.getCoursesNames());
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(spinnerAdapter);
            linearLayout.addView(spinner);
//            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
//            {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
//                {
//                    student = stud;
//                    data = new String[student.getCourses().size()];
//                    for(int i = 0; i < student.getCourses().size(); i++)
//                    {
//                        data[i] = student.getCourses().get(i).getRoom().toString();
//                    }
//                }
//            });
        }

//        String[] data = new String[student.getCourses().size()];


        Button map_btn = findViewById(R.id.list_map_btn);
        map_btn.setOnClickListener(new SwitchActivity(this, MapActivity.class, data));
    }

    public static int countChecked(ViewGroup parentLayout)
    {
        int checkedCount = 0;

        int childCount = parentLayout.getChildCount();

        for (int i = 0; i < childCount; i++)
        {
            View childView = parentLayout.getChildAt(i);
            if (childView instanceof CheckBox)
            {
                CheckBox checkBox = (CheckBox) childView;
                if (checkBox.isChecked())
                {
                    checkedCount++;
                }
            }
        }
        return checkedCount;
    }
}
