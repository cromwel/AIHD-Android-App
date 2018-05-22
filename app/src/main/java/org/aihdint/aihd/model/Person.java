package org.aihdint.aihd.model;

import com.orm.SugarRecord;

/**
 * Developed by Rodney on 15/02/2018.
 */

public class Person extends SugarRecord {
    //private variables
    private String _id;
    private String family_name,given_name;
    private String gender;
    private String birthdate;
    private String birthdate_estimated;
    private String telephone;
    private String identifier_type;
    private String location_id;
    private String address1,address2,address3,county_district,city_village;
    private String supporter;
    private String supporter_address;
    private String supporter_number;
    private String _status;
    private String isDead;

    // Empty constructor
    public Person(){

    }

    // constructor
    public Person(String id, String name){
        this._id = id;
        this.family_name = name;
    }
    // constructor
    public Person(String family_name, String given_name, String gender, String birthdate, String birthdate_estimated,
                  String telephone, String identifier_type, String location_id,
                  String address1, String address2, String address3, String county_district, String city_village, String supporter, String supporter_address, String supporter_number, String status) {
        //this._id = id;
        this.family_name = family_name;
        this.given_name = given_name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.birthdate_estimated = birthdate_estimated;
        this.telephone = telephone;
        this.identifier_type = identifier_type;
        this.location_id = location_id;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.county_district = county_district;
        this.city_village = city_village;
        this.supporter = supporter;
        this.supporter_address = supporter_address;
        this.supporter_number = supporter_number;
        this._status = status;
    }



    // getting ID
    public String  getID(){
        return this._id;
    }

    // setting id
    public void setID(String id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this.family_name;
    }

    // getting status
    public String getStatus(){
        return this._status;
    }

    // setting name
    public void setName(String name){
        this.family_name = name;
    }

    // setting status
    public void setStatus(String status){
        this._status = status;
    }

    public String getSupporter() {
        return supporter;
    }

    public void setSupporter(String supporter) {
        this.supporter = supporter;
    }

    public String getSupporter_address() {
        return supporter_address;
    }

    public void setSupporter_address(String supporter_address) {
        this.supporter_address = supporter_address;
    }

    public String getSupporter_number() {
        return supporter_number;
    }

    public void setSupporter_number(String supporter_number) {
        this.supporter_number = supporter_number;
    }

    public String getIsDead() {
        return isDead;
    }

    public void setIsDead(String isDead) {
        this.isDead = isDead;
    }
}
