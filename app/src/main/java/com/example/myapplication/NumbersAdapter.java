package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder> {
    Context mCtx;
    List<Num> numbersList;
    List<Integer> same_cells;
    public NumbersAdapter(Context mCtx, ArrayList<Num> numList) {
        this.mCtx = mCtx;
        this.numbersList = numList;
        String s= Utils.findItemsThatSumTozero(numList);
        if(s.contains(","))
        {
            s=s.substring(0,s.length()-1);
            String[] same_cells_s=s.split(",");
            same_cells=new ArrayList<>();
            for (int i=0;i<same_cells_s.length;i++)
                same_cells.add(Integer.parseInt(same_cells_s[i].toString()));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(same_cells!=null&&same_cells.contains(position))
            return 1;
        else return 0;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(mCtx).inflate(R.layout.grid_layout, parent, false);
        View view2= LayoutInflater.from(mCtx).inflate(R.layout.grid_same_layout, parent, false);
        if(viewType==1)
            return new NumberViewHolder(view2);
        else
           return new NumberViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        Num num = numbersList.get(position);
        holder.textView.setText(num.getNumber()+"");
    }

    @Override
    public int getItemCount() {
        return numbersList.size();
    }


    class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public NumberViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_number);
        }
    }


}
