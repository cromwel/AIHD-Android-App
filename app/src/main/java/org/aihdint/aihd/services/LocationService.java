package org.aihdint.aihd.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.orm.query.Select;

import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.model.Location;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import static org.aihdint.aihd.app.Config.LOCATIONS_URL;

/**
 * Developed by Rodney on 16/04/2018.
 */

public class LocationService extends IntentService {

    public LocationService() {
        super(LocationService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                new RetrieveLocations().execute();
            }
        });
        thread.start();

    }

    public class RetrieveLocations extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // showing refresh animation before making http call
        }

        @Override
        protected Void doInBackground(Void... params) {

            JsonArrayRequest req = new JsonArrayRequest(LOCATIONS_URL,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Log.d("Response", response.toString());
                            if (response.length() > 0) {
                                List<Location> location_count = Select.from(Location.class).list();

                                // looping through json and adding to list
                                for (int i = 0; i < response.length(); i++) {

                                    try {

                                        JSONObject locationObj = response.getJSONObject(i);

                                        String location_id = locationObj.getString("location_id");
                                        String name = locationObj.getString("name");

                                        if(response.length() > location_count.size()){
                                            Log.d("Insert ", "Inserting location " + name);
                                            Location location = new Location(location_id, name);
                                            location.save();
                                        }

                                    } catch (JSONException e) {
                                        // hiding the progress bar
                                        e.printStackTrace();
                                    }
                                }
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();

                }
            });

            // Adding request to request queue
            AppController.getInstance().addToRequestQueue(req);

            return null;
        }
        @Override
        protected void onPostExecute(Void args) {

        }
    }
}
