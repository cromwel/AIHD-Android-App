package org.aihdint.aihd.fragments.dm_initial;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.aihdint.aihd.R;

public class Initial_page_view_1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_view_1, container, false);

        TextView textViewEncounterDate = view.findViewById(R.id.dm_initial_date);


        return view;
    }
}
