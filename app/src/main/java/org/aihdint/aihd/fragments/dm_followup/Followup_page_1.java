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
import android.widget.RadioButton;

import org.aihdint.aihd.R;
import org.aihdint.aihd.Forms.JSONFormBuilder;
import org.aihdint.aihd.app.Alerts;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_1 extends Fragment {

    private EditText dm_followup_date, supporter_nameEditText, supporter_phoneEditText, supporter_phone_otherEditText;
    private EditText dmDiagnosisDateEditText, dmClinicDateEditText;
    private EditText htnDiagnosisDateEditText, htnClinicDateEditText;
    private String dm_diagnosis, hypertension, nhif, diabetes_type, hiv_status;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_followup_fragment_1, container, false);

        dm_followup_date = view.findViewById(R.id.dm_followup_date);
        supporter_nameEditText = view.findViewById(R.id.supporter_name);
        supporter_phoneEditText = view.findViewById(R.id.supporter_telephone);
        supporter_phone_otherEditText = view.findViewById(R.id.supporter_telephone_other);

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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

    public void dmDiagnosis(String diagnosis) {
        if (diagnosis.matches("165087")) {
            dmDiagnosisDateEditText.setVisibility(View.GONE);
            dmClinicDateEditText.setVisibility(View.GONE);
        } else {
            dmDiagnosisDateEditText.setVisibility(View.VISIBLE);
            dmClinicDateEditText.setVisibility(View.VISIBLE);
        }
    }

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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_diabetes_new:
                if (checked)
                    dm_diagnosis = "165087";
                dmDiagnosis(dm_diagnosis);
                break;
            case R.id.radio_diabetes_known:
                if (checked)
                    dm_diagnosis = "165088";
                dmDiagnosis(dm_diagnosis);
                break;
            case R.id.radio_diabetes_na:
                if (checked)
                    dm_diagnosis = "1175";
                dmDiagnosis(dm_diagnosis);
                break;
            case R.id.radio_hypertension_new:
                if (checked)
                    hypertension = "165092";
                htnDiagnosis(hypertension);
                break;
            case R.id.radio_hypertension_known:
                if (checked)
                    hypertension = "165093";
                htnDiagnosis(hypertension);
                break;
            case R.id.radio_hypertension_na:
                if (checked)
                    hypertension = "1175";
                htnDiagnosis(hypertension);
                break;
            case R.id.radio_NHIF_yes:
                if (checked)
                    nhif = "1065";
                break;
            case R.id.radio_NHIF_no:
                if (checked)
                    nhif = "1066";
                Alerts.alert_msg(getContext(), "NHIF Registration", "Encourage Client to Register for NHIF");
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

    public void updateValues() {
        String encounter_date = dm_followup_date.getText().toString().trim();

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current_date = dateFormat.format(new Date());

        JSONArray jsonArry = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("160638", "", "string", supporter_nameEditText.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160642", "", "string", supporter_phoneEditText.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165209", "", "string", supporter_phone_otherEditText.getText().toString().trim(), current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("165086", "", "", dm_diagnosis, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165091", "", "", hypertension, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1917", "", "", nhif, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165094", "", "", diabetes_type, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("138405", "", "", hiv_status, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("165089", "", "string", dmDiagnosisDateEditText.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165150", "", "string", dmClinicDateEditText.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165090", "", "string", htnDiagnosisDateEditText.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165151", "", "string", htnClinicDateEditText.getText().toString().trim(), current_date, ""));

        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("JSON FollowUp Page 1", jsonArry.toString() + " ");

        FragmentModelFollowUp.getInstance().followUpOne(encounter_date, jsonArry);
    }
}
