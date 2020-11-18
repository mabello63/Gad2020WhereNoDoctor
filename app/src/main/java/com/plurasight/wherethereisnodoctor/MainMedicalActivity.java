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

public class  MainMedicalActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SearchAdapter adapter;
    DBMedAssetHelper database;

    MaterialSearchBar materialSearchBar;
    List<String>  suggestList = new ArrayList<>(  );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_medical);

        //init View
        recyclerView = (RecyclerView)findViewById( R.id.recycler_search) ;
        layoutManager = new LinearLayoutManager(this );
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setHasFixedSize( true );
        materialSearchBar = (MaterialSearchBar)findViewById(R.id.search_bar);

        // init DB
        database = new DBMedAssetHelper(  this);

        //set Up Search Bar
        materialSearchBar.setHint( "Search" );
        materialSearchBar.setCardViewElevation( 10 );
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
        adapter = new SearchAdapter( this, database.getIndexCases());
        recyclerView.setAdapter( adapter );

    }

    private void startSearch(String text) {
         adapter = new SearchAdapter( this, database.getMedConditionsByDescription( text ) );
         recyclerView.setAdapter( adapter );
    }
    private void loadSuggestedList() {
        suggestList = database.getAllSimilarCases();
        materialSearchBar.setLastSuggestions( suggestList );
    }
}