package agbar.hack.watcalite;

import java.util.ArrayList;

/**
 * Created by Daniil on 21/03/2015.
 */
public class Review {
    private int score;
    private String comment;
    private ArrayList<String> hashtags;
    private LongLat longlat;

    public Review() {
        score = -1;
        comment = "none";
        hashtags = new ArrayList<String>();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setHashtags(ArrayList<String> hashtags) {
        this.hashtags = hashtags;
    }
}
