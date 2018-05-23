package org.aihdint.aihd.Forms;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.aihdint.aihd.PageAdapters.DM_Initial_Adpater;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.Alerts;
import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.app.NavigationDrawerShare;
import org.aihdint.aihd.fragments.dm_initial.FragmentModelInitial;
import org.aihdint.aihd.fragments.dm_initial.InitialActivityModel_One;
import org.aihdint.aihd.fragments.dm_initial.InitialActivityModel_Three;
import org.aihdint.aihd.fragments.dm_initial.InitialActivityModel_Two;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static org.aihdint.aihd.app.Config.DMINITIAL_URL;

/**
 * Developed by Rodney on 26/03/2018.
 */

public class DM_Initial extends AppCompatActivity implements FragmentModelInitial.FragStateChangeListener {

    private static final String TAG = DM_Initial.class.getSimpleName();

    private String jsonResponse;
    //Page 1
    private String occupation_other,diabetes_status,htn_status,hiv_status,enrolled_to_hiv_care,nhif_status,referral_status;
    //Checkboxes
    private String tb_status,breathing,palpitations,dizziness,fainting,leg_swell,urination_fatigue,lose_consciousness,
            blurr_vision,focal_weakness,foot_complaint,headache_migraines,complaint_other;

    private String dm_initial_date,diagnosis_diabetes_date,diagnosis_hypertension_date,hiv_other_status,tb_treatment_start,
            tb_comment,nhif_other,referral_other,referral_other_details,complaint_other_details,complaint_lmp,drug_abuse_other,occupation,education,drinking,smoking;

    private String intra_referral,inter_referral,extremities;

    //Page 2
    private String medication_none,medication_metformin,medication_glibenclamide,medication_insulin,medication_nph,medication_soluble_insulin,medication_enalapril,medication_hctz,medication_losartan,medication_nifedipine,medication_atenolol,medication_other;

