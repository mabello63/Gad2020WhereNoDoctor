package com.plurasight.wherethereisnodoctor;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class ExamineTheSickActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ExamineTheSickAdapter adapter;
    DBCaringAssetHelper database;


    MaterialSearchBar materialSearchBar;
    List<String>  suggestList = new ArrayList<>(  );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_examine_the_sick);


        //init View
        recyclerView = (RecyclerView)findViewById( R.id.recycler_search) ;
        layoutManager = new LinearLayoutManager(this );
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setHasFixedSize( true );
        materialSearchBar = (MaterialSearchBar)findViewById(R.id.search_bar);

        // init DB
        database = new DBCaringAssetHelper(this);

        //set Up Search Bar
        materialSearchBar.setHint( "Search" );
        materialSearchBar.setCardViewElevation( 15 );
        loadSuggestedList();
        materialSearchBar.addTextChangeListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                 List<String> suggest = new ArrayList<>(  );
                 for (String search:suggestList) {
                     if(search.toLowerCase().contains( materialSearchBar.getText().toLowerCase() ))
                         suggest.add(search);
                 }
                 materialSearchBar.setLastSuggestions( suggest );
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );

        materialSearchBar.setOnSearchActionListener( new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                if(!enabled) {
                    recyclerView.setAdapter( adapter );
                }

            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                  startSearch( text.toString());
            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        } );

        //init Adapter default set all
        recyclerView.setAdapter( adapter );

    }

    private void startSearch(String text) {
//         adapter = new CareForSickSearchAdapter(  this, database.getCaringDetailsByDescription( text ) );
        adapter = new ExamineTheSickAdapter(  this, database.getExamDetails( text ) );

        recyclerView.setAdapter( adapter );
    }
    private void loadSuggestedList() {
        suggestList = database.getAllSimilarExamCases();
        materialSearchBar.setLastSuggestions( suggestList );
    }
}