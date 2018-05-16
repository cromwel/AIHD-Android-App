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
        Spinner spinnerDrugInsulin = view.findViewById(R.id.spinnerDrugInsulin);
        Spinner spinnerDrugNPH = view.findViewById(R.id.spinnerDrugNPH);
        Spinner spinnerDrugSolubleInsulin = view.findViewById(R.id.spinnerDrugSolubleInsulin);
        Spinner spinnerDrugGlucoseOther = view.findViewById(R.id.spinnerDrugGlucoseOther);
        Spinner spinnerDrugEnalapril = view.findViewById(R.id.spinnerDrugEnalapril);
        Spinner spinnerDrugHCTZ = view.findViewById(R.id.spinnerDrugHCTZ);
        Spinner spinnerDrugLosartan = view.findViewById(R.id.spinnerDrugLosartan);
        Spinner spinnerDrugNifedipine = view.findViewById(R.id.spinnerDrugNifedipine);
        Spinner spinnerDrugAtenolol = view.findViewById(R.id.spinnerDrugAtenolol);
        Spinner spinnerDrugJASA = view.findViewById(R.id.spinnerDrugJASA);
        Spinner spinnerDrugAtorvastatin = view.findViewById(R.id.spinnerDrugAtorvastatin);
        Spinner spinnerDrugLisinopril = view.findViewById(R.id.spinnerDrugLisinopril);
        Spinner spinnerDrugAmlodipine = view.findViewById(R.id.spinnerDrugAmlodipine);
        Spinner spinnerDrugFelodipine = view.findViewById(R.id.spinnerDrugFelodipine);
        Spinner spinnerDrugAntiHypertensiveOther = view.findViewById(R.id.spinnerDrugAntiHypertensiveOther);
        Spinner spinnerDrugAmitriptylline = view.findViewById(R.id.spinnerDrugAmitriptylline);
        Spinner spinnerDrugCarbamazepine = view.findViewById(R.id.spinnerDrugCarbamazepine);
        Spinner spinnerDrugNeuropathyOther = view.findViewById(R.id.spinnerDrugNeuropathyOther);

        Spinner spinnerPlanMetformin = view.findViewById(R.id.spinnerPlanMetformin);
        Spinner spinnerPlanGlibenclamide = view.findViewById(R.id.spinnerPlanGlibenclamide);
        Spinner spinnerPlanEnalapril = view.findViewById(R.id.spinnerPlanEnalapril);
        Spinner spinnerPlanHCTZ = view.findViewById(R.id.spinnerPlanHCTZ);
        Spinner spinnerPlanLosartan = view.findViewById(R.id.spinnerPlanLosartan);
        Spinner spinnerPlanNifedipine = view.findViewById(R.id.spinnerPlanNifedipine);
        Spinner spinnerPlanAtenolol = view.findViewById(R.id.spinnerPlanAtenolol);
        Spinner spinnerPlanJASA = view.findViewById(R.id.spinnerPlanJASA);
        Spinner spinnerPlanAtorvastatin = view.findViewById(R.id.spinnerPlanAtorvastatin);
        Spinner spinnerPlanLisinopril = view.findViewById(R.id.spinnerPlanLisinopril);
        Spinner spinnerPlanAmlodipine = view.findViewById(R.id.spinnerPlanAmlodipine);
        Spinner spinnerPlanFelodipine = view.findViewById(R.id.spinnerPlanFelodipine);
        Spinner spinnerPlanAmitriptylline = view.findViewById(R.id.spinnerPlanAmitriptylline);
        Spinner spinnerPlanCarbamazepine = view.findViewById(R.id.spinnerPlanCarbamazepine);

        Spinner spinnerSupportGroup = view.findViewById(R.id.spinnerSupportGroup);
        Spinner spinnerDesignation = view.findViewById(R.id.spinnerDesignation);

        String[] arraySpinnerMetformin = new String[] {"500", "850", "1000"};
        String[] arraySpinnerGlibenclamide = new String[] {"2.5", "5", "7.5", "10"};
        String[] arraySpinnerEnalapril = new String[] {"2.5", "5", "7.5", "10","15","20"};
        String[] arraySpinnerHCTZ = new String[] {"12.5", "25"};
        String[] arraySpinnerLosartan = new String[] {"25", "50"};
        String[] arraySpinnerNifedipine = new String[] {"20", "40"};
        String[] arraySpinnerAtenolol = new String[] {"25", "50", "100"};
        String[] arraySpinnerJASA = new String[] {"75"};
        String[] arraySpinnerAtorvastatin = new String[] {"10", "20", "40", "80"};
        String[] arraySpinnerLisinopril = new String[] {"15", "20"};
        String[] arraySpinnerAmlodipine = new String[] {"2.5", "5"};
        String[] arraySpinnerFelodipine = new String[] {"2.5", "5"};
        String[] arraySpinnerAmitriptylline = new String[] {"25", "50"};
        String[] arraySpinnerCarbamazepine = new String[] {"100", "200"};

        spinnerPlanData(spinnerDrugMetformin,"Metaformin");
        spinnerPlanData(spinnerDrugGlibenclamide,"Glibenclamide");
        spinnerPlanData(spinnerDrugInsulin,"Insulin");
        spinnerPlanData(spinnerDrugNPH,"NPH");
        spinnerPlanData(spinnerDrugSolubleInsulin,"SolubleInsulin");
        spinnerPlanData(spinnerDrugGlucoseOther,"GlucoseOther");
        spinnerPlanData(spinnerDrugEnalapril,"Enalapril");
        spinnerPlanData(spinnerDrugHCTZ,"HCTZ");
        spinnerPlanData(spinnerDrugLosartan,"Losartan");
        spinnerPlanData(spinnerDrugNifedipine,"Nifedipine");
        spinnerPlanData(spinnerDrugAtenolol,"Atenolol");
        spinnerPlanData(spinnerDrugJASA,"JASA");
        spinnerPlanData(spinnerDrugAtorvastatin,"Atorvastatin");
        spinnerPlanData(spinnerDrugLisinopril,"Lisinopril");
        spinnerPlanData(spinnerDrugAmlodipine,"Amlodipine");
        spinnerPlanData(spinnerDrugFelodipine,"Felodipine");
        spinnerPlanData(spinnerDrugAntiHypertensiveOther,"AntiHypertensiveOther");
        spinnerPlanData(spinnerDrugAmitriptylline,"Amitriptylline");
        spinnerPlanData(spinnerDrugCarbamazepine,"Carbamazepine");
        spinnerPlanData(spinnerDrugNeuropathyOther,"NeuropathyOther");

        spinnerDoseData(spinnerPlanMetformin,arraySpinnerMetformin,"Metaformin");
        spinnerDoseData(spinnerPlanGlibenclamide,arraySpinnerGlibenclamide,"Glibenclamide");
        spinnerDoseData(spinnerPlanEnalapril,arraySpinnerEnalapril,"Enalapril");
        spinnerDoseData(spinnerPlanHCTZ,arraySpinnerHCTZ,"HCTZ");
        spinnerDoseData(spinnerPlanLosartan,arraySpinnerLosartan,"Losartan");
        spinnerDoseData(spinnerPlanNifedipine,arraySpinnerNifedipine,"Nifedipine");
        spinnerDoseData(spinnerPlanAtenolol,arraySpinnerAtenolol,"Atenolol");
        spinnerDoseData(spinnerPlanJASA,arraySpinnerJASA,"JASA");
        spinnerDoseData(spinnerPlanAtorvastatin,arraySpinnerAtorvastatin,"Atorvastatin");
        spinnerDoseData(spinnerPlanLisinopril,arraySpinnerLisinopril,"Lisinopril");
        spinnerDoseData(spinnerPlanAmlodipine,arraySpinnerAmlodipine,"Amlodipine");
        spinnerDoseData(spinnerPlanFelodipine,arraySpinnerFelodipine,"Felodipine");
        spinnerDoseData(spinnerPlanAmitriptylline,arraySpinnerAmitriptylline,"Amitriptylline");
        spinnerDoseData(spinnerPlanCarbamazepine,arraySpinnerCarbamazepine,"Carbamazepine");

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


    public  void spinnerPlanData(Spinner spinner, final String plan ){
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

            keyvalue.add(new KeyValue("", "Select Plan"));
            keyvalue.add(new KeyValue("1256", "Start"));
            keyvalue.add(new KeyValue("159835", "CT"));
            keyvalue.add(new KeyValue("165131", "Change"));
            keyvalue.add(new KeyValue("159836", "Stop"));


        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
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
