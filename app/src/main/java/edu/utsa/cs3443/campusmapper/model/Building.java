package edu.utsa.cs3443.campusmapper.model;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Building {
    private static final Map<String, Building> buildings = new HashMap<>();
    private final String code;
    private final int x;
    private final int y;
    private String name;

    public Building(String code, int x, int y, String name) {
        this.code = code;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public static void loadBuildings(Context context) throws IOException {
        Scanner scnr = new Scanner(context.getAssets().open("buildings.csv"));
        String[] split_line;

        scnr.nextLine();

        while (scnr.hasNextLine()) {
            split_line = scnr.nextLine().split(",");

            Log.d("BuildingDebug", String.join(",", split_line));

            buildings.put(split_line[0], new Building(split_line[0], Integer.parseInt(split_line[1]), Integer.parseInt(split_line[2]), split_line[3]));
        }
    }

    public static Building getBuilding(String key) {
        return buildings.get(key);
    }

    public String getCode() {
        return code;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return code + ", " + x + ", " + y + ", " + name;
    }
}
