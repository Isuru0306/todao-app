package com.navigate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.navigate.model.DBTraveller;

import java.util.ArrayList;
import java.util.List;

public class EditHotelDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hotel_details);

        String id = getIntent().getStringExtra("id");

        EditText name = findViewById(R.id.hotel_name_t);
        EditText location = findViewById(R.id.location_t);
        EditText url = findViewById(R.id.hotel_image_url);
        EditText rating = findViewById(R.id.hotel_ratings);
        EditText price = findViewById(R.id.hotel_price);

        Button update = findViewById(R.id.update_hotel_button);

        DBTraveller dbTraveller = new DBTraveller(this);
        ArrayList<String> data = dbTraveller.getEditData(id);
        System.out.println(data);

        name.setText(data.get(0));
        location.setText(data.get(1));
        url.setText(data.get(2));
        rating.setText(data.get(3));
        price.setText(data.get(4));

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbTraveller.update(id, rating.getText().toString(), price.getText().toString());
                Toast.makeText(EditHotelDetails.this, "Update successfully", Toast.LENGTH_SHORT).show();

                Intent main = new Intent(EditHotelDetails.this, MainActivity.class);
                startActivity(main);
            }
        });



    }
}