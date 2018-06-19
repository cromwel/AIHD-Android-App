package org.aihdint.aihd.fragments.dm_initial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.aihdint.aihd.R;
import org.aihdint.aihd.app.Alerts;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Initial_page_3 extends Fragment {

    private EditText editTextRBS, editTextFBC, editTextHBA, editTextUrea, editTextSodium, editTextChloride, editTextPotassium, editTextCreatinine, editTextHDL, editTextLDL, editTextCholesterol,
            editTextTriglcerides, editTextAST, editTextALT, editTextTotalBilirubin, editTextDirectBilirubin, editTextGamma;

    private EditText editTextRBSDate, editTextFBCDate, editTextHBADate, editTextUreaDate, editTextSodiumDate, editTextChlorideDate, editTextPotassiumDate, editTextCreatinineDate,
            editTextHDLDate, editTextLDLDate, editTextCholesterolDate, editTextTriglceridesDate, editTextASTDate, editTextALTDate, editTextTotalBilirubinDate,
            editTextDirectBilirubinDate, editTextGammaDate;

    private RadioGroup radioGroupGlucose, radioGroupProtein, radioGroupKetone;
    private RadioButton radioButtonGlucoseYes, radioButtonGlucoseNo, radioButtonGlucose1, radioButtonGlucose2, radioButtonGlucose3,
            radioButtonProteinYes, radioButtonProteinNo, radioButtonProtein1, radioButtonProtein2, radioButtonProtein3,
            radioButtonKetoneYes, radioButtonKetoneNo, radioButtonKetone1, radioButtonKetone2, radioButtonKetone3,
            radioButtonECGNormal, radioButtonECGAbnormal, radioButtonCXRNormal, radioButtonCXRAbnormal;

    private String glucose, protein, ketone, ecg, cxr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_3, container, false);

        editTextRBS= view.findViewById(R.id.blood_work_rbs);
        editTextFBC= view.findViewById(R.id.blood_work_fbc);
        editTextHBA= view.findViewById(R.id.blood_work_hba);
        editTextUrea= view.findViewById(R.id.blood_work_urea);
        editTextSodium= view.findViewById(R.id.blood_work_sodium);
        editTextChloride= view.findViewById(R.id.blood_work_chloride);
        editTextPotassium= view.findViewById(R.id.blood_work_potassium);
        editTextCreatinine = view.findViewById(R.id.blood_work_creatinine);
        editTextHDL= view.findViewById(R.id.blood_work_hdl);
        editTextLDL= view.findViewById(R.id.blood_work_ldl);
        editTextCholesterol= view.findViewById(R.id.blood_work_cholesterol);
        editTextTriglcerides= view.findViewById(R.id.blood_work_triglycerides);
        editTextAST= view.findViewById(R.id.blood_work_ast);
        editTextALT= view.findViewById(R.id.blood_work_alt);
        editTextTotalBilirubin= view.findViewById(R.id.blood_work_bilirubin);
        editTextDirectBilirubin= view.findViewById(R.id.blood_work_direct_bilirubin);
        editTextGamma= view.findViewById(R.id.blood_work_gamma);

        editTextRBSDate = view.findViewById(R.id.datetime_rbs);
        editTextFBCDate = view.findViewById(R.id.datetime_fbc);
        editTextHBADate = view.findViewById(R.id.datetime_hba);
        editTextUreaDate = view.findViewById(R.id.datetime_urea);
        editTextSodiumDate = view.findViewById(R.id.datetime_sodium);
        editTextChlorideDate = view.findViewById(R.id.datetime_chloride);
        editTextPotassiumDate = view.findViewById(R.id.datetime_potassium);
        editTextCreatinineDate = view.findViewById(R.id.datetime_creatinine);
        editTextHDLDate = view.findViewById(R.id.datetime_hdl);
        editTextLDLDate = view.findViewById(R.id.datetime_ldl);
        editTextCholesterolDate = view.findViewById(R.id.datetime_cholesterol);
        editTextTriglceridesDate = view.findViewById(R.id.datetime_triglycerides);
        editTextASTDate = view.findViewById(R.id.datetime_ast);
        editTextALTDate = view.findViewById(R.id.datetime_alt);
        editTextTotalBilirubinDate = view.findViewById(R.id.datetime_bilirubin);
        editTextDirectBilirubinDate = view.findViewById(R.id.datetime_direct_bilirubin);
        editTextGammaDate = view.findViewById(R.id.datetime_gamma);

        textWatcher(editTextRBS, "rbs");
        textWatcher(editTextFBC, "fbc");
        textWatcher(editTextHBA, "hba");
        textWatcher(editTextUrea, "urea");
        textWatcher(editTextSodium, "sodium");
        textWatcher(editTextChloride, "chloride");
        textWatcher(editTextPotassium, "potassium");
        textWatcher(editTextCreatinine, "creatinine");
        textWatcher(editTextHDL, "hdl");
        textWatcher(editTextLDL, "ldl");
        textWatcher(editTextCholesterol, "cholesterol");
        textWatcher(editTextTriglcerides, "triglcerides");
        textWatcher(editTextAST, "ast");
        textWatcher(editTextALT, "alt");
        textWatcher(editTextTotalBilirubin, "tbilirubin");
        textWatcher(editTextDirectBilirubin, "dbilirubin");
        textWatcher(editTextGamma, "gamma");

        textWatcher(editTextRBSDate, "");
        textWatcher(editTextFBCDate, "");
        textWatcher(editTextHBADate, "");
        textWatcher(editTextUreaDate, "");
        textWatcher(editTextSodiumDate, "");
        textWatcher(editTextChlorideDate, "");
        textWatcher(editTextPotassiumDate, "");
        textWatcher(editTextCreatinineDate, "");
        textWatcher(editTextHDLDate, "");
        textWatcher(editTextLDLDate, "");
        textWatcher(editTextCholesterolDate, "");
        textWatcher(editTextTriglceridesDate, "");
        textWatcher(editTextASTDate, "");
        textWatcher(editTextALTDate, "");
        textWatcher(editTextTotalBilirubinDate, "");
        textWatcher(editTextDirectBilirubinDate, "");
        textWatcher(editTextGammaDate, "");

        radioGroupGlucose = view.findViewById(R.id.radiogroup_glucose);
        radioGroupProtein = view.findViewById(R.id.radiogroup_protein);
        radioGroupKetone = view.findViewById(R.id.radiogroup_ketone);

        radioButtonGlucoseYes = view.findViewById(R.id.radio_glucose_yes);
        radioButtonGlucoseNo = view.findViewById(R.id.radio_glucose_no);
        radioButtonGlucose1 = view.findViewById(R.id.radio_glucose_plus);
        radioButtonGlucose2 = view.findViewById(R.id.radio_glucose_plus2);
        radioButtonGlucose3 = view.findViewById(R.id.radio_glucose_plus3);
        radioButtonProteinYes = view.findViewById(R.id.radio_protein_yes);
        radioButtonProteinNo = view.findViewById(R.id.radio_protein_no);
        radioButtonProtein1 = view.findViewById(R.id.radio_protein_plus);
        radioButtonProtein2 = view.findViewById(R.id.radio_protein_plus2);
        radioButtonProtein3 = view.findViewById(R.id.radio_protein_plus3);
        radioButtonKetoneYes = view.findViewById(R.id.radio_ketone_yes);
        radioButtonKetoneNo = view.findViewById(R.id.radio_ketone_no);
        radioButtonKetone1 = view.findViewById(R.id.radio_ketone_plus);
        radioButtonKetone2 = view.findViewById(R.id.radio_ketone_plus2);
        radioButtonKetone3 = view.findViewById(R.id.radio_ketone_plus3);
        radioButtonECGNormal = view.findViewById(R.id.radio_ecg_normal);
        radioButtonECGAbnormal = view.findViewById(R.id.radio_ecg_abnormal);
        radioButtonCXRNormal = view.findViewById(R.id.radio_cxr_normal);
        radioButtonCXRAbnormal = view.findViewById(R.id.radio_cxr_abnormal);

        radioButton(radioButtonGlucoseYes);
        radioButton(radioButtonGlucoseNo);
        radioButton(radioButtonGlucose1);
        radioButton(radioButtonGlucose2);
        radioButton(radioButtonGlucose3);
        radioButton(radioButtonProteinYes);
        radioButton(radioButtonProteinNo);
        radioButton(radioButtonProtein1);
        radioButton(radioButtonProtein2);
        radioButton(radioButtonProtein3);
        radioButton(radioButtonKetoneYes);
        radioButton(radioButtonKetoneNo);
        radioButton(radioButtonKetone1);
        radioButton(radioButtonKetone2);
        radioButton(radioButtonKetone3);
        radioButton(radioButtonECGNormal);
        radioButton(radioButtonECGAbnormal);
        radioButton(radioButtonCXRNormal);
        radioButton(radioButtonCXRAbnormal);

        return view;
    }

    public void textWatcher(EditText editText, final String field) {

        editText.addTextChangedListener(new TextWatcher() {

            private Timer timer = new Timer();
            private final long DELAY = 1500; // milliseconds

            @Override
            public void afterTextChanged(final Editable editable) {
                timer.cancel();
                timer = new Timer();

                final Runnable checkRunnable = new Runnable() {
                    public void run() {
                        if (editable.length() > 0) {
                            double value = parseDouble(editable.toString());
                            if (value > 11.1 && field.matches("rbs")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal RBS");
                            }
                            if (value < 7.8 && field.matches("fbc")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal FBS");
                            }
                            if (value > 6.5 && field.matches("hba")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal HBA 1c(%)");
                            }
                            if ((value < 2.7 || value > 8) && field.matches("urea")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Urea");
                            }
                            if ((value < 135 || value > 155) && field.matches("sodium")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Sodium");
                            }
                            if ((value < 98 || value < 108) && field.matches("chloride")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Chloride");
                            }
                            if ((value < 3.5 || value < 5.5) && field.matches("potassium")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Potassium");
                            }
                            if ((value < 0.7 && value > 1.9) && field.matches("ldl")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal HDL");
                            }
                            if (value > 3.4 && field.matches("ldl")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal LDL");
                            }
                            if ((value < 0 || value > 5.7) && field.matches("cholesterol")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Cholesterol");
                            }
                            if ((value < 0 || value > 5.7) && field.matches("triglcerides")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Triglcerides");
                            }
                            if ((value < 0 || value > 42) && field.matches("ast")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal AST");
                            }
                            if ((value < 0 || value > 37) && field.matches("dbilirubin")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal ALT");
                            }
                            if ((value < 1.17 && value > 20.5) && field.matches("tbilirubin")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Total Bilirubin");
                            }
                            if (value > 5.1 && field.matches("dbilirubin")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Direct Bilirubin");
                            }
                            if ((value < 9 || value > 48) && field.matches("gamma")) {
                                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Gamma");
                            }
                        }
                    }
                };

                TimerTask task = new TimerTask() {
                    public void run() {
                        getActivity().runOnUiThread(checkRunnable);
                    }
                };

                timer.schedule(task, DELAY);

                //updateValues();
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

    public void urinalysisGlucose(String status) {
        if (status.matches("1066")) {
            radioGroupGlucose.setVisibility(View.GONE);
        } else {
            radioGroupGlucose.setVisibility(View.VISIBLE);
        }
    }

    public void urinalysisProtein(String status) {
        if (status.matches("1066")) {
            radioGroupProtein.setVisibility(View.GONE);
        } else {
            radioGroupProtein.setVisibility(View.VISIBLE);
        }
    }

    public void urinalysisKetone(String status) {
        if (status.matches("1066")) {
            radioGroupKetone.setVisibility(View.GONE);
        } else {
            radioGroupKetone.setVisibility(View.VISIBLE);
        }
    }

    public void radioButton(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Is the button now checked?
                boolean checked = (buttonView).isChecked();

                // Check which radio button was clicked
                switch (radioButton.getId()) {
                    case R.id.radio_glucose_yes:
                        if (checked)
                            glucose = "1065";
                        urinalysisGlucose(glucose);
                        break;
                    case R.id.radio_glucose_no:
                        if (checked)
                            glucose = "1066";
                        urinalysisGlucose(glucose);
                        break;
                    case R.id.radio_protein_yes:
                        if (checked)
                            protein = "1065";
                        urinalysisProtein(protein);
                        break;
                    case R.id.radio_protein_no:
                        if (checked)
                            protein = "1066";
                        urinalysisProtein(protein);
                        break;
                    case R.id.radio_ketone_yes:
                        if (checked)
                            ketone = "1065";
                        urinalysisKetone(ketone);
                        break;
                    case R.id.radio_ketone_no:
                        if (checked)
                            ketone = "1066";
                        urinalysisKetone(ketone);
                        break;
                }

                //updateValues();
            }
        });

    }
}
