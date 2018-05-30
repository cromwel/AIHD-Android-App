package org.aihdint.aihd.fragments.dm_initial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

public class Initial_page_3 extends Fragment implements InitialActivityModel_Three.FragStateChangeListener {

    private EditText editTextRBS,editTextFBC,editTextHBA,editTextUrea,editTextSodium,editTextChloride,editTextPotassium,
            editTextHDL,editTextLDL,editTextCholesterol,editTextTriglcerides,
            editTextAST,editTextALT,editTextTotalBilirubin,editTextDirectBilirubin,editTextGamma;
    private RadioGroup radioGroupGlucose, radioGroupProtein, radioGroupKetone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_3, container, false);

        InitialActivityModel_Three.getInstance().setListener(this);

        editTextRBS= view.findViewById(R.id.blood_work_rbs);
        editTextFBC= view.findViewById(R.id.blood_work_fbc);
        editTextHBA= view.findViewById(R.id.blood_work_hba);
        editTextUrea= view.findViewById(R.id.blood_work_urea);
        editTextSodium= view.findViewById(R.id.blood_work_sodium);
        editTextChloride= view.findViewById(R.id.blood_work_chloride);
        editTextPotassium= view.findViewById(R.id.blood_work_potassium);
        editTextHDL= view.findViewById(R.id.blood_work_hdl);
        editTextLDL= view.findViewById(R.id.blood_work_ldl);
        editTextCholesterol= view.findViewById(R.id.blood_work_cholesterol);
        editTextTriglcerides= view.findViewById(R.id.blood_work_triglycerides);
        editTextAST= view.findViewById(R.id.blood_work_ast);
        editTextALT= view.findViewById(R.id.blood_work_alt);
        editTextTotalBilirubin= view.findViewById(R.id.blood_work_bilirubin);
        editTextDirectBilirubin= view.findViewById(R.id.blood_work_direct_bilirubin);
        editTextGamma= view.findViewById(R.id.blood_work_gamma);

        textWatcher(editTextRBS, "rbs");
        textWatcher(editTextFBC, "fbc");
        textWatcher(editTextHBA, "hba");
        textWatcher(editTextUrea, "urea");
        textWatcher(editTextSodium, "sodium");
        textWatcher(editTextChloride, "chloride");
        textWatcher(editTextPotassium, "potassium");
        textWatcher(editTextHDL, "hdl");
        textWatcher(editTextLDL, "ldl");
        textWatcher(editTextCholesterol, "cholesterol");
        textWatcher(editTextTriglcerides, "triglcerides");
        textWatcher(editTextAST, "ast");
        textWatcher(editTextALT, "alt");
        textWatcher(editTextTotalBilirubin, "tbilirubin");
        textWatcher(editTextDirectBilirubin, "dbilirubin");
        textWatcher(editTextGamma, "gamma");

        radioGroupGlucose = view.findViewById(R.id.radiogroup_glucose);
        radioGroupProtein = view.findViewById(R.id.radiogroup_protein);
        radioGroupKetone = view.findViewById(R.id.radiogroup_ketone);

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

    @Override
    public void urinalysisGlucose(String status) {
        if (status.matches("1066")) {
            radioGroupGlucose.setVisibility(View.GONE);
        } else {
            radioGroupGlucose.setVisibility(View.VISIBLE);
        }
        Log.d("Radio G", status + " ");
    }

    @Override
    public void urinalysisProtein(String status) {
        if (status.matches("1066")) {
            radioGroupProtein.setVisibility(View.GONE);
        } else {
            radioGroupProtein.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void urinalysisKetone(String status) {
        if (status.matches("1066")) {
            radioGroupKetone.setVisibility(View.GONE);
        } else {
            radioGroupKetone.setVisibility(View.VISIBLE);
        }
    }
}
