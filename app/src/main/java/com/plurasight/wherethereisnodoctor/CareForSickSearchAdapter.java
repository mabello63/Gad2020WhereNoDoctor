package com.plurasight.wherethereisnodoctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CareForSickSearchAdapter extends RecyclerView.Adapter<CareForSickSearchViewHolder>{

    private Context context;
    private List<CareForSickGroup> mCareForSickGroups;

    public CareForSickSearchAdapter(Context context, List<CareForSickGroup> mCareForSick) {
        this.context = context;
        this.mCareForSickGroups = mCareForSick;
    }

    @Override
    public CareForSickSearchViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( context );
        View itemView = inflater.inflate( R.layout.layout_care_for_sick_item, parent, false );
        return new CareForSickSearchViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(CareForSickSearchViewHolder holder, int position) {

        holder.care_details.setText( mCareForSickGroups.get(position).getDetails());
        holder.care_desc.setText( mCareForSickGroups.get(position).getCare_desc());

     }

    @Override
    public int getItemCount() {
        return mCareForSickGroups.size();
    }
}



