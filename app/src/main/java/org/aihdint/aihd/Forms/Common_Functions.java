package org.aihdint.aihd.Forms;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;


import org.aihdint.aihd.R;

public class Common_Functions {


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

    public String checkBoxTreatment(final CheckBox checkBox) {

        final String[] value = {""};
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();

                //Check which checkbox was clicked
                switch (checkBox.getId()) {
                    case R.id.treatment_metformin:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_glibenclamide:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_insulin:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_soluble_insulin:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_nph:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_enalapril:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_captopril:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_lisinopril:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_perindopril:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_ramipril:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_candesartan:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_irbesartan:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_losartan:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_telmisartan:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_valsartan:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_olmesartan:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_atenolol:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_labetolol:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_propranolol:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_carvedilol:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_nebivolol:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_metoprolol:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_bisoprolol:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_amlodipine:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_felodipine:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_nifedipine:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_methyldopa:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_hydralazine:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_prazocin:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_chlorthalidone:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_hydrochlorothia:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_indapamide:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_diet:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_physical_exercise:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_herbal:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                    case R.id.treatment_other:
                        if (checked) {
                            value[0] = "165099";
                        } else {
                            value[0] = "";
                        }
                        break;
                }
            }
        });

        return value[0];
    }

}
