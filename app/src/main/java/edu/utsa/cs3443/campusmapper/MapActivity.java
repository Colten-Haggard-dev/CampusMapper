package edu.utsa.cs3443.campusmapper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.campusmapper.controller.SwitchActivity;
import edu.utsa.cs3443.campusmapper.model.Building;
import edu.utsa.cs3443.campusmapper.model.Student;

public class MapActivity extends AppCompatActivity {
    private int dpi;
    private int size;
    private String student_id;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        dpi = getResources().getDisplayMetrics().densityDpi/160;
        size = 85 * dpi;

        RelativeLayout draggable_layout = findViewById(R.id.DraggableLayout);

        // {student_id, courses...}
        String[] data = getIntent().getStringArrayExtra("data");

        if (Student.getStudentsIdMap() == null) {
            Toast.makeText(this, "ERROR: NO STUDENT HASHMAP", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Student.getStudentsIdMap().containsKey(data[0])) {
            Toast.makeText(this, "ERROR: STUDENT DOES NOT EXIST", Toast.LENGTH_SHORT).show();
            return;
        }

        student_id = Student.getStudentFromMap(data[0]).getId();

        for (String s: data) {
            Building b = Building.getBuilding(s);

            if (b != null) {
                addBuildingButton(b, draggable_layout);
            }
        }
    }

    private void addBuildingButton(Building building, RelativeLayout layout) {
        Button button = new Button(MapActivity.this);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(size, size);
        float x_ratio = (float) 4061 / (float) 1547;
        float y_ratio = (float) 2804 / (float) 1068;
        String[] data = {building.getCode(), student_id};

        layoutParams.leftMargin = (int) (building.getX() * x_ratio - size/dpi);
        layoutParams.topMargin = (int) (building.getY() * y_ratio - size/dpi);
        button.setLayoutParams(layoutParams);
        button.setText(building.getCode());
        button.setOnClickListener(new SwitchActivity(MapActivity.this, BuildingActivity.class, data));

        layout.addView(button);
    }
}