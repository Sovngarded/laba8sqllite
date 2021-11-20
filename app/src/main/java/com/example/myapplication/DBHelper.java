package com.example.myapplication;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.content.PeriodicSync;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "myBase";
    public static final String TABLE_PERSONS = "persons";
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_MAIL = "mail";


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_PERSONS + "(" + KEY_ID + " integer primary key," + KEY_NAME + " text," + KEY_MAIL + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion)
    {
        db.execSQL("drop table if exists " + TABLE_PERSONS);
        onCreate(db);
    }

    public List<Person> getAllContacts() {
        List<Person> personList = new ArrayList<Person>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PERSONS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setID(Integer.parseInt(cursor.getString(0)));
                person.setName(cursor.getString(1));
                person.setEmail(cursor.getString(2));

                String name = cursor.getString(1) +"\n"+ cursor.getString(2);
                MainActivity2.ArrayofName.add(name);
                // Adding contact to list
                personList.add(person);
            } while (cursor.moveToNext());
        }

        // return contact list
        return personList;
    }
}

