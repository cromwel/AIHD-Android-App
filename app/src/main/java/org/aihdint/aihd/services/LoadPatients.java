package org.aihdint.aihd.services;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.app.Config;
import org.aihdint.aihd.model.Person;
import org.aihdint.aihd.patient.Patients;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Application Created by Rodney on 14-Sep-16.
 */
public class LoadPatients extends IntentService {

    public LoadPatients() {
        super(LoadPatients.class.getSimpleName());
    }

    private Gson patientsGson;

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            DownloadPatients(intent.getStringExtra("page"));
        } else {
            DownloadPatients(null);
        }

    }

    private void DownloadPatients(final String page) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-M-d");
        patientsGson = gsonBuilder.create();

        StringRequest req = new StringRequest(Request.Method.POST, Config.PATIENT_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObj = new JSONObject(response);

                    // Getting JSON Array node
                    JSONArray patients = jsonObj.getJSONArray("data");


                    //List<Person> persons = Arrays.asList(patientsGson.fromJson(response, Person[].class));
                    Log.d("Response", response);
                    if (patients.length() > 0) {
                        Person.deleteAll(Person.class);

                        List<Person> persons = Arrays.asList(patientsGson.fromJson(patients.toString(), Person[].class));

                        for (Person person : persons) {
                            // GOT THE OBJECT of PEOPLE
                            person.save();
                            Log.d("Patient List", person.get_id().toString());
                        }

                        if (page != null && page.equals("patient")) {
                            Intent add_patient = new Intent(getApplicationContext(), Patients.class);
                            add_patient.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(add_patient);
                            ((Activity) getApplicationContext()).finish();
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
