package org.aihdint.aihd.patient;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import org.aihdint.aihd.R;
import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.app.Config;
import org.aihdint.aihd.app.CustomDividerItemDecoration;
import org.aihdint.aihd.common.NavigationDrawerShare;
import org.aihdint.aihd.model.Person;
import org.aihdint.aihd.adapters.models.PatientAdapter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Patients extends AppCompatActivity implements SwipyRefreshLayout.OnRefreshListener {

    //private String TAG = MainActivity.class.getSimpleName();

    private List<Person> contactList;
    private List<Person> personList;
    private PatientAdapter adapter;
    private String IsForm;
    private SwipyRefreshLayout swipeRefreshLayout;
    private Gson patientsGson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patients);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        Intent intent = getIntent();
        IsForm = intent.getStringExtra("isForm");

        swipeRefreshLayout = findViewById(R.id.swipyrefreshlayout);
        EditText inputSearch = findViewById(R.id.input_search);
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        contactList = new ArrayList<>();
        personList = new ArrayList<>();

        swipeRefreshLayout.setOnRefreshListener(this);
        adapter = new PatientAdapter(this, contactList);

        DownloadPatients();

        assert recyclerView != null;
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new CustomDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 36));
        recyclerView.setAdapter(adapter);

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // filter your list from your input
                filter(s.toString());
                //you can use runnable postDelayed like 500 ms to delay search text
            }
        });


        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        swipeRefreshLayout.setRefreshing(true);
                                        getPatients();
                                    }
                                }
        );

    }


    public void getPatients() {
        contactList.clear();
        personList.clear();

        List<Person> allpersons = Person.findWithQuery(Person.class, "SELECT * FROM PERSON ORDER BY FAMILYNAME ASC");

        for (Person pn : allpersons) {
            // adding each child node to HashMap key => value
            Person person = new Person();
            person.set_id(pn.get_id());
            person.setFamily_name(pn.getFamily_name());
            person.setGiven_name(pn.getGiven_name());
            person.set_status("0");
            person.setIsReport(IsForm);
            person.setIdentifier(pn.getIdentifier());
            // adding contact to contact list
            personList.add(person);
            contactList.add(person);
            adapter.notifyDataSetChanged();
        }

        swipeRefreshLayout.setRefreshing(false);

    }


    void filter(String text) {
        @SuppressWarnings("unchecked") List<Person> temp = new ArrayList();
        contactList = personList;
        for (Person d : contactList) {
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            String name = d.getFamily_name() + " " + d.getGiven_name();
            if (name.toLowerCase().contains(text.toLowerCase())) {
                temp.add(d);
            }
        }
        //update recyclerview
        adapter.searchList(temp);
    }

    @Override
    public void onRefresh(SwipyRefreshLayoutDirection direction) {
        Log.d("Patients", "Refresh triggered at " + (direction == SwipyRefreshLayoutDirection.TOP ? "top" : "bottom"));

        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (isConnected) {
            DownloadPatients();
        }
    }


    private void DownloadPatients() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-M-d");
        patientsGson = gsonBuilder.create();

        StringRequest req = new StringRequest(Request.Method.POST, Config.PATIENT_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObj = new JSONObject(response);

                    // Getting JSON Array node
                    JSONArray patients = jsonObj.getJSONArray("data");

                    //List<Person> persons = Arrays.asList(patientsGson.fromJson(response, Person[].class));
                    Log.d("Response", response);
                    if (patients.length() > 0) {
                        Person.deleteAll(Person.class);

                        List<Person> persons = Arrays.asList(patientsGson.fromJson(patients.toString(), Person[].class));

                        for (Person person : persons) {
                            // GOT THE OBJECT of PEOPLE
                            person.save();
                        }

                        getPatients();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<>();
                params.put("location_id", AppController.getInstance().getSessionManager().getUserDetails().get("location_id"));
                params.put("uuid", AppController.getInstance().getSessionManager().getUserDetails().get("user_id"));

                JSONObject JSONparams = new JSONObject(params);
                Log.d("Params", JSONparams.toString());

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);

    }

}