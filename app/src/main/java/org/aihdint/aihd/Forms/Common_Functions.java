package org.aihdint.aihd.Forms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import org.aihdint.aihd.R;
import org.aihdint.aihd.fragments.dm_followup.FollowUpActivityModel_Four;

public class Common_Functions {

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public static void WHR(EditText editTextWaist, EditText editTextHip, TextView textViewWaistHipRatio) {
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

            textViewWaistHipRatio.setText(String.format("%.1f", whr_value));

        }

    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public static void BMI(Context mContext, EditText editTextHeight, EditText editTextWeight, TextView textViewBMI) {

        double hght = 0;
        double wght = 0;
        String category = "";

        if (editTextHeight.getText().toString().trim().length() > 0) {
            hght = Integer.parseInt(editTextHeight.getText().toString().trim());
            hght = hght / 100;
        }

        if (editTextWeight.getText().toString().trim().length() > 0) {
            wght = Integer.parseInt(editTextWeight.getText().toString().trim());
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
            textViewBMI.setText(String.format("%.1f", textViewBMI_value) + category);

        }

    }


}
