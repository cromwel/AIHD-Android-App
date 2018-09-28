package org.aihdint.aihd.common.variables;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.EditText;

public class DrugsDose {

    private Context mContext;

    public DrugsDose(Context mContext) {
        this.mContext = mContext;
    }

    public CheckBox checkBoxEnalapril, checkBoxCaptopril, checkBoxLisinopril, checkBoxPerindopril, checkBoxRamipril;
    public CheckBox checkBoxCandesartan, checkBoxIrbesartan, checkBoxLosartan, checkBoxTelmisartan, checkBoxValsartan, checkBoxOlmesartan;

    public String Metformin, Glibenclamide, Insulin, SolubleInsulin, NPH, NPH2, Captopril, Enalapril, Lisinopril, Perindopril, Ramipril, Candesartan, Irbesartan, Losartan,
            Telmisartan, Valsartan, Olmesartan, Atenolol, Labetolol, Propranolol, Carvedilol, Nebivolol, Metoprolol, Bisoprolol, Amlodipine, Felodipine, Nifedipine,
            Chlorthalidone, Hydrochlorothia, Indapamide, Methyldopa, Hydralazine, Prazocin, Diet, PhysicalExercise, Herbal, TreatmentOther;

    public String doseMetformin, doseGlibenclamide, doseCaptopril, doseEnalapril, doseLisinopril, dosePerindopril, doseRamipril, doseCandesartan, doseIrbesartan, doseLosartan,
            doseTelmisartan, doseValsartan, doseOlmesartan, doseAtenolol, doseLabetolol, dosePropranolol, doseCarvedilol, doseNebivolol, doseMetoprolol, doseBisoprolol,
            doseAmlodipine, doseFelodipine, doseNifedipine, doseChlorthalidone, doseHydrochlorothia, doseIndapamide, doseMethyldopa, doseHydralazine, dosePrazocin;

    public String frequencyMetformin, frequencyGlibenclamide, frequencyCaptopril, frequencyEnalapril, frequencyLisinopril, frequencyPerindopril, frequencyRamipril,
            frequencyCandesartan, frequencyIrbesartan, frequencyLosartan, frequencyTelmisartan, frequencyValsartan, frequencyOlmesartan, frequencyAtenolol, frequencyLabetolol,
            frequencyPropranolol, frequencyCarvedilol, frequencyNebivolol, frequencyMetoprolol, frequencyBisoprolol, frequencyAmlodipine, frequencyFelodipine,
            frequencyNifedipine, frequencyChlorthalidone, frequencyHydrochlorothia, frequencyIndapamide, frequencyMethyldopa, frequencyHydralazine, frequencyPrazocin,
            frequencyInsulin, frequencySolubleInsulin, frequencyNPH1, frequencyNPH2;

    public String continueCare, urinalysis, hba, microalbumin, creatinine, potassium, ecg, treatmentTest;

    public EditText editTextInsulin, editTextSolubleInsulin, editTextNPH1, editTextNPH2;
    public EditText editTextDiet, editTextPhysicalExercise, editTextHerbal, editTextTreatmentOther, editTextComment;
    public EditText editTextACE, editTextARB, editTextBeta, editTextCCB, editTextThiazide, editTextThiazideLike, editTextAntiHypertensives, editTextOGLA, editTextInsulinOther;
    public EditText editTextReturnDate, editTextReferralLocation, editTextReferralDate, editTextReferralNote, editTextClinician;

    //SpinnerDose
    public static final String[] arraySpinnerCaptopril = new String[]{"Select", "5mg", "25mg", "50mg"};
    public static final String[] arraySpinnerEnalapril = new String[]{"Select", "5mg", "10mg", "20mg"};
    public static final String[] arraySpinnerLisinopril = new String[]{"Select", "20mg ", "40mg"};
    public static final String[] arraySpinnerPerindopril = new String[]{"Select", "2mg ", "4mg", "5mg", "8mg", "10mg"};
    public static final String[] arraySpinnerRamipril = new String[]{"Select", "1.25mg", "2.5mg", "10mg"};

    public static final String[] arraySpinnerCandesartan = new String[]{"Select", "4mg", "8mg", "16mg", "32mg"};
    public static final String[] arraySpinnerIrbesartan = new String[]{"Select", "75mg", "150mg ", "300mg"};
    public static final String[] arraySpinnerLosartan = new String[]{"Select", "50mg", "100mg"};
    public static final String[] arraySpinnerTelmisartan = new String[]{"Select", "20mg", "40mg", "80mg"};
    public static final String[] arraySpinnerValsartan = new String[]{"Select", "40mg", "80mg ", "160mg", "320mg"};
    public static final String[] arraySpinnerOlmesartan = new String[]{"Select", "5mg", "20mg", "40mg"};

    public static final String[] arraySpinnerAtenolol = new String[]{"Select", "25mg", "50mg", "100mg"};
    public static final String[] arraySpinnerLabetolol = new String[]{"Select", "100mg", "200mg", "300mg"};
    public static final String[] arraySpinnerPropranolol = new String[]{"Select", "40mg", "80mg"};
    public static final String[] arraySpinnerCarvedilol = new String[]{"Select", "3.125mg", "6.25mg", "12.5mg", "10mg", "20mg", "25mg ", "40mg", "80mg"};
    public static final String[] arraySpinnerNebivolol = new String[]{"Select", "2.5mg", "5mg", "10mg", "20mg"};
    public static final String[] arraySpinnerMetoprolol = new String[]{"Select", "25mg", "37.5mg", "50mg", "75mg", "100mg ", "200mg"};
    public static final String[] arraySpinnerBisoprolol = new String[]{"Select", "5mg", "10mg"};

    public static final String[] arraySpinnerAmlodipine = new String[]{"Select", "2.5mg", "5mg", "10mg"};
    public static final String[] arraySpinnerFelodipine = new String[]{"Select", "2.5mg", "5mg", "10mg"};
    public static final String[] arraySpinnerNifedipine = new String[]{"Select", "10mg", "20mg"};

    public static final String[] arraySpinnerChlorthalidone = new String[]{"Select", "25mg", "50mg"};
    public static final String[] arraySpinnerHydrochlorothia = new String[]{"Select", "12.5mg ", "25mg"};
    public static final String[] arraySpinnerIndapamide = new String[]{"Select", "1.5mg", "2.5mg", "5mg"};

    public static final String[] arraySpinnerMethyldopa = new String[]{"Select", "250mg", "500mg"};
    public static final String[] arraySpinnerHydralazine = new String[]{"Select", "25mg",};
    public static final String[] arraySpinnerPrazocin = new String[]{"Select", "0.5mg", "1mg"};

    public static final String[] arraySpinnerMetformin = new String[]{"Select", "500mg", "850mg", "1000mg"};
    public static final String[] arraySpinnerGlibenclamide = new String[]{"Select", "5mg"};

}
