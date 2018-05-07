package org.aihdint.aihd.model;

import com.orm.SugarRecord;

/**
 * Developed by Rodney on 04/05/2018.
 */
public class DM_Intial_Model extends SugarRecord {

    private String diabetes_status,htn_status,hiv_status,nhif_status,referral_status,complaint_other;
    private String dm_initial_date,diagnosis_diabetes_date,diagnosis_hypertension_date,hiv_other_status,
            tb_treatment_start,tb_comment,nhif_other,referral_other,referral_other_details,complaint_other_details,complaint_lmp,abuse_other,occupation,education;

    DM_Intial_Model(){}
}
