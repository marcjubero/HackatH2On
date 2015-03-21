package agbar.hack.watcalite;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Daniil on 21/03/2015.
 */
public class DetailedInfo extends ActionBarActivity {

    private final String TAG = getClass().getSimpleName();

    private Double latitude, longitude;
    private ListView listview;
    private ArrayList<String> hardcoded_comments;
    private int hardcoded_score;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_info);

        // getting intent
        Intent intent = getIntent();
        latitude = intent.getDoubleExtra("latitude",0);
        Log.d(TAG, "Latitude: " + String.valueOf(latitude));

        longitude = intent.getDoubleExtra("longitude",0);
        Log.d(TAG, "Longitude: "+String.valueOf(longitude));

        // getting actual data from the sv (not implemented yet)

        // temporal hardcoded elements
        hardcoded_comments = new ArrayList<String>();
        hardcoded_comments.add("Esta agua es una mierda!");
        hardcoded_comments.add("Nah, esta agua esta bien!");

        hardcoded_score = 3;

        // layout elements

        TextView score = (TextView) findViewById(R.id.score_textView);
        score.setText(String.valueOf(hardcoded_score));

        listview = (ListView) findViewById(R.id.comments_listView);
        CommentsAdapter adapter = new CommentsAdapter(this,0,hardcoded_comments);
        listview.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detailedinfo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch(item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
