package org.aihdint.aihd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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
import android.widget.Toast;

import org.aihdint.aihd.app.CustomDividerItemDecoration;
import org.aihdint.aihd.app.HttpHandler;
import org.aihdint.aihd.app.NavigationDrawerShare;
import org.aihdint.aihd.database.DatabaseHandler;
import org.aihdint.aihd.model.Person;
import org.aihdint.aihd.model.adapter.PatientAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Patients extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private DatabaseHandler database;

    private EditText inputSearch;
    private List <Person> contactList;
    private PatientAdapter adapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patients);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.CreateDrawer(toolbar);

        HttpHandler sh = new HttpHandler();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            new AddPatient().execute();
        }

        inputSearch = findViewById(R.id.input_search);
        RecyclerView recyclerView =  findViewById(R.id.my_recycler_view);

        contactList = new ArrayList<>();

        adapter = new PatientAdapter(this, contactList);

        assert recyclerView != null;
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new CustomDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 36));
        recyclerView.setAdapter(adapter);

        /*
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        */

        database = new DatabaseHandler(this);

        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if(isConnected) {
            //new GetPersons().execute();
        }else{
            //getPatients();
            //Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }

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


    }

    @SuppressLint("StaticFieldLeak")
    private class GetPersons extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Toast.makeText(Patients.this,"Patient Data is downloading",Toast.LENGTH_LONG).show();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            //https://api.androidhive.info/contacts/
            String url = "http://45.79.145.240:8080/ems/ws/rest/v1/person?q=";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray persons = jsonObj.getJSONArray("results");

                    // looping through All Users
                    Log.d("Server Persons :", String.valueOf(persons.length()));
                    Log.d("Database Persons :", String.valueOf(database.getPersonsCount()));

                    for (int i = 0; i < persons.length(); i++) {
                        JSONObject c = persons.getJSONObject(i);
                        String id = c.getString("uuid");
                        String name = c.getString("display");

                        if(persons.length()>database.getPersonsCount()) {
                            Log.d("Insert: ", "Inserting " + name);
                            database.addPerson(new Person(id, name));
                        }

                        /*
                        Links node is JSON Object
                        JSONObject links = c.getJSONObject("links");
                        String rel = links.getString("rel");
                        String uri = links.getString("uri");
                        */
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            // Reading all contacts
            getPatients();

        }
    }


    @SuppressLint("StaticFieldLeak")
    private class AddPatient extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String jsonStr = sh.patient();

            Log.e(TAG, "Response POST Patient: " + jsonStr);
            if (jsonStr == null)  {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

        }
    }



    public void getPatients(){
        // Reading all contacts
        Log.d("Reading: ", "Reading all persons..");
        List<Person> persons = database.getAllPersons();

        for (Person cn : persons) {
            // adding each child node to HashMap key => value
            Person person = new Person();
            person.setID(cn.getID());
            person.setName(cn.getName());
            // adding contact to contact list
            contactList.add(person);
            adapter.notifyDataSetChanged();
        }
    }

    void filter(String text){
        List<Person> temp = new ArrayList();
        for(Person d: contactList){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getName().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }
        }
        //update recyclerview
        adapter.searchList(temp);
    }
}