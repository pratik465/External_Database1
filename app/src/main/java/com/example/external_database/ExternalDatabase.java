package com.example.external_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;


public class ExternalDatabase extends SQLiteOpenHelper {

    String DB_PATH = "";
    static final String DB_NAME = "Data.db";
    Context Context;

    public ExternalDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Pratik", null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean isDataBaseExists() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }
}
