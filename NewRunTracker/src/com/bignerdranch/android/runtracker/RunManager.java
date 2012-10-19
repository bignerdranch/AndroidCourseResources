package com.bignerdranch.android.runtracker;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.LocationManager;

public class RunManager {
    public static final String ACTION_LOCATION = "com.bignerdranch.android.runtracker.ACTION_LOCATION";
    
    private static RunManager sRunManager;
    private Context mAppContext;
    
    private RunManager(Context appContext) {
        this.mAppContext = appContext;
    }
    
    public static RunManager get(Context c) {
        if (sRunManager == null) {
            // we use the application context to avoid leaking activities
            sRunManager = new RunManager(c.getApplicationContext());
        }
        return sRunManager;
    }

    private PendingIntent getLocationPendingIntent(boolean shouldCreate) {
        Intent broadcast = new Intent(ACTION_LOCATION);
        int flags = shouldCreate ? 0 : PendingIntent.FLAG_NO_CREATE;
        return PendingIntent.getBroadcast(mAppContext, 0, broadcast, flags);
    }

    public void startLocationUpdates() {
        LocationManager lm = (LocationManager)mAppContext.getSystemService(Context.LOCATION_SERVICE);
        PendingIntent pi = getLocationPendingIntent(true);
        lm.requestLocationUpdates(0, 0, new Criteria(), pi);
    }
    
    public void stopLocationUpdates() {
        PendingIntent pi = getLocationPendingIntent(false);
        if (pi != null) {
            LocationManager lm = (LocationManager)mAppContext.getSystemService(Context.LOCATION_SERVICE);
            lm.removeUpdates(pi);
            pi.cancel();
        }
    }
    
    public boolean isTrackingRun() {
        return getLocationPendingIntent(false) != null;
    }
}
