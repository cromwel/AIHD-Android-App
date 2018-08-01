package org.aihdint.aihd.model;

import com.orm.SugarRecord;

import org.json.JSONObject;

public class Forms extends SugarRecord {

    private String form_id;
    private String form_name;
    private String creator;
    private String patient_id;
    private String date;
    private String status;
    private JSONObject obs;

    public Forms() {
    }

    public Forms(String form_id, String form_name, String creator, String patient_id, String date, String status) {
        this.form_id = form_id;
        this.form_name = form_name;
        this.creator = creator;
        this.patient_id = patient_id;
        this.date = date;
        this.status = status;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public String getForm_name() {
        return form_name;
    }

    public void setForm_name(String form_name) {
        this.form_name = form_name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public JSONObject getObs() {
        return obs;
    }

    public void setObs(JSONObject obs) {
        this.obs = obs;
    }
}
