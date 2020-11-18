package com.plurasight.wherethereisnodoctor;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class   DBPharmacyOpenHelper extends SQLiteAssetHelper {
    private static final String DTATABASE_NAME = "PharmacyDB171120B.db";
    private static final int DATABASE_VERSION = 2;

    public DBPharmacyOpenHelper(Context context) {
        super( context, DTATABASE_NAME,null, DATABASE_VERSION );
    }
}
