package com.plurasight.wherethereisnodoctor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;


public class DBPharmacyAssetHelper extends SQLiteAssetHelper {
    private static final String DB_NAME = "PharmacyDB171120B.db";
    private static final int DB_VER = 2;

    public DBPharmacyAssetHelper(Context context) {
        super( context, DB_NAME, null, DB_VER );
    }

    //function getAllFriends
    public List<Pharmacy> getIndexCases() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //      public   String medcode, genericname,othernames,uses,dosage,warnings, caution,sigeeffects,moreinfo, groupcode;

//     Make sure all the column names are in your table
        String[] sqlSelect = {"MedCode", "GenericName", "OtherNames", "Uses", "Dosage", "Warnings", "Caution",
                "SigeEffects", "MoreInfo", "GroupCode"};
        String tableName = "Medicines"; // Make sure this is your table name
        qb.setTables( tableName );
        Cursor cursor = qb.query( db, sqlSelect, null, null, null, null, null );
        List<Pharmacy> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Pharmacy pharmacy = new Pharmacy();
                pharmacy.setMedCode( cursor.getString( cursor.getColumnIndex( "MedCode" ) ) );
                pharmacy.setGenericName( cursor.getString( cursor.getColumnIndex( "GenericName" ) ) );
                pharmacy.setOtherNames( cursor.getString( cursor.getColumnIndex( "OtherNames" ) ) );
                pharmacy.setUses( cursor.getString( cursor.getColumnIndex( "Uses" ) ) );
                pharmacy.setDosage( cursor.getString( cursor.getColumnIndex( "Dosage" ) ) );
                pharmacy.setWarnings( cursor.getString( cursor.getColumnIndex( "Warnings" ) ) );
                pharmacy.setCaution( cursor.getString( cursor.getColumnIndex( "Caution" ) ) );
                pharmacy.setSigeEffects( cursor.getString( cursor.getColumnIndex( "SigeEffects" ) ) );
                pharmacy.setMoreInfo( cursor.getString( cursor.getColumnIndex( "MoreInfo" ) ) );
                pharmacy.setGroupCode( cursor.getString( cursor.getColumnIndex( "GroupCode" ) ) );
                result.add( pharmacy );
            } while (cursor.moveToNext());
        }
        return result;
    }

    ;

    //function get all friends Names
    public List<String> getAllSimilarCases() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

//     Make sure all the column names are in your table
        String[] sqlSelect = {"GenericName"};
        String tableName = "Medicines"; // Make sure this is your table name
        qb.setTables( tableName );
        Cursor cursor = qb.query( db, sqlSelect, null, null, null, null, null );
        List<String> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                result.add( cursor.getString( cursor.getColumnIndex( "GenericName" ) ) );
            } while (cursor.moveToNext());
        }
        return result;
    }

    //function get Friend by Name
    public List<Pharmacy> getMedDetailsByGenericNames(String genericname) {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

//     Make sure all the column names are in your table
        String[] sqlSelect = {"medcode", "GenericName", "othernames", "uses", "dosage", "warnings", "caution",
                "sigeeffects", "moreinfo", "groupcode"};
        String tableName = "Medicines"; // Make sure this is your table name
        qb.setTables( tableName );

        // This will be like query: Select * from Friends where Name like %patter%
        // If you want to extract name, just change

        Cursor cursor = qb.query( db, sqlSelect, "GenericName LIKE ?", new String[]{"%" + genericname + "%"},
                null, null, null );
        List<Pharmacy> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {

                Pharmacy pharmacy = new Pharmacy();
                pharmacy.setMedCode( cursor.getString( cursor.getColumnIndex( "MedCode" ) ) );
                pharmacy.setGenericName( cursor.getString( cursor.getColumnIndex( "GenericName" ) ) );
                pharmacy.setOtherNames( cursor.getString( cursor.getColumnIndex( "OtherNames" ) ) );
                pharmacy.setUses( cursor.getString( cursor.getColumnIndex( "Uses" ) ) );
                pharmacy.setDosage( cursor.getString( cursor.getColumnIndex( "Dosage" ) ) );
                pharmacy.setWarnings( cursor.getString( cursor.getColumnIndex( "Warnings" ) ) );
                pharmacy.setCaution( cursor.getString( cursor.getColumnIndex( "Caution" ) ) );
                pharmacy.setSigeEffects( cursor.getString( cursor.getColumnIndex( "SigeEffects" ) ) );
                pharmacy.setMoreInfo( cursor.getString( cursor.getColumnIndex( "MoreInfo" ) ) );
                pharmacy.setGroupCode( cursor.getString( cursor.getColumnIndex( "GroupCode" ) ) );
                result.add( pharmacy );

            } while (cursor.moveToNext());
        }
        return result;
    }
}
