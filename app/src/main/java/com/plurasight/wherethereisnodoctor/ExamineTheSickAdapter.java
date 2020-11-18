package com.plurasight.wherethereisnodoctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ExamineTheSickAdapter extends RecyclerView.Adapter<ExamineTheSickViewHolder>{

    private Context context;
    private List<ExamineTheSickClass> examineTheSick;

    public ExamineTheSickAdapter(Context context, List<ExamineTheSickClass> examineTheSick) {
        this.context = context;
        this.examineTheSick = examineTheSick;
    }

    @Override
    public ExamineTheSickViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( context );
        View itemView = inflater.inflate( R.layout.layout_examine_the_sick_item, parent, false );
        return new ExamineTheSickViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(ExamineTheSickViewHolder  holder, int position) {

        holder.exam_description.setText( examineTheSick.get(position).getExam_description());
        holder.procedure.setText( examineTheSick.get(position).getProcedure());
     }
    @Override
    public int getItemCount() {
        return examineTheSick.size();
    }
}



