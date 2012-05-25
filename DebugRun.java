package com.bignerdranch.android.runtracker;

import java.util.ArrayList;

import android.content.Context;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.util.Log;

public class DebugRun extends AsyncTask<Void,Location,Void> {
    private static DebugRun debugRun;

    private static final String testProvider = "TEST_PROVIDER";

    public static void startRun(Context c) {
        if (debugRun != null) {
            return;
        }

        debugRun = new DebugRun();
        debugRun.locationManager = (LocationManager)
            c.getSystemService(Context.LOCATION_SERVICE);

        debugRun.execute();
    }

    protected LocationManager locationManager;

    public void onPreExecute() {
        if (locationManager.getProvider(testProvider) != null) {
            locationManager.removeTestProvider(testProvider);
        }
        locationManager.addTestProvider(
                testProvider, 
                false, 
                false, 
                false, 
                false, 
                true, 
                false, 
                false, 
                0, 
                0);
        locationManager.setTestProviderEnabled(testProvider, true);
        locationManager.setTestProviderStatus(testProvider, GpsStatus.GPS_EVENT_STARTED, null, System.currentTimeMillis());
    }

    private Location newLocation(double lat, double lon, double alt) {
        Location l = new Location(testProvider);
        l.setLatitude(lat);
        l.setLongitude(lon);
        l.setAltitude(alt);

        return l;
    }

