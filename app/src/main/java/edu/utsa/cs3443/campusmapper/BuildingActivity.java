package edu.utsa.cs3443.campusmapper;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.campusmapper.model.Building;

public class BuildingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);

        // {building code, student id}
        String[] data = getIntent().getStringArrayExtra("data");

        for (Building b: Building.getBuildings()) {
            if (b.getCode().equals(data[0])) {
                ((TextView) findViewById(R.id.building_name_lbl)).setText(b.getName());
                ((TextView) findViewById(R.id.building_code_lbl)).setText(b.getCode());
                return;
            }
        }
    }
}