package com.example.danielmaina.noted;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by danielmaina on 10/22/16.
 */
public class NotesProvider extends ContentProvider {
 //AUTHORITY Identifies the content provider to the android framework
    //only one app can use a given authority
    private static final String AUTHORITY = "com.example.Noted.notesprovider";
   //the BASE_PATH represents the entire dataset
    //since this app has only one table it'll take "notes"-the name of the table -as the only BASE_PATH
    private static final String BASE_PATH = "notes";
    //the following Uniform Resource Identifier identifies the content provider
    private static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);


    //constants to identify the requested operation-the things you can do with the content provider
    private static final int NOTES = 1;
    private static final int NOTES_ID = 2;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    //static initializer for the Uri Matcher
    //this code will run the first time anything is called from this class
    static {
        uriMatcher.addURI(AUTHORITY, BASE_PATH, NOTES);
        uriMatcher.addURI(AUTHORITY, BASE_PATH + "/#", NOTES_ID);
    }


    private SQLiteDatabase database;
    @Override
    public boolean onCreate() {

        //creating openHelper class object and passing the context parameter
        DBOpenHelper helper = new DBOpenHelper(getContext());
        //create and get the database using an instance of SQlite database
         database = helper.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    //this method gets data from the database.It either returns a single row or the whole dataset
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return database.query(DBOpenHelper.TABLE_NOTES,DBOpenHelper.ALL_COLUMNS,s,null,null,null,
                DBOpenHelper.NOTE_CREATED + "DESC" );
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        long id = database.insert(DBOpenHelper.TABLE_NOTES,null,contentValues);
        return Uri.parse(BASE_PATH + "/"+ id);
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return database.delete(DBOpenHelper.TABLE_NOTES,s,strings);
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return database.update(DBOpenHelper.TABLE_NOTES,contentValues,s,strings);
    }
}
