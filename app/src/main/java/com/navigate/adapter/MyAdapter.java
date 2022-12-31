package com.navigate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.navigate.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RecyclerVH> {

    Context c;
    String[] arry;

    public MyAdapter(Context c, String[] array){
        this.c = c;
        this.arry = array;
    }


    @NonNull
    @Override
    public RecyclerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(c).inflate(R.layout.item_cart, parent, false);

        return new RecyclerVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerVH holder, int position) {

        holder.itemName.setText(arry[position]);
    }

    @Override
    public int getItemCount() {
        return arry.length;
    }

    public class RecyclerVH extends  RecyclerView.ViewHolder{
        TextView itemName;
        public RecyclerVH(View itemView){
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.itemName);
        }
    }
}
