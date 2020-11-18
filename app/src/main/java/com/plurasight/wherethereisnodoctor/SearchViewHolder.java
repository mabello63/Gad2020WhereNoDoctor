package com.plurasight.wherethereisnodoctor;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class SearchViewHolder extends RecyclerView.ViewHolder {
    public TextView case_desc, signs, treatment, prevention,warnings, ref_page;

    public SearchViewHolder(View itemView) {
        super( itemView );

        case_desc = (TextView) itemView.findViewById( R.id.case_desc);
        signs = (TextView) itemView.findViewById( R.id.signs );
        treatment = (TextView) itemView.findViewById( R.id.treatment );
        prevention= (TextView) itemView.findViewById( R.id.prevention );
        warnings = (TextView) itemView.findViewById( R.id.warnings);
        ref_page= (TextView) itemView.findViewById( R.id.ref_page );
    }
}



