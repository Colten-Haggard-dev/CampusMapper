package edu.utsa.cs3443.campusmapper.model;
import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteToCsv
{

    private List<String[]> data;
    private Context context;

    public WriteToCsv(Context context,List<String[]> data)
    {
        this.context = context;
        this.data = data;
    }

    public void write() throws IOException
    {
        String path = "/data";
        File dir = new File(path);
        Log.d("Test",dir.toString());
        if(!dir.exists())
        {
            dir.mkdirs();
        }

        String csvName = data.get(0)[0] + data.get(0)[1] +".csv";
        File csvFile = new File(path,csvName);
        if(csvFile.exists())
        {
            Log.d("Test","File does exist");
        }
        else
        {
            Log.d("Test","File does NOT exist");
        }
        // FileOutputStream csvFile = openFileOutput(csvName, Context.MODE_PRIVATE);
        FileWriter csvWriter = new FileWriter(csvFile);
        // Write the data to the CSV file
        for (String[] row : data)
        {
            csvWriter.write(String.join(",", row) + "\n");
        }

        // Close the FileWriter object
        csvWriter.close();
    }

}
