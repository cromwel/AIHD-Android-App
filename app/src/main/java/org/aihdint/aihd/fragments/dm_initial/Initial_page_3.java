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

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Initial_page_3 extends Fragment implements InitialActivityModel_Three.FragStateChangeListener {

    private EditText editTextRBS;
    private RadioGroup radioGroupGlucose, radioGroupProtein, radioGroupKetone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_3, container, false);

        InitialActivityModel_Three.getInstance().setListener(this);

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
