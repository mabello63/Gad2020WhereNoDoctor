package com.plurasight.wherethereisnodoctor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;


public class DBPharmacyGroupAssetHelper extends SQLiteAssetHelper {
    private static final String DB_NAME = "PharmacyDB171120B.db";
    private static final int DB_VER = 2;

    public DBPharmacyGroupAssetHelper(Context context) {
        super( context, DB_NAME, null, DB_VER );
    }


    public List<PharmacyGroup> getIndexCases() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"MedCode", "GenericName", "OtherNames", "Uses", "Dosage", "Warnings", "Caution",
                "SigeEffects", "MoreInfo", "Desc"};
        String tableName = "Medicines INNER JOIN Groupings ON Medicines.GroupCode = Groupings.GroupCode";
        qb.setTables( tableName );
        Cursor cursor = qb.query( db, sqlSelect, null, null, null, null, null );
        List<PharmacyGroup> result = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                PharmacyGroup pharmacy = new PharmacyGroup();
                //        pharmacy.setMedCode(cursor.getString(cursor.getColumnIndex( "MedCode" )));
                pharmacy.setGenericName( cursor.getString( cursor.getColumnIndex( "GenericName" ) ) );
                pharmacy.setOtherNames( cursor.getString( cursor.getColumnIndex( "OtherNames" ) ) );
                pharmacy.setUses( cursor.getString( cursor.getColumnIndex( "Uses" ) ) );
                pharmacy.setDosage( cursor.getString( cursor.getColumnIndex( "Dosage" ) ) );
                pharmacy.setWarnings( cursor.getString( cursor.getColumnIndex( "Warnings" ) ) );
                pharmacy.setCaution( cursor.getString( cursor.getColumnIndex( "Caution" ) ) );
                pharmacy.setSigeEffects( cursor.getString( cursor.getColumnIndex( "SigeEffects" ) ) );
                pharmacy.setMoreInfo( cursor.getString( cursor.getColumnIndex( "MoreInfo" ) ) );
                pharmacy.setGroupCode( cursor.getString( cursor.getColumnIndex( "Desc" ) ) );
                result.add( pharmacy );
            } while (cursor.moveToNext());
        }
        return result;
    }


    //function get all friends Names
    public List<String> getAllSimilarCases() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

//     Make sure all the column names are in your table
//        String[] sqlSelect = {"GenericName"};
        String[] sqlSelect = {"Desc"};
        String tableName = "Medicines INNER JOIN Groupings ON Medicines.GroupCode = Groupings.GroupCode"; // Make sure this is your table name
        qb.setTables( tableName );
        Cursor cursor = qb.query( db, sqlSelect, null, null, null, null, null );
        List<String> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                result.add( cursor.getString( cursor.getColumnIndex( "Desc" ) ) );
            } while (cursor.moveToNext());
        }
        return result;
    }


    public List<PharmacyGroup> getMedDetailsByGroupNames(String groupName) {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

//     Make sure all the column names are in your table
        String[] sqlSelect = {"MedCode", "GenericName", "OtherNames", "Uses", "Dosage", "Warnings", "Caution",
                "Sigeeffects", "MoreInfo", "Groupings.Desc"};
        // String tableName = "Medicines"; // Make sure this is your table name

        String tableName = "Medicines INNER JOIN Groupings ON Medicines.GroupCode = Groupings.GroupCode"; // Make sure this is your table name
        qb.setTables( tableName );

        Cursor cursor = qb.query( db, sqlSelect, "Groupings.Desc LIKE ?", new String[]{"%" + groupName + "%"},
                null, null, null );
        List<PharmacyGroup> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {

                PharmacyGroup pharmacy = new PharmacyGroup();
                pharmacy.setMedCode( cursor.getString( cursor.getColumnIndex( "MedCode" ) ) );
                pharmacy.setGenericName( cursor.getString( cursor.getColumnIndex( "GenericName" ) ) );
                pharmacy.setOtherNames( cursor.getString( cursor.getColumnIndex( "OtherNames" ) ) );
                pharmacy.setUses( cursor.getString( cursor.getColumnIndex( "Uses" ) ) );
                pharmacy.setDosage( cursor.getString( cursor.getColumnIndex( "Dosage" ) ) );
                pharmacy.setWarnings( cursor.getString( cursor.getColumnIndex( "Warnings" ) ) );
                pharmacy.setCaution( cursor.getString( cursor.getColumnIndex( "Caution" ) ) );
                pharmacy.setSigeEffects( cursor.getString( cursor.getColumnIndex( "SigeEffects" ) ) );
                pharmacy.setMoreInfo( cursor.getString( cursor.getColumnIndex( "MoreInfo" ) ) );
                //          pharmacy.setGroupCode(cursor.getString(cursor.getColumnIndex( "GroupCode")));
                result.add( pharmacy );

            } while (cursor.moveToNext());
        }
        return result;
    }
    // Adpater SetUp For Caring For Sick Module



    ;


//    public List<String> getAllSimilarCaringCases() {
//        SQLiteDatabase db = getReadableDatabase();
//        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
//
////     Make sure all the column names are in your table
////        String[] sqlSelect = {"GenericName"};
//        String[] sqlSelect = {"case_desc"};
////          String tableName = "Caringforsickness INNER JOIN Caringcategory ON Caringforsickness.category_code = Caringcategory.category_code";
//        String tableName = " Caringforsickness INNER JOIN Caringcategory  ON Caringforsickness.category_code = Caringcategory.category_code";
//
//        qb.setTables( tableName );
//        Cursor cursor = qb.query( db, sqlSelect, null, null, null, null, null );
//        List<String> result = new ArrayList<>();
//        if (cursor.moveToFirst()) {
//            do {
//                result.add( cursor.getString( cursor.getColumnIndex( "case_desc" ) ) );
//            } while (cursor.moveToNext());
//        }
//        return result;
//    }


    public List<CareForSickGroup> getCaringDetailsByDescription(String descriptionCaption) {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

//     Make sure all the column names are in your table
        String[] sqlSelect = {"care_code", "details", "category_code", "care_desc", "Caringcategory.category_code"};
        // String tableName = "Medicines"; // Make sure this is your table name

        String tableName = "Caringforsickness INNER JOIN Caringcategory ON Caringforsickness.category_code = Caringcategory.category_code"; // Make sure this is your table name
        qb.setTables( tableName );

        Cursor cursor = qb.query( db, sqlSelect, "CaringCategory.care_desc LIKE ?", new String[]{"%" + descriptionCaption + "%"},
                null, null, null );
        List<CareForSickGroup> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                CareForSickGroup careForSickGroup = new CareForSickGroup();
                careForSickGroup.setCare_code( cursor.getString( cursor.getColumnIndex( "care_code" ) ) );
                careForSickGroup.setDetails( cursor.getString( cursor.getColumnIndex( "details" ) ) );
                careForSickGroup.setCategory_code( cursor.getString( cursor.getColumnIndex( "category_code" ) ) );
                //                careForSickGroup.setCare_desc(cursor.getString(cursor.getColumnIndex( "care_desc")));

                result.add( careForSickGroup );
            } while (cursor.moveToNext());
        }
        return result;

    }

}