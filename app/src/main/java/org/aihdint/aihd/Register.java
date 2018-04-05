package org.aihdint.aihd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.aihdint.aihd.app.CustomOnItemSelectedListener;
import org.aihdint.aihd.app.NavigationDrawerShare;
import org.aihdint.aihd.model.KeyValue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Developed by Rodney on 19/03/2018.
 */

public class Register extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Spinner spinnerLocation;
    private String gender,isEstimated;
    private  String ID ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.CreateDrawer(toolbar);


        addListenerOnSpinnerItemSelection();

       // inputUsername = findViewById(R.id.username);
        //inputPassword = findViewById(R.id.password);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinnerLocation = findViewById(R.id.spinnerLocation);


        List<String> Location_Name = new ArrayList<>();
        Location_Name.add("Pharmacy");
        Location_Name.add("Laboratory");
        Location_Name.add("Isolation Ward");
        Location_Name.add("Registration Desk");
        Location_Name.add("Inpatient Ward");
        Location_Name.add("Outpatient");
        Location_Name.add("Other/Field");

        List<String> Location_ID = new ArrayList<>();
        Location_Name.add("1");
        Location_Name.add("2");
        Location_Name.add("3");
        Location_Name.add("4");
        Location_Name.add("5");
        Location_Name.add("6");
        Location_Name.add("7");

        setLocationData();

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

    private void setLocationData() {

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
    }

    public void dob (View view){

        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                Register.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

        dpd.showYearPickerFirst(true);
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth+"/"+(++monthOfYear)+"/"+year;
        //dobTextView.setText(date);
        //dob=date;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_male:
                if (checked)
                    gender = "Male";
                break;
            case R.id.radio_female:
                if (checked)
                    gender = "Female";
                break;
            case R.id.radio_yes:
                if (checked)
                    isEstimated = "1";
                break;
            case R.id.radio_no:
                if (checked)
                    isEstimated = "0";
                break;
        }
    }


}
