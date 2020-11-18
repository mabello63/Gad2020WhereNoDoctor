package com.plurasight.wherethereisnodoctor;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class WelcomeActivity extends AppCompatActivity {
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_welcome );
        mToolbar = findViewById( R.id.toolbar );
        mToolbar.getOverflowIcon().setColorFilter( Color.WHITE, PorterDuff.Mode.DST);
        setSupportActionBar(mToolbar  );
    }
    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        super.setSupportActionBar( toolbar );
    }
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate( R.menu.app_menu, menu );
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){
            switch (item.getItemId()) {
                case R.id.register:
                    startActivity( new Intent( this, AddNewCasesActivity.class ) );
                    return true;
                case R.id.consult:
                    startActivity( new Intent( this, MainMedicalActivity.class ) );
                    return true;
                case R.id.individualMed:
                    startActivity( new Intent( this, PharmacyActivity.class ) );
                    return true;
                case R.id.groupMed:
                    startActivity( new Intent( this, PharmacyGroupActivity.class ) );
                    return true;
                case R.id.care_for_the_sick:
                    startActivity( new Intent( this, CareForSickActivity.class ) );
                    return true;
                case R.id.examine_the_sick:
                    startActivity( new Intent( this, ExamineTheSickActivity.class ) );
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }
    }
