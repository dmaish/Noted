package com.example.danielmaina.noted;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by danielmaina on 10/21/16.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    //Constants for Db name and version
    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 1;

    //Constants for identifying table and column
    //table
    private static final String TABLE_NOTES = "notes";
    //columns
    private static final String NOTE_ID = "_id";
    private static final String NOTE_TEXT ="noteText";
    private static final String NOTE_CREATED = "noteCreated";

    //SQL code to create the table(the query)
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NOTES + " (" +
                    NOTE_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOTE_TEXT + " TEXT, " +
                    NOTE_CREATED + " TEXT default CURRENT_TIMESTAMP" +
                    ")";




    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //method for initiating the DB the first time its created
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    //method for rebuilding the database with a new or updated structure
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
