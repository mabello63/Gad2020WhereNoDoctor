package com.plurasight.wherethereisnodoctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder>{

    private Context context;
    private List<MedConditions> medConditions;

    public SearchAdapter(Context context, List<MedConditions> medConditions) {
        this.context = context;
        this.medConditions = medConditions;
    }

    @Override
    public SearchViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( context );
        View itemView = inflater.inflate( R.layout.layout_medical_item, parent, false );
        return new SearchViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.case_desc.setText( medConditions.get(position).getCase_desc());
        holder.signs.setText( medConditions.get(position).getSigns());
        holder.treatment.setText( medConditions.get(position).getTreatment());
        holder.prevention.setText( medConditions.get(position).getPrevention());
        holder.warnings.setText( medConditions.get(position).getWarnings());
        holder.ref_page.setText( medConditions.get(position).getRef_page());

    }

    @Override
    public int getItemCount() {
        return medConditions.size();
    }
}



