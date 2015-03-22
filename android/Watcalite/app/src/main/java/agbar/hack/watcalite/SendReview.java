package agbar.hack.watcalite;

import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import android.widget.EditText;
import android.widget.Spinner;

import java.util.*;

import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class SendReview extends ActionBarActivity {

    Review review;
    LongLat longlat;
    private final String TAG = getClass().getSimpleName();

    // layout views
    Spinner score_spinner;
    EditText comment_edit_text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendreview);

        score_spinner = (Spinner) findViewById(R.id.score_spinner);
        comment_edit_text = (EditText) findViewById(R.id.comment_edit_text);
        button = (Button) findViewById(R.id.send_review_button);

        review = new Review();
        longlat = new LongLat();
        // location listener, so each time the GPS senses a new location, this callback function will be called from the android system
        LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener mlocListener = new MyLocationListener(review, longlat);
        mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);


    }

    private void find_hastags(String content, ArrayList<String> hashtag)
    {
        for (int i = 0; i < content.length(); ++i){
            if (content.charAt(i) == '#') {
                ++i; //the position i has got '#'
                String aux="";
                while((i < content.length())&&(letra_numero(content.charAt(i)))) {
                    aux += content.charAt(i);
                    ++i;
                }
                hashtag.add(aux);
            }
        }
        Toast.makeText(getApplicationContext(), "surto", Toast.LENGTH_SHORT).show();

    }

    private boolean letra_numero(char c)
    {
        return ( (c >= 48 && c <= 57) || (c >= 65 && c <= 122) );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void sendReview(View view) {

        // getting the user's score

        // getting the user's comment
        Log.d(TAG, "Displaying the content");
        String comment = comment_edit_text.getText().toString(); // the user's comment
        review.setComment(comment);

        // getting the user's used hashtags
        Log.d(TAG, "Displaying the hashtags");
        ArrayList<String> hashtags = new ArrayList<String>();
        if (comment != null) find_hastags(comment, hashtags);
        review.setHashtags(hashtags);

        Log.d(TAG, "Making the json");
        Gson gson = new Gson();
        String json = gson.toJson(review);

        Log.d(TAG, "This is the json: "+json);

        // send it to database through a asyncTask
    }
}