    //Page 3
    private String glucose, protein, ketone, ecg, cxr;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_initial);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.CreateDrawer(toolbar);

        occupation_other = diabetes_status = htn_status = hiv_status = enrolled_to_hiv_care = nhif_status = referral_status = tb_status = breathing = palpitations = dizziness = fainting = leg_swell = urination_fatigue = lose_consciousness =
        blurr_vision = focal_weakness = foot_complaint = headache_migraines = complaint_other = drinking = dm_initial_date  = diagnosis_diabetes_date = diagnosis_hypertension_date = hiv_other_status = tb_treatment_start =
                tb_comment = nhif_other = intra_referral = inter_referral = referral_other = referral_other_details = complaint_other_details = complaint_lmp = drug_abuse_other = occupation = education = drinking = smoking =
                        glucose = protein = ketone = ecg = cxr = "";


        medication_none =medication_metformin=medication_glibenclamide=medication_insulin=medication_nph=medication_soluble_insulin=medication_enalapril=medication_hctz=medication_losartan=medication_nifedipine=medication_atenolol=medication_other;


        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        FragmentModelInitial.getInstance().setListener(this);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Page 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 5"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final DM_Initial_Adpater adapter = new DM_Initial_Adpater
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_new_dm_patient:
                if (checked)
                    diabetes_status = "165087";
                    InitialActivityModel_One.getInstance().dmDiagnosis(diabetes_status);
                break;
            case R.id.radio_known_dm_patient:
                if (checked)
                    diabetes_status = "165088";
                    InitialActivityModel_One.getInstance().dmDiagnosis(diabetes_status);
                break;
            case R.id.radio_new_htn_patient:
                if (checked)
                    htn_status = "165092";
                    InitialActivityModel_One.getInstance().htnDiagnosis(htn_status);
                break;
            case R.id.radio_known_htn_patient:
                if (checked)
                    htn_status = "165093";
                    InitialActivityModel_One.getInstance().htnDiagnosis(htn_status);
                break;
            case R.id.radio_hiv_plus:
                if (checked)
                    hiv_status = "664";
                    InitialActivityModel_One.getInstance().hivStatus(hiv_status);
                break;
            case R.id.radio_hiv_negative:
                if (checked)
                    hiv_status = "138571";
                    InitialActivityModel_One.getInstance().hivStatus(hiv_status);
                break;
            case R.id.radio_hiv_unknown:
                if (checked)
                    hiv_status = "1067";
                    InitialActivityModel_One.getInstance().hivStatus(hiv_status);
                break;
            case R.id.radio_enrolled_yes:
                if (checked)
                    enrolled_to_hiv_care = "1065";
                break;
            case R.id.radio_enrolled_no:
                if (checked)
                    enrolled_to_hiv_care = "1066";
                break;
            case R.id.radio_nhif_yes:
                if (checked)
                    nhif_status = "1065";
                    InitialActivityModel_One.getInstance().nhifStatus(nhif_status);
                break;
            case R.id.radio_nhif_no:
                if (checked)
                    nhif_status = "1066";
                    InitialActivityModel_One.getInstance().nhifStatus(nhif_status);
                Alerts.alert_msg(this, "NHIF Registration", "Encourage Client to Register for NHIF");
                break;
            case R.id.radio_nhif_other:
                if (checked)
                    nhif_status = "5622";
                    InitialActivityModel_One.getInstance().nhifStatus(nhif_status);
                break;
            case R.id.radio_referral_yes:
                if (checked)
                    referral_status = "1065";
                    InitialActivityModel_One.getInstance().referralStatus(referral_status);
                break;
            case R.id.radio_referral_no:
                if (checked)
                    referral_status = "1066";
                    InitialActivityModel_One.getInstance().referralStatus(referral_status);
                break;
            case R.id.radio_smoke_yes:
                if (checked)
                    smoking = "1065";
                break;
            case R.id.radio_smoke_no:
                if (checked)
                    smoking = "1066";
                break;
            case R.id.radio_smoke_stopped:
                if (checked)
                    smoking = "158939";
                break;
            case R.id.radio_drink_yes:
                if (checked)
                    drinking = "159450";
                break;
            case R.id.radio_drink_no:
                if (checked)
                    drinking = "1090";
                break;
            case R.id.radio_drink_stopped:
                if (checked)
                    drinking = "159452";
                break;
            case R.id.radio_referral_chw:
                if (checked)
                    intra_referral = "1759";
                break;
            case R.id.radio_referral_dispensary:
                if (checked)
                    intra_referral = "165107";
                break;
            case R.id.radio_referral_maternity:
                if (checked)
                    inter_referral = "163146";
                break;
            case R.id.radio_referral_inpatient:
                if (checked)
                    inter_referral = "160551";
                break;
            case R.id.radio_referral_opd:
                if (checked)
                    inter_referral = "160542";
                break;
            case R.id.radio_referral_casualty:
                if (checked)
                    inter_referral = "160473";
                break;
            case R.id.radio_referral_ccc:
                if (checked)
                    inter_referral = "162050";
                break;
            case R.id.radio_referral_other:
                if (checked)
                    inter_referral = "5622";
                break;
            case R.id.radio_extremities_normal:
                if (checked)
                    extremities = "1115";
                    InitialActivityModel_Two.getInstance().extremitiesStatus(extremities);
                break;
            case R.id.radio_extremities_abnormal:
                if (checked)
                    extremities = "1116";
                    InitialActivityModel_Two.getInstance().extremitiesStatus(extremities);
                break;

            case R.id.radio_glucose_yes:
                if (checked)
                    glucose = "1065";
                InitialActivityModel_Three.getInstance().urinalysisGlucose(glucose);
                break;
            case R.id.radio_glucose_no:
                if (checked)
                    glucose = "1066";
                InitialActivityModel_Three.getInstance().urinalysisGlucose(glucose);
                break;
            case R.id.radio_protein_yes:
                if (checked)
                    protein = "1065";
                InitialActivityModel_Three.getInstance().urinalysisProtein(protein);
                break;
            case R.id.radio_protein_no:
                if (checked)
                    protein = "1066";
                InitialActivityModel_Three.getInstance().urinalysisProtein(protein);
                break;
            case R.id.radio_ketone_yes:
                if (checked)
                    ketone = "1065";
                InitialActivityModel_Three.getInstance().urinalysisKetone(ketone);
                break;
            case R.id.radio_ketone_no:
                if (checked)
                    ketone = "1066";
                InitialActivityModel_Three.getInstance().urinalysisKetone(ketone);
                break;

        }
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_tb_status:
                if (checked){
                    tb_status ="1659";
                }else{
                    tb_status ="";
                }
                break;
            case R.id.checkbox_complaint_breath:
                if (checked){
                    breathing ="110265";
                }else{
                    breathing ="";
                }
                break;
            case R.id.checkbox_complaint_palpitations:
                if (checked){
                    palpitations="158627";
                }else{
                    palpitations="";
                }
                break;
            case R.id.checkbox_complaint_dizziness:
                if (checked){
                    dizziness="156046";
                }else{
                    dizziness="";
                }
                break;
            case R.id.checkbox_complaint_fainting:
                if (checked){
                    fainting="112961";
                }else{
                    fainting="";
                }
                break;
            case R.id.checkbox_complaint_leg_swell:
                if (checked){
                    leg_swell="135966";
                }else{
                    leg_swell="";
                }
                break;
            case R.id.checkbox_complaint_urination_fatigue:
                if (checked){
                    urination_fatigue="134185";
                }else{
                    urination_fatigue="";
                }
                break;
            case R.id.checkbox_complaint_lose_consciousness:
                if (checked){
                    lose_consciousness="135592";
                }else{
                    lose_consciousness="";
                }
                break;
            case R.id.checkbox_complaint_blurr_vision:
                if (checked){
                    blurr_vision="147104";
                }else{
                    blurr_vision="";
                }
                break;
            case R.id.checkbox_complaint_focal_weakness:
                if (checked){
                    focal_weakness="6005";
                }else{
                    focal_weakness="";
                }
                break;
            case R.id.checkbox_foot_complaint:
                if (checked){
                    foot_complaint="164529";
                }else{
                    foot_complaint="";
                }
                break;
            case R.id.checkbox_complaint_headache_migraines:
                if (checked){
                    headache_migraines="115782";
                }else{
                    headache_migraines="";
                }
                break;
            case R.id.checkbox_complaint_other:
                if(checked){
                    complaint_other = "5622";
                    InitialActivityModel_One.getInstance().complaintStatus(complaint_other);
                }else {
                    complaint_other = "";
                    InitialActivityModel_One.getInstance().complaintStatus(complaint_other);
                }
            case R.id.checkbox_medication_none:
                if(checked){
                    medication_none = "1107";
                    InitialActivityModel_Two.getInstance().medicationNone(medication_none);
                }else {
                    medication_none = "";
                    InitialActivityModel_Two.getInstance().medicationNone(medication_none);
                }
            case R.id.checkbox_medication_metformin:
                if(checked){
                    medication_metformin = "79651";
                }else {
                    medication_metformin = "";
                }
            case R.id.checkbox_medication_glibenclamide:
                if(checked){
                    medication_glibenclamide = "77071";
                }else {
                    medication_glibenclamide = "";
                }
            case R.id.checkbox_medication_insulin:
                if(checked){
                    medication_insulin = "159459";
                }else {
                    medication_insulin = "";
                }
            case R.id.checkbox_medication_nph:
                if(checked){
                    medication_nph = "78068";
                }else {
                    medication_nph = "";
                }
            case R.id.checkbox_medication_soluble_insulin:
                if(checked){
                    medication_soluble_insulin = "282";
                }else {
                    medication_soluble_insulin = "";
                }
            case R.id.checkbox_medication_enalapril:
                if(checked){
                    medication_enalapril = "75633";
                }else {
                    medication_enalapril = "";
                }
            case R.id.checkbox_medication_hctz:
                if(checked){
                    medication_hctz = "77696";
                }else {
                    medication_hctz = "";
                }
            case R.id.checkbox_medication_losartan:
                if(checked){
                    medication_losartan = "79074";
                }else {
                    medication_losartan = "";
                }
            case R.id.checkbox_medication_nifedipine:
                if(checked){
                    medication_nifedipine = "80637";
                }else {
                    medication_nifedipine = "";
                }
            case R.id.checkbox_medication_atenolol:
                if(checked){
                    medication_atenolol = "71652";
                }else {
                    medication_atenolol = "";
                }

        }

    }

    public void onCheckboxMedicineOther(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_medication_other:
                if(checked){
                    medication_other = "5622";
                    InitialActivityModel_Two.getInstance().medicationOther(medication_other);
                }else {
                    medication_other = "";
                    InitialActivityModel_Two.getInstance().medicationOther(medication_other);
                }
        }
    }

    @Override
    public void initialOne(String dm_initial_dateEditText,String occupation_otherEditText,String diagnosis_diabetes_dateEditTextEditText,String diagnosis_hypertension_dateEditText,
                           String hiv_other_statusEditText,String tb_treatment_startEditText,String tb_commentEditText,String nhif_otherEditText,
                           String referral_otherEditText,String referral_other_detailsEditText,String complaint_otherEditText,
                           String complaint_lmpEditText,String abuse_otherEditText,String occupationEditText,String educationEditText) {

        dm_initial_date = dm_initial_dateEditText;

        diagnosis_diabetes_date = diagnosis_diabetes_dateEditTextEditText;
        occupation_other = occupation_otherEditText;
        diagnosis_hypertension_date = diagnosis_hypertension_dateEditText;
        hiv_other_status = hiv_other_statusEditText;
        tb_treatment_start = tb_treatment_startEditText;
        tb_comment = tb_commentEditText;
        nhif_other = nhif_otherEditText;
        referral_other = referral_otherEditText;
        referral_other_details = referral_other_detailsEditText;
        complaint_other_details = complaint_otherEditText;
        complaint_lmp = complaint_lmpEditText;
        drug_abuse_other = abuse_otherEditText;
        occupation = occupationEditText;
        education = educationEditText;

    }

    @Override
    public void initialTwo(String tag) {

    }

    @Override
    public void initialThree(String tag) {

    }

    @Override
    public void initialFour(String tag) {

    }


    /**
     * Method to make json array request where response starts with [
     * */

    private void dmInitialForm() {

        // Tag used to cancel the request
        String tag_string_req = "req_upload";

        StringRequest strReq = new StringRequest(Request.Method.POST,
                DMINITIAL_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                jsonResponse = response;
                Log.d(TAG, "Upload Response: " + response);

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        // User successfully stored in MySQL
                        // Now store the user in sqlite
                        Toast.makeText(getApplicationContext(), "Form successfully uploaded.!", Toast.LENGTH_LONG).show();
                    }

                    hideDialog();
                } catch (JSONException e) {
                    hideDialog();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Upload Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<>();

                params.put("dm_initial_date", dm_initial_date);
                params.put("diabetes_status", diabetes_status);
                params.put("htn_status", htn_status);
                params.put("hiv_status", hiv_status);
                params.put("enrolled_to_hiv_care", enrolled_to_hiv_care);
                params.put("nhif", nhif_status);
                params.put("referral", referral_status);
                params.put("complaint_other", complaint_other);
                params.put("dm_diagnosis_year", diagnosis_diabetes_date);
                params.put("htn_diagnosis_year", diagnosis_hypertension_date);
                params.put("other_patient_status", hiv_other_status);
                params.put("on_tb_treatment",tb_status);
                params.put("tb_treatment_start", tb_treatment_start);
                params.put("tb_comments", tb_comment);
                params.put("other_nhif",nhif_other);
                params.put("referral_comment", referral_other);
                params.put("refering_other", referral_other_details);
                params.put("inter_referral", inter_referral);
                params.put("intra_referral", intra_referral);
                params.put("complaint_other_details", complaint_other_details);
                params.put("occupation", occupation);
                params.put("occupation_other", occupation_other);
                params.put("education_level",education);
                params.put("drinking", drinking);
                params.put("smoking",smoking);
                params.put("drug_abuse_other",drug_abuse_other);
                params.put("breathing",breathing);
                params.put("palpitations",palpitations);
                params.put("dizziness",dizziness);
                params.put("fainting",fainting);
                params.put("leg_swell",leg_swell);
                params.put("urination_fatigue",urination_fatigue);
                params.put("lose_consciousness",lose_consciousness);
                params.put("blurr_vision",blurr_vision);
                params.put("focal_weakness",focal_weakness);
                params.put("foot_complaint",foot_complaint);
                params.put("headache_migraines",headache_migraines);
                params.put("complaint_lmp", complaint_lmp);
                params.put("uuid",AppController.getInstance().getSessionManager().getUserDetails().get("user_id"));

                JSONObject jsonParams = new JSONObject(params);
                JSONObject jsonAdd = new JSONObject();

                try {
                    jsonAdd.put("Encounter", "85562bbn-jjk96");
                    jsonAdd.put("obs", jsonParams);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d("Params", jsonAdd.toString());


                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);

    }


    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    public void validateInitial(View view) {
        pDialog.setMessage("Uploading DM Initial Form" +
                "...");
        showDialog();
        dmInitialForm();
    }
}
