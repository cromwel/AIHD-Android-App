package org.aihdint.aihd.fragments.dm_initial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import org.aihdint.aihd.Forms.Common_Functions;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.Alerts;

import java.util.Timer;
import java.util.TimerTask;

import customfonts.TextView_Roboto_Bold;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Initial_page_2 extends Fragment implements InitialActivityModel_Two.FragStateChangeListener  {

    private LinearLayout past_current_medication,other_past_current_medication,extremities;
    private EditText  medication_other,adhere_specify,allergy_specify,temp,pulse_rate,systolic_one,diastolic_one,systolic_two,diastolic_two;
    private EditText editTextWaist, editTextHip, editTextHeight, editTextWeight;
    private EditText other_general_exam,cvs,rs,pa,cns;
    private TextView_Roboto_Bold bmi,waist_hip_ratio;

    private EditText monofilament_rf, monofilament_lf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_2, container, false);

        InitialActivityModel_Two.getInstance().setListener(this);

        past_current_medication = view.findViewById(R.id.past_current_medication);
        other_past_current_medication = view.findViewById(R.id.other_past_current_medication);
        medication_other = view.findViewById(R.id.medication_other);
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

        extremities = view.findViewById(R.id.extremities);

        monofilament_rf = view.findViewById(R.id.monofilament_rf);
        monofilament_lf = view.findViewById(R.id.monofilament_lf);

        textWatcher (temp,"temp");
        textWatcher (pulse_rate,"pulse_rate");
        textWatcher (systolic_one,"blood_pressure");
        textWatcher (systolic_two,"blood_pressure");
        textWatcher (diastolic_one,"blood_pressure");
        textWatcher (diastolic_two,"blood_pressure");
        textWatcher(editTextHeight, "bmi");
        textWatcher(editTextWeight, "bmi");
        textWatcher(editTextWaist, "whr");
        textWatcher(editTextHip, "whr");
        textWatcher(monofilament_rf, "monofilament_lf");
        textWatcher(monofilament_lf, "monofilament_rf");


        return view;
    }


    @Override
    public void medicationNone(String status) {
        if (status.matches("1107")) {
            past_current_medication.setVisibility(View.GONE);
        }else {
            past_current_medication.setVisibility(View.VISIBLE);
        }
        Log.d("None",status+" ");
    }

    @Override
    public void medicationOther(String status) {
        if (status.matches("5622")) {
            other_past_current_medication.setVisibility(View.VISIBLE);
        }else {
            other_past_current_medication.setVisibility(View.GONE);
        }
    }

    @Override
    public void extremitiesStatus(String status) {
        if (status.matches("1116")) {
            extremities.setVisibility(View.VISIBLE);
        }else {
            extremities.setVisibility(View.GONE);
        }
    }

    public void textWatcher (EditText editText, final String check){

        editText.addTextChangedListener(new TextWatcher() {

            private Timer timer=new Timer();
            private final long DELAY = 1500; // milliseconds

            @Override
            public void afterTextChanged(final Editable editable) {
                timer.cancel();
                timer = new Timer();

                final Runnable checkRunnable = new Runnable() {
                    public void run() {
                        if(check.matches("temp")) {
                            checkTemp(editable.toString());
                        }else if(check.matches("pulse_rate")) {
                            checkPR(editable.toString());
                        }else if(check.matches("blood_pressure")) {
                            checkBP();
                        }else if(check.matches("bmi")) {
                            Common_Functions.BMI(getContext(), editTextHeight, editTextWeight, bmi);
                        }else if(check.matches("whr")) {
                            Common_Functions.WHR(editTextWaist, editTextHip, waist_hip_ratio);
                        } else if (check.matches("monofilament_lf")) {
                            monofilament(editable.toString());
                        } else if (check.matches("monofilament_rf")) {
                            monofilament(editable.toString());
                        }
                    }
                };

                TimerTask task = new TimerTask(){
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

    public void checkTemp(String temp){
        if(temp.length() != 0) {
            if(Double.parseDouble(temp) <35||Double.parseDouble(temp) >40){
                Alerts.alert_msg(getContext(), "Temperature", "Kindly confirm if the Temperature entered is correct.");
            }else if(Double.parseDouble(temp) <36.1){
                Alerts.alert_msg(getContext(), "Temperature", "Patient has hypothermia.");
            }else if(Double.parseDouble(temp) > 37.1){
                Alerts.alert_msg(getContext(), "Temperature", "Patient has a Fever.");
            }
        }
    }

    public void checkPR(String pr){
        if (pr.length() != 0) {
            if(Double.parseDouble(pr) <60||Double.parseDouble(pr) >100){
                Alerts.alert_msg(getContext(), "Temperature", "Kindly confirm if the Pulse Rate entered is correct.");
            }
        }
    }

    public void monofilament(String value) {
        if (value.length() != 0) {
            if (Double.parseDouble(value) > 5) {
                Alerts.alert_msg(getContext(), "Monofilament", "Abnormal Monofilament");
            }
        }
    }


    public void checkBP(){

        int systolic_1=0;
        int diastolic_1=0;
        int systolic_2=0;
        int diastolic_2=0;

        if(systolic_one.getText().toString().trim().length()>0) {
            systolic_1 = Integer.parseInt(systolic_one.getText().toString().trim());
        }

        if(diastolic_one.getText().toString().trim().length()>0) {
            diastolic_1 = Integer.parseInt(diastolic_one.getText().toString().trim());
        }

        if(systolic_two.getText().toString().trim().length()>0) {
            systolic_2 = Integer.parseInt(systolic_two.getText().toString().trim());
        }

        if(diastolic_two.getText().toString().trim().length()>0) {
            diastolic_2 = Integer.parseInt(diastolic_two.getText().toString().trim());
        }


        if (diastolic_1 > 0 && systolic_1 > 0) {
                int systolic = (systolic_1+systolic_2)/2;
                int diastolic = (diastolic_1+diastolic_2)/2;

                Log.d("Values BP",systolic+"/"+diastolic);
                if((systolic > 89 && systolic < 129 )
                        &&( diastolic > 59 && diastolic < 84)){
                    Alerts.alert_msg(getContext(), "Blood Pressure ", "Normal BP");
                }else if((diastolic >84 && diastolic < 89 )
                        &&(systolic > 129 && systolic <139 )){
                    Alerts.alert_msg(getContext(), "Blood Pressure ", "High Normal BP");
                }else if((diastolic > 89 && diastolic <99 )
                        &&(systolic > 139 && systolic <159 )){
                    Alerts.alert_msg(getContext(), "Blood Pressure ", "Mild Hypertention");
                }else if((diastolic > 99 && diastolic <109 )
                        &&(systolic > 159 && systolic <179 )){
                    Alerts.alert_msg(getContext(), "Blood Pressure ", "Moderate Hypertention");
                }else if((diastolic > 109 && diastolic <1000 )
                        &&(systolic > 179 && systolic <1000 )){
                    Alerts.alert_msg(getContext(), "Blood Pressure ", "Severe Hypertention");
                }
            }

    }
}
