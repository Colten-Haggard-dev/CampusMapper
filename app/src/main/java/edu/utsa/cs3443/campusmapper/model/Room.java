package edu.utsa.cs3443.campusmapper.model;

public class Room {
    private String code;
    private int floor;
    private int corridor;
    private int number;

    public Room(String code, int floor, int corridor, int number) {
        this.code = code;
        this.floor = floor;
        this.corridor = corridor;
        this.number = number;
    }

    public static Room parseRoom(String str) {
        String[] code_split = str.split(" ");
        String[] room_split = code_split[1].split("\\.");

        return new Room(code_split[0], Integer.getInteger(room_split[0]), Integer.getInteger(room_split[1]), Integer.getInteger(room_split[2]));
    }
}
