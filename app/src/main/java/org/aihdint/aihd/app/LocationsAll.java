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

public class LocationsAll {

    private Context mContext;
    public String location_id;
    public LocationsAll(Context mContext) {
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

                KeyValue country = (KeyValue) parent.getSelectedItem();
                location_id = country.getId();
                //Toast.makeText(mContext, "ID: "+country.getId()+", Name : "+country.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
