package com.example.external_database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class ExternalDatabase extends SQLiteOpenHelper {

    String DB_PATH = "";
    static final String DB_NAME = "Data.db";
    Context context;
    String DB_Path = "";

    public ExternalDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) throws IOException {
        super(context, "Pratik", null, 1);
        this.context = context;
        DB_Path = context.getApplicationInfo().dataDir + "/databases/";
        if (isDataBaseExists()){
            copyDataBase();
        }

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
    private void copyDataBase() throws IOException {

        InputStream myInput = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public List<ShayriModel> getShayri(){
        List<ShayriModel> modelList = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        String que = "SELECT * FROM myShayri";
        Cursor cursor = database.rawQuery(que,null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {

            int id = cursor.getInt(0);
            String shayri = cursor.getString(1);
            String cat = cursor.getString(2);
            ShayriModel model = new ShayriModel(id,shayri,cat);
            modelList.add(model);
            cursor.moveToNext();

        }
        return modelList;
    }

}
