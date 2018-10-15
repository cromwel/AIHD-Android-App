package org.aihdint.aihd.common.json;

import org.aihdint.aihd.common.DateCalendar;
import org.aihdint.aihd.common.variables.DrugsDose;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.json.JSONArray;

public class JsonDrugs {

    public static JSONArray jsonArrayDrugs(DrugsDose drugsDose, JSONArray jsonArry) {

        jsonArry.put(JSONFormBuilder.observations("1282", "165280", "valueCoded", drugsDose.Metformin, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165280", "valueNumeric", drugsDose.doseMetformin, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165280", "valueCoded", drugsDose.frequencyMetformin, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165281", "valueCoded", drugsDose.Glibenclamide, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165281", "valueNumeric", drugsDose.doseGlibenclamide, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165281", "valueCoded", drugsDose.frequencyGlibenclamide, DateCalendar.date(), ""));

        //Insulin
        jsonArry.put(JSONFormBuilder.observations("1282", "165282", "valueCoded", drugsDose.Insulin, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165282", "valueNumeric", drugsDose.editTextInsulin.getText().toString(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165282", "valueCoded", drugsDose.frequencyInsulin, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165283", "valueCoded", drugsDose.SolubleInsulin, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165283", "valueNumeric", drugsDose.editTextSolubleInsulin.getText().toString(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165283", "valueCoded", drugsDose.frequencySolubleInsulin, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165285", "valueCoded", drugsDose.NPH, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165285", "valueNumeric", drugsDose.editTextNPH1.getText().toString(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165285", "valueCoded", drugsDose.frequencyNPH1, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165286", "valueCoded", drugsDose.NPH2, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165286", "valueNumeric", drugsDose.editTextNPH2.getText().toString(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165286", "valueCoded", drugsDose.frequencyNPH2, DateCalendar.date(), ""));

        //ACE
        jsonArry.put(JSONFormBuilder.observations("1282", "165253", "valueCoded", drugsDose.Captopril, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165253", "valueNumeric", drugsDose.doseCaptopril, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165253", "valueCoded", drugsDose.frequencyCaptopril, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165254", "valueCoded", drugsDose.Enalapril, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165254", "valueNumeric", drugsDose.doseEnalapril, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165254", "valueCoded", drugsDose.frequencyEnalapril, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165255", "valueCoded", drugsDose.Lisinopril, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165255", "valueNumeric", drugsDose.doseLisinopril, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165255", "valueCoded", drugsDose.frequencyLisinopril, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165256", "valueCoded", drugsDose.Perindopril, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165256", "valueNumeric", drugsDose.dosePerindopril, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165256", "valueCoded", drugsDose.frequencyPerindopril, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165257", "valueCoded", drugsDose.Ramipril, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165257", "valueNumeric", drugsDose.doseRamipril, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165257", "valueCoded", drugsDose.frequencyRamipril, DateCalendar.date(), ""));

        //ARB
        jsonArry.put(JSONFormBuilder.observations("1282", "165258", "valueCoded", drugsDose.Candesartan, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165258", "valueNumeric", drugsDose.doseCandesartan, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165258", "valueCoded", drugsDose.frequencyCandesartan, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165259", "valueCoded", drugsDose.Irbesartan, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165259", "valueNumeric", drugsDose.doseIrbesartan, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165259", "valueCoded", drugsDose.frequencyIrbesartan, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165260", "valueCoded", drugsDose.Losartan, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165260", "valueNumeric", drugsDose.doseLosartan, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165260", "valueCoded", drugsDose.frequencyLosartan, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165261", "valueCoded", drugsDose.Telmisartan, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165261", "valueNumeric", drugsDose.doseTelmisartan, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165261", "valueCoded", drugsDose.frequencyTelmisartan, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165262", "valueCoded", drugsDose.Valsartan, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165262", "valueNumeric", drugsDose.doseValsartan, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165262", "valueCoded", drugsDose.frequencyValsartan, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165263", "valueCoded", drugsDose.Olmesartan, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165263", "valueNumeric", drugsDose.doseOlmesartan, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165263", "valueCoded", drugsDose.frequencyOlmesartan, DateCalendar.date(), ""));

        //Beta Blockers
        jsonArry.put(JSONFormBuilder.observations("1282", "165264", "valueCoded", drugsDose.Atenolol, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165264", "valueNumeric", drugsDose.doseAtenolol, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165264", "valueCoded", drugsDose.frequencyAtenolol, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165265", "valueCoded", drugsDose.Labetolol, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165265", "valueNumeric", drugsDose.doseLabetolol, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165265", "valueCoded", drugsDose.frequencyLabetolol, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165266", "valueCoded", drugsDose.Propranolol, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165266", "valueNumeric", drugsDose.dosePropranolol, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165266", "valueCoded", drugsDose.frequencyPropranolol, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165267", "valueCoded", drugsDose.Carvedilol, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165267", "valueNumeric", drugsDose.doseCarvedilol, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165267", "valueCoded", drugsDose.frequencyCarvedilol, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165268", "valueCoded", drugsDose.Nebivolol, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165268", "valueNumeric", drugsDose.doseNebivolol, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165268", "valueCoded", drugsDose.frequencyNebivolol, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165269", "valueCoded", drugsDose.Metoprolol, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165269", "valueNumeric", drugsDose.doseMetoprolol, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165269", "valueCoded", drugsDose.frequencyMetoprolol, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165270", "valueCoded", drugsDose.Bisoprolol, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165270", "valueNumeric", drugsDose.doseBisoprolol, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165270", "valueCoded", drugsDose.frequencyBisoprolol, DateCalendar.date(), ""));

        //Long Acting CCB
        jsonArry.put(JSONFormBuilder.observations("1282", "165271", "valueCoded", drugsDose.Amlodipine, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165271", "valueNumeric", drugsDose.doseAmlodipine, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165271", "valueCoded", drugsDose.frequencyAmlodipine, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165272", "valueCoded", drugsDose.Felodipine, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165272", "valueNumeric", drugsDose.doseFelodipine, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165272", "valueCoded", drugsDose.frequencyFelodipine, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165273", "valueCoded", drugsDose.Nifedipine, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165273", "valueNumeric", drugsDose.doseNifedipine, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165273", "valueCoded", drugsDose.frequencyNifedipine, DateCalendar.date(), ""));

        //AntiHypersensitives
        jsonArry.put(JSONFormBuilder.observations("1282", "165277", "valueCoded", drugsDose.Methyldopa, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165277", "valueNumeric", drugsDose.doseMethyldopa, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165277", "valueCoded", drugsDose.frequencyMethyldopa, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165278", "valueCoded", drugsDose.Hydralazine, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165278", "valueNumeric", drugsDose.doseHydralazine, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165278", "valueCoded", drugsDose.frequencyHydralazine, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165279", "valueCoded", drugsDose.Prazocin, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165279", "valueNumeric", drugsDose.dosePrazocin, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165279", "valueCoded", drugsDose.frequencyPrazocin, DateCalendar.date(), ""));

        //Thizide
        jsonArry.put(JSONFormBuilder.observations("1282", "165274", "valueCoded", drugsDose.Chlorthalidone, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165274", "valueNumeric", drugsDose.doseChlorthalidone, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165274", "valueCoded", drugsDose.frequencyChlorthalidone, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165275", "valueCoded", drugsDose.Hydrochlorothia, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165275", "valueNumeric", drugsDose.doseHydrochlorothia, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165275", "valueCoded", drugsDose.frequencyHydrochlorothia, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165276", "valueCoded", drugsDose.Indapamide, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165276", "valueNumeric", drugsDose.doseIndapamide, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165276", "valueCoded", drugsDose.frequencyIndapamide, DateCalendar.date(), ""));

        //Other
        jsonArry.put(JSONFormBuilder.observations("1282", "165307", "valueCoded", drugsDose.Diet, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165201", "165307", "valueText", drugsDose.editTextDiet.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165308", "valueCoded", drugsDose.PhysicalExercise, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165202", "165308", "valueText", drugsDose.editTextPhysicalExercise.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165309", "valueCoded", drugsDose.Herbal, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165203", "165309", "valueText", drugsDose.editTextHerbal.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165310", "valueCoded", drugsDose.TreatmentOther, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165204", "165310", "valueText", drugsDose.editTextTreatmentOther.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("161011", "", "valueText", drugsDose.editTextComment.getText().toString().trim(), DateCalendar.date(), ""));

        return jsonArry;
    }
}
