package agbar.hack.watcalite;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< HEAD

import com.google.gson.Gson;

=======
import android.widget.TextView;
import java.util.*;
import android.text.TextWatcher;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
>>>>>>> origin/master

public class MainActivity extends ActionBarActivity {

    Review review;
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        review = new Review();
        // location listener, so each time the GPS senses a new location, this callback function will be called from the android system
        LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener mlocListener = new MyLocationListener(review);
        mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
=======
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView comment_content =  (TextView) findViewById(R.id.editText);

                String content = comment_content.getText().toString();

                ArrayList<String> hastag = new ArrayList<String>();
                if (content != null) { //there are characters inside the textview
                    find_hastags(content, hastag);
                }

                Iterator<String> it = hastag.iterator();

                String s = ""+ hastag.size();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                while( it.hasNext() ){
                    //Toast.makeText(getApplicationContext(), it.next(), Toast.LENGTH_SHORT).show();
                }
            }
        });
>>>>>>> origin/master
    }

    private void find_hastags(String content, ArrayList<String> hastag)
    {
        for (int i = 0; i < content.length(); ++i){
            if (content.charAt(i) == '#') {
                ++i; //the position i has got '#'
                String aux="";
                while( letra_numero(content.charAt(i)) && i < content.length()) {
                    aux += content.charAt(i);
                    ++i;
                }
                hastag.add(aux);
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            sendReview();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendReview() {
        Gson gson = new Gson();
        String json = gson.toJson(review);

        Log.d(TAG, json);

        // send it to database
    }
}













