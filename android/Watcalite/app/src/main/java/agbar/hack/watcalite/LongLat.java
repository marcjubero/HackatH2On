package agbar.hack.watcalite;

/**
 * Created by Daniil on 21/03/2015.
 */
public class LongLat {

    private static Double longitude;
    private static Double latitude;

    public void setLongLat(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }


    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }
}
