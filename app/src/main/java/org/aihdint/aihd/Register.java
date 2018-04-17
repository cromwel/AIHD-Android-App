package org.aihdint.aihd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.app.LocationsAll;
import org.aihdint.aihd.app.NavigationDrawerShare;
import org.aihdint.aihd.model.Person;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.aihdint.aihd.app.Config.PATIENT_REGISTER_URL;

/**
 * Developed by Rodney on 19/03/2018.
 */

public class Register extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = Register.class.getSimpleName();

    private String gender,birthdate,isEstimated,jsonResponse ;
    private TextView textViewDOB;
    private EditText textViewFamilyName,textViewGivenName,textViewTelephone,textViewIdentifier;
    private EditText textViewAddress1,textViewAddress2,textViewAddress3,textViewCounty,textViewVillage;

    private ProgressDialog pDialog;
    private LocationsAll locations;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.CreateDrawer(toolbar);

        textViewFamilyName = findViewById(R.id.family_name);
        textViewGivenName = findViewById(R.id.given_name);
        textViewTelephone = findViewById(R.id.telephone);
        textViewIdentifier = findViewById(R.id.identifier_type);

        textViewAddress1 = findViewById(R.id.address1);
        textViewAddress2 = findViewById(R.id.address2);
        textViewAddress3 = findViewById(R.id.address3);
        textViewCounty = findViewById(R.id.county_district);
        textViewVillage = findViewById(R.id.city_village);

        textViewDOB = findViewById(R.id.birthdate_textview);
        isEstimated = "0";

        Spinner spinnerLocation = findViewById(R.id.spinnerLocation);

        locations = new LocationsAll(this);
        locations.setLocationData(spinnerLocation);

    }

    public void dob (View view){

        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                Register.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

        dpd.showYearPickerFirst(true);
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = year+"-"+monthOfYear+"-"+dayOfMonth;
        textViewDOB.setText(date);
        birthdate = date;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_male:
                if (checked)
                    gender = "M";
                break;
            case R.id.radio_female:
                if (checked)
                    gender = "F";
                break;
            case R.id.birthdate_estimated_yes:
                if (checked)
                    isEstimated = "1";
                break;
            case R.id.birthdate_estimated_no:
                if (checked)
                    isEstimated = "0";
                break;
        }
    }

    public void Submit(View view) {

        validation();
    }

    public void validation(){
        String family_name = textViewFamilyName.getText().toString().trim();
        String given_name = textViewGivenName.getText().toString().trim();
        String telephone = textViewTelephone.getText().toString().trim();
        String identifier_type = textViewIdentifier.getText().toString().trim();
        String address1 = textViewAddress1.getText().toString().trim();
        String address2 = textViewAddress2.getText().toString().trim();
        String address3 = textViewAddress3.getText().toString().trim();
        String county_district = textViewCounty.getText().toString().trim();
        String city_village = textViewVillage.getText().toString().trim();


        // Check for empty data in the form
        if (!family_name.isEmpty()
                && !given_name.isEmpty()
                && !gender.isEmpty()
                && !telephone.isEmpty()
                && !identifier_type.isEmpty()
                && !birthdate.isEmpty()
                ) {

            pDialog.setMessage("Registering patient...");
            showDialog();

            // Inserting row in users table
            new Person(family_name, given_name, gender, birthdate, isEstimated, telephone, identifier_type, locations.location_id, address1, address2, address3, county_district, city_village, "0");

            registerPatient(family_name, given_name, telephone, identifier_type, address1, address2, address3, county_district, city_village);
        } else {
            // Prompt user to enter credentials
            Toast.makeText(getApplicationContext(),
                    "Please enter the required details marked with *", Toast.LENGTH_LONG)
                    .show();
        }
    }

    /**
     * Method to make json array request where response starts with [
     * */

    private void registerPatient(final String family_name, final String given_name, final String telephone,final String identifier_type,
                                 final String address1,final String address2,final String address3,final String county_district,final String city_village) {

        // Tag used to cancel the request
        String tag_string_req = "req_register";

        StringRequest strReq = new StringRequest(Request.Method.POST,
                PATIENT_REGISTER_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                jsonResponse = response;
                Log.d(TAG, "Register Response: " + response);

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        // User successfully stored in MySQL
                        // Now store the user in sqlite
                        String uuid = jObj.getString("uuid");

                        Toast.makeText(getApplicationContext(), "Patient successfully registered.!", Toast.LENGTH_LONG).show();

                        // Launch login activity
                        Intent intent = new Intent(getApplicationContext(), Patients.class);
                        startActivity(intent);
                        finish();
                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("message");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }

                    hideDialog();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<>();
                params.put("family_name", family_name);
                params.put("given_name", given_name);
                params.put("telephone", telephone);
                params.put("identifier_type", identifier_type);
                params.put("gender", gender);
                params.put("birthdate", birthdate);
                params.put("birthdate_estimated", isEstimated);
                params.put("address1", address1);
                params.put("address2", address2);
                params.put("address3", address3);
                params.put("county_district", county_district);
                params.put("city_village", city_village);
                params.put("location_id",locations.location_id);
                params.put("uuid",AppController.getInstance().getSessionManager().getUserDetails().get("user_id"));

                Log.d("Params", params.toString());

                return params;
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



}
