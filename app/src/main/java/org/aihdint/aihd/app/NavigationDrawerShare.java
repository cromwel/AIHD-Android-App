package org.aihdint.aihd.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.aihdint.aihd.Forms.DM_Initial;
import org.aihdint.aihd.Home;
import org.aihdint.aihd.Login;
import org.aihdint.aihd.Patient.Patients;
import org.aihdint.aihd.Patient.Profile;
import org.aihdint.aihd.R;
import org.aihdint.aihd.Patient.Register;
import org.aihdint.aihd.Forms.DM_FollowUp;

/**
 * Developed by Rodney on 20/03/2018.
 */

public class NavigationDrawerShare implements NavigationView.OnNavigationItemSelectedListener {

    private Context mContext;
    public NavigationDrawerShare(Context mContext) {
        this.mContext = mContext;
    }

    public void CreateDrawer(Toolbar toolbar) {

    // Displaying user information from shared preferences

        PackageInfo packageinfo = null;
        try {
            packageinfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        assert packageinfo != null;
        String Version = packageinfo.versionName;

        DrawerLayout drawer = ((Activity) mContext).findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                (Activity) mContext, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = ((Activity) mContext).findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View hView = navigationView.getHeaderView(0);
        TextView nav_version = hView.findViewById(R.id.nav_version);
        TextView nav_name = hView.findViewById(R.id.nav_name);
        try {
            nav_version.setText("Version " + Version);
            nav_name.setText(AppController.getInstance().getSessionManager().getUserDetails().get("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBackPressed() {
        DrawerLayout drawer = ((Activity) mContext).findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            ((Activity)mContext).onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent home = new Intent(mContext.getApplicationContext(), Home.class);
            mContext.startActivity(home);
        }
        /*else if (id == R.id.nav_reports) {
            Intent reports = new Intent(mContext.getApplicationContext(), Patient_Reports.class);
            mContext.startActivity(reports);
        }*/
         else if (id == R.id.nav_dm_initial) {
            Intent dm_initial = new Intent(mContext.getApplicationContext(), DM_Initial.class);
            mContext.startActivity(dm_initial);
            ((Activity)mContext).finish();
        } else if (id == R.id.nav_dm_follow_up) {
            Intent dm_followup = new Intent(mContext.getApplicationContext(), DM_FollowUp.class);
            mContext.startActivity(dm_followup);
            ((Activity)mContext).finish();
        }else if (id == R.id.nav_add_patients) {
            Intent add_patient = new Intent(mContext.getApplicationContext(), Register.class);
            mContext.startActivity(add_patient);
            ((Activity)mContext).finish();
        }else if (id == R.id.nav_patients) {
            Intent patient = new Intent(mContext.getApplicationContext(), Patients.class);
            mContext.startActivity(patient);
            ((Activity)mContext).finish();
        }else if (id == R.id.nav_share) {
            Alerts launch = new Alerts(mContext);
            //launch.alert_msg(this,"The Long Road","Maybe its a hard, loong road");
            launch.share(mContext);
        }else if (id == R.id.nav_logout) {
            // Session manager
            SessionManager session = new SessionManager(mContext.getApplicationContext());
            session.setLogin(false);
            Intent login = new Intent(mContext.getApplicationContext(), Login.class);
            mContext.startActivity(login);
            ((Activity) mContext).finish();
        }

        DrawerLayout drawer = ((Activity) mContext).findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
