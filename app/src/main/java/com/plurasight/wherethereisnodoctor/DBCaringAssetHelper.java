package com.plurasight.wherethereisnodoctor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;


public class DBCaringAssetHelper extends SQLiteAssetHelper {
    private static final String DB_NAME = "PharmacyDB171120B.db";
    private static final int DB_VER = 2;

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    //    super.onUpgrade( db, oldVersion, newVersion );

        switch(oldVersion) {
            case 1:
               db.execSQL("DROP TABLE IF EXISTS Caringforsickness");
               db.execSQL("DROP TABLE IF EXISTS Caringcategory");
               db.execSQL("DROP TABLE IF EXISTS ExamDetails");
               db.execSQL("DROP TABLE IF EXISTS ExamineSickPerson");
               db.execSQL("DROP TABLE IF EXISTS Medicines");
            case 2:
                //upgrade logic from version 2 to 3
            case 3:
                //upgrade logic from version 3 to 4
                break;
            default:
                throw new IllegalStateException(
                        "onUpgrade() with unknown oldVersion " + oldVersion);
        }


    }

    public DBCaringAssetHelper(Context context) {

        super( context, DB_NAME, null, DB_VER );

    }


    public List<CareForSickGroup> getIndexCases() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"care_code", "details","category_code", "care_desc"};
        String tableName = "Caringforsickness INNER JOIN Caringcategory ON CaringForSickness.category_code = Caringcategory.category_code";
        qb.setTables( tableName );
        Cursor cursor = qb.query( db, sqlSelect, null, null, null, null, null );
        List<CareForSickGroup> result = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                CareForSickGroup careForSickGroup = new CareForSickGroup();
                careForSickGroup.setCare_code( cursor.getString( cursor.getColumnIndex( "care_code" ) ) );
                careForSickGroup.setDetails( cursor.getString( cursor.getColumnIndex( "details" ) ) );
                careForSickGroup.setCategory_code( cursor.getString( cursor.getColumnIndex( "category_code" ) ) );
                careForSickGroup.setCare_desc( cursor.getString( cursor.getColumnIndex( "care_desc" ) ) );
                result.add( careForSickGroup );
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
        String[] sqlSelect = {"care_desc"};
        String tableName = "Caringforsickness INNER JOIN Caringcategory ON CaringForSickness.category_code = Caringcategory.category_code"; // Make sure this is your table name
        qb.setTables( tableName );
        Cursor cursor = qb.query( db, sqlSelect, null, null, null, null, null );
        List<String> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                result.add( cursor.getString( cursor.getColumnIndex( "care_desc" ) ) );
            } while (cursor.moveToNext());
        }
        return result;
    }


    public List<CareForSickGroup> getCareDeails(String description) {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"care_code", "details","Caringforsickness.category_code", "care_desc"};

        String tableName = "Caringforsickness INNER JOIN Caringcategory ON CaringForSickness.category_code = Caringcategory.category_code"; // Make sure this is your table name
        qb.setTables( tableName );

        Cursor cursor = qb.query( db, sqlSelect, "Caringcategory.care_desc LIKE ?", new String[]{"%" + description + "%"},
                null, null, null );
        List<CareForSickGroup> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {

                CareForSickGroup careForSickGroup = new CareForSickGroup();
                careForSickGroup.setCare_code( cursor.getString( cursor.getColumnIndex( "care_code" ) ) );
                careForSickGroup.setDetails( cursor.getString( cursor.getColumnIndex( "details" ) ) );
                careForSickGroup.setCategory_code( cursor.getString( cursor.getColumnIndex( "category_code" ) ) );
                careForSickGroup.setCare_desc( cursor.getString( cursor.getColumnIndex( "care_desc" ) ) );


                result.add( careForSickGroup );

            } while (cursor.moveToNext());
        }
        return result;
    }
// Module for Examining The Sick Person

public List<ExamineTheSickClass> getIndexExamCases() {
    SQLiteDatabase db = getReadableDatabase();
    SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
    String[] sqlSelect = {"detail_code", "procedure","exam_code", "exam_description"};
    String tableName = "ExamDetails INNER JOIN ExamineSickPerson ON ExamDetails.exam_code = ExamineSickPerson.exam_code";
    qb.setTables( tableName );
    Cursor cursor = qb.query( db, sqlSelect, null, null, null, null, null );
    List<ExamineTheSickClass> result = new ArrayList<>();

    if (cursor.moveToFirst()) {
        do {
            ExamineTheSickClass examineTheSick = new ExamineTheSickClass();
            examineTheSick.setDetail_code( cursor.getString( cursor.getColumnIndex( "detail_code" ) ) );
            examineTheSick.setProcedure( cursor.getString( cursor.getColumnIndex( "procedure" ) ) );
            examineTheSick.setExam_code( cursor.getString( cursor.getColumnIndex( "exam_code" ) ) );
            examineTheSick.setExam_description( cursor.getString( cursor.getColumnIndex( "exam_description" ) ) );
            result.add( examineTheSick );
        } while (cursor.moveToNext());
    }
    return result;
}
    //function get all friends Names
    public List<String> getAllSimilarExamCases() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

//     Make sure all the column names are in your table
//        String[] sqlSelect = {"GenericName"};
        String[] sqlSelect = {"exam_description"};
        String tableName = "ExamDetails INNER JOIN ExamineSickPerson ON ExamDetails.exam_code = ExamineSickPerson.exam_code"; // Make sure this is your table name
        qb.setTables( tableName );
        Cursor cursor = qb.query( db, sqlSelect, null, null, null, null, null );
        List<String> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                result.add( cursor.getString( cursor.getColumnIndex( "exam_description" ) ) );
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<ExamineTheSickClass> getExamDetails(String description) {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"detail_code", "procedure","ExamDetails.exam_code", "exam_description"};

        String tableName = "ExamDetails INNER JOIN ExamineSickPerson ON ExamDetails.exam_code = ExamineSickPerson.exam_code"; // Make sure this is your table name
        qb.setTables( tableName );

        Cursor cursor = qb.query( db, sqlSelect, "ExamineSickPerson.exam_description LIKE ?", new String[]{"%" + description + "%"},
                null, null, null );
        List<ExamineTheSickClass> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                ExamineTheSickClass examineTheSick = new ExamineTheSickClass();
                examineTheSick.setDetail_code( cursor.getString( cursor.getColumnIndex( "detail_code" ) ) );
                examineTheSick.setProcedure( cursor.getString( cursor.getColumnIndex( "procedure" ) ) );
                examineTheSick.setExam_code( cursor.getString( cursor.getColumnIndex( "exam_code" ) ) );
                examineTheSick.setExam_description( cursor.getString( cursor.getColumnIndex( "exam_description" ) ) );
                result.add( examineTheSick );

            } while (cursor.moveToNext());
        }
        return result;
    }

}