package com.ex.flightlogbook;

import android.app.Activity;
import android.content.Intent;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;


/**
 * Created by anita_lin on 2018/1/18.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE, constants = BuildConfig.class)
public class RobolectricUnitTest {
    @Test
    public void launchflightlogbook_shouldStartMainActivity() throws Exception {

        // Create MainActivity instance; that is, trigger this activity. When Robolectric.setupActivity return, this activity is done for onCreate、onStart、onResume callback
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        // trigger Click
        mainActivity.findViewById(R.id.createbutton).performClick();

//        Intent expectedIntent = new Intent(mainActivity, LogEditActivity.class);
//
//        // Get mainActitivy's ShadowActivity's instance
//        ShadowActivity shadowActivity = Shadows.shadowOf(mainActivity);
//
//        // Get startActivity's intent which is called by mainActivity.
//        // Normal Activity class has no this
//        Intent actualIntent = shadowActivity.getNextStartedActivity();
//        Assert.assertEquals(expectedIntent, actualIntent);
    }
}
