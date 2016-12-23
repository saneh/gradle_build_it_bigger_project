package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;


/**
 * This test is not working properly. Need to get clarity on testing in android
 */
public class EndpointsAsyncTaskTest extends ApplicationTestCase {

    String mJokeString = null;
    Exception mError = null;
    CountDownLatch signal = null;

    public EndpointsAsyncTaskTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testJokeGetTask() throws InterruptedException {
        EndpointsAsyncTask task = new EndpointsAsyncTask(getContext());
        task.setListener(new EndpointsAsyncTask.GetJokeTaskListener() {
            @Override
            public void onComplete(String joke, Exception e) {
                mJokeString = joke;
                mError = e;
                signal.countDown();
            }
        }).execute();
        signal.await();

        assertNull(mError);
        assertFalse(TextUtils.isEmpty(mJokeString));

    }
}
