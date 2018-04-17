package org.aihdint.aihd.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.aihdint.aihd.model.Person;
import org.aihdint.aihd.model.Report;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Rodney on 15/02/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "aihd";

    // Contacts table name
    private static final String TABLE_PERSONS = "persons";
    private static final String TABLE_REPORTS = "reports";

    // Contacts Table
    private static final String KEY_ID = "_id";
    private static final String KEY_USERID = "uuid";
    private static final String KEY_NAME = "name";
    private static final String KEY_STATUS = "status";

    // Reports Table
    private static final String KEY_REPORT_ID = "_id";
    private static final String KEY_USER_ID = "uuid";
    private static final String KEY_IMAGE = "image_url";
    private static final String KEY_DATE = "date";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_PERSONS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_USERID + " TEXT,"
                + KEY_NAME + " TEXT,"
                + KEY_STATUS + " INTEGER DEFAULT 0 )";

        String CREATE_REPORTS_TABLE = "CREATE TABLE " + TABLE_REPORTS + "("
                + KEY_REPORT_ID + " INTEGER PRIMARY KEY,"
                + KEY_USER_ID + " TEXT,"
                + KEY_NAME + " TEXT,"
                + KEY_IMAGE + " BLOB,"
                + KEY_STATUS + " INTEGER DEFAULT 0 ,"
                + KEY_DATE + " TEXT )";

        db.execSQL(CREATE_CONTACTS_TABLE);
        db.execSQL(CREATE_REPORTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REPORTS);

        // Create tables again
        onCreate(db);
    }


    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new person
    public void addPerson(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERID, person.getID()); // Person Phone
        values.put(KEY_NAME, person.getName()); // Person Name

        // Inserting Row
        db.insert(TABLE_PERSONS, null, values);
        db.close(); // Closing database connection
    }

    // Adding new report
    public void addReport(Report report) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_ID, report.getID()); // User ID
        values.put(KEY_IMAGE, report.getImage()); // Report Image
        values.put(KEY_NAME, report.getName()); // Report Name
        values.put(KEY_DATE, report.getDate()); // Report Date

        // Inserting Row
        Log.d("Add Report :", String.valueOf(values));
        db.insert(TABLE_REPORTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single person
    public Person getPerson(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PERSONS, new String[] { KEY_USERID,
                        KEY_NAME, KEY_STATUS }, KEY_USERID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        //Person person = new Person(cursor.getString(1),cursor.getString(2), cursor.getString(3));
        // return contact
        //return person;
        return null;
    }

    // Getting All Contacts
    public List<Person> getAllPersons() {
        List<Person> personList = new ArrayList<Person>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PERSONS;

        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Person contact = new Person();
                contact.setID(cursor.getString(1));
                contact.setName(cursor.getString(2));
                contact.setStatus(cursor.getString(3));
                // Adding contact to list
                personList.add(contact);
            } while (cursor.moveToNext());
        }

        cursor.close();
        // return contact list
        return personList;
    }


    public List<Person> getPersons() {
        List<Person> personList = new ArrayList<Person>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PERSONS +" LIMIT 10";

        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Person contact = new Person();
                contact.setID(cursor.getString(1));
                contact.setName(cursor.getString(2));
                contact.setStatus(cursor.getString(3));
                // Adding contact to list
                personList.add(contact);
            } while (cursor.moveToNext());
        }

        cursor.close();
        // return contact list
        return personList;
    }

    public List<Report> getReports(){
        List<Report> reportList = new ArrayList<Report>();

        String selectQuery = "SELECT  * FROM " + TABLE_REPORTS;
        SQLiteDatabase db = this.getWritableDatabase();

        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Report report =  new Report();
                report.setID(cursor.getString(1));
                report.setName(cursor.getString(2));
                byte[] imgByte = cursor.getBlob(3);
                report.setImage(imgByte);
                report.setDate(cursor.getString(5));

                reportList.add(report);
            } while (cursor.moveToNext());
        }

        Log.d("Report Count", String.valueOf(reportList.size()));
        cursor.close();
        return reportList ;
    }

    // Updating single person
    public int updateContact(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, person.getName());
        values.put(KEY_STATUS, person.getStatus());

        // updating row
        return db.update(TABLE_PERSONS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(person.getID()) });
    }

    // Deleting single contact
    public void deleteContact(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PERSONS, KEY_ID + " = ?",
                new String[] { String.valueOf(person.getID()) });
        db.close();
    }


    // Getting persons Count
    public int getPersonsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PERSONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

}
