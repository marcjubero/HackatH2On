package agbar.hack.watcalite;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Daniil on 21/03/2015.
 */
public class MyLocationListener implements LocationListener {

    private final String TAG = getClass().getSimpleName();

    private Review review;
    private LongLat longlat;

    public MyLocationListener(Review review, LongLat longlat){
        this.review = review;
        this.longlat = longlat;
    }

    /**
     * will be called every time that the location changes
     * @param location
     */
    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "location changed!");
        Double latitude = location.getLatitude();
        Double longitude = location.getLongitude();
        Log.d(TAG, "new vars -> latitude: "+latitude+", longitude: "+longitude);

        // update Review
        longlat.setLongLat(longitude,latitude);
    }

    /**
     * mandatory function (does nothing)
     * @param provider
     * @param status
     * @param extras
     */
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d(TAG,"status changed!");
    }

    /**
     * GPS on
     * @param provider
     */
    @Override
    public void onProviderEnabled(String provider) {
        Log.d(TAG, "the provider: " + provider + " is on");
    }

    /**
     * GPS on
     * @param provider
     */
    @Override
    public void onProviderDisabled(String provider) {
        Log.d(TAG, "the provider: " + provider + " is off");
    }
}
