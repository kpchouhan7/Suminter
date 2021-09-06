package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_acitivity extends AppCompatActivity {
  EditText admin_user,admin_pass;
  Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_acitivity);
        admin_user = findViewById(R.id.admin_user);
        admin_pass = findViewById(R.id.admin_pass);
        login  = findViewById(R.id.login);


       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String username,password;
               username = admin_user.getText().toString();
               password = admin_pass.getText().toString();
               if(username.equals("nm") && password.equals("123")){
                   Toast.makeText(Admin_acitivity.this, "login successful", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(getApplicationContext(),ahome.class);
                   startActivity(intent);
               }
               else{
                   Toast.makeText(Admin_acitivity.this, "login failed", Toast.LENGTH_SHORT).show();

               }
           }
       });

    }
}