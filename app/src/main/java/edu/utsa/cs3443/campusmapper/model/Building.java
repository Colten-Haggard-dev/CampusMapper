package edu.utsa.cs3443.campusmapper.model;

import android.content.res.AssetManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.utsa.cs3443.campusmapper.R;

public class Building {
    private static Building[] buildings;
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

    public static void loadBuildings(AssetManager assets) throws IOException {
        ArrayList<Building> building_list = new ArrayList<>();
        Scanner scnr = new Scanner(assets.open("buildings.csv"));
        String[] split_line;

        while (scnr.hasNextLine()) {
            split_line = scnr.nextLine().split(",");

            building_list.add(new Building(split_line[0], Integer.getInteger(split_line[1]), Integer.getInteger(split_line[2]), Integer.getInteger(split_line[3])));
        }

        buildings = (Building[]) building_list.toArray();
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
        int[] point = {x, y};
        return point;
    }

    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
