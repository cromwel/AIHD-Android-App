package org.aihdint.aihd.patient;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.aihdint.aihd.forms.DM_FollowUp;
import org.aihdint.aihd.forms.DM_HTN_Forms;
import org.aihdint.aihd.forms.DM_Initial;
import org.aihdint.aihd.R;
import org.aihdint.aihd.common.NavigationDrawerShare;

public class Profile extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private String patient_id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String identifier = intent.getStringExtra("identifier");
        patient_id = intent.getStringExtra("patient_id");

        TextView textViewName = findViewById(R.id.patient_name);
        textViewName.setText(name);

        TextView textViewIdentifier = findViewById(R.id.patient_identifier);
        if (!identifier.isEmpty()) {
            textViewIdentifier.setText(identifier);
        }

    }


    public void dmInitial(View view) {
        Intent dm_initial = new Intent(getApplicationContext(), DM_Initial.class);
        dm_initial.putExtra("patient_id", patient_id);
        startActivity(dm_initial);
        finish();
    }

    public void dmFollowup(View view) {
        Intent dm_followup = new Intent(getApplicationContext(), DM_FollowUp.class);
        dm_followup.putExtra("patient_id", patient_id);
        startActivity(dm_followup);
        finish();
    }

    public void forms(View view) {
        Intent forms = new Intent(getApplicationContext(), DM_HTN_Forms.class);
        forms.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        forms.putExtra("patient_id", patient_id);
        startActivity(forms);
        finish();
    }

    public void admission(View view) {
        Intent admission = new Intent(getApplicationContext(), Admission.class);
        admission.putExtra("patient_id", patient_id);
        startActivity(admission);
        finish();
    }

    public void footClinic(View view) {

        Intent foot_clinic = new Intent(getApplicationContext(), FootClinic.class);
        foot_clinic.putExtra("patient_id", patient_id);
        startActivity(foot_clinic);
        finish();
    }

    public void transfer(View view) {

        Intent transfer = new Intent(getApplicationContext(), Transfer.class);
        transfer.putExtra("patient_id", patient_id);
        startActivity(transfer);
        finish();
    }

    public void deceased(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        // Set Dialog Title
        alertDialog.setTitle("Patient Deceased");

        // Set Dialog Message
        alertDialog.setMessage("Patient Status?");
        LinearLayout lp = new LinearLayout(this);
        lp.setOrientation(LinearLayout.VERTICAL);

        CheckBox checkBox = new CheckBox(this);
        checkBox.setOnCheckedChangeListener(this);
        checkBox.setId(R.id.checkBoxDeceased);
        checkBox.setText(R.string.deceased);

        EditText editText = new EditText(this);
        editText.setId(R.id.editTextDeath);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        editText.setHint("Cause of death?");

        lp.addView(checkBox);
        lp.addView(editText);
        lp.setPadding(50, 40, 50, 10);

        alertDialog.setView(lp);

        // Set OK Button
        alertDialog.setButton("SUBMIT", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Status Updated", Toast.LENGTH_LONG).show();

            }
        });

        // Show Alert Message
        alertDialog.show();

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }
}
