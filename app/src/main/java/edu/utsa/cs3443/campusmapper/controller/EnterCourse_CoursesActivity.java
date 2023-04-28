package edu.utsa.cs3443.campusmapper.controller;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;

import edu.utsa.cs3443.campusmapper.model.WriteToCsv;

public class EnterCourse_CoursesActivity implements View.OnClickListener
{
    private ArrayList<String[]> data;
    private EditText crs_num,crs_name,room,dpt;
    public EnterCourse_CoursesActivity( ArrayList<String[]> y, EditText a, EditText b, EditText c, EditText d)
    {
        data = y;
        dpt = a;
        crs_num = b;
        crs_name = c;
        room = d;
    }
    @Override
    public void onClick(View v)
    {
        String crs_num_str = crs_num.getText().toString();
        String crs_name_str = crs_name.getText().toString();
        String roomStr = room.getText().toString();
        String dptStr = dpt.getText().toString();

        data.add(new String[]{dptStr,crs_num_str,crs_name_str,roomStr});
    }
}
