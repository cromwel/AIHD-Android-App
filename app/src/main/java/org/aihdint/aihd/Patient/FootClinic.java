package org.aihdint.aihd.Patient;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import org.aihdint.aihd.R;
import org.aihdint.aihd.app.NavigationDrawerShare;

public class FootClinic extends AppCompatActivity {

    private ProgressDialog pDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_foot_clinic);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.CreateDrawer(toolbar);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
    }
}
