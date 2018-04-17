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

    private Spinner spinnerProvider;
    private Spinner spinnerDrug1;
    private Spinner spinnerDrug2;
    private Spinner spinnerDrug3;
    private Spinner spinnerDrug4;
    private Spinner spinnerDrug5;
    private Spinner spinnerDrug6;
    private Spinner spinnerDrug7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_follow_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.CreateDrawer(toolbar);

        setProviderData();
    }

//Choose a provider
    private void setProviderData() {

        spinnerProvider = findViewById(R.id.spinnerProvider);

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add countries

        keyvalue.add(new KeyValue("1", "India"));
        keyvalue.add(new KeyValue("2", "USA"));
        keyvalue.add(new KeyValue("3", "China"));
        keyvalue.add(new KeyValue("4", "UK"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerProvider.setAdapter(adapter);
        //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

        spinnerProvider.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

    spinnerDrug1 = findViewById(R.id.spinnerDrug1);

    ArrayList<KeyValue> keyvalue = new ArrayList<>();
    //Add countries

    keyvalue.add(new KeyValue("1", "India"));
    keyvalue.add(new KeyValue("2", "USA"));
    keyvalue.add(new KeyValue("3", "China"));
    keyvalue.add(new KeyValue("4", "UK"));

    //fill data in spinner
    ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
    spinnerDrug1.setAdapter(adapter);
    //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

    spinnerDrug1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        spinnerDrug2 = findViewById(R.id.spinnerDrug2);

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add countries

        keyvalue.add(new KeyValue("1", "India"));
        keyvalue.add(new KeyValue("2", "USA"));
        keyvalue.add(new KeyValue("3", "China"));
        keyvalue.add(new KeyValue("4", "UK"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerDrug2.setAdapter(adapter);
        //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

        spinnerDrug2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

            spinnerDrug3 = findViewById(R.id.spinnerDrug3);

            ArrayList<KeyValue> keyvalue = new ArrayList<>();
            //Add countries

            keyvalue.add(new KeyValue("1", "India"));
            keyvalue.add(new KeyValue("2", "USA"));
            keyvalue.add(new KeyValue("3", "China"));
            keyvalue.add(new KeyValue("4", "UK"));

            //fill data in spinner
            ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
            spinnerDrug3.setAdapter(adapter);
            //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

            spinnerDrug3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        spinnerDrug4 = findViewById(R.id.spinnerDrug4);

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add countries

        keyvalue.add(new KeyValue("1", "India"));
        keyvalue.add(new KeyValue("2", "USA"));
        keyvalue.add(new KeyValue("3", "China"));
        keyvalue.add(new KeyValue("4", "UK"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerDrug4.setAdapter(adapter);
        //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

        spinnerDrug4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        spinnerDrug5 = findViewById(R.id.spinnerDrug5);

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add countries

        keyvalue.add(new KeyValue("1", "India"));
        keyvalue.add(new KeyValue("2", "USA"));
        keyvalue.add(new KeyValue("3", "China"));
        keyvalue.add(new KeyValue("4", "UK"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerDrug5.setAdapter(adapter);
        //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

        spinnerDrug5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        spinnerDrug6 = findViewById(R.id.spinnerDrug6);

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add countries

        keyvalue.add(new KeyValue("1", "India"));
        keyvalue.add(new KeyValue("2", "USA"));
        keyvalue.add(new KeyValue("3", "China"));
        keyvalue.add(new KeyValue("4", "UK"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerDrug6.setAdapter(adapter);
        //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

        spinnerDrug6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        spinnerDrug7 = findViewById(R.id.spinnerDrug7);

        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        //Add countries

        keyvalue.add(new KeyValue("1", "India"));
        keyvalue.add(new KeyValue("2", "USA"));
        keyvalue.add(new KeyValue("3", "China"));
        keyvalue.add(new KeyValue("4", "UK"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinnerDrug7.setAdapter(adapter);
        //spinnerLocation.setSelection(adapter.getPosition();//Optional to set the selected item.

        spinnerDrug7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
