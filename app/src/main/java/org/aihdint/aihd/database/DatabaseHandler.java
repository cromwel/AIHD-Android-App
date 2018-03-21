package org.aihdint.aihd.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.aihdint.aihd.model.Person;

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

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_USERID = "uuid";
    private static final String KEY_NAME = "name";
    private static final String KEY_STATUS = "status";

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
                + KEY_STATUS + " INTEGER DEFAULT 0" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONS);

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

    // Getting single person
    public Person getPerson(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PERSONS, new String[] { KEY_USERID,
                        KEY_NAME, KEY_STATUS }, KEY_USERID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Person person = new Person(cursor.getString(1),
                cursor.getString(2), cursor.getString(3));
        // return contact
        return person;
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

        // return contact list
        return personList;
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
