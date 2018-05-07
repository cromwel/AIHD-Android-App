package org.aihdint.aihd.app;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.aihdint.aihd.model.KeyValue;
import org.aihdint.aihd.model.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Rodney on 16/04/2018.
 */

public class SpinnerAll {

    private Context mContext;
    public String location_id,concept_id;
    public SpinnerAll(Context mContext) {
        this.mContext = mContext;
    }

    public void setLocationData(Spinner spinnerLocation) {

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add locations

        List<Location> locations = Location.listAll(Location.class);
        for (Location ln : locations) {
            // adding each child node to HashMap key => value
            keyvalue.add(new KeyValue(ln.getID(), ln.getName()));
        }

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerLocation.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //spinnerLocation.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinnerLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                location_id = value.getId();
                //Toast.makeText(mContext, "ID: "+country.getId()+", Name : "+country.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    public void setDeliveryPoint(Spinner spinner,String spinner_data) {

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add locations

        if (spinner_data.matches("location")){
            // adding each child node to HashMap key => value
            keyvalue.add(new KeyValue("", "Select Location"));
            keyvalue.add(new KeyValue("1", "OutPatient Clinic"));
            keyvalue.add(new KeyValue("2", "Maternity"));
            keyvalue.add(new KeyValue("3", "C.C.C"));
            keyvalue.add(new KeyValue("4", "Inpatient"));
            keyvalue.add(new KeyValue("5", "Family Planning"));
            keyvalue.add(new KeyValue("6", "Casuality"));
        }else if(spinner_data.matches("occupation")){
            // adding each child node to HashMap key => value
            keyvalue.add(new KeyValue("", "Select Occupation"));
            keyvalue.add(new KeyValue("1540", "Employed"));
            keyvalue.add(new KeyValue("165170", "Unemployed"));
            keyvalue.add(new KeyValue("161382", "Self Employed"));
            keyvalue.add(new KeyValue("159465", "Student"));
            keyvalue.add(new KeyValue("5622", "Other"));
        }else if(spinner_data.matches("education")) {
            // adding each child node to HashMap key => value
            keyvalue.add(new KeyValue("", "Selcet Education Level"));
            keyvalue.add(new KeyValue("1714", "Secondary"));
            keyvalue.add(new KeyValue("1713", "Primary"));
            keyvalue.add(new KeyValue("1107", "None"));
            keyvalue.add(new KeyValue("160289", "Pre-School"));
            keyvalue.add(new KeyValue("160293", "Special education"));
            keyvalue.add(new KeyValue("160292", "Tertiary education"));
            keyvalue.add(new KeyValue("159785", "College/university/polytechnic"));
        }

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //spinnerLocation.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                concept_id = value.getId();
                //Toast.makeText(mContext, "ID: "+value.getId()+", Name : "+value.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

}
