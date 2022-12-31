package com.navigate.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.navigate.EditHotelDetails;
import com.navigate.MainActivity;
import com.navigate.R;

import com.navigate.model.DBTraveller;
import com.navigate.model.ItemData;
import com.navigate.ui.home.HomeFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EditAdapter extends RecyclerView.Adapter<EditAdapter.EditItemViewHolder> {

    Context context;
    List<ItemData> itemDataList;

    public EditAdapter(Context context, List<ItemData> itemDataList) {
        this.context = context;
        this.itemDataList = itemDataList;
    }



    @NonNull
    @Override
    public EditItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.edit_layout, parent, false);

        // here we create a recyclerview row item layout file
        return new EditItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EditItemViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.id.setText(itemDataList.get(position).getId());
        holder.hotelname.setText(itemDataList.get(position).getPlaceName());
        holder.loaction.setText(itemDataList.get(position).getPrice());

        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit = new Intent(context, EditHotelDetails.class);
                edit.putExtra("id", itemDataList.get(position).getId());
                context.startActivity(edit);
            }
        });

        holder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBTraveller dbTraveller = new DBTraveller(context);
                dbTraveller.remove(itemDataList.get(position).getId());
                Toast.makeText(context, "Deleted successfully", Toast.LENGTH_SHORT).show();

                Intent main = new Intent(context, MainActivity.class);
                context.startActivity(main);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemDataList.size();
    }

    public static final class EditItemViewHolder extends RecyclerView.ViewHolder{

        TextView id, hotelname, loaction;
        Button editBtn, removeBtn;

        public EditItemViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.idhotel);
            hotelname = itemView.findViewById(R.id.hotelnameedit);
            loaction = itemView.findViewById(R.id.hotellocation);
            editBtn = itemView.findViewById(R.id.editbutton);
            removeBtn = itemView.findViewById(R.id.removebutton);

        }
    }
}
