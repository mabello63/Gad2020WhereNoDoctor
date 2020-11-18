package com.plurasight.wherethereisnodoctor;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBMedicalOpenHelper extends SQLiteAssetHelper {
    private static final String DTATABASE_NAME = "MyExternalDatabase.db";
    private static final int DATABASE_VERSION = 1;

    public DBMedicalOpenHelper(Context context) {
        super( context, DTATABASE_NAME,null, DATABASE_VERSION );
    }
}