    public Void doInBackground(Void... params) {
        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(newLocation(-84.3238770, 33.751459, 309));
        locations.add(newLocation(-84.3238663, 33.7514752, 304));
        locations.add(newLocation(-84.3238610, 33.7514859, 303));
        locations.add(newLocation(-84.32385, 33.7514752, 303));
        locations.add(newLocation(-84.3237590, 33.7514859, 287));
        locations.add(newLocation(-84.3237376, 33.7514859, 286));
        locations.add(newLocation(-84.3237537, 33.7514805, 286));
        locations.add(newLocation(-84.3237537, 33.7514430, 283));
        locations.add(newLocation(-84.3237483, 33.7514108, 286));
        locations.add(newLocation(-84.3237590, 33.7514162, 287));
        locations.add(newLocation(-84.3237751, 33.7514269, 287));
        locations.add(newLocation(-84.3237859, 33.7514376, 287));
        locations.add(newLocation(-84.3238180, 33.7514698, 283));
        locations.add(newLocation(-84.3238288, 33.7514805, 282));
        locations.add(newLocation(-84.323887, 33.7515181, 280));
        locations.add(newLocation(-84.3238985, 33.7515234, 279));
        locations.add(newLocation(-84.3239146, 33.7515342, 279));
        locations.add(newLocation(-84.3239307, 33.7515449, 279));
        locations.add(newLocation(-84.3239468, 33.7515503, 280));
        locations.add(newLocation(-84.323957, 33.7515556, 280));
        locations.add(newLocation(-84.3239682, 33.751566, 280));
        locations.add(newLocation(-84.3239790, 33.7515717, 280));
        locations.add(newLocation(-84.3239897, 33.7515825, 280));
        locations.add(newLocation(-84.3240058, 33.75159323, 280));
        locations.add(newLocation(-84.3240165, 33.75160932, 280));
        locations.add(newLocation(-84.3240272, 33.75161468, 280));
        locations.add(newLocation(-84.3247300, 33.7510514, 277));
        locations.add(newLocation(-84.3247246, 33.751062, 276));
        locations.add(newLocation(-84.3247032, 33.75108897, 276));
        locations.add(newLocation(-84.3246924, 33.7510782, 280));
        locations.add(newLocation(-84.3247032, 33.7510836, 282));
        locations.add(newLocation(-84.324697, 33.75109970, 281));
        locations.add(newLocation(-84.324697, 33.75112652, 283));
        locations.add(newLocation(-84.3246924, 33.75115334, 281));
        locations.add(newLocation(-84.3246871, 33.7511640, 284));
        locations.add(newLocation(-84.3246871, 33.7511748, 284));
        locations.add(newLocation(-84.3246871, 33.7511855, 284));
        locations.add(newLocation(-84.3246871, 33.7511962, 284));
        locations.add(newLocation(-84.3246871, 33.751206, 285));
        locations.add(newLocation(-84.3246763, 33.7512177, 286));
        locations.add(newLocation(-84.3246763, 33.7512284, 287));
        locations.add(newLocation(-84.3246763, 33.7512391, 288));
        locations.add(newLocation(-84.3246817, 33.7512499, 287));
        locations.add(newLocation(-84.3246763, 33.75126, 287));
        locations.add(newLocation(-84.3246763, 33.7512713, 287));
        locations.add(newLocation(-84.3246710, 33.7512820, 287));
        locations.add(newLocation(-84.3246710, 33.7512981, 287));
        locations.add(newLocation(-84.3246763, 33.751314, 286));
        locations.add(newLocation(-84.3246710, 33.7513303, 286));
        locations.add(newLocation(-84.324660, 33.75135183, 287));
        locations.add(newLocation(-84.3246495, 33.75136792, 287));
        locations.add(newLocation(-84.3246495, 33.75137865, 287));
        locations.add(newLocation(-84.3246388, 33.75140011, 286));
        locations.add(newLocation(-84.3246281, 33.7514108, 286));
        locations.add(newLocation(-84.3246227, 33.7514269, 286));
        locations.add(newLocation(-84.3246120, 33.7514376, 285));
        locations.add(newLocation(-84.324606, 33.7514537, 285));
        locations.add(newLocation(-84.3246012, 33.7514644, 285));
        locations.add(newLocation(-84.3245959, 33.7514752, 285));
        locations.add(newLocation(-84.3245851, 33.7514805, 285));
        locations.add(newLocation(-84.3245798, 33.7515020, 286));
        locations.add(newLocation(-84.3245744, 33.751512, 286));
        locations.add(newLocation(-84.3245637, 33.7515234, 286));
        locations.add(newLocation(-84.324553, 33.7515288, 287));
        locations.add(newLocation(-84.3245476, 33.7515395, 287));
        locations.add(newLocation(-84.3245422, 33.7515503, 287));
        locations.add(newLocation(-84.3245315, 33.751566, 288));
        locations.add(newLocation(-84.3245208, 33.7515717, 288));
        locations.add(newLocation(-84.3245154, 33.7515825, 288));
        locations.add(newLocation(-84.324499, 33.75158786, 290));
        locations.add(newLocation(-84.3244940, 33.75160396, 290));
        locations.add(newLocation(-84.3244832, 33.75161468, 291));
        locations.add(newLocation(-84.3244725, 33.75162541, 292));
        locations.add(newLocation(-84.324461, 33.75164151, 292));
        locations.add(newLocation(-84.324445, 33.75165224, 293));
        locations.add(newLocation(-84.3244349, 33.7516629, 293));
        locations.add(newLocation(-84.3244242, 33.7516736, 294));
        locations.add(newLocation(-84.3244135, 33.7516790, 294));
        locations.add(newLocation(-84.3244028, 33.7516897, 294));
        locations.add(newLocation(-84.3243813, 33.7516897, 294));
        locations.add(newLocation(-84.3243598, 33.7516844, 295));
        locations.add(newLocation(-84.3243438, 33.7516790, 295));
        locations.add(newLocation(-84.3243277, 33.7516844, 295));
        locations.add(newLocation(-84.3243062, 33.7516790, 295));
        locations.add(newLocation(-84.3242955, 33.7516736, 296));
        locations.add(newLocation(-84.3242794, 33.7516683, 297));
        locations.add(newLocation(-84.3242686, 33.7516629, 296));
        locations.add(newLocation(-84.3242526, 33.75165224, 297));
        locations.add(newLocation(-84.3242365, 33.75164151, 297));
        locations.add(newLocation(-84.3242204, 33.75162541, 297));
        locations.add(newLocation(-84.3242043, 33.75162005, 297));
        locations.add(newLocation(-84.3241882, 33.75161468, 298));
        locations.add(newLocation(-84.3241775, 33.75160396, 299));
        locations.add(newLocation(-84.3241667, 33.75159859, 298));
        locations.add(newLocation(-84.324156, 33.75159323, 299));
        locations.add(newLocation(-84.3241453, 33.7515771, 299));
        locations.add(newLocation(-84.3241345, 33.751566, 298));
        locations.add(newLocation(-84.3241184, 33.7515556, 298));
        locations.add(newLocation(-84.3241077, 33.751566, 297));
        locations.add(newLocation(-84.3240863, 33.7515556, 296));
        locations.add(newLocation(-84.3240702, 33.7515503, 296));
        locations.add(newLocation(-84.3240541, 33.7515449, 296));
        locations.add(newLocation(-84.3240380, 33.7515288, 297));
        locations.add(newLocation(-84.3240272, 33.7515234, 297));
        locations.add(newLocation(-84.3240058, 33.7515181, 297));
        locations.add(newLocation(-84.323995, 33.7515074, 297));
        locations.add(newLocation(-84.3239790, 33.7515020, 296));
        locations.add(newLocation(-84.3239629, 33.7514913, 295));
        locations.add(newLocation(-84.3239521, 33.7514805, 294));
        locations.add(newLocation(-84.323941, 33.7514644, 294));
        locations.add(newLocation(-84.3239307, 33.7514537, 293));
        locations.add(newLocation(-84.3239146, 33.7514483, 294));
        locations.add(newLocation(-84.3238985, 33.7514483, 293));
        locations.add(newLocation(-84.3238770, 33.7514483, 293));
        locations.add(newLocation(-84.32385, 33.7514483, 292));
        locations.add(newLocation(-84.3238395, 33.7514537, 291));
        locations.add(newLocation(-84.3238234, 33.751459, 291));
        locations.add(newLocation(-84.3238019, 33.7514698, 291));
        locations.add(newLocation(-84.3237859, 33.7514805, 291));
        locations.add(newLocation(-84.3237751, 33.7514859, 291));
        locations.add(newLocation(-84.3237644, 33.7514913, 291));
        locations.add(newLocation(-84.3237483, 33.7514913, 290));
        locations.add(newLocation(-84.323742, 33.7515020, 290));
        locations.add(newLocation(-84.3237322, 33.7515074, 290));
        locations.add(newLocation(-84.3237268, 33.7515181, 290));
        locations.add(newLocation(-84.3237161, 33.7515288, 290));
        locations.add(newLocation(-84.323705, 33.7515342, 290));
        locations.add(newLocation(-84.3237000, 33.7515181, 290));
        locations.add(newLocation(-84.3237161, 33.7515074, 290));
        locations.add(newLocation(-84.3237376, 33.7514966, 290));
        locations.add(newLocation(-84.3237537, 33.7514913, 290));
        locations.add(newLocation(-84.3237751, 33.7514859, 290));
        locations.add(newLocation(-84.3237751, 33.7514966, 290));
        locations.add(newLocation(-84.323796, 33.7515020, 290));
        locations.add(newLocation(-84.323796, 33.751512, 290));
        locations.add(newLocation(-84.3238127, 33.7515234, 289));
        locations.add(newLocation(-84.3237912, 33.7514966, 289));
        locations.add(newLocation(-84.3237805, 33.7514859, 289));
        locations.add(newLocation(-84.3237698, 33.751459, 289));
        locations.add(newLocation(-84.3237805, 33.7514537, 289));
        locations.add(newLocation(-84.3237751, 33.7514430, 290));

        for (Location l : locations) {
            publishProgress(l);
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
        }
		return null;
    }

    public void onProgressUpdate(Location... params) {
        params[0].setTime(System.currentTimeMillis());
        locationManager.setTestProviderLocation(testProvider, params[0]);
    }

    public void onPostExecute() {
        locationManager.removeTestProvider(testProvider);
    }
}
