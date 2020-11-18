package com.plurasight.wherethereisnodoctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super( context, "MedConditions181120B.db", null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL( "create Table IndexCases(case_id TEXT primary key,case_desc TEXT, treatment TEXT, " +
                "signs TEXT, prevention TEXT,warnings TEXT, ref_page TEXT)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists IndexCases");
    }

    public Boolean insertIndexCases(String case_id, String case_desc, String treatment, String signs, String prevention,
                                    String warnings, String ref_page){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(  );
        contentValues.put("case_id",case_id);
        contentValues.put("case_desc",case_desc);
        contentValues.put("treatment",treatment);
        contentValues.put("signs",signs);
        contentValues.put("prevention",prevention);
        contentValues.put("warnings",warnings);
        contentValues.put("ref_page",ref_page);
      long result = DB.insert("indexCases",null,contentValues);
      if (result == -1) {
          return false;
      } else {
          return true;
      }

    }

    public Boolean updateIndexCases(String case_id, String case_desc, String treatment,String signs, String prevention,
                                    String warnings, String ref_page) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( "case_id", case_id );
        contentValues.put( "case_desc", case_desc );
        contentValues.put( "treatment", treatment);
        contentValues.put("signs", signs);
        contentValues.put("warnings", warnings);
        contentValues.put("ref_page", warnings);
        Cursor cursor = DB.rawQuery( "Select * from indexCases where case_id = ?", new String[]{case_id} );
        if (cursor.getCount() > 0) {
            long result = DB.update( "indexCases", contentValues, "case_id=?", new String[]{case_id} );
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
        public Boolean deleteIndexCases(String case_id){
            SQLiteDatabase DB = this.getWritableDatabase();
            Cursor cursor = DB.rawQuery("Select * from index_cases where case_id  = ?", new String[]{case_id});
            if (cursor.getCount()>0) {
                long result = DB.delete( "indexCases", "case_id=?", new String[]{case_id} );
                if (result == -1) {
                    return false;
                } else {
                    return true;
                }
            }else {
                return false;
            }

    }
    public Cursor getData(String case_desc){
       SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from indexCases where case_desc like ?", new String[]{case_desc});
        if (cursor.getCount()>0)
            return cursor;
        else
           return null;

    }
}
