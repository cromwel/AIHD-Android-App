package org.aihdint.aihd.fragments.dm_initial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orm.query.Condition;
import com.orm.query.Select;

import org.aihdint.aihd.forms.JSONFormBuilder;
import org.aihdint.aihd.R;
import org.aihdint.aihd.model.Concepts;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Initial_page_view_1 extends Fragment {

    private TextView textViewEncounterDate, textViewEducation, textViewOccupation, textViewPatientStatus, textViewDiabetes, textViewDiabetesFamily, textViewDiabetesYear,
            textViewDiabetesType, textViewHypertension, textViewHypertensionFamily, textViewHypertensionYear, textViewHypertensionType, textViewHIV, textViewHIVCare, textViewHIVOther,
            textViewTBScreened, textViewTBStatus, textViewTBTreatment, textViewTBDate, textViewTBComment, textViewNHIF, textViewInterReferral, textViewIntraReferral,
            textViewStatusComment, textViewReferralDetails, textViewComplaints, textViewLMP, textViewExercise, textViewDiet, textViewSmoking, textViewAlcohol, textViewRiskOther;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_view_1, container, false);

        textViewEncounterDate = view.findViewById(R.id.dm_initial_date);
        textViewEducation = view.findViewById(R.id.level_education);
        textViewOccupation = view.findViewById(R.id.occupation);
        textViewPatientStatus = view.findViewById(R.id.patient_status);
        textViewDiabetes = view.findViewById(R.id.diabetes);
        textViewDiabetesFamily = view.findViewById(R.id.diabetes_family);
        textViewDiabetesYear = view.findViewById(R.id.diagnosis_diabetes_date);
        textViewDiabetesType = view.findViewById(R.id.diabetes_type);
        textViewHypertension = view.findViewById(R.id.hypertension);
        textViewHypertensionFamily = view.findViewById(R.id.hypertension_family);
        textViewHypertensionYear = view.findViewById(R.id.diagnosis_hypertension_date);
        textViewHypertensionType = view.findViewById(R.id.hypertension_type);
        textViewHIV = view.findViewById(R.id.hiv_status);
        textViewHIVCare = view.findViewById(R.id.hiv_enrolled);
        textViewHIVOther = view.findViewById(R.id.hiv_other_status);
        textViewTBScreened = view.findViewById(R.id.tb_screened);
        textViewTBStatus = view.findViewById(R.id.tb_status);
        textViewTBTreatment = view.findViewById(R.id.tb_treatment);
        textViewTBDate = view.findViewById(R.id.tb_treatment_start);
        textViewTBComment = view.findViewById(R.id.tb_comment);
        textViewNHIF = view.findViewById(R.id.nhif_details);
        textViewInterReferral = view.findViewById(R.id.inter_referral);
        textViewIntraReferral = view.findViewById(R.id.intra_referral);
        textViewStatusComment = view.findViewById(R.id.comments);
        textViewReferralDetails = view.findViewById(R.id.referral_other_details);
        textViewComplaints = view.findViewById(R.id.complaints);
        textViewLMP = view.findViewById(R.id.complaint_lmp);
        textViewExercise = view.findViewById(R.id.exercise);
        textViewDiet = view.findViewById(R.id.diet);
        textViewSmoking = view.findViewById(R.id.smoking);
        textViewAlcohol = view.findViewById(R.id.drinking);
        textViewRiskOther = view.findViewById(R.id.risk_other);


        Intent intent = getActivity().getIntent();
        //report_id = intent.getStringExtra("report_id");
        String file_name = intent.getStringExtra("file_name");

        Log.d("Form Data", JSONFormBuilder.loadForm(getContext(), "initial", file_name) + "");
        viewForm(JSONFormBuilder.loadForm(getContext(), "initial", file_name));

        return view;
    }


    public void viewForm(String response) {

        try {
            JSONObject jsonObj = new JSONObject(response);

            textViewEncounterDate.setText(String.format("Encounter Date:%s", jsonObj.getString("encounterDate")));
            // Getting JSON Array node
            JSONArray obs = jsonObj.getJSONArray("obs");

            if (obs.length() > 0) {
                for (int i = 0; i < obs.length(); i++) {
                    JSONObject concept = obs.getJSONObject(i);
                    switch (concept.getString("concept_id")) {
                        case "1712":
                            textViewEducation.setText(conceptAnswer(concept, "1712"));
                            break;
                        case "1542":
                            textViewOccupation.setText(conceptAnswer(concept, "1542"));
                            break;
                        case "165171":
                            textViewPatientStatus.setText(conceptAnswer(concept, "165171"));
                            break;
                        case "165086":
                            textViewDiabetes.setText(conceptAnswer(concept, "165086"));
                            break;
                        case "140228":
                            textViewDiabetesFamily.setText(conceptAnswer(concept, "140228"));
                            break;
                        case "165153":
                            textViewDiabetesYear.setText(conceptAnswer(concept, "165153"));
                            break;
                        case "165094":
                            textViewDiabetesType.setText(conceptAnswer(concept, "165094"));
                            break;
                        case "165091":
                            textViewHypertension.setText(conceptAnswer(concept, "165091"));
                            break;
                        case "165191":
                            textViewHypertensionFamily.setText(conceptAnswer(concept, "165191"));
                            break;
                        case "165154":
                            textViewHypertensionYear.setText(conceptAnswer(concept, "165154"));
                            break;
                        case "165198":
                            textViewHypertensionType.setText(conceptAnswer(concept, "165198"));
                            break;
                        case "138405":
                            textViewHIV.setText(conceptAnswer(concept, "138405"));
                            break;
                        case "159811":
                            textViewHIVCare.setText(conceptAnswer(concept, "159811"));
                            break;
                        case "165155":
                            textViewHIVOther.setText(conceptAnswer(concept, "165155"));
                            break;
                        case "164800":
                            textViewTBScreened.setText(conceptAnswer(concept, "164800"));
                            break;
                        case "":
                            textViewTBStatus.setText(conceptAnswer(concept, ""));
                            break;
                        case "1659":
                            textViewTBTreatment.setText(conceptAnswer(concept, "1659"));
                            break;
                        case "165172":
                            textViewTBDate.setText(conceptAnswer(concept, "165172"));
                            break;
                        case "165173":
                            textViewTBComment.setText(conceptAnswer(concept, "165173"));
                            break;
                        case "1917":
                            textViewNHIF.setText(conceptAnswer(concept, "1917"));
                            break;
                        case "165162":
                            textViewNHIF.setText(conceptAnswer(concept, "165162"));
                            break;
                        case "164408":
                            textViewInterReferral.setText(conceptAnswer(concept, "164408"));
                            break;
                        case "165163":
                            textViewIntraReferral.setText(conceptAnswer(concept, "165163"));
                            break;
                        case "165164":
                            textViewStatusComment.setText(conceptAnswer(concept, "165164"));
                            break;
                        case "165156":
                            textViewReferralDetails.setText(conceptAnswer(concept, "165156"));
                            break;
                        case "6042":
                            textViewComplaints.append(conceptAnswer(concept, "6042") + "\n");
                            break;
                        case "1427":
                            textViewLMP.setText(conceptAnswer(concept, "1427"));
                            break;
                        case "165208":
                            textViewExercise.setText(conceptAnswer(concept, "165208"));
                            break;
                        case "165207":
                            textViewDiet.setText(conceptAnswer(concept, "165207"));
                            break;
                        case "152722":
                            textViewSmoking.setText(conceptAnswer(concept, "152722"));
                            break;
                        case "159449":
                            textViewAlcohol.setText(conceptAnswer(concept, "159449"));
                            break;
                        case "165165":
                            textViewRiskOther.setText(conceptAnswer(concept, "165165"));
                            break;


                    }
                }
            }

        } catch (Exception e) {
            // hiding the progress bar
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
