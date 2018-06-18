package org.aihdint.aihd.Forms;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;

import org.aihdint.aihd.PageAdapters.DM_Initial_Adpater;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.app.NavigationDrawerShare;
import org.aihdint.aihd.fragments.dm_initial.FragmentModelInitial;
import org.aihdint.aihd.fragments.dm_initial.InitialActivityModel_Three;
import org.aihdint.aihd.fragments.dm_initial.InitialActivityModel_Two;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static org.aihdint.aihd.app.Config.DMINITIAL_URL;

/**
 * Developed by Rodney on 26/03/2018.
 */

public class DM_Initial extends AppCompatActivity implements FragmentModelInitial.FragStateChangeListener {

    private static final String TAG = DM_Initial.class.getSimpleName();

    private String jsonResponse;

    //Page 2
    private String extremities, medication_none, medication_metformin, medication_glibenclamide, medication_insulin, medication_nph, medication_soluble_insulin, medication_enalapril, medication_hctz, medication_losartan, medication_nifedipine, medication_atenolol, medication_other;

    //Page 3
    private String glucose, protein, ketone, ecg, cxr;
    private ProgressDialog pDialog;

    private JSONArray jsonArry1, jsonArry2, jsonArry3, jsonArry4;
    private String file_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_initial);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.CreateDrawer(toolbar);

        extremities = medication_metformin = medication_glibenclamide = medication_insulin = medication_nph = medication_soluble_insulin = medication_enalapril = medication_hctz = medication_losartan = medication_nifedipine = medication_atenolol = medication_other;

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        FragmentModelInitial.getInstance().setListener(this);

        file_name = "DM_HTN_INITIAL_" + System.currentTimeMillis() + ".json";

        jsonArry1 = new JSONArray();
        jsonArry2 = new JSONArray();
        jsonArry3 = new JSONArray();
        jsonArry4 = new JSONArray();


        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Page 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 5"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final DM_Initial_Adpater adapter = new DM_Initial_Adpater
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //noinspection deprecation
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {

            case R.id.radio_extremities_normal:
                if (checked)
                    extremities = "1115";
                    InitialActivityModel_Two.getInstance().extremitiesStatus(extremities);
                break;
            case R.id.radio_extremities_abnormal:
                if (checked)
                    extremities = "1116";
                    InitialActivityModel_Two.getInstance().extremitiesStatus(extremities);
                break;

            case R.id.radio_glucose_yes:
                if (checked)
                    glucose = "1065";
                InitialActivityModel_Three.getInstance().urinalysisGlucose(glucose);
                break;
            case R.id.radio_glucose_no:
                if (checked)
                    glucose = "1066";
                InitialActivityModel_Three.getInstance().urinalysisGlucose(glucose);
                break;
            case R.id.radio_protein_yes:
                if (checked)
                    protein = "1065";
                InitialActivityModel_Three.getInstance().urinalysisProtein(protein);
                break;
            case R.id.radio_protein_no:
                if (checked)
                    protein = "1066";
                InitialActivityModel_Three.getInstance().urinalysisProtein(protein);
                break;
            case R.id.radio_ketone_yes:
                if (checked)
                    ketone = "1065";
                InitialActivityModel_Three.getInstance().urinalysisKetone(ketone);
                break;
            case R.id.radio_ketone_no:
                if (checked)
                    ketone = "1066";
                InitialActivityModel_Three.getInstance().urinalysisKetone(ketone);
                break;

        }
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_medication_none:
                if(checked){
                    medication_none = "1107";
                    InitialActivityModel_Two.getInstance().medicationNone(medication_none);
                }else {
                    medication_none = "";
                    InitialActivityModel_Two.getInstance().medicationNone(medication_none);
                }
            case R.id.checkbox_medication_metformin:
                if(checked){
                    medication_metformin = "79651";
                }else {
                    medication_metformin = "";
                }
            case R.id.checkbox_medication_glibenclamide:
                if(checked){
                    medication_glibenclamide = "77071";
                }else {
                    medication_glibenclamide = "";
                }
            case R.id.checkbox_medication_insulin:
                if(checked){
                    medication_insulin = "159459";
                }else {
                    medication_insulin = "";
                }
            case R.id.checkbox_medication_nph:
                if(checked){
                    medication_nph = "78068";
                }else {
                    medication_nph = "";
                }
            case R.id.checkbox_medication_soluble_insulin:
                if(checked){
                    medication_soluble_insulin = "282";
                }else {
                    medication_soluble_insulin = "";
                }
            case R.id.checkbox_medication_enalapril:
                if(checked){
                    medication_enalapril = "75633";
                }else {
                    medication_enalapril = "";
                }
            case R.id.checkbox_medication_hctz:
                if(checked){
                    medication_hctz = "77696";
                }else {
                    medication_hctz = "";
                }
            case R.id.checkbox_medication_losartan:
                if(checked){
                    medication_losartan = "79074";
                }else {
                    medication_losartan = "";
                }
            case R.id.checkbox_medication_nifedipine:
                if(checked){
                    medication_nifedipine = "80637";
                }else {
                    medication_nifedipine = "";
                }
            case R.id.checkbox_medication_atenolol:
                if(checked){
                    medication_atenolol = "71652";
                }else {
                    medication_atenolol = "";
                }

        }

    }

    public void onCheckboxMedicineOther(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_medication_other:
                if(checked){
                    medication_other = "5622";
                    InitialActivityModel_Two.getInstance().medicationOther(medication_other);
                }else {
                    medication_other = "";
                    InitialActivityModel_Two.getInstance().medicationOther(medication_other);
                }
        }
    }


    @Override
    public void initialOne(String date, JSONArray params) {

    }

    @Override
    public void initialTwo(JSONArray params) {

    }

    @Override
    public void initialThree(JSONArray params) {

    }

    @Override
    public void initialFour(JSONArray params) {

    }

    public void validate(View view) {

        File dir = new File(Environment.getExternalStorageDirectory() + "/aihd/followup");
        if (!dir.mkdirs()) {
            Log.e("Directory Message", "Directory not created");
        }

        File file = new File(dir, file_name);

        try {

            JSONArray jsonArray = JSONFormBuilder.concatArray(jsonArry1, jsonArry2, jsonArry3, jsonArry4);
            JSONObject jsonForm = new JSONObject();

            try {
                jsonForm.put("formDescription", "DM HTN Initial Encounter Form");
                jsonForm.put("formEncounterType", "bf3f3108-f87c-11e7-913d-5f679b8fdacb");
                jsonForm.put("formUuid", "7b0abbe2-98ab-4ba3-a423-e2441859f976");
                jsonForm.put("formVersion", "1.0");
                jsonForm.put("formUILocation", "patientDashboard.visitActions");
                jsonForm.put("formOrder", "1");
                jsonForm.put("encounterDate", "");
                jsonForm.put("encounterProvider", "");
                jsonForm.put("patient_id", "");
                jsonForm.put("obs", jsonArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            FileOutputStream f = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(f);
            pw.println(jsonForm.toString());
            //pw.println(jsonObs2.toString());
            pw.flush();
            pw.close();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("Error", "*** File not found. Did you add a WRITE_EXTERNAL_STORAGE permission to the manifest?");
        } catch (Exception e) {
            e.printStackTrace();
        }


        Toast.makeText(getBaseContext(), file_name + " file saved", Toast.LENGTH_SHORT).show();

        //Read File
        try {
            File myFile = new File(Environment.getExternalStorageDirectory() + "/aihd/followup/" + file_name);
            FileInputStream fIn = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader(
                    new InputStreamReader(fIn));
            String aDataRow;
            StringBuilder aBuffer = new StringBuilder();
            while ((aDataRow = myReader.readLine()) != null) {
                aBuffer.append(aDataRow).append("\n");
            }
            Log.e("Reading from storage", aBuffer.toString());
            myReader.close();
            Toast.makeText(getBaseContext(),
                    "Done reading SD 'mysdfile.txt'",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }

        //Log.d("JSON FollowUp", jsonObs1.toString() + " " + dir.toString());


    }


    /**
     * Method to make json array request where response starts with [
     * */

    private void dmInitialForm() {

        // Tag used to cancel the request
        String tag_string_req = "req_upload";

        StringRequest strReq = new StringRequest(Request.Method.POST,
                DMINITIAL_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                jsonResponse = response;
                Log.d(TAG, "Upload Response: " + response);

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        // User successfully stored in MySQL
                        // Now store the user in sqlite
                        Toast.makeText(getApplicationContext(), "Form successfully uploaded.!", Toast.LENGTH_LONG).show();
                    }

                    hideDialog();
                } catch (JSONException e) {
                    hideDialog();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Upload Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<>();

                params.put("uuid",AppController.getInstance().getSessionManager().getUserDetails().get("user_id"));

                JSONObject jsonParams = new JSONObject(params);
                JSONObject jsonAdd = new JSONObject();

                try {
                    jsonAdd.put("Encounter", "85562bbn-jjk96");
                    jsonAdd.put("obs", jsonParams);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d("Params", jsonAdd.toString());


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

    public void validateInitial(View view) {
        pDialog.setMessage("Uploading DM Initial Form" +
                "...");
        showDialog();
        dmInitialForm();
    }
}
