package com.navigate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.navigate.model.DBTraveller;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView travellerName = findViewById(R.id.travellerName);
        TextView travellerMobileNo = findViewById(R.id.travellerMobilNo);
        TextView travellerEmail = findViewById(R.id.travellerEmail);
        TextView travellerPassword = findViewById(R.id.travellerPassword);

        Button register = findViewById(R.id.register_button);

        DBTraveller dbTraveller = new DBTraveller(Register.this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = travellerName.getText().toString();
                String mobileNo = travellerMobileNo.getText().toString();
                String email = travellerEmail.getText().toString();
                String password = travellerPassword.getText().toString();

                if (name.isEmpty() || mobileNo.isEmpty() || email.isEmpty() || password.isEmpty()){
                    Toast.makeText(Register.this, "Please fill in all the information", Toast.LENGTH_SHORT).show();
                }else{
                    dbTraveller.addNewTraveller(name, mobileNo, email, password);
                    Toast.makeText(Register.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                    travellerName.setText("");
                    travellerMobileNo.setText("");
                    travellerEmail.setText("");
                    travellerPassword.setText("");
                }
            }
        });

    }

    public void viewLoginForm(View view){
        Intent loginForm = new Intent(this, Login.class);
        startActivity(loginForm);
    }

}