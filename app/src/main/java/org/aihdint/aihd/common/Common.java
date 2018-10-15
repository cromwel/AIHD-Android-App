package org.aihdint.aihd.common;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.orm.query.Condition;
import com.orm.query.Select;

import org.aihdint.aihd.R;
import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.model.Concepts;
import org.json.JSONObject;

import java.util.List;
import java.util.Locale;

public class Common {

    public static void checkBP(final View view, final EditText editTextSystolicOne, final EditText editTextDiastolicOne) {

        int systolic_1 = 0;
        int diastolic_1 = 0;

        if (editTextSystolicOne.getText().toString().trim().length() > 0) {
            systolic_1 = Integer.parseInt(editTextSystolicOne.getText().toString().trim());
        }

        if (editTextDiastolicOne != null && editTextDiastolicOne.getText().toString().trim().length() > 0) {
            diastolic_1 = Integer.parseInt(editTextDiastolicOne.getText().toString().trim());
        }

        if (diastolic_1 > 0 && systolic_1 > 0) {

            Log.d("Values BP", systolic_1 + "/" + diastolic_1);
            if ((systolic_1 > 89 && systolic_1 < 129)
                    && (diastolic_1 > 59 && diastolic_1 < 84)) {
                Alerts.errorMessage(view, "Blood Pressure: Normal BP");
            } else if ((diastolic_1 > 84 && diastolic_1 < 89)
                    && (systolic_1 > 129 && systolic_1 < 139)) {
                Alerts.errorMessage(view, "Blood Pressure: High Normal BP");
            } else if ((diastolic_1 > 89 && diastolic_1 < 99)
                    && (systolic_1 > 139 && systolic_1 < 159)) {
                Alerts.errorMessage(view, "Blood Pressure: Mild Hypertention");
            } else if ((diastolic_1 > 99 && diastolic_1 < 109)
                    && (systolic_1 > 159 && systolic_1 < 179)) {
                Alerts.errorMessage(view, "Blood Pressure: Moderate Hypertention");
            } else if ((diastolic_1 > 109 && diastolic_1 < 1000)
                    && (systolic_1 > 179 && systolic_1 < 1000)) {
                Alerts.errorMessage(view, "Blood Pressure: Severe Hypertention");
            }
        }
    }


    public static void whr(final EditText editTextWaist, final EditText editTextHip, final TextView textViewWaistHipRatio) {

        double wst = 0;
        double hp = 0;

        if (editTextWaist.getText().toString().trim().length() > 0) {
            wst = Integer.parseInt(editTextWaist.getText().toString().trim());
        }

        if (editTextHip.getText().toString().trim().length() > 0) {
            hp = Integer.parseInt(editTextHip.getText().toString().trim());
        }

        if (wst > 0 && hp > 0) {
            double whr_value = wst / hp;

            textViewWaistHipRatio.setText(String.format(Locale.US, "%.1f", whr_value));

        }


    }

    public static void bmi(final Context mContext, final EditText editTextHeight, final EditText editTextWeight, final TextView textViewBMI) {

        double hght = 0;
        double wght = 0;
        String category = "";

        if (editTextHeight.getText().toString().trim().length() > 0) {
            hght = Double.parseDouble(editTextHeight.getText().toString().trim());
            hght = hght / 100;
        }

        if (editTextWeight.getText().toString().trim().length() > 0) {
            wght = Double.parseDouble(editTextWeight.getText().toString().trim());
        }

        if (hght > 0 && wght > 0) {
            double textViewBMI_value = wght / (hght * hght);
            if (textViewBMI_value < 18.5) {
                textViewBMI.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
                category = " Underweight";
            } else if (textViewBMI_value > 18.5 && textViewBMI_value < 25) {
                textViewBMI.setTextColor(ContextCompat.getColor(mContext, R.color.green));
                category = " Normal Weight";
            } else if (textViewBMI_value > 25 && textViewBMI_value < 30) {
                textViewBMI.setTextColor(ContextCompat.getColor(mContext, R.color.orange));
                category = " Overweight";
            } else if (textViewBMI_value > 30) {
                textViewBMI.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
                category = " Obese";
            }
            String bmi = String.format(Locale.US, "%.1f", textViewBMI_value) + category;
            textViewBMI.setText(bmi);
        }

    }

    public static void checkTemp(View view, String temp) {
        if (temp.length() != 0) {
            if (Double.parseDouble(temp) < 35 || Double.parseDouble(temp) > 40) {
                Alerts.errorMessage(view, "Kindly confirm if the Temperature entered is correct.");
            } else if (Double.parseDouble(temp) < 36.1) {
                Alerts.errorMessage(view, "Patient has hypothermia.");
            } else if (Double.parseDouble(temp) > 37.1) {
                Alerts.errorMessage(view, "Patient has a Fever.");
            }
        }
    }

    public static void checkPR(View view, String pr) {
        if (pr.length() != 0 && (Double.parseDouble(pr) < 60 || Double.parseDouble(pr) > 100)) {
            Alerts.errorMessage(view, "Kindly confirm if the Pulse Rate entered is correct.");
        }
    }

    public static void monofilament(View view, String value) {
        if ((value.length() != 0) && (Double.parseDouble(value) > 5)) {
            Alerts.errorMessage(view, "Abnormal Monofilament.");
        }
    }

    public static String conceptAnswer(JSONObject concept, String concept_id) {
        String value = "";
        try {
            if (concept.getString("concept_id").equals(concept_id)) {
                List<Concepts> answer = Select.from(Concepts.class)
                        .where(Condition.prop("conceptid").eq(concept.getString("concept_answer")))
                        .limit("1")
                        .list();

                for (Concepts cpts : answer) {
                    // adding each child node to HashMap key => value
                    value = cpts.getConcept_answer();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String concept(JSONObject concept, String concept_id) {
        String value = "";
        try {
            if (concept.getString("concept_id").equals(concept_id)) {
                value = concept.getString("concept_answer");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;

    }


    public static String locationId() {
        String location_id = AppController.getInstance().getSessionManager().getUserDetails().get("location_id");
        location_id = location_id.toLowerCase();
        location_id = location_id.replace(".", "");
        location_id = location_id.replace(" ", "_");

        return location_id;
    }

}
