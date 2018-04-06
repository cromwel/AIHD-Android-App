package org.aihdint.aihd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import org.aihdint.aihd.R;
import org.aihdint.aihd.app.NavigationDrawerShare;
import org.aihdint.aihd.model.KeyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created : dennis on 3/23/18.
 */

public class DM_FollowUp extends AppCompatActivity {

    private Spinner spinnerLocation;
    private Spinner spinnerLocation1;
    private Spinner spinnerLocation2;
    private Spinner spinnerLocation3;
    private Spinner spinnerLocation4;
    private Spinner spinnerLocation5;
    private Spinner spinnerLocation6;
    private Spinner spinnerLocation7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_follow_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.CreateDrawer(toolbar);

        setLocationData();
    }

//Choose a provider
    private void setLocationData() {

        spinnerLocation = findViewById(R.id.spinnerLocation);

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add countries

        keyvalue.add(new KeyValue("1", "India"));
        keyvalue.add(new KeyValue("2", "USA"));
        keyvalue.add(new KeyValue("3", "China"));
        keyvalue.add(new KeyValue("4", "UK"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerLocation.setAdapter(adapter);
        //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

        spinnerLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue country = (KeyValue) parent.getSelectedItem();
                Toast.makeText(getApplicationContext(), "Country ID: "+country.getId()+",  Country Name : "+country.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

//Choose a drug
    //Drug 1
private void setLocation1Data() {

    spinnerLocation1 = findViewById(R.id.spinnerLocation1);

    ArrayList<KeyValue> keyvalue = new ArrayList<>();
    //Add countries

    keyvalue.add(new KeyValue("1", "India"));
    keyvalue.add(new KeyValue("2", "USA"));
    keyvalue.add(new KeyValue("3", "China"));
    keyvalue.add(new KeyValue("4", "UK"));

    //fill data in spinner
    ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
    spinnerLocation1.setAdapter(adapter);
    //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

    spinnerLocation1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            KeyValue country = (KeyValue) parent.getSelectedItem();
            Toast.makeText(getApplicationContext(), "Country ID: "+country.getId()+",  Country Name : "+country.getName(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    });
}
    //Drug 2
    private void setLocation2Data() {

        spinnerLocation2 = findViewById(R.id.spinnerLocation2);

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add countries

        keyvalue.add(new KeyValue("1", "India"));
        keyvalue.add(new KeyValue("2", "USA"));
        keyvalue.add(new KeyValue("3", "China"));
        keyvalue.add(new KeyValue("4", "UK"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerLocation2.setAdapter(adapter);
        //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

        spinnerLocation2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue country = (KeyValue) parent.getSelectedItem();
                Toast.makeText(getApplicationContext(), "Country ID: "+country.getId()+",  Country Name : "+country.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

        //Drug 3
        private void setLocation3Data() {

            spinnerLocation3 = findViewById(R.id.spinnerLocation3);

            ArrayList<KeyValue> keyvalue = new ArrayList<>();
            //Add countries

            keyvalue.add(new KeyValue("1", "India"));
            keyvalue.add(new KeyValue("2", "USA"));
            keyvalue.add(new KeyValue("3", "China"));
            keyvalue.add(new KeyValue("4", "UK"));

            //fill data in spinner
            ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
            spinnerLocation3.setAdapter(adapter);
            //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

            spinnerLocation3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    KeyValue country = (KeyValue) parent.getSelectedItem();
                    Toast.makeText(getApplicationContext(), "Country ID: "+country.getId()+",  Country Name : "+country.getName(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }

    //Drug 4
    private void setLocation4Data() {

        spinnerLocation4 = findViewById(R.id.spinnerLocation4);

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add countries

        keyvalue.add(new KeyValue("1", "India"));
        keyvalue.add(new KeyValue("2", "USA"));
        keyvalue.add(new KeyValue("3", "China"));
        keyvalue.add(new KeyValue("4", "UK"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerLocation4.setAdapter(adapter);
        //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

        spinnerLocation4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue country = (KeyValue) parent.getSelectedItem();
                Toast.makeText(getApplicationContext(), "Country ID: "+country.getId()+",  Country Name : "+country.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    //Drug 5
    private void setLocation5Data() {

        spinnerLocation5 = findViewById(R.id.spinnerLocation5);

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add countries

        keyvalue.add(new KeyValue("1", "India"));
        keyvalue.add(new KeyValue("2", "USA"));
        keyvalue.add(new KeyValue("3", "China"));
        keyvalue.add(new KeyValue("4", "UK"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerLocation5.setAdapter(adapter);
        //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

        spinnerLocation5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue country = (KeyValue) parent.getSelectedItem();
                Toast.makeText(getApplicationContext(), "Country ID: "+country.getId()+",  Country Name : "+country.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    //Drug 6
    private void setLocation6Data() {

        spinnerLocation6 = findViewById(R.id.spinnerLocation6);

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add countries

        keyvalue.add(new KeyValue("1", "India"));
        keyvalue.add(new KeyValue("2", "USA"));
        keyvalue.add(new KeyValue("3", "China"));
        keyvalue.add(new KeyValue("4", "UK"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerLocation6.setAdapter(adapter);
        //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

        spinnerLocation6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue country = (KeyValue) parent.getSelectedItem();
                Toast.makeText(getApplicationContext(), "Country ID: "+country.getId()+",  Country Name : "+country.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    //Drug 7
    private void setLocation7Data() {

        spinnerLocation7 = findViewById(R.id.spinnerLocation7);

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add countries

        keyvalue.add(new KeyValue("1", "India"));
        keyvalue.add(new KeyValue("2", "USA"));
        keyvalue.add(new KeyValue("3", "China"));
        keyvalue.add(new KeyValue("4", "UK"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerLocation7.setAdapter(adapter);
        //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

        spinnerLocation7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue country = (KeyValue) parent.getSelectedItem();
                Toast.makeText(getApplicationContext(), "Country ID: "+country.getId()+",  Country Name : "+country.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_male:
                if (checked)
                    //gender = "Male";
                    break;
            case R.id.radio_female:
                if (checked)
                    //gender = "Female";
                    break;
            case R.id.radio_yes:
                if (checked)
                    //isEstimated = "1";
                    break;
            case R.id.radio_no:
                if (checked)
                    //isEstimated = "0";
                    break;
        }
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked
        boolean checked = ((CheckBox) view).isChecked();

        /*Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_complaint_blurr_vision:
                if (checked){

                }else{

                }
                break;
               case R.id.checkbox_complaint_blurr_vision:
                if (checked){

                }else{

                }
                break;
        */
            // TODO: Chief Complaints

    }



}
