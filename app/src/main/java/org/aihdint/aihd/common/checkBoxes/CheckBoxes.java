package org.aihdint.aihd.common.checkBoxes;

import android.widget.CheckBox;
import android.widget.CompoundButton;

import org.aihdint.aihd.R;

public class CheckBoxes {

    private static String value = "";
    private static checkBoxInterface checkBoxEvent;

    public static void checkBoxTreatment(final CheckBox checkBox, checkBoxInterface event) {
        checkBoxEvent = event;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();

                //Check which checkbox was clicked
                switch (checkBox.getId()) {
                    case R.id.treatment_metformin:
                        if (checked) {
                            value = "79651";
                        }
                        break;
                    case R.id.treatment_glibenclamide:
                        if (checked) {
                            value = "77071";
                        }
                        break;
                    case R.id.treatment_insulin:
                        if (checked) {
                            value = "159459";
                        }
                        break;
                    case R.id.treatment_soluble_insulin:
                        if (checked) {
                            value = "282";
                        }
                        break;
                    case R.id.treatment_nph:
                        if (checked) {
                            value = "165284";
                        }
                        break;
                    case R.id.treatment_nph_2:
                        if (checked) {
                            value = "165287";
                        }
                        break;
                    case R.id.treatment_captopril:
                        if (checked) {
                            value = "72806";
                        }
                        break;
                    case R.id.treatment_enalapril:
                        if (checked) {
                            value = "75633";
                        }
                        break;
                    case R.id.treatment_lisinopril:
                        if (checked) {
                            value = "78945";
                        }
                        break;
                    case R.id.treatment_perindopril:
                        if (checked) {
                            value = "81822";
                        }
                        break;
                    case R.id.treatment_ramipril:
                        if (checked) {
                            value = "83067";
                        }
                        break;
                    case R.id.treatment_candesartan:
                        if (checked) {
                            value = "72758";
                        }
                        break;
                    case R.id.treatment_irbesartan:
                        if (checked) {
                            value = "78210";
                        }
                        break;
                    case R.id.treatment_losartan:
                        if (checked) {
                            value = "79074";
                        }
                        break;
                    case R.id.treatment_telmisartan:
                        if (checked) {
                            value = "84764";
                        }
                        break;
                    case R.id.treatment_valsartan:
                        if (checked) {
                            value = "86056";
                        }
                        break;
                    case R.id.treatment_olmesartan:
                        if (checked) {
                            value = "165229";
                        }
                        break;
                    case R.id.treatment_atenolol:
                        if (checked) {
                            value = "71652";
                        }
                        break;
                    case R.id.treatment_labetolol:
                        if (checked) {
                            value = "78599";
                        }
                        break;
                    case R.id.treatment_propranolol:
                        if (checked) {
                            value = "82732";
                        }
                        break;
                    case R.id.treatment_carvedilol:
                        if (checked) {
                            value = "72944";
                        }
                        break;
                    case R.id.treatment_nebivolol:
                        if (checked) {
                            value = "80470";
                        }
                        break;
                    case R.id.treatment_metoprolol:
                        if (checked) {
                            value = "79764";
                        }
                        break;
                    case R.id.treatment_bisoprolol:
                        if (checked) {
                            value = "72247";
                        }
                        break;
                    case R.id.treatment_amlodipine:
                        if (checked) {
                            value = "71137";
                        }
                        break;
                    case R.id.treatment_felodipine:
                        if (checked) {
                            value = "76211";
                        }
                        break;
                    case R.id.treatment_nifedipine:
                        if (checked) {
                            value = "80637";
                        }
                        break;
                    case R.id.treatment_methyldopa:
                        if (checked) {
                            value = "79723";
                        }
                        break;
                    case R.id.treatment_hydralazine:
                        if (checked) {
                            value = "77675";
                        }
                        break;
                    case R.id.treatment_prazocin:
                        if (checked) {
                            value = "77985";
                        }
                        break;
                    case R.id.treatment_chlorthalidone:
                        if (checked) {
                            value = "73338";
                        }
                        break;
                    case R.id.treatment_hydrochlorothia:
                        if (checked) {
                            value = "77696";
                        }
                        break;
                    case R.id.treatment_indapamide:
                        if (checked) {
                            value = "77985";
                        }
                        break;

                    case R.id.treatment_diet:
                        if (checked) {
                            value = "165200";
                        }
                        break;
                    case R.id.treatment_physical_exercise:
                        if (checked) {
                            value = "159364";
                        }
                        break;
                    case R.id.treatment_herbal:
                        if (checked) {
                            value = "165203";
                        }
                        break;
                    case R.id.treatment_other:
                        if (checked) {
                            value = "5622";
                        }
                        break;
                    case R.id.followup_continue:
                        if (checked) {
                            value = "165132";
                        }
                        break;
                    case R.id.treatment_urinalysis:
                        if (checked) {
                            value = "302";
                        }
                        break;
                    case R.id.treatment_hba:
                        if (checked) {
                            value = "159644";
                        }
                        break;
                    case R.id.treatment_microalbumin:
                        if (checked) {
                            value = "164938";
                        }
                        break;
                    case R.id.treatment_creatinine:
                        if (checked) {
                            value = "1011";
                        }
                        break;
                    case R.id.treatment_potassium:
                        if (checked) {
                            value = "159659";
                        }
                        break;
                    case R.id.treatment_ecg:
                        if (checked) {
                            value = "161157";
                        }
                        break;
                    case R.id.treatment_followup_other:
                        if (checked) {
                            value = "5622";
                        }
                        break;
                    default:
                        break;
                }

                checkBoxEvent.checkBoxClick(value, checkBox);
            }
        });

    }


}
