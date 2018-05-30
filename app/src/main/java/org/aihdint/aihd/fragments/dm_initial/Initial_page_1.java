package org.aihdint.aihd.fragments.dm_initial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import org.aihdint.aihd.R;
import org.aihdint.aihd.model.KeyValue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Initial_page_1 extends Fragment implements InitialActivityModel_One.FragStateChangeListener {

    private EditText dm_initial_dateEditText,occupation_otherEditText,diagnosis_diabetes_dateEditText,diagnosis_hypertension_dateEditText,hiv_other_statusEditText;
    private EditText tb_treatment_startEditText,tb_commentEditText,nhif_otherEditText,referral_otherEditText;
    private EditText referral_other_detailsEditText,complaint_otherEditText,complaint_lmpEditText,abuse_otherEditText;
    private RadioGroup hiv_enrolled,referral_patient;
    private String occupation,education_level;
    private LinearLayout hiv_status_details, nhif_other_details;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_1, container, false);

        InitialActivityModel_One.getInstance().setListener(this);

        //EditText
        dm_initial_dateEditText = view.findViewById(R.id.dm_initial_date);
        occupation_otherEditText = view.findViewById(R.id.occupation_other);
        diagnosis_diabetes_dateEditText = view.findViewById(R.id.diagnosis_diabetes_date);
        diagnosis_hypertension_dateEditText = view.findViewById(R.id.diagnosis_hypertension_date);
        hiv_other_statusEditText = view.findViewById(R.id.hiv_other_status);
        tb_treatment_startEditText = view.findViewById(R.id.tb_treatment_start);
        tb_commentEditText = view.findViewById(R.id.tb_comment);
        nhif_otherEditText = view.findViewById(R.id.nhif_other);
        referral_otherEditText = view.findViewById(R.id.referral_other);
        referral_other_detailsEditText = view.findViewById(R.id.referral_other_details);
        complaint_otherEditText = view.findViewById(R.id.complaint_other);
        complaint_lmpEditText = view.findViewById(R.id.complaint_lmp);
        abuse_otherEditText = view.findViewById(R.id.abuse_other);

        //Spinner
        Spinner educationLevelSpinner = view.findViewById(R.id.spinnerEducation);
        Spinner occupationSpinner = view.findViewById(R.id.spinnerOccupation);

        //RadioGroup
        hiv_enrolled = view.findViewById(R.id.hiv_enrolled);
        referral_patient = view.findViewById(R.id.interreferral_details);

        //LinearLayout
        nhif_other_details = view.findViewById(R.id.nhif_other_details);
        hiv_status_details = view.findViewById(R.id.hiv_status_details);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dm_initial_dateEditText.setText(dateFormat.format(new Date())); // it will show 16/07/2013

        ArrayList<KeyValue> keyvalueOccupation = new ArrayList<>();
        ArrayList<KeyValue> keyvalueEducation = new ArrayList<>();
        //Add locations
        // adding each child node to HashMap key => value
        keyvalueOccupation.add(new KeyValue("", "Select Occupation"));
        keyvalueOccupation.add(new KeyValue("1540", "Employed"));
        keyvalueOccupation.add(new KeyValue("165170", "Unemployed"));
        keyvalueOccupation.add(new KeyValue("161382", "Self Employed"));
        keyvalueOccupation.add(new KeyValue("159465", "Student"));
        keyvalueOccupation.add(new KeyValue("5622", "Other"));

        // adding each child node to HashMap key => value
        keyvalueEducation.add(new KeyValue("", "Select Education Level"));
        keyvalueEducation.add(new KeyValue("1107", "None"));
        keyvalueEducation.add(new KeyValue("160290", "Incomplete Primary"));
        keyvalueEducation.add(new KeyValue("1713", "Primary"));
        keyvalueEducation.add(new KeyValue("1714", "Secondary"));
        keyvalueEducation.add(new KeyValue("160292", "Tertiary education"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, keyvalueOccupation);
        occupationSpinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalueOccupation.get(2)));//Optional to set the selected item.

        occupationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                    occupation = value.getId();
                    updateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter1 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, keyvalueEducation);
        educationLevelSpinner.setAdapter(adapter1);
        adapter1.notifyDataSetChanged();
        //spinnerLocation.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        educationLevelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                education_level = value.getId();
                updateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        updateValues();

        return view;
    }

    @Override
    public void dmDiagnosis(String diagnosis) {
        if (diagnosis.matches("165087")) {
            diagnosis_diabetes_dateEditText.setVisibility(View.GONE);
        }else {
            diagnosis_diabetes_dateEditText.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void htnDiagnosis(String status) {
        if (status.matches("165092")) {
            diagnosis_hypertension_dateEditText.setVisibility(View.GONE);
        }else {
            diagnosis_hypertension_dateEditText.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hivStatus(String status) {
        if (status.matches("138571")) {
            hiv_enrolled.setVisibility(View.VISIBLE);
        }else {
            hiv_enrolled.setVisibility(View.GONE);
        }
    }

    @Override
    public void nhifStatus(String status) {
        if (status.matches("5622")) {
            nhif_other_details.setVisibility(View.VISIBLE);
        }else {
            nhif_other_details.setVisibility(View.GONE);
        }
    }

    @Override
    public void referralStatus(String status) {
        if (status.matches("1065")) {
            referral_patient.setVisibility(View.VISIBLE);
        }else {
            referral_patient.setVisibility(View.GONE);
        }
    }

    @Override
    public void complaintStatus(String status) {
        if (status.matches("5622")) {
            complaint_otherEditText.setVisibility(View.VISIBLE);
        }else {
            complaint_otherEditText.setVisibility(View.GONE);
        }
    }

    public  void updateValues(){
        FragmentModelInitial.getInstance().initialOne(
                dm_initial_dateEditText.getText().toString().trim(),
                occupation_otherEditText.getText().toString().trim(),
                diagnosis_diabetes_dateEditText.getText().toString().trim(),
                diagnosis_hypertension_dateEditText.getText().toString().trim(),
                hiv_other_statusEditText.getText().toString().trim(),
                tb_treatment_startEditText.getText().toString().trim(),
                tb_commentEditText.getText().toString().trim(),
                nhif_otherEditText.getText().toString().trim(),
                referral_otherEditText.getText().toString().trim(),
                referral_other_detailsEditText.getText().toString().trim(),
                complaint_otherEditText.getText().toString().trim(),
                complaint_lmpEditText.getText().toString().trim(),
                abuse_otherEditText.getText().toString().trim(),
                occupation,
                education_level
        );
    }

}
