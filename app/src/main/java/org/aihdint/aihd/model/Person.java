package org.aihdint.aihd.model;

/**
 * Developed by Rodney on 15/02/2018.
 */

public class Person {
    //private variables
    private String _id;
    private String _name;
    private String _status;

    // Empty constructor
    public Person(){

    }
    // constructor
    public Person(String id, String name, String status){
        this._id = id;
        this._name = name;
        this._status = status;
    }

    // constructor
    public Person(String id, String name){
        this._id = id;
        this._name = name;
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
        return this._name;
    }

    // getting status
    public String getStatus(){
        return this._status;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // setting status
    public void setStatus(String status){
        this._status = status;
    }
}
