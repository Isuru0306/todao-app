package com.navigate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.navigate.model.DBTraveller;

import java.io.IOException;
import java.util.ArrayList;

public class Login extends AppCompatActivity {

    private long pressedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        EditText travellerEmail = findViewById(R.id.loginEmail);
        EditText travellerPassword = findViewById(R.id.loginPassword);

        Button login = findViewById(R.id.login_button);
        DBTraveller dbTraveller = new DBTraveller(Login.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = travellerEmail.getText().toString();
                String password = travellerPassword.getText().toString();

                if(!email.isEmpty() && !password.isEmpty()){
                    ArrayList<String> data = dbTraveller.getData(email);

                    if (!data.isEmpty()){

                        if(email.equalsIgnoreCase(data.get(2)) && password.equals(data.get(3))){

                            Intent mainActivity = new Intent(Login.this, MainActivity.class);
                            startActivity(mainActivity);

                        }else{
                            Toast.makeText(Login.this, "Your password or email Wrong", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(Login.this, "You don't have an account. Please register..!", Toast.LENGTH_SHORT).show();
                    }
//
                }else{
                    Toast.makeText(Login.this, "All fields required", Toast.LENGTH_SHORT).show();
                }
//
            }
        });


    }


    public void viewRegisterClicked(View view){
        Intent register = new Intent(this, Register.class);
        startActivity(register);
    }

    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {

            finishAffinity();

        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }


}