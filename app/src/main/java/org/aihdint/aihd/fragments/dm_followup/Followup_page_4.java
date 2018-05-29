package org.aihdint.aihd.fragments.dm_followup;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.aihdint.aihd.R;
import org.aihdint.aihd.model.KeyValue;

import java.util.ArrayList;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_followup_fragment_4, container, false);

        //SpinnerDosae
        Spinner spinnerDrugCaptopril = view.findViewById(R.id.spinnerDrugCaptopril);
        Spinner spinnerDrugEnalapril = view.findViewById(R.id.spinnerDrugEnalapril);
        Spinner spinnerDrugLisinopril = view.findViewById(R.id.spinnerDrugLisinopril);
        Spinner spinnerDrugPerindopril = view.findViewById(R.id.spinnerDrugPerindopril);
        Spinner spinnerDrugRamipril = view.findViewById(R.id.spinnerDrugRamipril);

        Spinner spinnerDrugCandesartan = view.findViewById(R.id.spinnerDrugCandesartan);
        Spinner spinnerDrugIrbesartan = view.findViewById(R.id.spinnerDrugIrbesartan);
        Spinner spinnerDrugLosartan = view.findViewById(R.id.spinnerDrugLosartan);
        Spinner spinnerDrugTelmisartan = view.findViewById(R.id.spinnerDrugTelmisartan);
        Spinner spinnerDrugValsartan = view.findViewById(R.id.spinnerDrugValsartan);
        Spinner spinnerDrugOlmesartan = view.findViewById(R.id.spinnerDrugOlmesartan);

        Spinner spinnerDrugAtenolol = view.findViewById(R.id.spinnerDrugAtenolol);
        Spinner spinnerDrugLabetolol = view.findViewById(R.id.spinnerDrugLabetolol);
        Spinner spinnerDrugPropranolol = view.findViewById(R.id.spinnerDrugPropranolol);
        Spinner spinnerDrugCarvedilol = view.findViewById(R.id.spinnerDrugCarvedilol);
        Spinner spinnerDrugNebivolol = view.findViewById(R.id.spinnerDrugNebivolol);
        Spinner spinnerDrugMetoprolol = view.findViewById(R.id.spinnerDrugMetoprolol);
        Spinner spinnerDrugBisoprolol = view.findViewById(R.id.spinnerDrugBisoprolol);

        Spinner spinnerDrugAmlodipine = view.findViewById(R.id.spinnerDrugAmlodipine);
        Spinner spinnerDrugFelodipine = view.findViewById(R.id.spinnerDrugFelodipine);
        Spinner spinnerDrugNifedipine = view.findViewById(R.id.spinnerDrugNifedipine);

        Spinner spinnerDrugChlorthalidone = view.findViewById(R.id.spinnerDrugChlorthalidone);
        Spinner spinnerDrugHydrochlorothia = view.findViewById(R.id.spinnerDrugHydrochlorothia);
        Spinner spinnerDrugIndapamide = view.findViewById(R.id.spinnerDrugIndapamide);

        Spinner spinnerDrugMethyldopa = view.findViewById(R.id.spinnerDrugMethyldopa);
        Spinner spinnerDrugHydralazine = view.findViewById(R.id.spinnerDrugHydralazine);
        Spinner spinnerDrugPrazocin = view.findViewById(R.id.spinnerDrugPrazocin);

        Spinner spinnerDrugMetformin = view.findViewById(R.id.spinnerDrugMetformin);
        Spinner spinnerDrugGlibenclamide = view.findViewById(R.id.spinnerDrugGlibenclamide);

        Spinner spinnerSupportGroup = view.findViewById(R.id.spinnerSupportGroup);
        Spinner spinnerDesignation = view.findViewById(R.id.spinnerDesignation);


        //Spinners Frequency
        Spinner spinnerDrugCaptoprilFrq = view.findViewById(R.id.spinnerDrugCaptoprilFrq);
        Spinner spinnerDrugEnalaprilFrq = view.findViewById(R.id.spinnerDrugEnalaprilFrq);
        Spinner spinnerDrugLisinoprilFrq = view.findViewById(R.id.spinnerDrugLisinoprilFrq);
        Spinner spinnerDrugPerindoprilFrq = view.findViewById(R.id.spinnerDrugPerindoprilFrq);
        Spinner spinnerDrugRamiprilFrq = view.findViewById(R.id.spinnerDrugRamiprilFrq);

        Spinner spinnerDrugCandesartanFrq = view.findViewById(R.id.spinnerDrugCandesartanFrq);
        Spinner spinnerDrugIrbesartanFrq = view.findViewById(R.id.spinnerDrugIrbesartanFrq);
        Spinner spinnerDrugLosartanFrq = view.findViewById(R.id.spinnerDrugLosartanFrq);
        Spinner spinnerDrugTelmisartanFrq = view.findViewById(R.id.spinnerDrugTelmisartanFrq);
        Spinner spinnerDrugValsartanFrq = view.findViewById(R.id.spinnerDrugValsartanFrq);
        Spinner spinnerDrugOlmesartanFrq = view.findViewById(R.id.spinnerDrugOlmesartanFrq);

        Spinner spinnerDrugAtenololFrq = view.findViewById(R.id.spinnerDrugAtenololFrq);
        Spinner spinnerDrugLabetololFrq = view.findViewById(R.id.spinnerDrugLabetololFrq);
        Spinner spinnerDrugPropranololFrq = view.findViewById(R.id.spinnerDrugPropranololFrq);
        Spinner spinnerDrugCarvedilolFrq = view.findViewById(R.id.spinnerDrugCarvedilolFrq);
        Spinner spinnerDrugNebivololFrq = view.findViewById(R.id.spinnerDrugNebivololFrq);
        Spinner spinnerDrugMetoprololFrq = view.findViewById(R.id.spinnerDrugMetoprololFrq);
        Spinner spinnerDrugBisoprololFrq = view.findViewById(R.id.spinnerDrugBisoprololFrq);

        Spinner spinnerDrugAmlodipineFrq = view.findViewById(R.id.spinnerDrugAmlodipineFrq);
        Spinner spinnerDrugFelodipineFrq = view.findViewById(R.id.spinnerDrugFelodipineFrq);
        Spinner spinnerDrugNifedipineFrq = view.findViewById(R.id.spinnerDrugNifedipineFrq);

        Spinner spinnerDrugChlorthalidoneFrq = view.findViewById(R.id.spinnerDrugChlorthalidoneFrq);
        Spinner spinnerDrugHydrochlorothiaFrq = view.findViewById(R.id.spinnerDrugHydrochlorothiaFrq);
        Spinner spinnerDrugIndapamideFrq = view.findViewById(R.id.spinnerDrugIndapamideFrq);

        Spinner spinnerDrugMethyldopaFrq = view.findViewById(R.id.spinnerDrugMethyldopaFrq);
        Spinner spinnerDrugHydralazineFrq = view.findViewById(R.id.spinnerDrugHydralazineFrq);
        Spinner spinnerDrugPrazocinFrq = view.findViewById(R.id.spinnerDrugPrazocinFrq);

        Spinner spinnerDrugMetforminFrq = view.findViewById(R.id.spinnerDrugMetforminFrq);
        Spinner spinnerDrugGlibenclamideFrq = view.findViewById(R.id.spinnerDrugGlibenclamideFrq);

        //SpinnerDose
        String[] arraySpinnerCaptopril = new String[]{"Select","25mg","50mg"};
        String[] arraySpinnerEnalapril = new String[]{"Select","10mg", "20mg "};
        String[] arraySpinnerLisinopril = new String[]{"Select","20mg ", "40mg "};
        String[] arraySpinnerPerindopril = new String[]{"Select","2mg ", "4mg", "5mg", "8mg", "10mg"};
        String[] arraySpinnerRamipril = new String[]{"Select","1.25", "2.5mg ", "10mg "};

        String[] arraySpinnerCandesartan = new String[]{"Select", "4mg", "8mg ", "16mg",  "32mg "};
        String[] arraySpinnerIrbesartan = new String[]{"Select", "75mg", "150mg ", "300mg "};
        String[] arraySpinnerLosartan = new String[]{"Select","50mg ", "100mg "};
        String[] arraySpinnerTelmisartan = new String[]{"Select", "20mg" ,"40mg ", "80mg "};
        String[] arraySpinnerValsartan = new String[]{"Select", "40mg", "80mg ", "160mg ", "320mg"};
        String[] arraySpinnerOlmesartan = new String[]{"Select", "5mg","20mg ", "40mg "};

        String[] arraySpinnerAtenolol = new String[]{"Select","25mg ", "50mg", "100mg "};
        String[] arraySpinnerLabetolol = new String[]{"Select", "100mg", "200mg ", "300mg "};
        String[] arraySpinnerPropranolol = new String[]{"Select","40mg ", "80mg "};
        String[] arraySpinnerCarvedilol = new String[]{"Select", "3.125mg", "6.25mg ", "12.5mg", "10mg", "20mg","25mg ", "40mg","80mg"};
        String[] arraySpinnerNebivolol = new String[]{"Select","2.5mg ", "5mg ", "10mg", "20mg"};
        String[] arraySpinnerMetoprolol = new String[]{"Select","25mg ", "37.5mg", "50mg", "75mg", "100mg ", "200mg"};
        String[] arraySpinnerBisoprolol = new String[]{"Select","5mg ", "10mg "};

        String[] arraySpinnerAmlodipine = new String[]{"Select","2.5mg", "5mg ", "10mg "};
        String[] arraySpinnerFelodipine = new String[]{"Select", "2.5mg","5mg ", "10mg "};
        String[] arraySpinnerNifedipine = new String[]{"Select","10mg ", "20mg "};

        String[] arraySpinnerChlorthalidone = new String[]{"Select","25mg ", "50mg "};
        String[] arraySpinnerHydrochlorothia = new String[]{"Select","12.5mg ", "25mg"};
        String[] arraySpinnerIndapamide = new String[]{"Select","1.5mg ", "2.5mg ", "5mg "};

        String[] arraySpinnerMethyldopa = new String[]{"Select","250mg", "500mg"};
        String[] arraySpinnerHydralazine = new String[]{"Select","25mg ", };
        String[] arraySpinnerPrazocin = new String[]{"Select","0.5mg ", "1mg "};

        String[] arraySpinnerMetformin = new String[]{"Select","500mg", "850",  "1000mg"};
        String[] arraySpinnerGlibenclamide = new String[]{"Select","5mg",};

        spinnerDoseData(spinnerDrugCaptopril, arraySpinnerCaptopril, "Captopril");
        spinnerDoseData(spinnerDrugEnalapril, arraySpinnerEnalapril, "Enalapril");
        spinnerDoseData(spinnerDrugLisinopril, arraySpinnerLisinopril, "Lisinopril");
        spinnerDoseData(spinnerDrugPerindopril, arraySpinnerPerindopril, "Perindopril");
        spinnerDoseData(spinnerDrugRamipril, arraySpinnerRamipril, "Ramipril");

        spinnerDoseData(spinnerDrugCandesartan, arraySpinnerCandesartan, "Candesartan");
        spinnerDoseData(spinnerDrugIrbesartan, arraySpinnerIrbesartan, "Irbesartan");
        spinnerDoseData(spinnerDrugLosartan, arraySpinnerLosartan, "Losartan");
        spinnerDoseData(spinnerDrugTelmisartan, arraySpinnerTelmisartan, "Telmisartan");
        spinnerDoseData(spinnerDrugValsartan, arraySpinnerValsartan, "Valsartan");
        spinnerDoseData(spinnerDrugOlmesartan, arraySpinnerOlmesartan, "Olmesartan");

        spinnerDoseData(spinnerDrugAtenolol, arraySpinnerAtenolol, "Atenolol");
        spinnerDoseData(spinnerDrugLabetolol, arraySpinnerLabetolol, "Labetolol");
        spinnerDoseData(spinnerDrugPropranolol, arraySpinnerPropranolol, "Propranolol");
        spinnerDoseData(spinnerDrugCarvedilol, arraySpinnerCarvedilol, "Carvedilol");
        spinnerDoseData(spinnerDrugNebivolol, arraySpinnerNebivolol, "Nebivolol");
        spinnerDoseData(spinnerDrugMetoprolol, arraySpinnerMetoprolol, "Metoprolol");
        spinnerDoseData(spinnerDrugBisoprolol, arraySpinnerBisoprolol, "Bisoprolol");

        spinnerDoseData(spinnerDrugAmlodipine, arraySpinnerAmlodipine, "Amlodipine");
        spinnerDoseData(spinnerDrugFelodipine, arraySpinnerFelodipine, "Felodipine");
        spinnerDoseData(spinnerDrugNifedipine, arraySpinnerNifedipine, "Nifedipine");

        spinnerDoseData(spinnerDrugChlorthalidone, arraySpinnerChlorthalidone, "Chlorthalidone");
        spinnerDoseData(spinnerDrugHydrochlorothia, arraySpinnerHydrochlorothia, "Hydrochlorothia");
        spinnerDoseData(spinnerDrugIndapamide, arraySpinnerIndapamide, "Indapamide");

        spinnerDoseData(spinnerDrugMethyldopa, arraySpinnerMethyldopa, "Methyldopa");
        spinnerDoseData(spinnerDrugHydralazine, arraySpinnerHydralazine, "Hydralazine");
        spinnerDoseData(spinnerDrugPrazocin, arraySpinnerPrazocin, "Prazocin");
        spinnerDoseData(spinnerDrugMetformin, arraySpinnerMetformin, "Metformin");
        spinnerDoseData(spinnerDrugGlibenclamide, arraySpinnerGlibenclamide, "Glibenclamide");

        //SpinnerFrequency
        spinnerDataFrequency(spinnerDrugCaptoprilFrq, "Captopril");
        spinnerDataFrequency(spinnerDrugEnalaprilFrq, "Enalapril");
        spinnerDataFrequency(spinnerDrugLisinoprilFrq, "Lisinopril");
        spinnerDataFrequency(spinnerDrugPerindoprilFrq, "Perindopril");
        spinnerDataFrequency(spinnerDrugRamiprilFrq, "Ramipril");

        spinnerDataFrequency(spinnerDrugCandesartanFrq, "Candesartan");
        spinnerDataFrequency(spinnerDrugIrbesartanFrq, "Irbesartan");
        spinnerDataFrequency(spinnerDrugLosartanFrq, "Losartan");
        spinnerDataFrequency(spinnerDrugTelmisartanFrq, "Telmisartan");
        spinnerDataFrequency(spinnerDrugValsartanFrq, "Valsartan");
        spinnerDataFrequency(spinnerDrugOlmesartanFrq, "Olmesartan");

        spinnerDataFrequency(spinnerDrugAtenololFrq, "Atenolol");
        spinnerDataFrequency(spinnerDrugLabetololFrq, "Labetolol");
        spinnerDataFrequency(spinnerDrugPropranololFrq, "Propranolol");
        spinnerDataFrequency(spinnerDrugCarvedilolFrq, "Carvedilol");
        spinnerDataFrequency(spinnerDrugNebivololFrq, "Nebivolol");
        spinnerDataFrequency(spinnerDrugMetoprololFrq, "Metoprolol");
        spinnerDataFrequency(spinnerDrugBisoprololFrq, "Bisoprolol");

        spinnerDataFrequency(spinnerDrugAmlodipineFrq, "Amlodipine");
        spinnerDataFrequency(spinnerDrugFelodipineFrq, "Felodipine");
        spinnerDataFrequency(spinnerDrugNifedipineFrq, "Nifedipine");

        spinnerDataFrequency(spinnerDrugChlorthalidoneFrq, "Chlorthalidone");
        spinnerDataFrequency(spinnerDrugHydrochlorothiaFrq, "Hydrochlorothia");
        spinnerDataFrequency(spinnerDrugIndapamideFrq, "Indapamide");

        spinnerDataFrequency(spinnerDrugMethyldopaFrq, "Methyldopa");
        spinnerDataFrequency(spinnerDrugHydralazineFrq, "Hydralazine");
        spinnerDataFrequency(spinnerDrugPrazocinFrq, "Prazocin");
        spinnerDataFrequency(spinnerDrugMetforminFrq, "Metformin");
        spinnerDataFrequency(spinnerDrugGlibenclamideFrq, "Glibenclamide");

        spinnerData(spinnerSupportGroup, "support_group");
        spinnerData(spinnerDesignation, "designation");

        return view;
    }

    public void spinnerData(Spinner spinner, final String data) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        if (data.matches("support_group")) {
            // adding each child node to HashMap key => value
            keyvalue.add(new KeyValue("", "Select Support Group"));
            keyvalue.add(new KeyValue("1065", "Yes"));
            keyvalue.add(new KeyValue("1066", "No"));
            keyvalue.add(new KeyValue("5622", "Unknown"));
        } else if (data.matches("designation")) {
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
                if (data.matches("support_group")) {
                    //occupation = value.getId();
                } else if (data.matches("designation")) {
                    //occupation = value.getId();
                }
                //updateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    public void spinnerDataFrequency(Spinner spinner, final String drug) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        keyvalue.add(new KeyValue("", "Select"));
        keyvalue.add(new KeyValue("", "OD"));
        keyvalue.add(new KeyValue("", "BD"));
        keyvalue.add(new KeyValue("", "TDS"));


        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                if (drug.matches("Captopril")) {
                    //occupation = value.getId();
                } else if (drug.matches("Enalapril")) {
                    //occupation = value.getId();
                }
                //updateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    public void spinnerDoseData(Spinner spinner, String[] arraySpinner, final String plan) {

        //fill data in spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, arraySpinner);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //KeyValue value = (KeyValue) parent.getSelectedItem();
                String dose = parent.getSelectedItem().toString().replace("mg", "");
                dose = dose.replaceAll("\\s+", " ");
                Log.d("Dose",dose+" ");
                if (plan.matches("support_group")) {
                    //occupation = value.getId();
                } else if (plan.matches("designation")) {
                    //occupation = value.getId();
                } else if (plan.matches("plan")) {
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
