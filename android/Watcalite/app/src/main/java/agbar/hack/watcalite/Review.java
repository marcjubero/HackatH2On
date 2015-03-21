package agbar.hack.watcalite;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Daniil on 21/03/2015.
 */
public class Review {
    private int score;
    private String comment;
    private ArrayList<String> hashtags;
    private Double longtitude;
    private Double latitude;
    private String date;

    public Review() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        String date = sdf.format(calendar.getTime());
        calendar.getTime();

        score = -1;
        comment = "none";
        hashtags = new ArrayList<String>();
        longtitude = -1.0;
        latitude = -1.0;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
