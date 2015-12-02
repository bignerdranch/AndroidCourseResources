package com.bignerdranch.android.testprovider;

import android.app.Activity;

import android.location.Location;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class TestProviderActivity extends Activity {
    public static final String TAG = "TestProviderActivity";

    Button startStopButton;
    TextView statusTextView;
    Location lastLocation;

    DebugRun.Listener listener = new DebugRun.Listener() {
        public void onLocationChanged(Location location) {
            lastLocation = location;
            updateUI();
        }

        public void onProviderChanged() {
            updateUI();
        }
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        startStopButton = (Button)findViewById(R.id.startStopButton);
        startStopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DebugRun debugRun = DebugRun.getInstance(TestProviderActivity.this);
                boolean isActive = debugRun.doesHasTestProvider();
                if (isActive) {
                    debugRun.turnOffTestProvider();
                } else {
                    debugRun.turnOnTestProvider();
                }
            }
        });
        statusTextView = (TextView)findViewById(R.id.statusTextView);

        DebugRun.getInstance(this).addListener(listener);
    }

    @Override
    public void onDestroy() {
        DebugRun.getInstance(this).removeListener(listener);

        super.onDestroy();
    }
    

    void updateUI() {
        boolean isActive = DebugRun.getInstance(this)
            .doesHasTestProvider();

        if (isActive && lastLocation != null) {
            String statusText = 
                "Latitude: " + String.valueOf(lastLocation.getLatitude()) + "\n" + 
                "Longitude: " + String.valueOf(lastLocation.getLongitude()) + "\n" + 
                "Altitude: " + String.valueOf(lastLocation.getAltitude()) + "\n";
            statusTextView.setText(statusText);
        } else {
            statusTextView.setText("");
        }
        if (isActive) {
            startStopButton.setText(R.string.stop);
        } else {
            startStopButton.setText(R.string.start);
        }
    }
}
