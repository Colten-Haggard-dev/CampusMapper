package edu.utsa.cs3443.campusmapper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import edu.utsa.cs3443.campusmapper.controller.SwitchActivity;


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

        String[] temp_data = {"MH", "BB", "FLN", "ART"};

        Button add_courses_btn = findViewById(R.id.add_courses_btn);
        Button view_students_btn = findViewById(R.id.view_students_btn);
        Button test_map_btn = findViewById(R.id.map_test_btn);

        add_courses_btn.setOnClickListener(controller);
        view_students_btn.setOnClickListener(new SwitchActivity(MainActivity.this, StudentListActivity.class, null));
        test_map_btn.setOnClickListener(new SwitchActivity(MainActivity.this, MapActivity.class, temp_data));
    }
}