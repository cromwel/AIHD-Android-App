package org.aihdint.aihd.fragments.dm_followup;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import org.aihdint.aihd.Forms.Common_Functions;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.Alerts;
import org.aihdint.aihd.Forms.JSONFormBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import customfonts.TextView_Roboto_Bold;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_3 extends Fragment {

    private EditText editTextSystolic, editTextDiastolic;
    private EditText editTextWaist, editTextHip, editTextHeight, editTextWeight, editTextNutrition;
    private TextView_Roboto_Bold textViewBMI, textViewWaistHipRatio;
    private String foot_exam, eye_exam, dental_exam, eye_checkup;
    private String cardiovascular_disease, high_cholestrol, peripheral_vascular_disease,
            peripheral_neuropathy, autonomic_neuropathy, retinopathy, kidney_disease, asthma_COPD,
            arthritis, assesment_other;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_followup_fragment_3, container, false);

        editTextSystolic = view.findViewById(R.id.followup_systolic);
        editTextDiastolic = view.findViewById(R.id.followup_diastolic);

        editTextWaist = view.findViewById(R.id.followup_waist_circ);
        editTextHip = view.findViewById(R.id.followup_hip_circ);
        editTextHeight = view.findViewById(R.id.followup_height);
        editTextWeight = view.findViewById(R.id.followup_weight);
        editTextNutrition = view.findViewById(R.id.followup_nutrition);

        textViewBMI = view.findViewById(R.id.followup_bmi);
        textViewWaistHipRatio = view.findViewById(R.id.followup_hip_waist_ratio);

        textWatcher(editTextSystolic, "blood_pressure");
        textWatcher(editTextDiastolic, "blood_pressure");
        textWatcher(editTextHeight, "textViewBMI");
        textWatcher(editTextWeight, "textViewBMI");
        textWatcher(editTextWaist, "whr");
        textWatcher(editTextHip, "whr");

        return view;
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
                        if (check.matches("blood_pressure")) {
                            checkBP();
                        } else if (check.matches("textViewBMI")) {
                            Common_Functions.BMI(getContext(), editTextHeight, editTextWeight, textViewBMI);
                        } else if (check.matches("whr")) {
                            Common_Functions.WHR(editTextWaist, editTextHip, textViewWaistHipRatio);
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


    public void checkBP() {

        int systolic = 0;
        int diastolic = 0;

        if (editTextSystolic.getText().toString().trim().length() > 0) {
            systolic = Integer.parseInt(editTextSystolic.getText().toString().trim());
        }

        if (editTextDiastolic.getText().toString().trim().length() > 0) {
            diastolic = Integer.parseInt(editTextDiastolic.getText().toString().trim());
        }

        if (diastolic > 0 && systolic > 0) {

            Log.d("Values BP", systolic + "/" + diastolic);
            if ((systolic > 89 && systolic < 129)
                    && (diastolic > 59 && diastolic < 84)) {
                Alerts.alert_msg(getContext(), "Blood Pressure ", "Normal BP");
            } else if ((diastolic > 84 && diastolic < 89)
                    && (systolic > 129 && systolic < 139)) {
                Alerts.alert_msg(getContext(), "Blood Pressure ", "High Normal BP");
            } else if ((diastolic > 89 && diastolic < 99)
                    && (systolic > 139 && systolic < 159)) {
                Alerts.alert_msg(getContext(), "Blood Pressure ", "Mild Hypertention");
            } else if ((diastolic > 99 && diastolic < 109)
                    && (systolic > 159 && systolic < 179)) {
                Alerts.alert_msg(getContext(), "Blood Pressure ", "Moderate Hypertention");
            } else if ((diastolic > 109 && diastolic < 1000)
                    && (systolic > 179 && systolic < 1000)) {
                Alerts.alert_msg(getContext(), "Blood Pressure ", "Severe Hypertention");
            }
        }

    }


    public void checkBox(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();

                //Check which checkbox was clicked
                switch (checkBox.getId()) {
                    case R.id.checkbox_foot_exam:
                        if (checked) {
                            foot_exam = "165099";
                        } else {
                            foot_exam = "";
                        }
                        break;
                    case R.id.checkbox_eye_exam:
                        if (checked) {
                            eye_exam = "165100";
                        } else {
                            eye_exam = "";
                        }
                        break;
                    case R.id.checkbox_dental_exam:
                        if (checked) {
                            dental_exam = "165101";
                        } else {
                            dental_exam = "";
                        }
                        break;
                    case R.id.checkbox_eye_check_up:
                        if (checked) {
                            eye_checkup = "165102";
                        } else {
                            eye_checkup = "";
                        }
                        break;
                    case R.id.checkbox_cardiovascular_disease:
                        if (checked) {
                            cardiovascular_disease = "137593";
                        } else {
                            cardiovascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_high_BP:
                        if (checked) {
                            cardiovascular_disease = "137593";
                        } else {
                            cardiovascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_high_cholestrol:
                        if (checked) {
                            cardiovascular_disease = "137593";
                        } else {
                            cardiovascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_peripheral_vascular_disease:
                        if (checked) {
                            cardiovascular_disease = "137593";
                        } else {
                            cardiovascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_peripheral_neuropathy:
                        if (checked) {
                            cardiovascular_disease = "137593";
                        } else {
                            cardiovascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_retinopathy:
                        if (checked) {
                            cardiovascular_disease = "137593";
                        } else {
                            cardiovascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_kidney_disease:
                        if (checked) {
                            cardiovascular_disease = "137593";
                        } else {
                            cardiovascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_asthma_COPD:
                        if (checked) {
                            cardiovascular_disease = "137593";
                        } else {
                            cardiovascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_arthritis:
                        if (checked) {
                            cardiovascular_disease = "137593";
                        } else {
                            cardiovascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_assesment_other:
                        if (checked) {
                            cardiovascular_disease = "137593";
                        } else {
                            cardiovascular_disease = "";
                        }
                        break;

                }

                updateValues();

            }
        });
    }

    public void updateValues() {

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String current_date = dateFormat.format(new Date());

        JSONObject jsonObs = new JSONObject();
        try {
            jsonObs.put("0301", JSONFormBuilder.observations("5090", editTextHeight.getText().toString().trim(), current_date, ""));
            jsonObs.put("0302", JSONFormBuilder.observations("5089", editTextWeight.getText().toString().trim(), current_date, ""));
            jsonObs.put("0303", JSONFormBuilder.observations("5085", editTextSystolic.getText().toString().trim(), current_date, ""));
            jsonObs.put("0304", JSONFormBuilder.observations("5086", editTextDiastolic.getText().toString().trim(), current_date, ""));
            jsonObs.put("0305", JSONFormBuilder.observations("163081", editTextHip.getText().toString().trim(), current_date, ""));
            jsonObs.put("0306", JSONFormBuilder.observations("163080", editTextWaist.getText().toString().trim(), current_date, ""));
            jsonObs.put("0307", JSONFormBuilder.observations("165190", editTextNutrition.getText().toString().trim(), current_date, ""));

            jsonObs.put("0308", JSONFormBuilder.observations("1391", editTextDiastolic.getText().toString().trim(), current_date, ""));
            jsonObs.put("0309", JSONFormBuilder.observations("1391", editTextHip.getText().toString().trim(), current_date, ""));
            jsonObs.put("0310", JSONFormBuilder.observations("1391", editTextWaist.getText().toString().trim(), current_date, ""));
            jsonObs.put("0311", JSONFormBuilder.observations("1391", editTextNutrition.getText().toString().trim(), current_date, ""));

            //jsonObservation.put("obs",jsonObs);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("JSON FollowUp Page 3", jsonObs.toString() + " ");

        FragmentModelFollowUp.getInstance().followUpThree(jsonObs);
    }

}
