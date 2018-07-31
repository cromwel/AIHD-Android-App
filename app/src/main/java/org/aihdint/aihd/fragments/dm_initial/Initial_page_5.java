package org.aihdint.aihd.fragments.dm_initial;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import org.aihdint.aihd.forms.JSONFormBuilder;
import org.aihdint.aihd.R;
import org.aihdint.aihd.model.KeyValue;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Initial_page_5 extends Fragment {

    private CheckBox checkBoxEnalapril, checkBoxCaptopril, checkBoxLisinopril, checkBoxPerindopril, checkBoxRamipril;
    private CheckBox checkBoxCandesartan, checkBoxIrbesartan, checkBoxLosartan, checkBoxTelmisartan, checkBoxValsartan, checkBoxOlmesartan;

    private String Metformin, Glibenclamide, Insulin, SolubleInsulin, NPH, Captopril, Enalapril, Lisinopril, Perindopril, Ramipril, Candesartan, Irbesartan, Losartan,
            Telmisartan, Valsartan, Olmesartan, Atenolol, Labetolol, Propranolol, Carvedilol, Nebivolol, Metoprolol, Bisoprolol, Amlodipine, Felodipine, Nifedipine,
            Chlorthalidone, Hydrochlorothia, Indapamide, Methyldopa, Hydralazine, Prazocin, Diet, PhysicalExercise, Herbal, TreatmentOther;

    private String doseMetformin, doseGlibenclamide, doseCaptopril, doseEnalapril, doseLisinopril, dosePerindopril, doseRamipril, doseCandesartan, doseIrbesartan, doseLosartan,
            doseTelmisartan, doseValsartan, doseOlmesartan, doseAtenolol, doseLabetolol, dosePropranolol, doseCarvedilol, doseNebivolol, doseMetoprolol, doseBisoprolol,
            doseAmlodipine, doseFelodipine, doseNifedipine, doseChlorthalidone, doseHydrochlorothia, doseIndapamide, doseMethyldopa, doseHydralazine, dosePrazocin;

    private String frequencyMetformin, frequencyGlibenclamide, frequencyCaptopril, frequencyEnalapril, frequencyLisinopril, frequencyPerindopril, frequencyRamipril,
            frequencyCandesartan, frequencyIrbesartan, frequencyLosartan, frequencyTelmisartan, frequencyValsartan, frequencyOlmesartan, frequencyAtenolol, frequencyLabetolol,
            frequencyPropranolol, frequencyCarvedilol, frequencyNebivolol, frequencyMetoprolol, frequencyBisoprolol, frequencyAmlodipine, frequencyFelodipine,
            frequencyNifedipine, frequencyChlorthalidone, frequencyHydrochlorothia, frequencyIndapamide, frequencyMethyldopa, frequencyHydralazine, frequencyPrazocin;

    private EditText editTextDiet, editTextPhysicalExercise, editTextHerbal, editTextTreatmentOther, editTextComment;
    //private EditText

    private String support_group, designation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_5, container, false);


        CheckBox checkBoxMetformin = view.findViewById(R.id.treatment_metformin);
        CheckBox checkBoxGlibenclamide = view.findViewById(R.id.treatment_glibenclamide);

        checkBoxEnalapril = view.findViewById(R.id.treatment_enalapril);
        checkBoxCaptopril = view.findViewById(R.id.treatment_captopril);
        checkBoxLisinopril = view.findViewById(R.id.treatment_lisinopril);
        checkBoxPerindopril = view.findViewById(R.id.treatment_perindopril);
        checkBoxRamipril = view.findViewById(R.id.treatment_ramipril);

        checkBoxCandesartan = view.findViewById(R.id.treatment_candesartan);
        checkBoxIrbesartan = view.findViewById(R.id.treatment_irbesartan);
        checkBoxLosartan = view.findViewById(R.id.treatment_losartan);
        checkBoxTelmisartan = view.findViewById(R.id.treatment_telmisartan);
        checkBoxValsartan = view.findViewById(R.id.treatment_valsartan);
        checkBoxOlmesartan = view.findViewById(R.id.treatment_olmesartan);

        CheckBox checkBoxAtenolol = view.findViewById(R.id.treatment_atenolol);
        CheckBox checkBoxLabetolol = view.findViewById(R.id.treatment_labetolol);
        CheckBox checkBoxPropranolol = view.findViewById(R.id.treatment_propranolol);
        CheckBox checkBoxCarvedilol = view.findViewById(R.id.treatment_carvedilol);
        CheckBox checkBoxNebivolol = view.findViewById(R.id.treatment_nebivolol);
        CheckBox checkBoxMetoprolol = view.findViewById(R.id.treatment_metoprolol);
        CheckBox checkBoxBisoprolol = view.findViewById(R.id.treatment_bisoprolol);

        CheckBox checkBoxAmlodipine = view.findViewById(R.id.treatment_amlodipine);
        CheckBox checkBoxFelodipine = view.findViewById(R.id.treatment_felodipine);
        CheckBox checkBoxNifedipine = view.findViewById(R.id.treatment_nifedipine);

        CheckBox checkBoxChlorthalidone = view.findViewById(R.id.treatment_chlorthalidone);
        CheckBox checkBoxHydrochlorothia = view.findViewById(R.id.treatment_hydrochlorothia);
        CheckBox checkBoxIndapamide = view.findViewById(R.id.treatment_indapamide);

        CheckBox checkBoxMethyldopa = view.findViewById(R.id.treatment_methyldopa);
        CheckBox checkBoxHydralazine = view.findViewById(R.id.treatment_hydralazine);
        CheckBox checkBoxPrazocin = view.findViewById(R.id.treatment_prazocin);

        checkBoxTreatment(checkBoxMetformin);
        checkBoxTreatment(checkBoxGlibenclamide);

        checkBoxTreatment(checkBoxCaptopril);
        checkBoxTreatment(checkBoxEnalapril);
        checkBoxTreatment(checkBoxLisinopril);
        checkBoxTreatment(checkBoxPerindopril);
        checkBoxTreatment(checkBoxRamipril);

        checkBoxTreatment(checkBoxCandesartan);
        checkBoxTreatment(checkBoxIrbesartan);
        checkBoxTreatment(checkBoxLosartan);
        checkBoxTreatment(checkBoxTelmisartan);
        checkBoxTreatment(checkBoxValsartan);
        checkBoxTreatment(checkBoxOlmesartan);

        checkBoxTreatment(checkBoxAtenolol);
        checkBoxTreatment(checkBoxLabetolol);
        checkBoxTreatment(checkBoxPropranolol);
        checkBoxTreatment(checkBoxCarvedilol);
        checkBoxTreatment(checkBoxNebivolol);
        checkBoxTreatment(checkBoxMetoprolol);
        checkBoxTreatment(checkBoxBisoprolol);

        checkBoxTreatment(checkBoxAmlodipine);
        checkBoxTreatment(checkBoxFelodipine);
        checkBoxTreatment(checkBoxNifedipine);

        checkBoxTreatment(checkBoxChlorthalidone);
        checkBoxTreatment(checkBoxHydrochlorothia);
        checkBoxTreatment(checkBoxIndapamide);

        checkBoxTreatment(checkBoxMethyldopa);
        checkBoxTreatment(checkBoxHydralazine);
        checkBoxTreatment(checkBoxPrazocin);

        CheckBox checkBoxUrinalysis = view.findViewById(R.id.treatment_urinalysis);
        CheckBox checkBoxHBA = view.findViewById(R.id.treatment_hba);
        CheckBox checkBoxMicroalbumin = view.findViewById(R.id.treatment_microalbumin);
        CheckBox checkBoxCreatinine = view.findViewById(R.id.treatment_creatinine);
        CheckBox checkBoxPotassium = view.findViewById(R.id.treatment_potassium);
        CheckBox checkBoxECG = view.findViewById(R.id.treatment_ecg);
        CheckBox checkBoxTestOther = view.findViewById(R.id.treatment_followup_other);

        checkBoxTreatment(checkBoxUrinalysis);
        checkBoxTreatment(checkBoxHBA);
        checkBoxTreatment(checkBoxMicroalbumin);
        checkBoxTreatment(checkBoxCreatinine);
        checkBoxTreatment(checkBoxPotassium);
        checkBoxTreatment(checkBoxECG);
        checkBoxTreatment(checkBoxTestOther);

        CheckBox checkBoxManagementDM = view.findViewById(R.id.followup_further_management_dm);
        CheckBox checkBoxManagementHTN = view.findViewById(R.id.followup_further_management_htn);
        CheckBox checkBoxEyeReview = view.findViewById(R.id.followup_eye_review);
        CheckBox checkBoxSurgicalReview = view.findViewById(R.id.followup_surgical_review);
        CheckBox checkBoxRenalReview = view.findViewById(R.id.followup_renal_review);
        CheckBox checkBoxCVDReview = view.findViewById(R.id.followup_cvd_review);
        CheckBox checkBoxNutrition = view.findViewById(R.id.followup_nutrition);
        CheckBox checkBoxPhysiotherapy = view.findViewById(R.id.followup_physiotherapy);
        CheckBox checkBoxFollowUpOther = view.findViewById(R.id.followup_other);

        checkBoxTreatment(checkBoxManagementDM);
        checkBoxTreatment(checkBoxManagementHTN);
        checkBoxTreatment(checkBoxEyeReview);
        checkBoxTreatment(checkBoxSurgicalReview);
        checkBoxTreatment(checkBoxRenalReview);
        checkBoxTreatment(checkBoxCVDReview);
        checkBoxTreatment(checkBoxNutrition);
        checkBoxTreatment(checkBoxPhysiotherapy);
        checkBoxTreatment(checkBoxFollowUpOther);

        //SpinnerDosage
        Spinner spinnerDrugMetformin = view.findViewById(R.id.spinnerDrugMetformin);
        Spinner spinnerDrugGlibenclamide = view.findViewById(R.id.spinnerDrugGlibenclamide);

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
        String[] arraySpinnerCaptopril = new String[]{"Select", "25mg", "50mg"};
        String[] arraySpinnerEnalapril = new String[]{"Select", "10mg", "20mg "};
        String[] arraySpinnerLisinopril = new String[]{"Select", "20mg ", "40mg "};
        String[] arraySpinnerPerindopril = new String[]{"Select", "2mg ", "4mg", "5mg", "8mg", "10mg"};
        String[] arraySpinnerRamipril = new String[]{"Select", "1.25", "2.5mg ", "10mg "};

        String[] arraySpinnerCandesartan = new String[]{"Select", "4mg", "8mg ", "16mg", "32mg "};
        String[] arraySpinnerIrbesartan = new String[]{"Select", "75mg", "150mg ", "300mg "};
        String[] arraySpinnerLosartan = new String[]{"Select", "50mg ", "100mg "};
        String[] arraySpinnerTelmisartan = new String[]{"Select", "20mg", "40mg ", "80mg "};
        String[] arraySpinnerValsartan = new String[]{"Select", "40mg", "80mg ", "160mg ", "320mg"};
        String[] arraySpinnerOlmesartan = new String[]{"Select", "5mg", "20mg ", "40mg "};

        String[] arraySpinnerAtenolol = new String[]{"Select", "25mg ", "50mg", "100mg "};
        String[] arraySpinnerLabetolol = new String[]{"Select", "100mg", "200mg ", "300mg "};
        String[] arraySpinnerPropranolol = new String[]{"Select", "40mg ", "80mg "};
        String[] arraySpinnerCarvedilol = new String[]{"Select", "3.125mg", "6.25mg ", "12.5mg", "10mg", "20mg", "25mg ", "40mg", "80mg"};
        String[] arraySpinnerNebivolol = new String[]{"Select", "2.5mg ", "5mg ", "10mg", "20mg"};
        String[] arraySpinnerMetoprolol = new String[]{"Select", "25mg ", "37.5mg", "50mg", "75mg", "100mg ", "200mg"};
        String[] arraySpinnerBisoprolol = new String[]{"Select", "5mg ", "10mg "};

        String[] arraySpinnerAmlodipine = new String[]{"Select", "2.5mg", "5mg ", "10mg "};
        String[] arraySpinnerFelodipine = new String[]{"Select", "2.5mg", "5mg ", "10mg "};
        String[] arraySpinnerNifedipine = new String[]{"Select", "10mg ", "20mg "};

        String[] arraySpinnerChlorthalidone = new String[]{"Select", "25mg ", "50mg "};
        String[] arraySpinnerHydrochlorothia = new String[]{"Select", "12.5mg ", "25mg"};
        String[] arraySpinnerIndapamide = new String[]{"Select", "1.5mg ", "2.5mg ", "5mg "};

        String[] arraySpinnerMethyldopa = new String[]{"Select", "250mg", "500mg"};
        String[] arraySpinnerHydralazine = new String[]{"Select", "25mg ",};
        String[] arraySpinnerPrazocin = new String[]{"Select", "0.5mg ", "1mg "};

        String[] arraySpinnerMetformin = new String[]{"Select", "500mg", "850mg", "1000mg"};
        String[] arraySpinnerGlibenclamide = new String[]{"Select", "5mg",};

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

        Spinner spinnerSupportGroup = view.findViewById(R.id.spinnerSupportGroup);
        Spinner spinnerDesignation = view.findViewById(R.id.spinnerDesignation);

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
                    support_group = value.getId();
                } else if (data.matches("designation")) {
                    designation = value.getId();
                }
                updateValues();
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
        keyvalue.add(new KeyValue("160862", "OD"));
        keyvalue.add(new KeyValue("160858", "BD"));
        keyvalue.add(new KeyValue("160866", "TDS"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue keyValue = (KeyValue) parent.getSelectedItem();

                if (!keyValue.getId().isEmpty()) {

                    if (drug.matches("Metformin")) {
                        frequencyMetformin = keyValue.getId();
                    } else {
                        frequencyMetformin = "";
                    }

                    if (drug.matches("Glibenclamide")) {
                        frequencyGlibenclamide = keyValue.getId();
                    } else {
                        frequencyGlibenclamide = "";
                    }

                    if (drug.matches("Enalapril")) {
                        frequencyEnalapril = keyValue.getId();
                    } else {
                        frequencyEnalapril = "";
                    }

                    if (drug.matches("Captopril")) {
                        frequencyCaptopril = keyValue.getId();
                    } else {
                        frequencyCaptopril = "";
                    }

                    if (drug.matches("Lisinopril")) {
                        frequencyLisinopril = keyValue.getId();
                    } else {
                        frequencyLisinopril = "";
                    }

                    if (drug.matches("Perindopril")) {
                        frequencyPerindopril = keyValue.getId();
                    } else {
                        frequencyPerindopril = "";
                    }

                    if (drug.matches("Ramipril")) {
                        frequencyRamipril = keyValue.getId();
                    } else {
                        frequencyRamipril = "";
                    }

                    if (drug.matches("Candesartan")) {
                        frequencyCandesartan = keyValue.getId();
                    } else {
                        frequencyCandesartan = "";
                    }

                    if (drug.matches("Irbesartan")) {
                        frequencyIrbesartan = keyValue.getId();
                    } else {
                        frequencyIrbesartan = "";
                    }

                    if (drug.matches("Losartan")) {
                        frequencyLosartan = keyValue.getId();
                    } else {
                        frequencyLosartan = "";
                    }

                    if (drug.matches("Telmisartan")) {
                        frequencyTelmisartan = keyValue.getId();
                    } else {
                        frequencyTelmisartan = "";
                    }

                    if (drug.matches("Valsartan")) {
                        frequencyValsartan = keyValue.getId();
                    } else {
                        frequencyValsartan = "";
                    }

                    if (drug.matches("Olmesartan")) {
                        frequencyOlmesartan = keyValue.getId();
                    } else {
                        frequencyOlmesartan = "";
                    }

                    if (drug.matches("Atenolol")) {
                        frequencyAtenolol = keyValue.getId();
                    } else {
                        frequencyAtenolol = "";
                    }

                    if (drug.matches("Labetolol")) {
                        frequencyLabetolol = keyValue.getId();
                    } else {
                        frequencyLabetolol = "";
                    }

                    if (drug.matches("Propranolol")) {
                        frequencyPropranolol = keyValue.getId();
                    } else {
                        frequencyPropranolol = "";
                    }

                    if (drug.matches("Carvedilol")) {
                        frequencyCarvedilol = keyValue.getId();
                    } else {
                        frequencyCarvedilol = "";
                    }

                    if (drug.matches("Nebivolol")) {
                        frequencyNebivolol = keyValue.getId();
                    } else {
                        frequencyNebivolol = "";
                    }

                    if (drug.matches("Metoprolol")) {
                        frequencyMetoprolol = keyValue.getId();
                    } else {
                        frequencyMetoprolol = "";
                    }

                    if (drug.matches("Bisoprolol")) {
                        frequencyBisoprolol = keyValue.getId();
                    } else {
                        frequencyBisoprolol = "";
                    }

                    if (drug.matches("Amlodipine")) {
                        frequencyAmlodipine = keyValue.getId();
                    } else {
                        frequencyAmlodipine = "";
                    }

                    if (drug.matches("Felodipine")) {
                        frequencyFelodipine = keyValue.getId();
                    } else {
                        frequencyFelodipine = "";
                    }

                    if (drug.matches("Nifedipine")) {
                        frequencyNifedipine = keyValue.getId();
                    } else {
                        frequencyNifedipine = "";
                    }

                    if (drug.matches("Methyldopa")) {
                        frequencyMethyldopa = keyValue.getId();
                    } else {
                        frequencyMethyldopa = "";
                    }

                    if (drug.matches("Hydralazine")) {
                        frequencyHydralazine = keyValue.getId();
                    } else {
                        frequencyHydralazine = "";
                    }

                    if (drug.matches("Prazocin")) {
                        frequencyPrazocin = keyValue.getId();
                    } else {
                        frequencyPrazocin = "";
                    }

                    if (drug.matches("Chlorthalidone")) {
                        frequencyChlorthalidone = keyValue.getId();
                    } else {
                        frequencyChlorthalidone = "";
                    }

                    if (drug.matches("Hydrochlorothia")) {
                        frequencyHydrochlorothia = keyValue.getId();
                    } else {
                        frequencyHydrochlorothia = "";
                    }

                    if (drug.matches("Indapamide")) {
                        frequencyIndapamide = keyValue.getId();
                    } else {
                        frequencyIndapamide = "";
                    }

                    updateValues();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }


    public void spinnerDoseData(Spinner spinner, String[] arraySpinner, final String drug) {
        //fill data in spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, arraySpinner);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //KeyValue value = (KeyValue) parent.getSelectedItem();
                String dose = parent.getSelectedItem().toString().replace("Select", "");
                dose = dose.replace("mg", "");
                dose = dose.replaceAll("\\s+", " ");

                if (!dose.isEmpty()) {
                    Log.d("Dose", dose + " ");

                    if (drug.matches("Metformin")) {
                        doseMetformin = dose;
                    } else {
                        doseMetformin = "";
                    }

                    if (drug.matches("Glibenclamide")) {
                        doseGlibenclamide = dose;
                    } else {
                        doseGlibenclamide = "";
                    }

                    if (drug.matches("Enalapril")) {
                        doseEnalapril = dose;
                    } else {
                        doseEnalapril = "";
                    }

                    if (drug.matches("Captopril")) {
                        doseCaptopril = dose;
                    } else {
                        doseCaptopril = "";
                    }

                    if (drug.matches("Lisinopril")) {
                        doseLisinopril = dose;
                    } else {
                        doseLisinopril = "";
                    }

                    if (drug.matches("Perindopril")) {
                        dosePerindopril = dose;
                    } else {
                        dosePerindopril = "";
                    }

                    if (drug.matches("Ramipril")) {
                        doseRamipril = dose;
                    } else {
                        doseRamipril = "";
                    }

                    if (drug.matches("Candesartan")) {
                        doseCandesartan = dose;
                    } else {
                        doseCandesartan = "";
                    }

                    if (drug.matches("Irbesartan")) {
                        doseIrbesartan = dose;
                    } else {
                        doseIrbesartan = "";
                    }

                    if (drug.matches("Losartan")) {
                        doseLosartan = dose;
                    } else {
                        doseLosartan = "";
                    }

                    if (drug.matches("Telmisartan")) {
                        doseTelmisartan = dose;
                    } else {
                        doseTelmisartan = "";
                    }

                    if (drug.matches("Valsartan")) {
                        doseValsartan = dose;
                    } else {
                        doseValsartan = "";
                    }

                    if (drug.matches("Olmesartan")) {
                        doseOlmesartan = dose;
                    } else {
                        doseOlmesartan = "";
                    }

                    if (drug.matches("Atenolol")) {
                        doseAtenolol = dose;
                    } else {
                        doseAtenolol = "";
                    }

                    if (drug.matches("Labetolol")) {
                        doseLabetolol = dose;
                    } else {
                        doseLabetolol = "";
                    }

                    if (drug.matches("Propranolol")) {
                        dosePropranolol = dose;
                    } else {
                        dosePropranolol = "";
                    }

                    if (drug.matches("Carvedilol")) {
                        doseCarvedilol = dose;
                    } else {
                        doseCarvedilol = "";
                    }

                    if (drug.matches("Nebivolol")) {
                        doseNebivolol = dose;
                    } else {
                        doseNebivolol = "";
                    }

                    if (drug.matches("Metoprolol")) {
                        doseMetoprolol = dose;
                    } else {
                        doseMetoprolol = "";
                    }

                    if (drug.matches("Bisoprolol")) {
                        doseBisoprolol = dose;
                    } else {
                        doseBisoprolol = "";
                    }

                    if (drug.matches("Amlodipine")) {
                        doseAmlodipine = dose;
                    } else {
                        doseAmlodipine = "";
                    }

                    if (drug.matches("Felodipine")) {
                        doseFelodipine = dose;
                    } else {
                        doseFelodipine = "";
                    }

                    if (drug.matches("Nifedipine")) {
                        doseNifedipine = dose;
                    } else {
                        doseNifedipine = "";
                    }

                    if (drug.matches("Methyldopa")) {
                        doseMethyldopa = dose;
                    } else {
                        doseMethyldopa = "";
                    }

                    if (drug.matches("Hydralazine")) {
                        doseHydralazine = dose;
                    } else {
                        doseHydralazine = "";
                    }

                    if (drug.matches("Prazocin")) {
                        dosePrazocin = dose;
                    } else {
                        dosePrazocin = "";
                    }

                    if (drug.matches("Chlorthalidone")) {
                        doseChlorthalidone = dose;
                    } else {
                        doseChlorthalidone = "";
                    }

                    if (drug.matches("Hydrochlorothia")) {
                        doseHydrochlorothia = dose;
                    } else {
                        doseHydrochlorothia = "";
                    }

                    if (drug.matches("Indapamide")) {
                        doseIndapamide = dose;
                    } else {
                        doseIndapamide = "";
                    }

                    updateValues();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void hideGroup(String group) {
        if (group.matches("ace")) {
            checkBoxCandesartan.setChecked(false);
            checkBoxIrbesartan.setChecked(false);
            checkBoxLosartan.setChecked(false);
            checkBoxTelmisartan.setChecked(false);
            checkBoxValsartan.setChecked(false);
            checkBoxOlmesartan.setChecked(false);
        } else if (group.matches("arb")) {
            checkBoxEnalapril.setChecked(false);
            checkBoxCaptopril.setChecked(false);
            checkBoxLisinopril.setChecked(false);
            checkBoxPerindopril.setChecked(false);
            checkBoxRamipril.setChecked(false);
        }

    }

    public void checkBoxTreatment(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();

                //Check which checkbox was clicked
                switch (checkBox.getId()) {
                    case R.id.treatment_metformin:
                        if (checked) {
                            Metformin = "79651";
                        } else {
                            Metformin = "";
                        }
                        break;
                    case R.id.treatment_glibenclamide:
                        if (checked) {
                            Glibenclamide = "77071";
                        } else {
                            Glibenclamide = "";
                        }
                        break;
                    case R.id.treatment_insulin:
                        if (checked) {
                            Insulin = "159459";
                        } else {
                            Insulin = "";
                        }
                        break;
                    case R.id.treatment_soluble_insulin:
                        if (checked) {
                            SolubleInsulin = "282";
                        } else {
                            SolubleInsulin = "";
                        }
                        break;
                    case R.id.treatment_nph:
                        if (checked) {
                            NPH = "78068";
                        } else {
                            NPH = "";
                        }
                        break;
                    case R.id.treatment_captopril:
                        if (checked) {
                            Captopril = "72806";
                            hideGroup("ace");
                        } else {
                            Captopril = "";
                        }
                        break;
                    case R.id.treatment_enalapril:
                        if (checked) {
                            Enalapril = "75633";
                            hideGroup("ace");
                        } else {
                            Enalapril = "";
                        }
                        break;
                    case R.id.treatment_lisinopril:
                        if (checked) {
                            Lisinopril = "78945";
                            hideGroup("ace");
                        } else {
                            Lisinopril = "";
                        }
                        break;
                    case R.id.treatment_perindopril:
                        if (checked) {
                            Perindopril = "81822";
                            hideGroup("ace");
                        } else {
                            Perindopril = "";
                        }
                        break;
                    case R.id.treatment_ramipril:
                        if (checked) {
                            Ramipril = "83067";
                            hideGroup("ace");
                        } else {
                            Ramipril = "";
                        }
                        break;
                    case R.id.treatment_candesartan:
                        if (checked) {
                            Candesartan = "72758";
                            hideGroup("arb");
                        } else {
                            Candesartan = "";
                        }
                        break;
                    case R.id.treatment_irbesartan:
                        if (checked) {
                            Irbesartan = "78210";
                            hideGroup("arb");
                        } else {
                            Irbesartan = "";
                        }
                        break;
                    case R.id.treatment_losartan:
                        if (checked) {
                            Losartan = "79074";
                            hideGroup("arb");
                        } else {
                            Losartan = "";
                        }
                        break;
                    case R.id.treatment_telmisartan:
                        if (checked) {
                            Telmisartan = "84764";
                            hideGroup("arb");
                        } else {
                            Telmisartan = "";
                        }
                        break;
                    case R.id.treatment_valsartan:
                        if (checked) {
                            Valsartan = "86056";
                            hideGroup("arb");
                        } else {
                            Valsartan = "";
                        }
                        break;
                    case R.id.treatment_olmesartan:
                        if (checked) {
                            Olmesartan = "165229";
                            hideGroup("arb");
                        } else {
                            Olmesartan = "";
                        }
                        break;
                    case R.id.treatment_atenolol:
                        if (checked) {
                            Atenolol = "71652";
                        } else {
                            Atenolol = "";
                        }
                        break;
                    case R.id.treatment_labetolol:
                        if (checked) {
                            Labetolol = "78599";
                        } else {
                            Labetolol = "";
                        }
                        break;
                    case R.id.treatment_propranolol:
                        if (checked) {
                            Propranolol = "82732";
                        } else {
                            Propranolol = "";
                        }
                        break;
                    case R.id.treatment_carvedilol:
                        if (checked) {
                            Carvedilol = "72944";
                        } else {
                            Carvedilol = "";
                        }
                        break;
                    case R.id.treatment_nebivolol:
                        if (checked) {
                            Nebivolol = "80470";
                        } else {
                            Nebivolol = "";
                        }
                        break;
                    case R.id.treatment_metoprolol:
                        if (checked) {
                            Metoprolol = "79764";
                        } else {
                            Metoprolol = "";
                        }
                        break;
                    case R.id.treatment_bisoprolol:
                        if (checked) {
                            Bisoprolol = "72247";
                        } else {
                            Bisoprolol = "";
                        }
                        break;
                    case R.id.treatment_amlodipine:
                        if (checked) {
                            Amlodipine = "71137";
                        } else {
                            Amlodipine = "";
                        }
                        break;
                    case R.id.treatment_felodipine:
                        if (checked) {
                            Felodipine = "76211";
                        } else {
                            Felodipine = "";
                        }
                        break;
                    case R.id.treatment_nifedipine:
                        if (checked) {
                            Nifedipine = "80637";
                        } else {
                            Nifedipine = "";
                        }
                        break;
                    case R.id.treatment_methyldopa:
                        if (checked) {
                            Methyldopa = "79723";
                        } else {
                            Methyldopa = "";
                        }
                        break;
                    case R.id.treatment_hydralazine:
                        if (checked) {
                            Hydralazine = "77675";
                        } else {
                            Hydralazine = "";
                        }
                        break;
                    case R.id.treatment_prazocin:
                        if (checked) {
                            Prazocin = "77985";
                        } else {
                            Prazocin = "";
                        }
                        break;
                    case R.id.treatment_chlorthalidone:
                        if (checked) {
                            Chlorthalidone = "73338";
                        } else {
                            Chlorthalidone = "";
                        }
                        break;
                    case R.id.treatment_hydrochlorothia:
                        if (checked) {
                            Hydrochlorothia = "77696";
                        } else {
                            Hydrochlorothia = "";
                        }
                        break;
                    case R.id.treatment_indapamide:
                        if (checked) {
                            Indapamide = "77985";
                        } else {
                            Indapamide = "";
                        }
                        break;
                    case R.id.treatment_diet:
                        if (checked) {
                            Diet = "165200";
                        } else {
                            Diet = "";
                        }
                        break;
                    case R.id.treatment_physical_exercise:
                        if (checked) {
                            PhysicalExercise = "159364";
                        } else {
                            PhysicalExercise = "";
                        }
                        break;
                    case R.id.treatment_herbal:
                        if (checked) {
                            Herbal = "165203";
                        } else {
                            Herbal = "";
                        }
                        break;
                    case R.id.treatment_other:
                        if (checked) {
                            TreatmentOther = "5622";
                        } else {
                            TreatmentOther = "";
                        }
                        break;
                }

                updateValues();
            }
        });

    }

    public void updateValues() {

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current_date = dateFormat.format(new Date());

        JSONArray jsonArry = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("1282", "165280", "valueCoded", Metformin, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165280", "valueCoded", doseMetformin, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165280", "valueCoded", frequencyMetformin, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165281", "valueCoded", Glibenclamide, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165281", "valueCoded", doseGlibenclamide, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165281", "valueCoded", frequencyGlibenclamide, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165282", "valueCoded", Insulin, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165282", "string", "", current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165283", "valueCoded", SolubleInsulin, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165283", "string", "", current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165284", "valueCoded", NPH, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165284", "string", "", current_date, ""));

        //ACE
        jsonArry.put(JSONFormBuilder.observations("1282", "165253", "valueCoded", Captopril, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165253", "valueCoded", doseCaptopril, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165253", "valueCoded", frequencyCaptopril, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165254", "valueCoded", Enalapril, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165254", "valueCoded", doseEnalapril, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165254", "valueCoded", frequencyEnalapril, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165255", "valueCoded", Lisinopril, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165255", "valueCoded", doseLisinopril, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165255", "valueCoded", frequencyLisinopril, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165256", "valueCoded", Perindopril, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165256", "valueCoded", dosePerindopril, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165256", "valueCoded", frequencyPerindopril, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165257", "valueCoded", Ramipril, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165257", "valueCoded", doseRamipril, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165257", "valueCoded", frequencyRamipril, current_date, ""));

        //ARB
        jsonArry.put(JSONFormBuilder.observations("1282", "165258", "valueCoded", Candesartan, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165258", "valueCoded", doseCandesartan, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165258", "valueCoded", frequencyCandesartan, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165259", "valueCoded", Irbesartan, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165259", "valueCoded", doseIrbesartan, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165259", "valueCoded", frequencyIrbesartan, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165260", "valueCoded", Losartan, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165260", "valueCoded", doseLosartan, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165260", "valueCoded", frequencyLosartan, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165261", "valueCoded", Telmisartan, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165261", "valueCoded", doseTelmisartan, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165261", "valueCoded", frequencyTelmisartan, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165262", "valueCoded", Valsartan, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165262", "valueCoded", doseValsartan, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165262", "valueCoded", frequencyValsartan, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165263", "valueCoded", Olmesartan, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165263", "valueCoded", doseOlmesartan, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165263", "valueCoded", frequencyOlmesartan, current_date, ""));

        //Beta Blockers
        jsonArry.put(JSONFormBuilder.observations("1282", "165264", "valueCoded", Atenolol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165264", "valueCoded", doseAtenolol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165264", "valueCoded", frequencyAtenolol, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165265", "valueCoded", Labetolol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165265", "valueCoded", doseLabetolol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165265", "valueCoded", frequencyLabetolol, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165266", "valueCoded", Propranolol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165266", "valueCoded", dosePropranolol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165266", "valueCoded", frequencyPropranolol, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165267", "valueCoded", Carvedilol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165267", "valueCoded", doseCarvedilol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165267", "valueCoded", frequencyCarvedilol, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165268", "valueCoded", Nebivolol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165268", "valueCoded", doseNebivolol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165268", "valueCoded", frequencyNebivolol, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165269", "valueCoded", Metoprolol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165269", "valueCoded", doseMetoprolol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165269", "valueCoded", frequencyMetoprolol, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165270", "valueCoded", Bisoprolol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165270", "valueCoded", doseBisoprolol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165270", "valueCoded", frequencyBisoprolol, current_date, ""));

        //Long Acting CCB
        jsonArry.put(JSONFormBuilder.observations("1282", "165271", "valueCoded", Amlodipine, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165271", "valueCoded", doseAmlodipine, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165271", "valueCoded", frequencyAmlodipine, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165272", "", Felodipine, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165272", "", doseFelodipine, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165272", "", frequencyFelodipine, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165273", "valueCoded", Nifedipine, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165273", "valueCoded", doseNifedipine, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165273", "valueCoded", frequencyNifedipine, current_date, ""));

        //AntiHypersensitives
        jsonArry.put(JSONFormBuilder.observations("1282", "165277", "valueCoded", Methyldopa, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165277", "valueCoded", doseMethyldopa, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165277", "valueCoded", frequencyMethyldopa, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165278", "valueCoded", Hydralazine, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165278", "valueCoded", doseHydralazine, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165278", "valueCoded", frequencyHydralazine, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165279", "valueCoded", Prazocin, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165279", "valueCoded", dosePrazocin, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165279", "valueCoded", frequencyPrazocin, current_date, ""));

        //Thizide
        jsonArry.put(JSONFormBuilder.observations("1282", "165274", "valueCoded", Chlorthalidone, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165274", "valueCoded", doseChlorthalidone, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165274", "valueCoded", frequencyChlorthalidone, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165275", "valueCoded", Hydrochlorothia, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165275", "valueCoded", doseHydrochlorothia, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165275", "valueCoded", frequencyHydrochlorothia, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165276", "valueCoded", Indapamide, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165276", "valueCoded", doseIndapamide, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165276", "valueCoded", frequencyIndapamide, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165142", "valueCoded", Diet, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165201", "165142", "string", "", current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165142", "valueCoded", PhysicalExercise, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165202", "165142", "string", "", current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165142", "valueCoded", Herbal, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165203", "165142", "string", "", current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165142", "valueCoded", TreatmentOther, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165204", "165142", "string", "", current_date, ""));

        //jsonArry.put(JSONFormBuilder.observations("161011", "", "string", editTextComment.getText().toString().trim(), current_date, ""));

        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Log.d("JSON Initial Page 5", jsonArry.toString() + " ");

        FragmentModelInitial.getInstance().initialFive(jsonArry);
    }

}
