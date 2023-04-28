package edu.utsa.cs3443.campusmapper;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

import edu.utsa.cs3443.campusmapper.model.Room;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void parseString_isCorrect() {
        String sample_str = "Sample 1.2.3";

        System.out.println(String.join("", Room.parseRoom(sample_str)));
    }
}