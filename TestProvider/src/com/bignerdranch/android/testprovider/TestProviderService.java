package com.bignerdranch.android.testprovider;

import android.app.Service;

import android.content.Intent;

import android.os.Handler;
import android.os.IBinder;

public class TestProviderService extends Service {
    public static final String TAG = "TestProviderService";

    int runIndex = 0;
    Handler handler;

    Runnable tickRunnable = new Runnable() {
        public void run() {
            DebugRun debugRun = DebugRun.getInstance(TestProviderService.this);

            if (debugRun.doesHasTestProvider()) {
                debugRun.publishLocation(runIndex++);
            }

            handler.removeCallbacks(this);
            handler.postDelayed(this, 1000);
        }
    };

    @Override
    public IBinder onBind(Intent i) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler = new Handler();

        handler.post(tickRunnable);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(tickRunnable);
    }
}
