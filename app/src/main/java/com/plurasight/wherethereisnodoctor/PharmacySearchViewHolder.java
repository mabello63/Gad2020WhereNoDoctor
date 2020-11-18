package com.plurasight.wherethereisnodoctor;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class PharmacySearchViewHolder extends RecyclerView.ViewHolder {
    public TextView genericname, othernames, uses, dosage, warnings, caution, sigeeffects,moreinfo;

    public PharmacySearchViewHolder(View itemView) {
        super( itemView );

        genericname= (TextView) itemView.findViewById( R.id.GenericName);
        othernames = (TextView) itemView.findViewById( R.id.OtherNames );
        uses = (TextView) itemView.findViewById( R.id.Uses);
        dosage= (TextView) itemView.findViewById( R.id.Dosage);
        warnings = (TextView) itemView.findViewById( R.id.Warnings);
        caution= (TextView) itemView.findViewById( R.id.Caution );
        sigeeffects= (TextView) itemView.findViewById( R.id.SigeEffects);
 //       moreinfo= (TextView) itemView.findViewById( R.id.MoreInfo );
    }
}



