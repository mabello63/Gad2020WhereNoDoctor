package com.plurasight.wherethereisnodoctor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class AddNewCasesActivity extends AppCompatActivity {
    EditText case_id, case_desc,treatment,signs, prevention, warnings, ref_page;
    Button insert;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_new_cases );

        case_id = findViewById( R.id.case_id);
        case_desc = findViewById( R.id.case_desc);
        treatment = findViewById( R.id.treatment );
        signs = findViewById( R.id.signs );
        warnings = findViewById( R.id.warnings );
        prevention = findViewById( R.id.prevention );
        ref_page = findViewById( R.id.ref_page );
        insert = findViewById( R.id.btnInsert );

        DB = new DBHelper( this );
        insert.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String case_idTxt = case_id.getText().toString();
                String case_descTxt = case_desc.getText().toString();
                String treatmentTxt = treatment.getText().toString();
                String signsTxt = signs.getText().toString();
                String warningsTxt = warnings.getText().toString();
                String preventionTxt = prevention.getText().toString();
                String ref_pageTxt = ref_page.getText().toString();
                Boolean checkInsertData = DB.insertIndexCases(case_idTxt,case_descTxt,treatmentTxt,signsTxt,preventionTxt,
                          warningsTxt,ref_pageTxt);
                if (checkInsertData == true){
                    Toast.makeText( AddNewCasesActivity.this, "New Entry Inserted into the Database", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText( AddNewCasesActivity.this, "New Entry Could not be Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        } );



    }

}