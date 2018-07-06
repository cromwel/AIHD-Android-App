package org.aihdint.aihd.Patient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import org.aihdint.aihd.Forms.DM_FollowUp;
import org.aihdint.aihd.Forms.DM_Initial;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.NavigationDrawerShare;

public class Profile extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.CreateDrawer(toolbar);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        TextView textViewName = findViewById(R.id.patient_name);
        textViewName.setText(name);

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

        }
    }

    public void dm_initial(View view) {
        Intent dm_initial = new Intent(getApplicationContext(), DM_Initial.class);
        startActivity(dm_initial);
        finish();
    }

    public void dm_followup(View view) {
        Intent dm_followup = new Intent(getApplicationContext(), DM_FollowUp.class);
        startActivity(dm_followup);
        finish();
    }

    public void admission(View view) {
        Intent admission = new Intent(getApplicationContext(), Admission.class);
        startActivity(admission);
        finish();
    }

    public void foot_clinic(View view) {

        Intent foot_clinic = new Intent(getApplicationContext(), FootClinic.class);
        startActivity(foot_clinic);
        finish();
    }

    public void transfer(View view) {

        Intent transfer = new Intent(getApplicationContext(), Transfer.class);
        startActivity(transfer);
        finish();
    }

    public void deceased(View view) {
    }
}
