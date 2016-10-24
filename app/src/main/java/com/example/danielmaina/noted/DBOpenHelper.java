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
                    NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOTE_TEXT + " TEXT " +
                    NOTE_CREATED + " TEXT default CURRENT_TIMESTAMP" +
                    ")";


//openHelper constructor - the parametres not needed have been removed
    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    //method for initiating the DB the first time its created
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //executing the query to create the database table
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    //method for rebuilding the database with a new or updated structure
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //if database has changed,the current table will be deleted using the following command
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        //the the oncreate method below will be run to create the new table(upgrading
            onCreate(sqLiteDatabase);
    }
}
