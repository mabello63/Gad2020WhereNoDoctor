package com.plurasight.wherethereisnodoctor;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class ExamineTheSickViewHolder extends RecyclerView.ViewHolder {
    public  TextView detail_code, procedure, exam_code, exam_description;

    public ExamineTheSickViewHolder(View itemView) {
        super( itemView );
        exam_description = (TextView)  itemView.findViewById( R.id.exam_description );
        procedure = (TextView) itemView.findViewById( R.id.procedure );


    }
}



