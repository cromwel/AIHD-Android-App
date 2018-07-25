package org.aihdint.aihd.fragments.dm_initial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.aihdint.aihd.Forms.DM_Initial_View;
import org.aihdint.aihd.Forms.JSONFormBuilder;
import org.aihdint.aihd.R;

import static android.content.Intent.getIntent;

public class Initial_page_view_1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_view_1, container, false);

        //TextView textViewEncounterDate = view.findViewById(R.id.dm_initial_date);

        Intent intent = getActivity().getIntent();
        //report_id = intent.getStringExtra("report_id");
        String file_name = intent.getStringExtra("file_name");

        Log.d("Form Data", JSONFormBuilder.loadForm(getContext(), "initial", file_name) + "");
        DM_Initial_View.viewForm(JSONFormBuilder.loadForm(getContext(), "initial", file_name));

        return view;
    }
}
