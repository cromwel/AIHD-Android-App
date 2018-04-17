package org.aihdint.aihd;

/*
 * Developed by Rodney on 02/03/2018.
 */

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.orm.query.Select;

import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.app.Config;
import org.aihdint.aihd.app.LocationsAll;
import org.aihdint.aihd.app.SessionManager;
import org.aihdint.aihd.model.Location;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.aihdint.aihd.app.Config.LOCATIONS_URL;


public class Login extends Activity {
    private static final String TAG = Login.class.getSimpleName();
    private EditText inputUsername;
    private EditText inputPassword;
    private ProgressDialog pDialog;
    private SessionManager session;
    private CoordinatorLayout coordinatorLayout;
    private LocationsAll locations;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        inputUsername = findViewById(R.id.username);
        inputPassword = findViewById(R.id.password);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        checkPermissions();

        new RetrieveLocations().execute();

        // Session manager
        session = new SessionManager(getApplicationContext());

        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(Login.this, Home.class);
            startActivity(intent);
            finish();
        }

        Spinner spinnerLocation = findViewById(R.id.spinnerLocationLogin);

        locations = new LocationsAll(this);
        locations.setLocationData(spinnerLocation);

    }


    public void login(View view) {

        String username = inputUsername.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        // Check for empty data in the form
        if (!username.isEmpty() && !password.isEmpty()) {
            // login user
            loginServer(username,password);
        } else {
            // Prompt user to enter credentials
            Toast.makeText(getApplicationContext(),
                    "Please enter the credentials!", Toast.LENGTH_LONG)
                    .show();
        }
    }

    /**
     * function to verify login details in mysql db
     * */
    private void loginServer(final String username, final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.GET,
                Config.LOGIN_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response);
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    String authenticated = jObj.getString("authenticated");

                    // Check for error node in json
                    if (authenticated.matches("true")) {
                        // user successfully logged in

                        // Now store the user in SQLite
                        //String uuid = jObj.getString("uid");

                        JSONObject user = jObj.getJSONObject("user");
                        String name = user.getString("display");

                            JSONObject person = user.getJSONObject("person");
                            String user_id = person.getString("uuid");

                        // Create login session
                        session.setLogin(true);
                        session.createLogin( user_id, name, password,locations.location_id);

                        // Launch main activity
                        Intent intent = new Intent(Login.this,
                                Home.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Error in login. Get the error message
                        Toast.makeText(getApplicationContext(),
                                "Username/Password Invalid", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                String credentials = username+":"+password;
                String auth = "Basic "
                        + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", auth);
                return headers;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void checkPermissions(){
        if (    ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ){
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            List<String> permissions = new ArrayList<>();
            permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions( permissions.toArray( new String[permissions.size()] ), 101 );
            }

            //return;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch ( requestCode ) {
            case 101: {
                for( int i = 0; i < permissions.length; i++ ) {
                    if( grantResults[i] == PackageManager.PERMISSION_GRANTED ) {
                        Log.d( "Permissions", "Permission Granted: " + permissions[i] );

                    } else if( grantResults[i] == PackageManager.PERMISSION_DENIED ) {
                        Log.d( "Permissions", "Permission Denied: " + permissions[i] );
                        //Toast.makeText(getActivity(), "LoyaltyClub won't work well unless you allow requested permissions to be granted", Toast.LENGTH_LONG).show();
                        Snackbar snackbar = Snackbar.make(coordinatorLayout, permissions[i]+ " : Permission Denied", Snackbar.LENGTH_INDEFINITE);
                        snackbar.show();
                    }
                }
            }
            break;
            default: {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }

    public class RetrieveLocations extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // showing refresh animation before making http call
        }

        @Override
        protected Void doInBackground(Void... params) {

            StringRequest req = new StringRequest(Request.Method.GET, LOCATIONS_URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("Response", response);

                    try {

                        // Getting JSON Array node
                        JSONObject data = new JSONObject(response);
                        boolean error = data.getBoolean("error");
                        JSONArray locations = data.getJSONArray("data");

                        if(error){

                            Toast.makeText(getApplicationContext(),"Error loading location data",Toast.LENGTH_SHORT).show();
                        }else {
                            if (locations.length() > 0) {

                                List<Location> location_count = Select.from(Location.class).list();

                                if (locations.length() > location_count.size()) {

                                    // looping through json and adding to list
                                    for (int i = 0; i < locations.length(); i++) {

                                        JSONObject locationObj = locations.getJSONObject(i);

                                        String location_id = locationObj.getString("location_id");
                                        String name = locationObj.getString("name");

                                        Log.d("Insert ", "Inserting location " + name);
                                        Location location = new Location(location_id, name);
                                        location.save();

                                    }

                                    Intent i = new Intent(getApplicationContext(), Login.class);
                                    startActivity(i);
                                    finish();
                                }
                            }
                        }

                        } catch (JSONException e) {
                            e.printStackTrace();
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