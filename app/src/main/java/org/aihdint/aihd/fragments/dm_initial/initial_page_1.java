package org.aihdint.aihd.fragments.dm_initial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.aihdint.aihd.R;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class initial_page_1 extends Fragment {

    String urination;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_followup_fragment_2, container, false);

        EditText frequentUrinationDateEditText = view.findViewById(R.id.frequent_urinations_date);

        return view;
    }


}
