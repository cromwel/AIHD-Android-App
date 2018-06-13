package org.aihdint.aihd.Forms;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import org.aihdint.aihd.PageAdapters.DM_FollowUp_Adpater;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.Alerts;
import org.aihdint.aihd.app.NavigationDrawerShare;
import org.aihdint.aihd.fragments.dm_followup.FollowUpActivityModel;
import org.aihdint.aihd.fragments.dm_followup.FollowUpActivityModel_Four;
import org.aihdint.aihd.fragments.dm_followup.FragmentModelFollowUp;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Rodney 4/24/18
 */

public class DM_FollowUp extends AppCompatActivity implements FragmentModelFollowUp.FragStateChangeListener {

    private JSONArray jsonObs1, jsonObs2, jsonObs3, jsonObs4;
    private String file_name, current_date;
    private String dm_diagnosis, hypertension, nhif, diabetes_type, hiv_status;


    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_follow_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.CreateDrawer(toolbar);

        FragmentModelFollowUp.getInstance().setListener(this);

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        current_date = dateFormat.format(new Date());

        file_name = "DM_HTN_FOLLOWUP_" + System.currentTimeMillis() + ".json";

        jsonObs1 = new JSONArray();
        jsonObs2 = new JSONArray();
        jsonObs3 = new JSONArray();
        jsonObs4 = new JSONArray();

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Page 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 4"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final DM_FollowUp_Adpater adapter = new DM_FollowUp_Adpater
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
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
        switch (view.getId()) {
            case R.id.radio_diagnosis_new:
                if (checked)
                    dm_diagnosis = "165087";
                FollowUpActivityModel.getInstance().dmDiagnosis(dm_diagnosis);
                break;
            case R.id.radio_diagnosis_known:
                if (checked)
                    dm_diagnosis = "165088";
                FollowUpActivityModel.getInstance().dmDiagnosis(dm_diagnosis);
                break;
            case R.id.radio_hypertension_new:
                if (checked)
                    hypertension = "165092";
                FollowUpActivityModel.getInstance().htnDiagnosis(hypertension);
                break;
            case R.id.radio_hypertension_known:
                if (checked)
                    hypertension = "165093";
                FollowUpActivityModel.getInstance().htnDiagnosis(hypertension);
                break;
            case R.id.radio_NHIF_yes:
                if (checked)
                    nhif = "1065";
                break;
            case R.id.radio_NHIF_no:
                if (checked)
                    nhif = "1066";
                Alerts.alert_msg(this, "NHIF Registration", "Encourage Client to Register for NHIF");
                break;
            case R.id.radio_diabetes_type_1:
                if (checked)
                    diabetes_type = "142474";
                break;
            case R.id.radio_diabetes_GDM:
                if (checked)
                    diabetes_type = "1449";
                break;
            case R.id.radio_diabetes_type_2:
                if (checked)
                    diabetes_type = "142473";
                break;
            case R.id.radio_HIV_negative:
                if (checked)
                    hiv_status = "664";
                break;
            case R.id.radio_HIV_positive:
                if (checked)
                    hiv_status = "138571";
                break;
            case R.id.radio_HIV_unknown:
                if (checked)
                    hiv_status = "1067";
                break;
        }
    }


    @Override
    public void followUpOne(String encounter_date, JSONArray params) {
        jsonObs1 = params;
    }

    @Override
    public void followUpTwo(JSONArray params) {
        jsonObs2 = params;
    }


    @Override
    public void followUpThree(JSONArray params) {
        jsonObs3 = params;
    }

    @Override
    public void followUpFour(JSONArray params) {
        jsonObs4 = params;
    }


    public void validate(View view) {

        if (
                dm_diagnosis != null && !dm_diagnosis.isEmpty()
                ) {

            FollowUpActivityModel_Four.getInstance().updateValues();

            jsonObs1.put(JSONFormBuilder.observations("165086", dm_diagnosis, current_date, ""));
            jsonObs1.put(JSONFormBuilder.observations("165091", hypertension, current_date, ""));

            jsonObs1.put(JSONFormBuilder.observations("1917", nhif, current_date, ""));
            jsonObs1.put(JSONFormBuilder.observations("165094", diabetes_type, current_date, ""));
            jsonObs1.put(JSONFormBuilder.observations("138405", hiv_status, current_date, ""));

                File dir = new File(Environment.getExternalStorageDirectory() + "/aihd/followup");
                if (!dir.mkdirs()) {
                    Log.e("Directory Message", "Directory not created");
                }

                File file = new File(dir, file_name);

                try {
                    FileOutputStream f = new FileOutputStream(file);
                    PrintWriter pw = new PrintWriter(f);
                    pw.println(jsonObs1.toString());
                    pw.println(jsonObs2.toString());
                    pw.println(jsonObs3.toString());
                    pw.println(jsonObs4.toString());
                    pw.flush();
                    pw.close();
                    f.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Log.i("Error", "******* File not found. Did you" +
                            " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
                } catch (IOException e) {
                    e.printStackTrace();
                }


            Toast.makeText(getBaseContext(), file_name + " file saved", Toast.LENGTH_SHORT).show();

                //Read File
                try {
                    File myFile = new File(Environment.getExternalStorageDirectory() + "/aihd/followup/" + file_name);
                    FileInputStream fIn = new FileInputStream(myFile);
                    BufferedReader myReader = new BufferedReader(
                            new InputStreamReader(fIn));
                    String aDataRow = "";
                    String aBuffer = "";
                    while ((aDataRow = myReader.readLine()) != null) {
                        aBuffer += aDataRow + "\n";
                    }
                    Log.e("Reading from storage", aBuffer);
                    myReader.close();
                    Toast.makeText(getBaseContext(),
                            "Done reading SD 'mysdfile.txt'",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }

                Log.d("JSON FollowUp", jsonObs1.toString() + " " + dir.toString());

        } else {
            Toast.makeText(getApplicationContext(), "Sorry unable to save, check mandatory fields are filled", Toast.LENGTH_SHORT).show();
        }

    }


}
