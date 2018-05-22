package org.aihdint.aihd.Patient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;

import org.aihdint.aihd.R;
import org.aihdint.aihd.app.NavigationDrawerShare;

public class Profile extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_patient);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.CreateDrawer(toolbar);

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked
        boolean checked = ((CheckBox) view).isChecked();

        //Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_diagnosis_dm:
                if (checked) {
                } else {
                }
                break;
            case R.id.checkbox_diagnosis_htn:
                if (checked) {
                } else {
                }
                break;
            case R.id.checkbox_deceased:
                if (checked) {
                } else {
                }
                break;

        }
    }

    public void dm_initial(View view) {
    }

    public void dm_followup(View view) {
    }
}
