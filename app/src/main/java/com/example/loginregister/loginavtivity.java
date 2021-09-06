package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginavtivity extends AppCompatActivity {
    EditText username1,password1;
    Button signin1;
    dbhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginavtivity);
        username1 = findViewById(R.id.username1);
        password1= findViewById(R.id.password1);
        signin1 = findViewById(R.id.signin1);
        db = new dbhelper(this);
        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username1.getText().toString();
                String pass = password1.getText().toString();
                if(user.equals("")||pass.equals("")){
                    Toast.makeText(loginavtivity.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass = db.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(loginavtivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),homeactivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(loginavtivity.this, "Invalid details", Toast.LENGTH_SHORT).show();
                    }
                }

                
            }
        });

    }
}