package com.plurasight.wherethereisnodoctor;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class CareForSickSearchViewHolder extends RecyclerView.ViewHolder {
    public  TextView  care_details, care_desc;

    public CareForSickSearchViewHolder(View itemView) {
        super( itemView );
        care_desc = (TextView) itemView.findViewById( R.id.care_desc );
       care_details = (TextView) itemView.findViewById( R.id.care_details);

    }
}



