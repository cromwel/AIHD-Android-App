package org.aihdint.aihd.Forms;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.aihdint.aihd.PageAdapters.DM_Initial_View_Adapter;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.NavigationDrawerShare;
import org.aihdint.aihd.model.Forms;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * Developed by Rodney on 26/03/2018.
 */

public class DM_Initial_View extends AppCompatActivity {

    //private static final String TAG = DM_Initial_View.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_initial);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.CreateDrawer(toolbar);

        Intent intent = getIntent();
        //report_id = intent.getStringExtra("report_id");
        //patient_id = intent.getStringExtra("patient_id");
        String file_name = intent.getStringExtra("file_name");

        Log.d("Form Data", JSONFormBuilder.loadForm(this, "initial", file_name) + "");
        viewForm(JSONFormBuilder.loadForm(this, "initial", file_name));

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Page 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 5"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final DM_Initial_View_Adapter adapter = new DM_Initial_View_Adapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //noinspection deprecation
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                /*No Action on Unselect*/
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                /*No Action on reselected*/
            }
        });

    }


    public void viewForm(String response) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-M-d");
        Gson formGson = gsonBuilder.create();

        try {
            JSONObject jsonObj = new JSONObject(response);

            // Getting JSON Array node
            JSONArray obs = jsonObj.getJSONArray("obs");

            Log.d("Response", response);
            if (obs.length() > 0) {

                List<Forms> forms = Arrays.asList(formGson.fromJson(obs.toString(), Forms[].class));

                for (Forms form : forms) {
                    // GOT THE OBJECT of Observations
                    Log.d("Obs List", form.toString());
                }

            }

        } catch (Exception e) {
            // hiding the progress bar
            e.printStackTrace();
        }
    }
}
