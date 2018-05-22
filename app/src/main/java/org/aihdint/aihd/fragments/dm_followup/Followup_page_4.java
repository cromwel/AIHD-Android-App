package org.aihdint.aihd.fragments.dm_followup;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.aihdint.aihd.R;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_followup_fragment_4, container, false);
        //Spinner
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

        String[] arraySpinnerCaptopril = new String[]{"25mg BD", "50mg BD", "50mg TDS"};
        String[] arraySpinnerEnalapril = new String[]{"10mg BD", "20mg BD"};
        String[] arraySpinnerLisinopril = new String[]{"10mg OD", "40mg OD"};
        String[] arraySpinnerPerindopril = new String[]{"5mg OD", "10mg OD"};
        String[] arraySpinnerRamipril = new String[]{"2.5mg OD", "10mg OD"};

        String[] arraySpinnerCandesartan = new String[]{"8mg OD", "32mg OD"};
        String[] arraySpinnerIrbesartan = new String[]{"150mg OD", "300mg OD"};
        String[] arraySpinnerLosartan = new String[]{"50mg OD", "100mg OD"};
        String[] arraySpinnerTelmisartan = new String[]{"40mg OD", "80mg OD"};
        String[] arraySpinnerValsartan = new String[]{"80mg OD", "160mg OD"};
        String[] arraySpinnerOlmesartan = new String[]{"20mg OD", "40mg OD"};

        String[] arraySpinnerAtenolol = new String[]{"25mg OD", "100mg OD"};
        String[] arraySpinnerLabetolol = new String[]{"200mg OD", "10mg OD"};
        String[] arraySpinnerPropranolol = new String[]{"2.5mg OD", "10mg OD"};
        String[] arraySpinnerCarvedilol = new String[]{"6.25mg OD", "25mg OD"};
        String[] arraySpinnerNebivolol = new String[]{"2.5mg OD", "5mg OD"};
        String[] arraySpinnerMetoprolol = new String[]{"25mg OD", "100mg OD"};
        String[] arraySpinnerBisoprolol = new String[]{"2.5mg OD", "10mg OD"};

        String[] arraySpinnerAmlodipine = new String[]{"5mg OD", "10mg OD"};
        String[] arraySpinnerFelodipine = new String[]{"5mg OD", "10mg OD"};
        String[] arraySpinnerNifedipine = new String[]{"Retard tab:20mg BD", "LA tabs:30mg OD", "LA tabs:60mg OD"};

        String[] arraySpinnerChlorthalidone = new String[]{"25mg OD", "50mg OD"};
        String[] arraySpinnerHydrochlorothia = new String[]{"12.5mg OD", "25mg OD"};
        String[] arraySpinnerIndapamide = new String[]{"1.5mg OD", "2.5mg OD", "5mg OD"};

        String[] arraySpinnerMethyldopa = new String[]{"250mg TDS", "1000mg TDS"};
        String[] arraySpinnerHydralazine = new String[]{"25mg OD", "10mg OD"};
        String[] arraySpinnerPrazocin = new String[]{"0.5mg OD", "10mg OD", "0.5mg BD", "10mg BD"};

        String[] arraySpinnerMetformin = new String[]{"500mg TDS", "1000mg TDS", "500mg BD", "1000mg BD"};
        String[] arraySpinnerGlibenclamide = new String[]{"2.5mg OD", "10mg OD", "2.5mg BD", "10mg BD"};

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


        return view;
    }

    public void spinnerDoseData(Spinner spinner, String[] arraySpinner, final String plan) {

        //fill data in spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, arraySpinner);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //KeyValue value = (KeyValue) parent.getSelectedItem();
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
