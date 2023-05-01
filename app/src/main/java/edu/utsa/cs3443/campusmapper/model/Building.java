package edu.utsa.cs3443.campusmapper.model;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Building {

    private static Map<String, Building> buildings;
    private String code;
    private int x;
    private int y;
    private int desc;

    public Building(String code, int x, int y, int desc) {
        this.code = code;
        this.x = x;
        this.y = y;
        this.desc = desc;
    }

    public static void loadBuildings(Context context) throws IOException {
        Scanner scnr = new Scanner(context.getAssets().open("buildings.csv"));
        String[] split_line;

        scnr.nextLine();

        while (scnr.hasNextLine()) {
            split_line = scnr.nextLine().split(",");

            Log.d("BuildingDebug", String.join(",", split_line));

            buildings.put(split_line[0], new Building(split_line[0], Integer.parseInt(split_line[1]), Integer.parseInt(split_line[2]), Integer.parseInt(split_line[3])));
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

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
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
        return code + ", " + x + ", " + y + ", " + desc;
    }
}
