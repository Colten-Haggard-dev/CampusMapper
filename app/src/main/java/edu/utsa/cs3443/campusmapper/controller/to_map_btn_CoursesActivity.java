package edu.utsa.cs3443.campusmapper.controller;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;

import edu.utsa.cs3443.campusmapper.MainActivity;
import edu.utsa.cs3443.campusmapper.model.WriteToCsv;

public class to_map_btn_CoursesActivity implements View.OnClickListener
{
    private ArrayList<String[]> data;
    private Context context;

    public to_map_btn_CoursesActivity(Context context, ArrayList<String[]> data)
    {
        this.data = data;
        this.context = context;
    }
    @Override
    public void onClick(View v)
    {
        WriteToCsv csvWrite = new WriteToCsv(context, data);
        try
        {
            csvWrite.write();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }
}
