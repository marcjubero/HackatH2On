package agbar.hack.watcalite.api;

import android.os.AsyncTask;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcjubero on 22/03/15.
 */
public class APIAsync extends AsyncTask<String,String,JsonObject> {

    static private String url = "http://46.101.46.175:8080";

    private AsyncTaskCompleted listener;

    public interface AsyncTaskCompleted {
        public void TaskFinished(JsonObject message);
    }

    public void TaskFinishedListener(AsyncTaskCompleted listener){
        this.listener = listener;
    }

    private JsonObject sendGet (String func, String params) throws Exception {

        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = httpclient.execute(new HttpGet(this.url + (params != ""? ("/" + func + "?" + params):"")));

        httpclient.getConnectionManager().shutdown();
        if (response.getStatusLine().getStatusCode() != 200){
            return new JsonParser().parse("{\"err\":1,\"message\":\"Server error\"}").getAsJsonObject();
        }
        return new JsonParser().parse(EntityUtils.toString(response.getEntity())).getAsJsonObject();
    }


    private JsonObject sendPost (String func, String params) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(this.url + "/" + func);

        String [] p = params.split("&");
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(p.length);
        for (int i = 0; i < p.length; ++i) {
            nameValuePairs.add(new BasicNameValuePair(p[i].split("=")[0], p[i].split("=")[1]));
        }

        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        HttpResponse response = httpclient.execute(httppost);

        httpclient.getConnectionManager().shutdown();
        if (response.getStatusLine().getStatusCode() != 200){
            return new JsonParser().parse("{\"err\":1,\"message\":\"Server error\"}").getAsJsonObject();
        }
        return new JsonParser().parse(EntityUtils.toString(response.getEntity())).getAsJsonObject();
    }

    @Override
    protected JsonObject doInBackground(String... params) {
        try {
            if(params[0].equalsIgnoreCase("addPoint"))
                return sendPost("addPoint", "rate=" + params[1] + "&" + "comment=" + params[2] + "&" + "lat=" + params[3] + "&" + "lon=" + params[4]);
            else if(params[0].equalsIgnoreCase("getPerRadius"))
                return sendPost("getPointsInRadius", "lat=" + params[1] + "&" + "lon=" + params[2] + "&" + "radius=" + params[3] + "&" + "days=" + params[4]);
            else if(params[0].equalsIgnoreCase("getPoints"))
                return sendGet("getPoints","");
            else
                return new JsonParser().parse("{\"err\":1,\"message\":\"Error in API call function, " + params[0] + " not exist\"}").getAsJsonObject();

        } catch (Exception e) {
            if (e.getMessage().contains("refused"))
                return new JsonParser().parse("{\"err\":1, \"message\":\"Server down\"}").getAsJsonObject();
            else
                return new JsonParser().parse("{\"err\":1, \"message\":\"Error parsing response\"}").getAsJsonObject();
        }
    }
}
