package com.plurasight.wherethereisnodoctor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBCaringOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "PharmacyDB171120B.db";

    private static DBCaringOpenHelper instance;
    private static final int DATABASE_VERSION = 2;

    public DBCaringOpenHelper(Context context) {
        super( context, DATABASE_NAME,null, DATABASE_VERSION );
    }
}
