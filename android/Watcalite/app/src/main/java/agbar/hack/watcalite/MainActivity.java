package agbar.hack.watcalite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Daniil on 21/03/2015.
 */
public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView opinar = (ImageView) findViewById(R.id.opinar_imageView);
        ImageView valoraciones = (ImageView) findViewById(R.id.valoraciones_imageView);

        /*try{
            opinar.setImageDrawable(getAssetImage("opinar"));
            valoraciones.setImageDrawable(getAssetImage("valoraciones"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void goToReview(View view) {
        Intent intent = new Intent(this,SendReview.class);
        startActivity(intent);
    }

    public void goToValorations(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    /*private Drawable getAssetImage(String filename) throws IOException {
        AssetManager assets = this.getResources().getAssets();
        InputStream buffer = new BufferedInputStream((assets.open("drawable/" + filename + ".jgg")));
        Bitmap bitmap = BitmapFactory.decodeStream(buffer);
        return new BitmapDrawable(this.getResources(), bitmap);
    }*/
}
