package com.mssslkova.tamagotchi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import android.icu.text.AlphabeticIndex;

import java.util.ArrayList;
import java.util.List;

public class RecordDao
{
    public SQLiteDatabase db;
    public RecordDao(Context context)//Конструктор
    {
        db = new DBHelper(context).getReadableDatabase();//открываем БД
    }
    public List<RecordEntity> getAll()//получаем все элементы списка
    {
        Cursor c = db.rawQuery("SELECT * FROM " + DBHelper.DATABASE_NAME, null);
        List<RecordEntity> list = new ArrayList<>();//экземпляр списка
        if (c.moveToFirst())//начиная с начала
        {
            int name = c.getColumnIndex(COLUMN_NAME);
            int livetime = c.getColumnIndex(COLUMN_LIVETIME);
            do {
                list.add(
                        new RecordEntity(
                                c.getString(name),
                                c.getFloat(livetime)
                        )
                );
            } while (c.moveToNext());
        }
        c.close();
        return list;
    }
    public void insert(RecordEntity recordEntity)
    {
        ContentValues raw = new ContentValues();
        raw.put(COLUMN_NAME, recordEntity.getName());
        raw.put(COLUMN_LIVETIME, recordEntity.getLivetime());
        db.insert(DBHelper.DATABASE_NAME, null, raw);
    }
    public void delete()
    {
        db.delete(DBHelper.DATABASE_NAME, null, null);
    }
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_LIVETIME = "livetime";
    private static RecordDao instance;
    public static RecordDao initDB(Context context)
    {
        if (instance == null)
        {
            instance = new RecordDao(context);
            return instance;
        } else
            return instance;
    }
}
