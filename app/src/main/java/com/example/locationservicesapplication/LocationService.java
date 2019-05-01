package com.example.locationservicesapplication;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.widget.Toast;

import com.google.android.gms.location.LocationResult;

public class LocationService extends BroadcastReceiver {

    public static final String ACTION_PROCESS_UPDATE = "com.example.locationservicesapplication.UPDATE_LOCATION";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();

            if (ACTION_PROCESS_UPDATE.equals(action)) {
                LocationResult locationResult = LocationResult.extractResult(intent);

                if (locationResult != null) {
                    Location location = locationResult.getLastLocation();
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    String displayText = "Latitude: " + latitude + "\nlongitude: " + longitude;

                    try {
                        MainActivity.getInstance().updateLocationTextView(displayText);
                    } catch (Exception exception) {
                        Toast.makeText(context,  displayText, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}
