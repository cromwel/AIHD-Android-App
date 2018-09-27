package org.aihdint.aihd.fragments.followup;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import org.aihdint.aihd.common.DateCalendar;
import org.aihdint.aihd.common.DrugsDose;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.aihdint.aihd.R;
import org.aihdint.aihd.common.checkBoxes.checkBoxes;
import org.aihdint.aihd.common.checkBoxes.checkBoxInterface;
import org.aihdint.aihd.model.KeyValue;
import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_4 extends Fragment implements checkBoxInterface {

    private CheckBox checkBoxEnalapril, checkBoxCaptopril, checkBoxLisinopril, checkBoxPerindopril, checkBoxRamipril;
    private CheckBox checkBoxCandesartan, checkBoxIrbesartan, checkBoxLosartan, checkBoxTelmisartan, checkBoxValsartan, checkBoxOlmesartan;

    private String Metformin, Glibenclamide, Insulin, SolubleInsulin, NPH, NPH2, Captopril, Enalapril, Lisinopril, Perindopril, Ramipril, Candesartan, Irbesartan, Losartan,
            Telmisartan, Valsartan, Olmesartan, Atenolol, Labetolol, Propranolol, Carvedilol, Nebivolol, Metoprolol, Bisoprolol, Amlodipine, Felodipine, Nifedipine,
            Chlorthalidone, Hydrochlorothia, Indapamide, Methyldopa, Hydralazine, Prazocin, Diet, PhysicalExercise, Herbal, TreatmentOther;

    private String doseMetformin, doseGlibenclamide, doseCaptopril, doseEnalapril, doseLisinopril, dosePerindopril, doseRamipril, doseCandesartan, doseIrbesartan, doseLosartan,
            doseTelmisartan, doseValsartan, doseOlmesartan, doseAtenolol, doseLabetolol, dosePropranolol, doseCarvedilol, doseNebivolol, doseMetoprolol, doseBisoprolol,
            doseAmlodipine, doseFelodipine, doseNifedipine, doseChlorthalidone, doseHydrochlorothia, doseIndapamide, doseMethyldopa, doseHydralazine, dosePrazocin;

    private String frequencyMetformin, frequencyGlibenclamide, frequencyCaptopril, frequencyEnalapril, frequencyLisinopril, frequencyPerindopril, frequencyRamipril,
            frequencyCandesartan, frequencyIrbesartan, frequencyLosartan, frequencyTelmisartan, frequencyValsartan, frequencyOlmesartan, frequencyAtenolol, frequencyLabetolol,
            frequencyPropranolol, frequencyCarvedilol, frequencyNebivolol, frequencyMetoprolol, frequencyBisoprolol, frequencyAmlodipine, frequencyFelodipine,
            frequencyNifedipine, frequencyChlorthalidone, frequencyHydrochlorothia, frequencyIndapamide, frequencyMethyldopa, frequencyHydralazine, frequencyPrazocin,
            frequencyInsulin, frequencySolubleInsulin, frequencyNPH1, frequencyNPH2;

    private String continueCare;
    private EditText editTextInsulin, editTextSolubleInsulin, editTextNPH1, editTextNPH2;
    private EditText editTextDiet, editTextExercise, editTextHerbal, editTextOther;
    private EditText editTextACE, editTextARB, editTextBeta, editTextCCB, editTextThiazide, editTextThiazideLike, editTextAntiHypertensives, editTextOGLA, editTextInsulinOther;

    private EditText editTextComment, editTextReturnDate, editTextReferralLocation, editTextReferralDate, editTextReferralNote, editTextClinician;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_followup_fragment_4, container, false);

        LinearLayout testLinearLayout = view.findViewById(R.id.testLinearLayout);
        testLinearLayout.setVisibility(View.GONE);

        editTextInsulin = view.findViewById(R.id.editTextInsulin);
        editTextSolubleInsulin = view.findViewById(R.id.editTextSolubleInsulin);
        editTextNPH1 = view.findViewById(R.id.editTextNPH1);
        editTextNPH2 = view.findViewById(R.id.editTextNPH2);

        editTextComment = view.findViewById(R.id.treatment_comment);
        editTextReturnDate = view.findViewById(R.id.followup_date);
        editTextReferralLocation = view.findViewById(R.id.referral_place);
        editTextReferralDate = view.findViewById(R.id.referral_date);
        editTextReferralNote = view.findViewById(R.id.referral_note);
        editTextClinician = view.findViewById(R.id.clinician);

        DateCalendar.date(getActivity(), editTextReturnDate);
        DateCalendar.date(getActivity(), editTextReferralDate);

        textWatcher(editTextComment);
        textWatcher(editTextReturnDate);
        textWatcher(editTextReferralLocation);
        textWatcher(editTextReferralDate);
        textWatcher(editTextReferralNote);
        textWatcher(editTextClinician);

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

        CheckBox checkBoxInsulin = view.findViewById(R.id.treatment_insulin);
        CheckBox checkBoxSolubleInsulin = view.findViewById(R.id.treatment_soluble_insulin);
        CheckBox checkBoxNPH = view.findViewById(R.id.treatment_nph);
        CheckBox checkBoxNPH2 = view.findViewById(R.id.treatment_nph_2);

        CheckBox checkBoxDiet = view.findViewById(R.id.treatment_diet);
        CheckBox checkBoxHerbal = view.findViewById(R.id.treatment_herbal);
        CheckBox checkBoxExercise = view.findViewById(R.id.treatment_physical_exercise);
        CheckBox checkBoxOther = view.findViewById(R.id.treatment_other);

        checkBoxes.checkBoxTreatment(checkBoxMetformin, this);
        checkBoxes.checkBoxTreatment(checkBoxGlibenclamide, this);

        checkBoxes.checkBoxTreatment(checkBoxCaptopril, this);
        checkBoxes.checkBoxTreatment(checkBoxEnalapril, this);
        checkBoxes.checkBoxTreatment(checkBoxLisinopril, this);
        checkBoxes.checkBoxTreatment(checkBoxPerindopril, this);
        checkBoxes.checkBoxTreatment(checkBoxRamipril, this);

        checkBoxes.checkBoxTreatment(checkBoxCandesartan, this);
        checkBoxes.checkBoxTreatment(checkBoxIrbesartan, this);
        checkBoxes.checkBoxTreatment(checkBoxLosartan, this);
        checkBoxes.checkBoxTreatment(checkBoxTelmisartan, this);
        checkBoxes.checkBoxTreatment(checkBoxValsartan, this);
        checkBoxes.checkBoxTreatment(checkBoxOlmesartan, this);

        checkBoxes.checkBoxTreatment(checkBoxAtenolol, this);
        checkBoxes.checkBoxTreatment(checkBoxLabetolol, this);
        checkBoxes.checkBoxTreatment(checkBoxPropranolol, this);
        checkBoxes.checkBoxTreatment(checkBoxCarvedilol, this);
        checkBoxes.checkBoxTreatment(checkBoxNebivolol, this);
        checkBoxes.checkBoxTreatment(checkBoxMetoprolol, this);
        checkBoxes.checkBoxTreatment(checkBoxBisoprolol, this);

        checkBoxes.checkBoxTreatment(checkBoxAmlodipine, this);
        checkBoxes.checkBoxTreatment(checkBoxFelodipine, this);
        checkBoxes.checkBoxTreatment(checkBoxNifedipine, this);

        checkBoxes.checkBoxTreatment(checkBoxChlorthalidone, this);
        checkBoxes.checkBoxTreatment(checkBoxHydrochlorothia, this);
        checkBoxes.checkBoxTreatment(checkBoxIndapamide, this);

        checkBoxes.checkBoxTreatment(checkBoxMethyldopa, this);
        checkBoxes.checkBoxTreatment(checkBoxHydralazine, this);
        checkBoxes.checkBoxTreatment(checkBoxPrazocin, this);
        checkBoxes.checkBoxTreatment(checkBoxDiet, this);

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

        spinnerDoseData(spinnerDrugCaptopril, DrugsDose.arraySpinnerCaptopril, "Captopril");
        spinnerDoseData(spinnerDrugEnalapril, DrugsDose.arraySpinnerEnalapril, "Enalapril");
        spinnerDoseData(spinnerDrugLisinopril, DrugsDose.arraySpinnerLisinopril, "Lisinopril");
        spinnerDoseData(spinnerDrugPerindopril, DrugsDose.arraySpinnerPerindopril, "Perindopril");
        spinnerDoseData(spinnerDrugRamipril, DrugsDose.arraySpinnerRamipril, "Ramipril");

        spinnerDoseData(spinnerDrugCandesartan, DrugsDose.arraySpinnerCandesartan, "Candesartan");
        spinnerDoseData(spinnerDrugIrbesartan, DrugsDose.arraySpinnerIrbesartan, "Irbesartan");
        spinnerDoseData(spinnerDrugLosartan, DrugsDose.arraySpinnerLosartan, "Losartan");
        spinnerDoseData(spinnerDrugTelmisartan, DrugsDose.arraySpinnerTelmisartan, "Telmisartan");
        spinnerDoseData(spinnerDrugValsartan, DrugsDose.arraySpinnerValsartan, "Valsartan");
        spinnerDoseData(spinnerDrugOlmesartan, DrugsDose.arraySpinnerOlmesartan, "Olmesartan");

        spinnerDoseData(spinnerDrugAtenolol, DrugsDose.arraySpinnerAtenolol, "Atenolol");
        spinnerDoseData(spinnerDrugLabetolol, DrugsDose.arraySpinnerLabetolol, "Labetolol");
        spinnerDoseData(spinnerDrugPropranolol, DrugsDose.arraySpinnerPropranolol, "Propranolol");
        spinnerDoseData(spinnerDrugCarvedilol, DrugsDose.arraySpinnerCarvedilol, "Carvedilol");
        spinnerDoseData(spinnerDrugNebivolol, DrugsDose.arraySpinnerNebivolol, "Nebivolol");
        spinnerDoseData(spinnerDrugMetoprolol, DrugsDose.arraySpinnerMetoprolol, "Metoprolol");
        spinnerDoseData(spinnerDrugBisoprolol, DrugsDose.arraySpinnerBisoprolol, "Bisoprolol");

        spinnerDoseData(spinnerDrugAmlodipine, DrugsDose.arraySpinnerAmlodipine, "Amlodipine");
        spinnerDoseData(spinnerDrugFelodipine, DrugsDose.arraySpinnerFelodipine, "Felodipine");
        spinnerDoseData(spinnerDrugNifedipine, DrugsDose.arraySpinnerNifedipine, "Nifedipine");

        spinnerDoseData(spinnerDrugChlorthalidone, DrugsDose.arraySpinnerChlorthalidone, "Chlorthalidone");
        spinnerDoseData(spinnerDrugHydrochlorothia, DrugsDose.arraySpinnerHydrochlorothia, "Hydrochlorothia");
        spinnerDoseData(spinnerDrugIndapamide, DrugsDose.arraySpinnerIndapamide, "Indapamide");

        spinnerDoseData(spinnerDrugMethyldopa, DrugsDose.arraySpinnerMethyldopa, "Methyldopa");
        spinnerDoseData(spinnerDrugHydralazine, DrugsDose.arraySpinnerHydralazine, "Hydralazine");
        spinnerDoseData(spinnerDrugPrazocin, DrugsDose.arraySpinnerPrazocin, "Prazocin");
        spinnerDoseData(spinnerDrugMetformin, DrugsDose.arraySpinnerMetformin, "Metformin");
        spinnerDoseData(spinnerDrugGlibenclamide, DrugsDose.arraySpinnerGlibenclamide, "Glibenclamide");

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


        return view;
    }

    public void textWatcher(EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(final Editable editable) {
                updateValues();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });
    }


    public void spinnerDataFrequency(final Spinner spinner, final String drug) {
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

                    switch (spinner.getId()) {
                        case R.id.spinnerDrugMetforminFrq:
                            if (drug.matches("Metformin")) {
                                frequencyMetformin = keyValue.getId();
                            } else {
                                frequencyMetformin = "";
                            }
                            break;
                        case R.id.spinnerDrugGlibenclamideFrq:
                            if (drug.matches("Glibenclamide")) {
                                frequencyGlibenclamide = keyValue.getId();
                            } else {
                                frequencyGlibenclamide = "";
                            }
                            break;
                        case R.id.spinnerDrugEnalaprilFrq:
                            if (drug.matches("Enalapril")) {
                                frequencyEnalapril = keyValue.getId();
                            } else {
                                frequencyEnalapril = "";
                            }
                            break;
                        case R.id.spinnerDrugCaptoprilFrq:
                            if (drug.matches("Captopril")) {
                                frequencyCaptopril = keyValue.getId();
                            } else {
                                frequencyCaptopril = "";
                            }
                            break;
                        case R.id.spinnerDrugLisinoprilFrq:
                            if (drug.matches("Lisinopril")) {
                                frequencyLisinopril = keyValue.getId();
                            } else {
                                frequencyLisinopril = "";
                            }
                            break;
                        case R.id.spinnerDrugPerindoprilFrq:
                            if (drug.matches("Perindopril")) {
                                frequencyPerindopril = keyValue.getId();
                            } else {
                                frequencyPerindopril = "";
                            }
                            break;
                        case R.id.spinnerDrugRamiprilFrq:
                            if (drug.matches("Ramipril")) {
                                frequencyRamipril = keyValue.getId();
                            } else {
                                frequencyRamipril = "";
                            }
                            break;
                        case R.id.spinnerDrugCandesartanFrq:
                            if (drug.matches("Candesartan")) {
                                frequencyCandesartan = keyValue.getId();
                            } else {
                                frequencyCandesartan = "";
                            }
                            break;
                        case R.id.spinnerDrugIrbesartanFrq:
                            if (drug.matches("Irbesartan")) {
                                frequencyIrbesartan = keyValue.getId();
                            } else {
                                frequencyIrbesartan = "";
                            }
                            break;
                        case R.id.spinnerDrugLosartanFrq:
                            if (drug.matches("Losartan")) {
                                frequencyLosartan = keyValue.getId();
                            } else {
                                frequencyLosartan = "";
                            }
                            break;
                        case R.id.spinnerDrugTelmisartanFrq:
                            if (drug.matches("Telmisartan")) {
                                frequencyTelmisartan = keyValue.getId();
                            } else {
                                frequencyTelmisartan = "";
                            }
                            break;
                        case R.id.spinnerDrugValsartanFrq:
                            if (drug.matches("Valsartan")) {
                                frequencyValsartan = keyValue.getId();
                            } else {
                                frequencyValsartan = "";
                            }
                            break;
                        case R.id.spinnerDrugOlmesartanFrq:
                            if (drug.matches("Olmesartan")) {
                                frequencyOlmesartan = keyValue.getId();
                            } else {
                                frequencyOlmesartan = "";
                            }
                            break;
                        case R.id.spinnerDrugAtenololFrq:
                            if (drug.matches("Atenolol")) {
                                frequencyAtenolol = keyValue.getId();
                            } else {
                                frequencyAtenolol = "";
                            }
                            break;
                        case R.id.spinnerDrugLabetololFrq:
                            if (drug.matches("Labetolol")) {
                                frequencyLabetolol = keyValue.getId();
                            } else {
                                frequencyLabetolol = "";
                            }
                            break;
                        case R.id.spinnerDrugPropranololFrq:
                            if (drug.matches("Propranolol")) {
                                frequencyPropranolol = keyValue.getId();
                            } else {
                                frequencyPropranolol = "";
                            }
                            break;
                        case R.id.spinnerDrugCarvedilolFrq:
                            if (drug.matches("Carvedilol")) {
                                frequencyCarvedilol = keyValue.getId();
                            } else {
                                frequencyCarvedilol = "";
                            }
                            break;
                        case R.id.spinnerDrugNebivololFrq:
                            if (drug.matches("Nebivolol")) {
                                frequencyNebivolol = keyValue.getId();
                            } else {
                                frequencyNebivolol = "";
                            }
                            break;
                        case R.id.spinnerDrugMetoprololFrq:
                            if (drug.matches("Metoprolol")) {
                                frequencyMetoprolol = keyValue.getId();
                            } else {
                                frequencyMetoprolol = "";
                            }
                            break;
                        case R.id.spinnerDrugBisoprololFrq:
                            if (drug.matches("Bisoprolol")) {
                                frequencyBisoprolol = keyValue.getId();
                            } else {
                                frequencyBisoprolol = "";
                            }
                            break;
                        case R.id.spinnerDrugAmlodipineFrq:
                            if (drug.matches("Amlodipine")) {
                                frequencyAmlodipine = keyValue.getId();
                            } else {
                                frequencyAmlodipine = "";
                            }
                            break;
                        case R.id.spinnerDrugFelodipineFrq:
                            if (drug.matches("Felodipine")) {
                                frequencyFelodipine = keyValue.getId();
                            } else {
                                frequencyFelodipine = "";
                            }
                            break;
                        case R.id.spinnerDrugNifedipineFrq:
                            if (drug.matches("Nifedipine")) {
                                frequencyNifedipine = keyValue.getId();
                            } else {
                                frequencyNifedipine = "";
                            }
                            break;
                        case R.id.spinnerDrugMethyldopaFrq:
                            if (drug.matches("Methyldopa")) {
                                frequencyMethyldopa = keyValue.getId();
                            } else {
                                frequencyMethyldopa = "";
                            }

                            break;
                        case R.id.spinnerDrugHydralazineFrq:
                            if (drug.matches("Hydralazine")) {
                                frequencyHydralazine = keyValue.getId();
                            } else {
                                frequencyHydralazine = "";
                            }
                            break;
                        case R.id.spinnerDrugPrazocinFrq:
                            if (drug.matches("Prazocin")) {
                                frequencyPrazocin = keyValue.getId();
                            } else {
                                frequencyPrazocin = "";
                            }
                            break;
                        case R.id.spinnerDrugChlorthalidoneFrq:
                            if (drug.matches("Chlorthalidone")) {
                                frequencyChlorthalidone = keyValue.getId();
                            } else {
                                frequencyChlorthalidone = "";
                            }
                            break;
                        case R.id.spinnerDrugHydrochlorothiaFrq:
                            if (drug.matches("Hydrochlorothia")) {
                                frequencyHydrochlorothia = keyValue.getId();
                            } else {
                                frequencyHydrochlorothia = "";
                            }
                            break;
                        case R.id.spinnerDrugIndapamideFrq:
                            if (drug.matches("Indapamide")) {
                                frequencyIndapamide = keyValue.getId();
                            } else {
                                frequencyIndapamide = "";
                            }
                            break;
                        default:
                            break;
                    }


                    updateValues();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }


    public void spinnerDoseData(final Spinner spinner, String[] arraySpinner, final String drug) {
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

                    switch (spinner.getId()) {
                        case R.id.spinnerDrugMetformin:
                            if (drug.matches("Metformin")) {
                                doseMetformin = dose;
                            } else {
                                doseMetformin = "";
                            }
                            break;
                        case R.id.spinnerDrugGlibenclamide:
                            if (drug.matches("Glibenclamide")) {
                                doseGlibenclamide = dose;
                            } else {
                                doseGlibenclamide = "";
                            }
                            break;
                        case R.id.spinnerDrugEnalapril:
                            if (drug.matches("Enalapril")) {
                                doseEnalapril = dose;
                            } else {
                                doseEnalapril = "";
                            }
                            break;
                        case R.id.spinnerDrugCaptopril:
                            if (drug.matches("Captopril")) {
                                doseCaptopril = dose;
                            } else {
                                doseCaptopril = "";
                            }
                            break;
                        case R.id.spinnerDrugLisinopril:
                            if (drug.matches("Lisinopril")) {
                                doseLisinopril = dose;
                            } else {
                                doseLisinopril = "";
                            }
                            break;
                        case R.id.spinnerDrugPerindopril:
                            if (drug.matches("Perindopril")) {
                                dosePerindopril = dose;
                            } else {
                                dosePerindopril = "";
                            }
                            break;
                        case R.id.spinnerDrugRamipril:
                            if (drug.matches("Ramipril")) {
                                doseRamipril = dose;
                            } else {
                                doseRamipril = "";
                            }
                            break;
                        case R.id.spinnerDrugCandesartan:
                            if (drug.matches("Candesartan")) {
                                doseCandesartan = dose;
                            } else {
                                doseCandesartan = "";
                            }
                            break;
                        case R.id.spinnerDrugIrbesartan:
                            if (drug.matches("Irbesartan")) {
                                doseIrbesartan = dose;
                            } else {
                                doseIrbesartan = "";
                            }
                            break;
                        case R.id.spinnerDrugLosartan:
                            if (drug.matches("Losartan")) {
                                doseLosartan = dose;
                            } else {
                                doseLosartan = "";
                            }
                            break;
                        case R.id.spinnerDrugTelmisartan:
                            if (drug.matches("Telmisartan")) {
                                doseTelmisartan = dose;
                            } else {
                                doseTelmisartan = "";
                            }
                            break;
                        case R.id.spinnerDrugValsartan:
                            if (drug.matches("Valsartan")) {
                                doseValsartan = dose;
                            } else {
                                doseValsartan = "";
                            }
                            break;
                        case R.id.spinnerDrugOlmesartan:
                            if (drug.matches("Olmesartan")) {
                                doseOlmesartan = dose;
                            } else {
                                doseOlmesartan = "";
                            }
                            break;
                        case R.id.spinnerDrugAtenolol:
                            if (drug.matches("Atenolol")) {
                                doseAtenolol = dose;
                            } else {
                                doseAtenolol = "";
                            }
                            break;
                        case R.id.spinnerDrugLabetolol:
                            if (drug.matches("Labetolol")) {
                                doseLabetolol = dose;
                            } else {
                                doseLabetolol = "";
                            }
                            break;
                        case R.id.spinnerDrugPropranolol:
                            if (drug.matches("Propranolol")) {
                                dosePropranolol = dose;
                            } else {
                                dosePropranolol = "";
                            }
                            break;
                        case R.id.spinnerDrugCarvedilol:
                            if (drug.matches("Carvedilol")) {
                                doseCarvedilol = dose;
                            } else {
                                doseCarvedilol = "";
                            }
                            break;
                        case R.id.spinnerDrugNebivolol:
                            if (drug.matches("Nebivolol")) {
                                doseNebivolol = dose;
                            } else {
                                doseNebivolol = "";
                            }
                            break;
                        case R.id.spinnerDrugMetoprolol:
                            if (drug.matches("Metoprolol")) {
                                doseMetoprolol = dose;
                            } else {
                                doseMetoprolol = "";
                            }
                            break;
                        case R.id.spinnerDrugBisoprolol:
                            if (drug.matches("Bisoprolol")) {
                                doseBisoprolol = dose;
                            } else {
                                doseBisoprolol = "";
                            }
                            break;
                        case R.id.spinnerDrugAmlodipine:
                            if (drug.matches("Amlodipine")) {
                                doseAmlodipine = dose;
                            } else {
                                doseAmlodipine = "";
                            }
                            break;
                        case R.id.spinnerDrugFelodipine:
                            if (drug.matches("Felodipine")) {
                                doseFelodipine = dose;
                            } else {
                                doseFelodipine = "";
                            }
                            break;
                        case R.id.spinnerDrugNifedipine:
                            if (drug.matches("Nifedipine")) {
                                doseNifedipine = dose;
                            } else {
                                doseNifedipine = "";
                            }
                            break;
                        case R.id.spinnerDrugMethyldopa:
                            if (drug.matches("Methyldopa")) {
                                doseMethyldopa = dose;
                            } else {
                                doseMethyldopa = "";
                            }

                            break;
                        case R.id.spinnerDrugHydralazine:
                            if (drug.matches("Hydralazine")) {
                                doseHydralazine = dose;
                            } else {
                                doseHydralazine = "";
                            }
                            break;
                        case R.id.spinnerDrugPrazocin:
                            if (drug.matches("Prazocin")) {
                                dosePrazocin = dose;
                            } else {
                                dosePrazocin = "";
                            }
                            break;
                        case R.id.spinnerDrugChlorthalidone:
                            if (drug.matches("Chlorthalidone")) {
                                doseChlorthalidone = dose;
                            } else {
                                doseChlorthalidone = "";
                            }
                            break;
                        case R.id.spinnerDrugHydrochlorothia:
                            if (drug.matches("Hydrochlorothia")) {
                                doseHydrochlorothia = dose;
                            } else {
                                doseHydrochlorothia = "";
                            }
                            break;
                        case R.id.spinnerDrugIndapamide:
                            if (drug.matches("Indapamide")) {
                                doseIndapamide = dose;
                            } else {
                                doseIndapamide = "";
                            }
                            break;
                        default:
                            break;


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


    @Override
    public void checkBoxClick(String val, CheckBox checkBox) {
        switch (checkBox.getId()) {
            case R.id.treatment_metformin:
                Metformin = val;
                break;
            case R.id.treatment_glibenclamide:
                Glibenclamide = val;
                break;
            case R.id.treatment_insulin:
                Insulin = val;
                break;
            case R.id.treatment_soluble_insulin:
                SolubleInsulin = val;
                break;
            case R.id.treatment_nph:
                NPH = val;
                break;
            case R.id.treatment_nph_2:
                NPH2 = val;
                break;
            case R.id.treatment_captopril:
                hideGroup("ace");
                Captopril = val;
                break;
            case R.id.treatment_enalapril:
                hideGroup("ace");
                Enalapril = val;
                break;
            case R.id.treatment_lisinopril:
                hideGroup("ace");
                Lisinopril = val;
                break;
            case R.id.treatment_perindopril:
                hideGroup("ace");
                Perindopril = val;
                break;
            case R.id.treatment_ramipril:
                hideGroup("ace");
                Ramipril = val;
                break;
            case R.id.treatment_candesartan:
                hideGroup("arb");
                Candesartan = val;
                break;
            case R.id.treatment_irbesartan:
                hideGroup("arb");
                Irbesartan = val;
                break;
            case R.id.treatment_losartan:
                hideGroup("arb");
                Losartan = val;
                break;
            case R.id.treatment_telmisartan:
                hideGroup("arb");
                Telmisartan = val;
                break;
            case R.id.treatment_valsartan:
                hideGroup("arb");
                Valsartan = val;
                break;
            case R.id.treatment_olmesartan:
                hideGroup("arb");
                Olmesartan = val;
                break;
            case R.id.treatment_atenolol:
                Atenolol = val;
                break;
            case R.id.treatment_labetolol:
                Labetolol = val;
                break;
            case R.id.treatment_propranolol:
                Propranolol = val;
                break;
            case R.id.treatment_carvedilol:
                Carvedilol = val;
                break;
            case R.id.treatment_nebivolol:
                Nebivolol = val;
                break;
            case R.id.treatment_metoprolol:
                Metoprolol = val;
                break;
            case R.id.treatment_bisoprolol:
                Bisoprolol = val;
                break;
            case R.id.treatment_amlodipine:
                Amlodipine = val;
                break;
            case R.id.treatment_felodipine:
                Felodipine = val;
                break;
            case R.id.treatment_nifedipine:
                Nifedipine = val;
                break;
            case R.id.treatment_methyldopa:
                Methyldopa = val;
                break;
            case R.id.treatment_hydralazine:
                Hydralazine = val;
                break;
            case R.id.treatment_prazocin:
                Prazocin = val;
                break;
            case R.id.treatment_chlorthalidone:
                Chlorthalidone = val;
                break;
            case R.id.treatment_hydrochlorothia:
                Hydrochlorothia = val;
                break;
            case R.id.treatment_indapamide:
                Indapamide = val;
                break;
            case R.id.treatment_diet:
                Diet = val;
                break;
            case R.id.treatment_physical_exercise:
                PhysicalExercise = val;
                break;
            case R.id.treatment_herbal:
                Herbal = val;
                break;
            case R.id.treatment_other:
                TreatmentOther = val;
                break;
            case R.id.followup_continue:
                continueCare = val;
                break;
            default:
                break;
        }

        updateValues();
    }

    public void updateValues() {

        JSONArray jsonArry = new JSONArray();

        try {
            //OGLA's'
            jsonArry.put(JSONFormBuilder.observations("1282", "165280", "valueCoded", Metformin, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165280", "valueNumeric", doseMetformin, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165280", "valueCoded", frequencyMetformin, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165281", "valueCoded", Glibenclamide, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165281", "valueNumeric", doseGlibenclamide, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165281", "valueCoded", frequencyGlibenclamide, DateCalendar.date(), ""));

            //Insulin
            jsonArry.put(JSONFormBuilder.observations("1282", "165282", "valueCoded", Insulin, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165282", "valueNumeric", editTextInsulin.getText().toString(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165282", "valueCoded", frequencyInsulin, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165283", "valueCoded", SolubleInsulin, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165283", "valueNumeric", editTextSolubleInsulin.getText().toString(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165283", "valueCoded", frequencySolubleInsulin, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165285", "valueCoded", NPH, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165285", "valueNumeric", editTextNPH1.getText().toString(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165285", "valueCoded", frequencyNPH1, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165286", "valueCoded", NPH2, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165286", "valueNumeric", editTextNPH2.getText().toString(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165286", "valueCoded", frequencyNPH2, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("160855", "165311", "valueCoded", editTextInsulinOther.getText().toString(), DateCalendar.date(), ""));
            //ACE
            jsonArry.put(JSONFormBuilder.observations("1282", "165253", "valueCoded", Captopril, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165253", "valueNumeric", doseCaptopril, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165253", "valueCoded", frequencyCaptopril, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165254", "valueCoded", Enalapril, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165254", "valueNumeric", doseEnalapril, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165254", "valueCoded", frequencyEnalapril, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165255", "valueCoded", Lisinopril, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165255", "valueNumeric", doseLisinopril, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165255", "valueCoded", frequencyLisinopril, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165256", "valueCoded", Perindopril, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165256", "valueNumeric", dosePerindopril, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165256", "valueCoded", frequencyPerindopril, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165257", "valueCoded", Ramipril, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165257", "valueNumeric", doseRamipril, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165257", "valueCoded", frequencyRamipril, DateCalendar.date(), ""));

            //ARB
            jsonArry.put(JSONFormBuilder.observations("1282", "165258", "valueCoded", Candesartan, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165258", "valueNumeric", doseCandesartan, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165258", "valueCoded", frequencyCandesartan, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165259", "valueCoded", Irbesartan, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165259", "valueNumeric", doseIrbesartan, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165259", "valueCoded", frequencyIrbesartan, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165260", "valueCoded", Losartan, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165260", "valueNumeric", doseLosartan, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165260", "valueCoded", frequencyLosartan, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165261", "valueCoded", Telmisartan, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165261", "valueNumeric", doseTelmisartan, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165261", "valueCoded", frequencyTelmisartan, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165262", "valueCoded", Valsartan, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165262", "valueNumeric", doseValsartan, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165262", "valueCoded", frequencyValsartan, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165263", "valueCoded", Olmesartan, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165263", "valueNumeric", doseOlmesartan, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165263", "valueCoded", frequencyOlmesartan, DateCalendar.date(), ""));

            //Beta Blockers
            jsonArry.put(JSONFormBuilder.observations("1282", "165264", "valueCoded", Atenolol, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165264", "valueNumeric", doseAtenolol, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165264", "valueCoded", frequencyAtenolol, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165265", "valueCoded", Labetolol, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165265", "valueNumeric", doseLabetolol, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165265", "valueCoded", frequencyLabetolol, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165266", "valueCoded", Propranolol, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165266", "valueNumeric", dosePropranolol, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165266", "valueCoded", frequencyPropranolol, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165267", "valueCoded", Carvedilol, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165267", "valueNumeric", doseCarvedilol, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165267", "valueCoded", frequencyCarvedilol, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165268", "valueCoded", Nebivolol, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165268", "valueNumeric", doseNebivolol, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165268", "valueCoded", frequencyNebivolol, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165269", "valueCoded", Metoprolol, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165269", "valueNumeric", doseMetoprolol, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165269", "valueCoded", frequencyMetoprolol, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165270", "valueCoded", Bisoprolol, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165270", "valueNumeric", doseBisoprolol, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165270", "valueCoded", frequencyBisoprolol, DateCalendar.date(), ""));

            //Long Acting CCB
            jsonArry.put(JSONFormBuilder.observations("1282", "165271", "valueCoded", Amlodipine, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165271", "valueCoded", doseAmlodipine, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165271", "valueCoded", frequencyAmlodipine, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165272", "", Felodipine, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165272", "valueNumeric", doseFelodipine, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165272", "", frequencyFelodipine, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165273", "valueCoded", Nifedipine, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165273", "valueNumeric", doseNifedipine, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165273", "valueCoded", frequencyNifedipine, DateCalendar.date(), ""));

            //AntiHypersensitives
            jsonArry.put(JSONFormBuilder.observations("1282", "165277", "valueCoded", Methyldopa, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165277", "valueNumeric", doseMethyldopa, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165277", "valueCoded", frequencyMethyldopa, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165278", "valueCoded", Hydralazine, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165278", "valueNumeric", doseHydralazine, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165278", "valueCoded", frequencyHydralazine, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165279", "valueCoded", Prazocin, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165279", "valueNumeric", dosePrazocin, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165279", "valueCoded", frequencyPrazocin, DateCalendar.date(), ""));

            //Thizide
            jsonArry.put(JSONFormBuilder.observations("1282", "165274", "valueCoded", Chlorthalidone, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165274", "valueNumeric", doseChlorthalidone, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165274", "valueCoded", frequencyChlorthalidone, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165275", "valueCoded", Hydrochlorothia, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165275", "valueNumeric", doseHydrochlorothia, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165275", "valueCoded", frequencyHydrochlorothia, DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165276", "valueCoded", Indapamide, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1443", "165276", "valueNumeric", doseIndapamide, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("160855", "165276", "valueCoded", frequencyIndapamide, DateCalendar.date(), ""));

            //other
            jsonArry.put(JSONFormBuilder.observations("1282", "165142", "valueCoded", Diet, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("165201", "165142", "valueText", "", DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165142", "valueCoded", PhysicalExercise, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("165202", "165142", "valueText", "", DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165142", "valueCoded", Herbal, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("165203", "165142", "valueText", "", DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("1282", "165142", "valueCoded", TreatmentOther, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("165204", "165142", "valueText", "", DateCalendar.date(), ""));

            jsonArry.put(JSONFormBuilder.observations("161011", "", "valueText", editTextComment.getText().toString().trim(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("165122", "", "valueCoded", continueCare, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("5096", "", "valueDate", editTextReturnDate.getText().toString(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("161562", "", "valueText", editTextReferralLocation.getText().toString().trim(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("163181", "", "valueText", editTextReferralDate.getText().toString().trim(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("165189", "", "valueText", editTextReferralNote.getText().toString().trim(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1473", "", "valueText", editTextClinician.getText().toString().trim(), DateCalendar.date(), ""));


            jsonArry = JSONFormBuilder.concatArray(jsonArry);

            Log.d("JSON FollowUp Page 4", jsonArry.toString() + " ");

            FragmentModelFollowUp.getInstance().followUpFour(jsonArry);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}