package com.navigate.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.navigate.R;

import com.navigate.model.ItemData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    Context context;
    List<ItemData> itemDataList;

    public ItemAdapter(Context context, List<ItemData> itemDataList) {
        this.context = context;
        this.itemDataList = itemDataList;
    }



    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);

        // here we create a recyclerview row item layout file
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.rating.setText(itemDataList.get(position).getRating());
        holder.placeName.setText(itemDataList.get(position).getPlaceName());
        holder.price.setText(itemDataList.get(position).getPrice());
        Picasso.with(context).load(itemDataList.get(position).getImageUrl()).into(holder.placeImage);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent i = new Intent(context, ItemDetails.class);
//                s

            }
        });

    }

    @Override
    public int getItemCount() {
        return itemDataList.size();
    }

    public static final class ItemViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName, rating, price;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.hotelImage);
            placeName = itemView.findViewById(R.id.itemName);
            rating = itemView.findViewById(R.id.ratings);
            price = itemView.findViewById(R.id.price_v);


        }
    }
}
