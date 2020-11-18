package com.plurasight.wherethereisnodoctor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBMedicalAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private  static DBMedicalAccess instance;
    Cursor c = null;

    //private class so that object creation from outside the class is avoided
    private DBMedicalAccess(Context context){
        this.openHelper = new DBMedicalOpenHelper(context );
    }

    // to return the single instance of the DBMedAssetHelper
    public static DBMedicalAccess getInstance(Context context){
        if (instance == null){
            instance = new DBMedicalAccess( context );
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

    //now let us create a method to query the databse and return retuslts
    // We will query the address by providing the name

    public String getAddress(String name) {
        c= db.rawQuery( "select Address from Table1 where Name = '"+name+"'", new String[]{});
        StringBuffer buffer = new StringBuffer(  );
        while (c.moveToNext()){
            String address = c.getString( 0);
            buffer.append( " "+address );
        }
        return buffer.toString();
    }
}
