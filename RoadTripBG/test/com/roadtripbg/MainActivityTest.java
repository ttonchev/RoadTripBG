package com.roadtripbg;

import com.roadtripbg.MainActivity;
import com.roadtripbg.R;
import org.robolectric.RobolectricTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void testASDF() throws Exception {
        String hello = new MainActivity().getResources().getString(R.string.app_name);
        assertThat(hello, equalTo("RoadTripBG"));
    }
}