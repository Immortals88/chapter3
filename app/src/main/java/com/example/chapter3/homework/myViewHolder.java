package com.example.chapter3.homework;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class myViewHolder extends RecyclerView.ViewHolder {
    private TextView mTextView;
    private TextView rank;
    public myViewHolder(View root) {
        super(root);
        mTextView = itemView.findViewById(R.id.tv_data);
        rank=itemView.findViewById(R.id.tv_rank);
    }
    public void bind(Data data,int position) {
        mTextView.setText(data.getInfo());
        if(position<=3){
            rank.setTextColor(0xe6face15);
        }
        rank.setText(position+".");
    }
}
