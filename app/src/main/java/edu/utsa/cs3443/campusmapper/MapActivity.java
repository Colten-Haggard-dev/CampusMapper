package edu.utsa.cs3443.campusmapper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import edu.utsa.cs3443.campusmapper.model.Building;

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

        String[] data = getIntent().getStringArrayExtra("data");

        for (Building b: Building.getBuildings()) {
            for (String s: data) {
                if (s.equals(b.getCode())) {
                    addBuildingButton(b, draggable_layout);
                    break;
                }
            }
        }
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