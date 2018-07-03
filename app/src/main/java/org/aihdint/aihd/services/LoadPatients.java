package org.aihdint.aihd.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;

import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.app.Config;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Application Created by Rodney on 14-Sep-16.
 */
public class LoadPatients extends IntentService {

    public LoadPatients() {
        super(LoadPatients.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                DownloadPatients();
            }
        });
        thread.start();

    }

    private void DownloadPatients() {

        StringRequest req = new StringRequest(Request.Method.POST, Config.PATIENT_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String jsonString) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonString);

                    // Getting JSON Array node
                    JSONArray patients = jsonObj.getJSONArray("data");
                    Log.d("Response", jsonString);
                    if (patients.length() > 0) {
                        // looping through json and adding to list
                        for (int i = 0; i < patients.length(); i++) {

                            JSONObject patientObj = patients.getJSONObject(i);

                            String person_id = patientObj.getString("person_id");
                            String gender = patientObj.getString("gender");
                            String birthdate = patientObj.getString("birthdate");
                            String phone = patientObj.getString("value");
                            String family_name = patientObj.getString("family_name");
                            String given_name = patientObj.getString("given_name");

                        }

                    }

                } catch (Exception e) {
                    // hiding the progress bar
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<>();
                params.put("location_id", AppController.getInstance().getSessionManager().getUserDetails().get("location_id"));
                params.put("uuid", AppController.getInstance().getSessionManager().getUserDetails().get("user_id"));

                JSONObject JSONparams = new JSONObject(params);
                Log.d("Params", JSONparams.toString());

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);

    }


}
