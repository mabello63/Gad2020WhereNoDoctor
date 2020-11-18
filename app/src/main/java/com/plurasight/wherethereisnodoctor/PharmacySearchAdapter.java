package com.plurasight.wherethereisnodoctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class PharmacySearchAdapter extends RecyclerView.Adapter<PharmacySearchViewHolder>{

    private Context context;
    private List<Pharmacy> pharmacy;

    public PharmacySearchAdapter(Context context, List<Pharmacy> pharmacy) {
        this.context = context;
        this.pharmacy = pharmacy;
    }

    @Override
    public PharmacySearchViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( context );
        View itemView = inflater.inflate( R.layout.layout_pharmacy_item, parent, false );
        return new PharmacySearchViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(PharmacySearchViewHolder holder, int position) {

        holder.genericname.setText( pharmacy.get(position).getGenericName());
        holder.othernames.setText( pharmacy.get(position).getOtherNames());
        holder.uses.setText( pharmacy.get(position).getUses());
        holder.dosage.setText( pharmacy.get(position).getDosage());
        holder.warnings.setText( pharmacy.get(position).getWarnings());
        holder.caution.setText( pharmacy.get(position).getCaution());
        holder.sigeeffects.setText( pharmacy.get(position).getSigeEffects());
     }

    @Override
    public int getItemCount() {
        return pharmacy.size();
    }
}



