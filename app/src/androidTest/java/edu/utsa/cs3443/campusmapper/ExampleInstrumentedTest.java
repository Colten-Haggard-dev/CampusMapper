package edu.utsa.cs3443.campusmapper;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import edu.utsa.cs3443.campusmapper.controller.SwitchActivity;
import edu.utsa.cs3443.campusmapper.model.Room;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("edu.utsa.cs3443.campusmapper", appContext.getPackageName());
    }

    /*
    @Test
    public void testSwitchActivity() {
        MainActivity mainActivity = new MainActivity();
        SwitchActivity switchActivity = new SwitchActivity(mainActivity, CoursesActivity.class, new Room("Sample 1.2.3"));
    }
     */
}