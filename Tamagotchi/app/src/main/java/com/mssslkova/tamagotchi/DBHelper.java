package com.mssslkova.tamagotchi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATA_VERSION = 1;
    public static final String DATABASE_NAME = "PetsDb";
   /*public static final String TABLE_PETS = "pets";
    public static final String KEY_NAME = "name";
    public static final int KEY_LIVETIME = "livetime";*/

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATA_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DATABASE_NAME + "(name TEXT NOT NULL," + " livetime INTEGER NOT NULL);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
