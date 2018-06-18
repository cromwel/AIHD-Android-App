package org.aihdint.aihd.fragments.dm_initial;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import org.aihdint.aihd.Forms.Common_Functions;
import org.aihdint.aihd.Forms.JSONFormBuilder;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.Alerts;
import org.aihdint.aihd.fragments.dm_followup.FragmentModelFollowUp;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import customfonts.TextView_Roboto_Bold;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Initial_page_2 extends Fragment {

    private LinearLayout linearLayoutPastCurrentMedication, linearLayoutOtherPastCurrentMedication, linearLayoutExtremities;
    private EditText editTextMedicationOther, adhere_specify, allergy_specify, temp, pulse_rate, systolic_one, diastolic_one, systolic_two, diastolic_two;
    private EditText editTextWaist, editTextHip, editTextHeight, editTextWeight;
    private EditText other_general_exam, cvs, rs, pa, cns;
    private TextView_Roboto_Bold bmi, waist_hip_ratio;

    private EditText monofilament_rf, monofilament_lf;

    private CheckBox checkBoxNone, checkBoxMetformin, checkBoxGlibenclamide, checkBoxInsulin, checkBoxNPH, checkBoxSoluble_insulin, checkBoxEnalapril,
            checkBoxHCTZ, checkBoxLosartan, checkBoxNifedipine, checkBoxAtenolol, checkBoxMedicationOther;

    private String medication_none, medication_metformin, medication_glibenclamide, medication_insulin, medication_nph, medication_soluble_insulin,
            medication_enalapril, medication_hctz, medication_losartan, medication_nifedipine, medication_atenolol, medication_other;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_2, container, false);


        linearLayoutPastCurrentMedication = view.findViewById(R.id.past_current_medication);
        linearLayoutOtherPastCurrentMedication = view.findViewById(R.id.other_past_current_medication);

        checkBoxNone = view.findViewById(R.id.checkbox_medication_none);
        checkBoxMetformin = view.findViewById(R.id.checkbox_medication_metformin);
        checkBoxGlibenclamide = view.findViewById(R.id.checkbox_medication_glibenclamide);
        checkBoxInsulin = view.findViewById(R.id.checkbox_medication_insulin);
        checkBoxNPH = view.findViewById(R.id.checkbox_medication_nph);
        checkBoxSoluble_insulin = view.findViewById(R.id.checkbox_medication_soluble_insulin);
        checkBoxEnalapril = view.findViewById(R.id.checkbox_medication_enalapril);
        checkBoxHCTZ = view.findViewById(R.id.checkbox_medication_hctz);
        checkBoxLosartan = view.findViewById(R.id.checkbox_medication_losartan);
        checkBoxNifedipine = view.findViewById(R.id.checkbox_medication_nifedipine);
        checkBoxAtenolol = view.findViewById(R.id.checkbox_medication_atenolol);
        checkBoxMedicationOther = view.findViewById(R.id.checkbox_medication_other);

        checkBox(checkBoxMetformin);
        checkBox(checkBoxGlibenclamide);
        checkBox(checkBoxInsulin);
        checkBox(checkBoxNPH);
        checkBox(checkBoxSoluble_insulin);
        checkBox(checkBoxEnalapril);
        checkBox(checkBoxHCTZ);
        checkBox(checkBoxLosartan);
        checkBox(checkBoxNifedipine);
        checkBox(checkBoxAtenolol);
        checkBox(checkBoxMedicationOther);

        adhere_specify = view.findViewById(R.id.adhere_specify);
        allergy_specify = view.findViewById(R.id.allergy_specify);

        temp = view.findViewById(R.id.temp);
        pulse_rate = view.findViewById(R.id.pulse_rate);

        systolic_one = view.findViewById(R.id.bp_systolic_one);
        diastolic_one = view.findViewById(R.id.bp_diastolic_one);
        systolic_two = view.findViewById(R.id.bp_systolic_two);
        diastolic_two = view.findViewById(R.id.bp_diastolic_two);

        editTextWaist = view.findViewById(R.id.waist_circ);
        editTextHip = view.findViewById(R.id.hip_circ);
        editTextHeight = view.findViewById(R.id.height);
        editTextWeight = view.findViewById(R.id.weight);
        bmi = view.findViewById(R.id.bmi);
        waist_hip_ratio = view.findViewById(R.id.waist_hip_ratio);

        linearLayoutExtremities = view.findViewById(R.id.extremitiesLinearLayout);

        monofilament_rf = view.findViewById(R.id.monofilament_rf);
        monofilament_lf = view.findViewById(R.id.monofilament_lf);

        textWatcher(temp, "temp");
        textWatcher(pulse_rate, "pulse_rate");
        textWatcher(systolic_one, "blood_pressure");
        textWatcher(systolic_two, "blood_pressure");
        textWatcher(diastolic_one, "blood_pressure");
        textWatcher(diastolic_two, "blood_pressure");
        textWatcher(editTextHeight, "bmi");
        textWatcher(editTextWeight, "bmi");
        textWatcher(editTextWaist, "whr");
        textWatcher(editTextHip, "whr");
        textWatcher(monofilament_rf, "monofilament_lf");
        textWatcher(monofilament_lf, "monofilament_rf");


        return view;
    }


    public void medicationNone(String status) {
        if (status.matches("1107")) {
            linearLayoutPastCurrentMedication.setVisibility(View.GONE);
        } else {
            linearLayoutPastCurrentMedication.setVisibility(View.VISIBLE);
        }
        Log.d("None", status + " ");
    }

    public void medicationOther(String status) {
        if (status.matches("5622")) {
            linearLayoutOtherPastCurrentMedication.setVisibility(View.VISIBLE);
        } else {
            linearLayoutOtherPastCurrentMedication.setVisibility(View.GONE);
        }
    }

    public void extremitiesStatus(String status) {
        if (status.matches("1116")) {
            linearLayoutExtremities.setVisibility(View.VISIBLE);
        } else {
            linearLayoutExtremities.setVisibility(View.GONE);
        }
    }

    public void textWatcher(EditText editText, final String check) {

        editText.addTextChangedListener(new TextWatcher() {

            private Timer timer = new Timer();
            private final long DELAY = 1500; // milliseconds

            @Override
            public void afterTextChanged(final Editable editable) {
                timer.cancel();
                timer = new Timer();

                final Runnable checkRunnable = new Runnable() {
                    public void run() {
                        if (check.matches("temp")) {
                            Common_Functions.checkTemp(getContext(), editable.toString());
                        } else if (check.matches("pulse_rate")) {
                            Common_Functions.checkPR(getContext(), editable.toString());
                        } else if (check.matches("blood_pressure")) {
                            Common_Functions.checkBP(getContext(), systolic_one, diastolic_one, systolic_two, diastolic_two);
                        } else if (check.matches("bmi")) {
                            Common_Functions.BMI(getActivity(), getContext(), editTextHeight, editTextWeight, bmi);
                        } else if (check.matches("whr")) {
                            Common_Functions.WHR(getActivity(), editTextWaist, editTextHip, waist_hip_ratio);
                        } else if (check.matches("monofilament_lf")) {
                            Common_Functions.monofilament(getContext(), editable.toString());
                        } else if (check.matches("monofilament_rf")) {
                            Common_Functions.monofilament(getContext(), editable.toString());
                        }
                    }
                };

                TimerTask task = new TimerTask() {
                    public void run() {
                        getActivity().runOnUiThread(checkRunnable);
                    }
                };

                timer.schedule(task, DELAY);
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

    public void checkBox(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();

                //Check which checkbox was clicked
                switch (checkBox.getId()) {
                    case R.id.checkbox_medication_none:
                        if (checked) {
                            medication_none = "1107";
                            InitialActivityModel_Two.getInstance().medicationNone(medication_none);
                        } else {
                            medication_none = "";
                            InitialActivityModel_Two.getInstance().medicationNone(medication_none);
                        }
                    case R.id.checkbox_medication_metformin:
                        if (checked) {
                            medication_metformin = "79651";
                        } else {
                            medication_metformin = "";
                        }
                    case R.id.checkbox_medication_glibenclamide:
                        if (checked) {
                            medication_glibenclamide = "77071";
                        } else {
                            medication_glibenclamide = "";
                        }
                    case R.id.checkbox_medication_insulin:
                        if (checked) {
                            medication_insulin = "159459";
                        } else {
                            medication_insulin = "";
                        }
                    case R.id.checkbox_medication_nph:
                        if (checked) {
                            medication_nph = "78068";
                        } else {
                            medication_nph = "";
                        }
                    case R.id.checkbox_medication_soluble_insulin:
                        if (checked) {
                            medication_soluble_insulin = "282";
                        } else {
                            medication_soluble_insulin = "";
                        }
                    case R.id.checkbox_medication_enalapril:
                        if (checked) {
                            medication_enalapril = "75633";
                        } else {
                            medication_enalapril = "";
                        }
                    case R.id.checkbox_medication_hctz:
                        if (checked) {
                            medication_hctz = "77696";
                        } else {
                            medication_hctz = "";
                        }
                    case R.id.checkbox_medication_losartan:
                        if (checked) {
                            medication_losartan = "79074";
                        } else {
                            medication_losartan = "";
                        }
                    case R.id.checkbox_medication_nifedipine:
                        if (checked) {
                            medication_nifedipine = "80637";
                        } else {
                            medication_nifedipine = "";
                        }
                    case R.id.checkbox_medication_atenolol:
                        if (checked) {
                            medication_atenolol = "71652";
                        } else {
                            medication_atenolol = "";
                        }
                }

                updateValues();
            }
        });
    }

    public void updateValues() {

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String current_date = dateFormat.format(new Date());

        JSONArray jsonArry = new JSONArray();

        //jsonArry.put(JSONFormBuilder.observations("1712", "", "valueCoded", education_level, current_date, ""));
        //jsonArry.put(JSONFormBuilder.observations("165165", "", "string", editTextRiskOther.getText().toString().trim(), current_date, ""));

        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("JSON FollowUp Page 2", jsonArry.toString() + " ");

        FragmentModelFollowUp.getInstance().followUpTwo(jsonArry);
    }



}
