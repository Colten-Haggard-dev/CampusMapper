package edu.utsa.cs3443.campusmapper.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import edu.utsa.cs3443.campusmapper.CoursesActivity;

public class addCourses_btn_MainController implements View.OnClickListener
{
    Context context;
    EditText name, abc123;
    public addCourses_btn_MainController(Context x, EditText y, EditText z)
    {
        context = x;
        name = y;
        abc123 = z;
    }

    @Override
    public void onClick(View v)
    {
        String name_string = name.getText().toString();
        String abc123_string = abc123.getText().toString();

        Intent intent = new Intent(context, CoursesActivity.class);
        intent.putExtra("name",name_string);
        intent.putExtra("abc123",abc123_string);
        context.startActivity(intent);
    }
}
