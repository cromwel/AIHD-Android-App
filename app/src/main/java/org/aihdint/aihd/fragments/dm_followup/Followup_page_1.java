package org.aihdint.aihd.fragments.dm_followup;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.EditText;

import org.aihdint.aihd.R;
import org.aihdint.aihd.Forms.JSONFormBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_1 extends Fragment implements FollowUpActivityModel.FragStateChangeListener {

    EditText dm_followup_date, supporter_nameEditText, supporter_phoneEditText, supporter_phone_otherEditText;
    EditText dmDiagnosisDateEditText, dmClinicDateEditText;
    EditText htnDiagnosisDateEditText, htnClinicDateEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_followup_fragment_1, container, false);

        FollowUpActivityModel.getInstance().setListener(this);

        dm_followup_date = view.findViewById(R.id.dm_followup_date);
        supporter_nameEditText = view.findViewById(R.id.supporter_name);
        supporter_phoneEditText = view.findViewById(R.id.supporter_telephone);
        supporter_phone_otherEditText = view.findViewById(R.id.supporter_telephone_other);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dm_followup_date.setText(dateFormat.format(new Date())); // current date

        dmDiagnosisDateEditText = view.findViewById(R.id.dm_diagnosis_date);
        dmClinicDateEditText = view.findViewById(R.id.dm_clinic_date);

        htnDiagnosisDateEditText = view.findViewById(R.id.htn_diagnosis_date);
        htnClinicDateEditText = view.findViewById(R.id.htn_clinic_date);

        textWatcher(dm_followup_date);
        textWatcher(supporter_nameEditText);
        textWatcher(supporter_phoneEditText);
        textWatcher(supporter_phone_otherEditText);
        textWatcher(dmDiagnosisDateEditText);
        textWatcher(dmClinicDateEditText);
        textWatcher(htnDiagnosisDateEditText);
        textWatcher(htnClinicDateEditText);

        return view;
    }


    @Override
    public void dmDiagnosis(String diagnosis) {
        if (diagnosis.matches("165087")) {
            dmDiagnosisDateEditText.setVisibility(View.GONE);
            dmClinicDateEditText.setVisibility(View.GONE);
        } else {
            dmDiagnosisDateEditText.setVisibility(View.VISIBLE);
            dmClinicDateEditText.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void htnDiagnosis(String status) {
        Log.d("HTN Diagnosis", status);
        if (status.matches("165092")) {
            htnDiagnosisDateEditText.setVisibility(View.GONE);
            htnClinicDateEditText.setVisibility(View.GONE);
        } else {
            htnDiagnosisDateEditText.setVisibility(View.VISIBLE);
            htnClinicDateEditText.setVisibility(View.VISIBLE);
        }
    }

    public void textWatcher(EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(final Editable editable) {
                updateValues();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });
    }

    public void updateValues() {
        String encounter_date = dm_followup_date.getText().toString().trim();

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String current_date = dateFormat.format(new Date());

        JSONArray jsonArry = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("160638", supporter_nameEditText.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160642", supporter_phoneEditText.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165209", supporter_phone_otherEditText.getText().toString().trim(), current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("165089", dmDiagnosisDateEditText.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165150", dmClinicDateEditText.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165090", htnDiagnosisDateEditText.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165151", htnClinicDateEditText.getText().toString().trim(), current_date, ""));

        //jsonObservation.put("obs",jsonObs);

        //Log.d("JSON FollowUp", jsonObservation.toString()+" ");

        FragmentModelFollowUp.getInstance().followUpOne(encounter_date, jsonArry);
    }
}
