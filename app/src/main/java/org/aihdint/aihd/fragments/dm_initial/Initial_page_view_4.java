package org.aihdint.aihd.fragments.dm_initial;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orm.query.Condition;
import com.orm.query.Select;

import org.aihdint.aihd.R;
import org.aihdint.aihd.app.CustomDividerItemDecoration;
import org.aihdint.aihd.forms.DM_Initial_View;
import org.aihdint.aihd.model.Complications;
import org.aihdint.aihd.model.Concepts;
import org.aihdint.aihd.model.adapter.ComplicationAdapter;
import org.aihdint.aihd.model.adapter.PatientAdapter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import customfonts.TextView_Roboto_Regular;

public class Initial_page_view_4 extends Fragment {

    private List<Complications> complicationList;
    private ComplicationAdapter adapter;
    private TextView textViewComplications;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_view_4, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.my_recycler_view);
        complicationList = new ArrayList<>();
        adapter = new ComplicationAdapter(getActivity(), complicationList);

        assert recyclerView != null;
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        AllComplication(DM_Initial_View.json);

        return view;
    }


    public void AllComplication(String response) {
        try {
            JSONObject jsonObj = new JSONObject(response);

            // Getting JSON Array node
            JSONArray obs = jsonObj.getJSONArray("obs");

            if (obs.length() > 0) {

                Complications complications = null;

                for (int i = 0; i < obs.length(); i++) {
                    JSONObject concept = obs.getJSONObject(i);
                    String date = "";
                    String comment = "";
                    String complication = "";
                    String diagnosis = "";
                    //if(concept.getString("concept_id").equals("159948")){
                    //date = concept.getString("concept_answer");
                    //}
                    if (concept.getString("concept_id").equals("6042")) {
                        complication = conceptAnswer(concept, "6042");
                    }

                    if (concept.getString("concept_id").equals("165127") || concept.getString("concept_id").equals("159948")) {

                        if (concept.getString("concept_id").equals("159948")) {
                            date = concept.getString("concept_answer");
                        } else {
                            comment = concept.getString("comment");
                            diagnosis = conceptAnswer(concept, "165127");
                        }
                    }

                    if (complication != "" && diagnosis != "" && date != "")
                        complications = new Complications(complication, diagnosis, date, comment);


                }

                complicationList.add(complications);
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String conceptAnswer(JSONObject concept, String concept_id) {
        String value = "";
        try {
            if (concept.getString("concept_id").equals(concept_id)) {
                List<Concepts> answer = Select.from(Concepts.class)
                        .where(Condition.prop("conceptid").eq(concept.getString("concept_answer")))
                        .limit("1")
                        .list();

                for (Concepts cpts : answer) {
                    // adding each child node to HashMap key => value
                    value = cpts.getConcept_answer();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

}
