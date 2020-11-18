package com.plurasight.wherethereisnodoctor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBPharmacyAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private  static DBPharmacyAccess instance;
    Cursor c = null;

    //private class so that object creation from outside the class is avoided
    private DBPharmacyAccess(Context context){
        this.openHelper = new DBPharmacyOpenHelper(context );
    }

    // to return the single instance of the DBMedAssetHelper
    public static DBPharmacyAccess getInstance(Context context){
        if (instance == null){
            instance = new DBPharmacyAccess( context );
        }
        return instance;
    }

    //to open the database
    public void open(){
        this.db = openHelper.getWritableDatabase();
    }

    //close the datase connection
    public void close(){
        if (db != null){
            this.db.close();
        }
    }


}
