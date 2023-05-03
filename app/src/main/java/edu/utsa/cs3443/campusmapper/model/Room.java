package edu.utsa.cs3443.campusmapper.model;

import androidx.annotation.NonNull;

public class Room {
    private final String code;
    private final int floor;
    private final int corridor;
    private final int number;

    public Room(String room_str) {
        String[] room = parseRoom(room_str);

        this.code = room[0];
        this.floor = Integer.parseInt(room[1]);
        this.corridor = Integer.parseInt(room[2]);
        this.number = Integer.parseInt(room[3]);
    }

    public static String[] parseRoom(String str) {
        String[] code_split = str.split(" ");
        String[] room_split = code_split[1].split("\\.");

        String[] ret = new String[room_split.length + 1];
        ret[0] = code_split[0];

        System.arraycopy(room_split, 0, ret, 1, room_split.length);

        return ret;
    }

    public String getCode() {
        return code;
    }

    @NonNull
    @Override
    public String toString()
    {
        return code+" "+floor+"."+corridor+"."+number;
    }
}
