package com.bignerdranch.android.testprovider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.preference.PreferenceManager;

public class ProviderReceiver extends BroadcastReceiver {
    public static final String ACTION_UPDATE_LOCATION = 
        ProviderReceiver.class.getPackage().getName() + ".ACTION_UPDATE_LOCATION";

    public static final String PREF_INDEX = "locationIndex";

    public static int getIndex(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(PREF_INDEX, 0);
    }

    public static void setIndex(Context context, int index) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit()
            .putInt(PREF_INDEX, index)
            .commit();
    }

    @Override
    public void onReceive(Context c, Intent intent) {
        int i = getIndex(c);

        DebugRun debugRun = DebugRun.getInstance(c);

        if (debugRun.doesHasTestProvider()) {
            debugRun.publishLocation(i);
        }
        setIndex(c, i + 1);
    }
}
