package org.aihdint.aihd.fragments.dm_followup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.EditText;

import org.aihdint.aihd.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import customfonts.EditText_Roboto;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_1 extends Fragment implements FollowUpActivityModel.FragStateChangeListener {

    EditText dmDiagnosisDateEditText;
    EditText dmClinicDateEditText;
    EditText htnDiagnosisDateEditText;
    EditText htnClinicDateEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_followup_fragment_1, container, false);

        FollowUpActivityModel.getInstance().setListener(this);


        EditText dm_followup_date = view.findViewById(R.id.dm_followup_date);
        EditText supporter_nameEditText = view.findViewById(R.id.supporter_name);
        EditText supporter_phoneEditText = view.findViewById(R.id.supporter_telephone);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dm_followup_date.setText(dateFormat.format(new Date())); // it will show 16/07/2013


        dmDiagnosisDateEditText = view.findViewById(R.id.dm_diagnosis_date);
        dmClinicDateEditText = view.findViewById(R.id.dm_clinic_date);

        htnDiagnosisDateEditText = view.findViewById(R.id.htn_diagnosis_date);
        htnClinicDateEditText = view.findViewById(R.id.htn_clinic_date);

        String supporter_name = supporter_nameEditText.getText().toString().trim();
        String supporter_phone = supporter_phoneEditText.getText().toString().trim();

        FragmentModelFollowUp.getInstance().followUpOne(supporter_name, supporter_phone);

        return view;
    }

    @Override
    public void dmDiagnosis(String diagnosis) {
        if (diagnosis.matches("165087")) {
            dmDiagnosisDateEditText.setVisibility(View.GONE);
            dmClinicDateEditText.setVisibility(View.GONE);
        }else {
            dmDiagnosisDateEditText.setVisibility(View.VISIBLE);
            dmClinicDateEditText.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void htnDiagnosis(String status) {
        Log.d("HTN Diagnosis",status);
        if (status.matches("165092")) {
            htnDiagnosisDateEditText.setVisibility(View.GONE);
            htnClinicDateEditText.setVisibility(View.GONE);
        }else {
            htnDiagnosisDateEditText.setVisibility(View.VISIBLE);
            htnClinicDateEditText.setVisibility(View.VISIBLE);
        }
    }
}
