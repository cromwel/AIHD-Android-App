package org.aihdint.aihd.Forms;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import org.aihdint.aihd.PageAdapters.DM_FollowUp_Adpater;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.Alerts;
import org.aihdint.aihd.app.NavigationDrawerShare;
import org.aihdint.aihd.fragments.dm_followup.FollowUpActivityModel;
import org.aihdint.aihd.fragments.dm_followup.FragmentModelFollowUp;


/**
 * Created by Rodney 4/24/18
 */

public class DM_FollowUp extends AppCompatActivity implements FragmentModelFollowUp.FragStateChangeListener {

    private String supporter_name, supporter_phone, dm_diagnosis, hypertension, nhif, diabetes_type, hiv_status;
    private String urination,thirst,hunger,weight_loss,fatigue,vision,impotence,numbness,cough,fever,noticable_weight_loss,night_sweats;
    private String sputum_smear,gene_xpert,chest_xray,anti_tb,invitation_contacts,evaluated_ipt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_follow_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.CreateDrawer(toolbar);

        FragmentModelFollowUp.getInstance().setListener(this);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Page 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 4"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final DM_FollowUp_Adpater adapter = new DM_FollowUp_Adpater
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_diagnosis_new:
                if (checked)
                    dm_diagnosis = "165087";
                    FollowUpActivityModel.getInstance().dmDiagnosis(dm_diagnosis);
                    break;
            case R.id.radio_diagnosis_known:
                if (checked)
                    dm_diagnosis = "165088";
                    FollowUpActivityModel.getInstance().dmDiagnosis(dm_diagnosis);
                    break;
            case R.id.radio_hypertension_new:
                if (checked)
                    hypertension = "165092";
                    FollowUpActivityModel.getInstance().htnDiagnosis(hypertension);
                break;
            case R.id.radio_hypertension_known:
                if (checked)
                    hypertension = "165093";
                    FollowUpActivityModel.getInstance().htnDiagnosis(hypertension);
                break;
            case R.id.radio_NHIF_yes:
                if (checked)
                    nhif = "1065";
                    break;
            case R.id.radio_NHIF_no:
                if (checked)
                    nhif = "1066";
                    Alerts.alert_msg(this, "NHIF Registration", "Encourage Client to Register for NHIF");
                    break;
            case R.id.radio_diabetes_type_1:
                if (checked)
                    diabetes_type = "142474";
                break;
            case R.id.radio_diabetes_GDM:
                if (checked)
                    diabetes_type = "1449";
                break;
            case R.id.radio_diabetes_type_2:
                if (checked)
                    diabetes_type = "142473";
                break;
            case R.id.radio_HIV_negative:
                if (checked)
                    hiv_status = "664";
                break;
            case R.id.radio_HIV_positive:
                if (checked)
                    hiv_status = "138571";
                break;
            case R.id.radio_HIV_unknown:
                if (checked)
                    hiv_status = "1067";
                break;
        }
    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked
        boolean checked = ((CheckBox) view).isChecked();

        //Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_frequent_urinations:
                if (checked) {
                    urination = "137593";
                } else {
                    urination = null;
                }
                break;
            case R.id.checkbox_excessive_thirst:
                if (checked) {

                } else {

                }
                break;

        }
    }


    public void validate(View view) {

        if (
                urination != null && !urination.isEmpty()
                ) {
            Toast.makeText(getApplicationContext(), hiv_status, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Sorry no data available", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void followUpOne(String supporterName, String supportePhone) {
        supporter_name = supporterName;
        supporter_phone = supportePhone;
    }

    @Override
    public void followUpTwo(String urinate) {

    }

    @Override
    public void followUpThree(String tag) {

    }

    @Override
    public void followUpFour(String tag) {

    }

}
