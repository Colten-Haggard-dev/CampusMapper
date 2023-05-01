package edu.utsa.cs3443.campusmapper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import edu.utsa.cs3443.campusmapper.model.Building;
import edu.utsa.cs3443.campusmapper.model.Room;

public class MapActivity extends AppCompatActivity {
    private int dpi;
    private int size;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        dpi = getResources().getDisplayMetrics().densityDpi/160;
        size = 85 * dpi;

        RelativeLayout draggable_layout = findViewById(R.id.DraggableLayout);

        Intent intent = getIntent();
        String[] data = intent.getStringArrayExtra("data");

        String[] building_names = new String[data.length];
        for(int i = 0 ; i < building_names.length - 1 ; i++)
        {
            building_names[i] = Room.parseRoom(data[i])[0];
        }

        try {
            Building.loadBuildings(MapActivity.this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Building b;
        for (String s: building_names)
        {
            b = Building.getBuilding(s);
            if (b != null)
            {
                addBuildingButton(b, draggable_layout);
            }
        }
        /*
        for (Building b: Building.getBuildings()) {
            for (String s: data) {
                if (s.equals(b.getCode())) {
                    addBuildingButton(b, draggable_layout);
                    break;
                }
            }
        }
        */

    }

    private void addBuildingButton(Building building, RelativeLayout layout) {
        Button button = new Button(MapActivity.this);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(size, size);
        float x_ratio = (float) 4061 / (float) 1547;
        float y_ratio = (float) 2804 / (float) 1068;

        layoutParams.leftMargin = (int) (building.getX() * x_ratio - size/dpi);
        layoutParams.topMargin = (int) (building.getY() * y_ratio - size/dpi);
        button.setLayoutParams(layoutParams);
        button.setText(building.getCode());

        layout.addView(button);
    }
}