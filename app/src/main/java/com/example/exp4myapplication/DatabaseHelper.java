package com.example.exp4myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user_info.db";
    private static final String TABLE_NAME = "user";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_EMAIL = "Email";
    private static final String COLUMN_AGE = "Age";
    private static final String COLUMN_COUNTRY = "Country";
    private static final String COLUMN_DATE_OF_BIRTH = "DateOfBirth";
    private static final String COLUMN_GENDER = "Gender";
    private static final String COLUMN_AGREE_TERMS = "AgreeTerms";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_AGE + " INTEGER, " +
                COLUMN_COUNTRY + " TEXT, " +
                COLUMN_DATE_OF_BIRTH + " TEXT, " +
                COLUMN_GENDER + " TEXT, " +
                COLUMN_AGREE_TERMS + " INTEGER)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_AGE, user.getAge());
        values.put(COLUMN_COUNTRY, user.getCountry());
        values.put(COLUMN_DATE_OF_BIRTH, user.getDateOfBirth());
        values.put(COLUMN_GENDER, user.getGender());
        values.put(COLUMN_AGREE_TERMS, user.isAgreeTerms() ? 1 : 0);

        return db.insert(TABLE_NAME, null, values);
    }
}

