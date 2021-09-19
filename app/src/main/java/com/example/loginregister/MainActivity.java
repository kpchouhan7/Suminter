package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password,retype;
    Button signin, signup,admin,loginpage,adminpage;
    dbhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        username = findViewById(R.id.username);
//        password =  findViewById(R.id.password);
//        retype =  findViewById(R.id.retype);
//        signin =  findViewById(R.id.signin);
//        signup =  findViewById(R.id.signup);
//        admin = findViewById(R.id.admin);
        loginpage = findViewById(R.id.loginpage);
        adminpage = findViewById(R.id.adminpage);
        loginpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginPage.class);
                startActivity(intent);
            }
        });
        adminpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Admin_acitivity.class);
                startActivity(intent);
            }
        });

//        admin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),Admin_acitivity.class);
//                startActivity(intent);
//            }
//        });
//        db = new dbhelper(this);
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String user = username.getText().toString();
//                String pass = password.getText().toString();
//                String rety = retype.getText().toString();
//                if(user.equals("") || pass.equals("") || rety.equals("")){
//                    Toast.makeText(MainActivity.this, "Enter All the fields", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    if(pass.equals(rety)){
//                        Boolean checkuser  = db.checkusername(user);
//                        if(checkuser==false){
//                            Boolean insert = db.insertData(user,pass);
//                            if(insert==true){
//                                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(getApplicationContext(),homeactivity.class);
//                                startActivity(intent);
//                            }
//                            else{
//                                Toast.makeText(MainActivity.this, "Registered failed", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                        else{
//                            Toast.makeText(MainActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    else{
//                        Toast.makeText(MainActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//            }
//        });
//        signin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),loginavtivity.class);
//                startActivity(intent);
//            }
//        });

    }
}