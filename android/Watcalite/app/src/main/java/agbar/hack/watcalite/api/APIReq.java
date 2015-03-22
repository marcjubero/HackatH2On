package agbar.hack.watcalite.api;

import com.google.gson.JsonObject;

/**
 * Created by marcjubero on 22/03/15.
 */
public class APIReq {

    public void addPoint(int rate, String comment, float lat, float lon) {
        APIAsync asyncRes = new APIAsync();
        asyncRes.execute(new String[]{"addPoint",String.valueOf(rate),comment,String.valueOf(lat),String.valueOf(lon)});

        asyncRes.TaskFinishedListener(new APIAsync.AsyncTaskCompleted() {
            @Override
            public void TaskFinished(JsonObject message) {
                System.err.println(message);
            }
        });
    }

    public void getPoints() {
        APIAsync asyncRes = new APIAsync();
        asyncRes.execute(new String[]{"getPoints",""});

        asyncRes.TaskFinishedListener(new APIAsync.AsyncTaskCompleted() {
            @Override
            public void TaskFinished(JsonObject message) {
                System.err.println(message);
            }
        });
    }

    public void getPointsInRadius(float lat, float lon, float radius, int days) {
        APIAsync asyncRes = new APIAsync();
        asyncRes.execute(new String[]{"getPointsInRadius",String.valueOf(lat), String.valueOf(lon), String.valueOf(radius),String.valueOf(days)});

        asyncRes.TaskFinishedListener(new APIAsync.AsyncTaskCompleted() {
            @Override
            public void TaskFinished(JsonObject message) {
                System.err.println(message);
            }
        });
    }

}
