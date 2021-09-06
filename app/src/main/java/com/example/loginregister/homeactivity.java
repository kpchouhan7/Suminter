package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homeactivity extends AppCompatActivity {
      Button cse,ece,it,csbs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
         cse = findViewById(R.id.cse);


         cse.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),select_year.class);
               startActivity(intent);
             }
         });
    }
}