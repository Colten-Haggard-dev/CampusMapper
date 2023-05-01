package edu.utsa.cs3443.campusmapper.model;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Building {
    private static Map<String, Building> buildings = new HashMap<>();
    private String code;
    private int x;
    private int y;
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

    public static Map<String, Building> getBuildings() {
        return buildings;
    }

    public static void setBuildings(Map<String ,Building> buildings) {
        Building.buildings = buildings;
    }

    public static Building getBuilding(String key) {
        return buildings.get(key);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getPoint() {
        return new int[]{x, y};
    }

    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @NonNull
    @Override
    public String toString() {
        return code + ", " + x + ", " + y + ", " + name;
    }
}
