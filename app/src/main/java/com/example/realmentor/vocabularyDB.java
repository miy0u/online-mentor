package com.example.realmentor;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class vocabularyDB extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "german";
    public static final String TABLE_CONSTANTS = "constants";

    public static final String KEY_ID = "_id";
    public static final String KEY_RUSSIAN = "russianWords";
    public static final String KEY_GERMAN = "germanWords";

    public vocabularyDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CONSTANTS + "(" + KEY_ID
                + " integer primary key," + KEY_RUSSIAN + " text," + KEY_GERMAN + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists " + TABLE_CONSTANTS);

        onCreate(db);
    }
}
