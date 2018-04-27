package org.aihdint.aihd.fragments.dm_followup;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.aihdint.aihd.R;
import org.aihdint.aihd.model.KeyValue;

import java.util.ArrayList;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_4 extends Fragment {

    private Spinner spinnerDrug1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_followup_fragment_4, container, false);

        spinnerDrug1 = view.findViewById(R.id.spinnerDrug1);

        return view;
    }

    //Choose a drug
    //Drug 1
    private void setLocation1Data(Spinner spinnerDrug) {

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add countries

        keyvalue.add(new KeyValue("1", "India"));
        keyvalue.add(new KeyValue("2", "USA"));
        keyvalue.add(new KeyValue("3", "China"));
        keyvalue.add(new KeyValue("4", "UK"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerDrug.setAdapter(adapter);
        //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

        spinnerDrug.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue country = (KeyValue) parent.getSelectedItem();
                Toast.makeText(getContext(), "Country ID: "+country.getId()+",  Country Name : "+country.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
