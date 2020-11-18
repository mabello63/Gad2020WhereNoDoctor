package com.plurasight.wherethereisnodoctor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteQueryBuilder;


import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;


public class DBMedAssetHelper extends SQLiteAssetHelper {
    private static final String DB_NAME = "MedConditions181120B.db";
    private static final int DB_VER = 1;

    public DBMedAssetHelper(Context context) {
        super( context, DB_NAME, null, DB_VER );
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //    super.onUpgrade( db, oldVersion, newVersion );

        switch(oldVersion) {
            case 1:
                db.execSQL("DROP TABLE IF EXISTS IndexCases");

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

    //function getAllFriends
    public List<MedConditions> getIndexCases(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

//     Make sure all the column names are in your table
        String[] sqlSelect = {"case_id", "case_desc","signs","treatment", "prevention", "warnings", "ref_page"};
        String tableName = "IndexCases"; // Make sure this is your table name
        qb.setTables( tableName );
        Cursor cursor = qb.query( db,sqlSelect,null,null,
                null,null,null);
        List<MedConditions> result = new ArrayList<>(  );
        if (cursor.moveToFirst()){
            do {
                MedConditions medConditions = new MedConditions();
                medConditions.setCase_id( cursor.getString(cursor.getColumnIndex( "case_id" )  ) );
                medConditions.setCase_desc( cursor.getString(cursor.getColumnIndex( "case_desc" )  ) );
                medConditions.setSigns( cursor.getString(cursor.getColumnIndex( "signs" )  ) );
                medConditions.setTreatment( cursor.getString(cursor.getColumnIndex( "treatment" )  ) );
                medConditions.setPrevention( cursor.getString(cursor.getColumnIndex( "prevention" )  ) );
                medConditions.setWarnings( cursor.getString(cursor.getColumnIndex( "warnings" )  ) );
                medConditions.setRef_page( cursor.getString(cursor.getColumnIndex( "ref_page" )  ) );

                result.add( medConditions );
            } while (cursor.moveToNext());
        }
        return result;
    };

    //function get all friends Names
    public List<String> getAllSimilarCases(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

//     Make sure all the column names are in your table
        String[] sqlSelect = {"Case_desc"};
        String tableName = "IndexCases"; // Make sure this is your table name
        qb.setTables( tableName );
        Cursor cursor = qb.query( db,sqlSelect,null,null,null,null,null);
        List<String> result = new ArrayList<>(  );
        if (cursor.moveToFirst()){
            do {
                result.add(cursor.getString(cursor.getColumnIndex( "case_desc" )));
            } while (cursor.moveToNext());
        }
        return result;
    }

    //function get Friend by Name
    public List<MedConditions> getMedConditionsByDescription(String case_desc){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

//     Make sure all the column names are in your table
        String[] sqlSelect = {"case_id", "case_desc","signs","treatment", "prevention", "warnings", "ref_page"};
        String tableName = "IndexCases"; // Make sure this is your table name
        qb.setTables( tableName );

        // This will be like query: Select * from Friends where Name like %patter%
        // If you want to extract name, just change

        Cursor cursor = qb.query( db,sqlSelect,"case_desc LIKE ?",new String[]{"%"+case_desc+"%"},
                null,null,null);
        List<MedConditions> result = new ArrayList<>(  );
        if (cursor.moveToFirst()){
            do {

                MedConditions medConditions = new MedConditions();
                medConditions.setCase_id( cursor.getString(cursor.getColumnIndex( "case_id" )  ) );
                medConditions.setCase_desc( cursor.getString(cursor.getColumnIndex( "case_desc" )  ) );
                medConditions.setSigns( cursor.getString(cursor.getColumnIndex( "signs" )  ) );
                medConditions.setTreatment( cursor.getString(cursor.getColumnIndex( "treatment" )  ) );
                medConditions.setPrevention( cursor.getString(cursor.getColumnIndex( "prevention" )  ) );
                medConditions.setWarnings( cursor.getString(cursor.getColumnIndex( "warnings" )  ) );
                medConditions.setRef_page( cursor.getString(cursor.getColumnIndex( "ref_page" )  ) );


                result.add( medConditions );
            } while (cursor.moveToNext());
        }
        return result;

    }
}
