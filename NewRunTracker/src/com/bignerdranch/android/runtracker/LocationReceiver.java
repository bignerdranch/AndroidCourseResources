package com.bignerdranch.android.runtracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

public class LocationReceiver extends BroadcastReceiver {

    private static final String TAG = "LocationReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Location loc = (Location)intent.getParcelableExtra(LocationManager.KEY_LOCATION_CHANGED);
        onLocationReceived(loc);
    }
    
    protected void onLocationReceived(Location loc) {
        Log.d(TAG, this + " Got location: " + loc.getLatitude() + ", " + loc.getLongitude());
    }

}
