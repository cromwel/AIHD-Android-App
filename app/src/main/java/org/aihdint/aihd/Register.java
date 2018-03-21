package org.aihdint.aihd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.aihdint.aihd.app.CustomOnItemSelectedListener;
import org.aihdint.aihd.app.NavigationDrawerShare;

import java.util.Calendar;

/**
 * Developed by Rodney on 19/03/2018.
 */

public class Register extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Spinner spinnerLocation;
    private String gender,isEstimated;

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
        spinnerLocation.setOnItemSelectedListener(new CustomOnItemSelectedListener());
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
