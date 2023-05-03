package edu.utsa.cs3443.campusmapper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;

import edu.utsa.cs3443.campusmapper.controller.SwitchActivity;
import edu.utsa.cs3443.campusmapper.model.Building;
import edu.utsa.cs3443.campusmapper.model.Student;

public class MapActivity extends AppCompatActivity {
    private int dpi;
    private int size;
    private String student_id;
    private String[] data;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        dpi = getResources().getDisplayMetrics().densityDpi/160;
        size = 85 * dpi;

        // {student_id, courses...}
        data = getIntent().getStringArrayExtra("data");

        if (Student.getStudentsIdMap() == null) {
            Toast.makeText(this, "ERROR: NO STUDENT HASHMAP", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Student.getStudentsIdMap().containsKey(data[0])) {
            Toast.makeText(this, "ERROR: STUDENT DOES NOT EXIST", Toast.LENGTH_SHORT).show();
            return;
        }

        student_id = Student.getStudentFromMap(data[0]).getId();

        RelativeLayout draggable_layout = findViewById(R.id.DraggableLayout);

        ImageView imageView = findViewById(R.id.map_image);

        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                for (String s: data) {
                    Building b = Building.getBuilding(s);

                    if (b != null) {
                        addBuildingButton(b, draggable_layout);
                    }
                }
            }
        });
    }

    private void addBuildingButton(Building building, RelativeLayout layout) {
        Button button = new Button(MapActivity.this);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(size, size);
        ImageView imageView = findViewById(R.id.map_image);

        float x_ratio = imageView.getWidth() / (float) 1547;
        float y_ratio = imageView.getHeight() / (float) 1068;
        String[] data = {building.getCode(), student_id};

        layoutParams.leftMargin = (int) (building.getX() * x_ratio - size/dpi);
        layoutParams.topMargin = (int) (building.getY() * y_ratio - size/dpi);
        button.setLayoutParams(layoutParams);
        button.setText(building.getCode());
        button.setOnClickListener(new SwitchActivity(MapActivity.this, BuildingActivity.class, data));

        layout.addView(button);
    }
}