package org.aihdint.aihd.fragments.dm_initial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.aihdint.aihd.R;
import org.aihdint.aihd.model.KeyValue;

import java.util.ArrayList;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Initial_page_5 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_5, container, false);

        //Spinner
        Spinner spinnerDrugMetformin = view.findViewById(R.id.spinnerDrugMetformin);
        Spinner spinnerDrugGlibenclamide = view.findViewById(R.id.spinnerDrugGlibenclamide);
        Spinner spinnerDrugEnalapril = view.findViewById(R.id.spinnerDrugEnalapril);
        Spinner spinnerDrugLosartan = view.findViewById(R.id.spinnerDrugLosartan);
        Spinner spinnerDrugNifedipine = view.findViewById(R.id.spinnerDrugNifedipine);
        Spinner spinnerDrugAtenolol = view.findViewById(R.id.spinnerDrugAtenolol);
        Spinner spinnerDrugLisinopril = view.findViewById(R.id.spinnerDrugLisinopril);
        Spinner spinnerDrugAmlodipine = view.findViewById(R.id.spinnerDrugAmlodipine);
        Spinner spinnerDrugFelodipine = view.findViewById(R.id.spinnerDrugFelodipine);


        Spinner spinnerSupportGroup = view.findViewById(R.id.spinnerSupportGroup);
        Spinner spinnerDesignation = view.findViewById(R.id.spinnerDesignation);

        String[] arraySpinnerMetformin = new String[] {"500", "850", "1000"};
        String[] arraySpinnerGlibenclamide = new String[] {"2.5", "5", "7.5", "10"};
        String[] arraySpinnerEnalapril = new String[] {"2.5", "5", "7.5", "10","15","20"};
        String[] arraySpinnerLosartan = new String[] {"25", "50"};
        String[] arraySpinnerNifedipine = new String[] {"20", "40"};
        String[] arraySpinnerAtenolol = new String[] {"25", "50", "100"};
        String[] arraySpinnerLisinopril = new String[] {"15", "20"};
        String[] arraySpinnerAmlodipine = new String[] {"2.5", "5"};
        String[] arraySpinnerFelodipine = new String[] {"2.5", "5"};


        spinnerDoseData(spinnerDrugMetformin, arraySpinnerMetformin, "Metaformin");
        spinnerDoseData(spinnerDrugGlibenclamide, arraySpinnerGlibenclamide, "Glibenclamide");
        spinnerDoseData(spinnerDrugEnalapril, arraySpinnerEnalapril, "Enalapril");
        spinnerDoseData(spinnerDrugLosartan, arraySpinnerLosartan, "Losartan");
        spinnerDoseData(spinnerDrugNifedipine, arraySpinnerNifedipine, "Nifedipine");
        spinnerDoseData(spinnerDrugAtenolol, arraySpinnerAtenolol, "Atenolol");
        spinnerDoseData(spinnerDrugLisinopril, arraySpinnerLisinopril, "Lisinopril");
        spinnerDoseData(spinnerDrugAmlodipine, arraySpinnerAmlodipine, "Amlodipine");
        spinnerDoseData(spinnerDrugFelodipine, arraySpinnerFelodipine, "Felodipine");

        spinnerData(spinnerSupportGroup,"support_group");
        spinnerData(spinnerDesignation,"designation");

        return view;
    }

    public  void spinnerData(Spinner spinner, final String data ){
        ArrayList<KeyValue> keyvalue = new ArrayList<>();
     
        if(data.matches("support_group")) {
            // adding each child node to HashMap key => value
            keyvalue.add(new KeyValue("", "Select Support Group"));
            keyvalue.add(new KeyValue("1065", "Yes"));
            keyvalue.add(new KeyValue("1066", "No"));
            keyvalue.add(new KeyValue("5622", "Unknown"));
        }else if(data.matches("designation")) {
            keyvalue.add(new KeyValue("", "Select Designation"));
            keyvalue.add(new KeyValue("", "Consultant"));
            keyvalue.add(new KeyValue("", "Medical officer"));
            keyvalue.add(new KeyValue("", "Clinical Officer"));
            keyvalue.add(new KeyValue("", "Nurse"));
        }

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                if(data.matches("support_group")) {
                    //occupation = value.getId();
                }else if(data.matches("designation")) {
                    //occupation = value.getId();
                }
                //updateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    public  void spinnerDoseData(Spinner spinner, String[] arraySpinner ,final String plan){

        //fill data in spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, arraySpinner);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //KeyValue value = (KeyValue) parent.getSelectedItem();
                if(plan.matches("support_group")) {
                    //occupation = value.getId();
                }else if(plan.matches("designation")) {
                    //occupation = value.getId();
                }else if(plan.matches("plan")) {
                    //occupation = value.getId();
                }
                //occupation = value.getId();
                //updateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

}
