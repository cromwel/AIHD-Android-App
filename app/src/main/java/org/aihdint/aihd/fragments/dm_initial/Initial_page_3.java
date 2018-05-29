package org.aihdint.aihd.fragments.dm_initial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import org.aihdint.aihd.R;
import org.aihdint.aihd.app.Alerts;

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

        try {
            if (parseInt(editTextRBS.getText().toString()) > 11.1) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal RBS");
            }
            if (parseInt(editTextFBC.getText().toString()) < 7.8) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal FBC");
            }
            if (parseInt(editTextHBA.getText().toString()) > 6.5) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal HBA 1c(%)");
            }
            if (parseInt(editTextUrea.getText().toString()) < 2.7 && parseInt(editTextUrea.getText().toString()) > 8) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Urea");
            }
            if (parseInt(editTextSodium.getText().toString()) < 135 && parseInt(editTextSodium.getText().toString()) > 155) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Sodium");
            }
            if (parseInt(editTextChloride.getText().toString()) < 98 && parseInt(editTextChloride.getText().toString()) < 108) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Chloride");
            }
            if (parseInt(editTextPotassium.getText().toString()) < 3.5 && parseInt(editTextPotassium.getText().toString()) < 5.5) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Potassium");
            }
            if (parseInt(editTextHDL.getText().toString()) < 0.7 && parseInt(editTextHDL.getText().toString()) > 1.9) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal HDL");
            }
            if (parseInt(editTextLDL.getText().toString()) > 3.4) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal LDL");
            }
            if (parseInt(editTextCholesterol.getText().toString()) < 0 && parseInt(editTextCholesterol.getText().toString()) > 5.7) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Cholesterol");
            }
            if (parseInt(editTextTriglcerides.getText().toString()) < 0 && parseInt(editTextTriglcerides.getText().toString()) > 5.7) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Triglcerides");
            }
            if (parseInt(editTextAST.getText().toString()) < 0 && parseInt(editTextAST.getText().toString()) > 42) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal AST");
            }
            if (parseInt(editTextALT.getText().toString()) < 0 && parseInt(editTextALT.getText().toString()) > 37) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal ALT");
            }
            if (parseInt(editTextTotalBilirubin.getText().toString()) < 1.17 && parseInt(editTextTotalBilirubin.getText().toString()) > 20.5) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Total Bilirubin");
            }
            if (parseInt(editTextDirectBilirubin.getText().toString()) > 5.1) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Direct Bilirubin");
            }
            if (parseInt(editTextGamma.getText().toString()) < 9 && parseInt(editTextGamma.getText().toString()) > 48) {
                Alerts.alert_msg(getContext(), "Investigation Alert", "Abnormal Gamma");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        radioGroupGlucose = view.findViewById(R.id.radiogroup_glucose);
        radioGroupProtein = view.findViewById(R.id.radiogroup_protein);
        radioGroupKetone = view.findViewById(R.id.radiogroup_ketone);

        return view;
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
