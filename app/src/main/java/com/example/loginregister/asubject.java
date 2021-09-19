package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class asubject extends AppCompatActivity {
    ListView l;
    String subjects[]
            = { "Programming through C", "Calculus","Engineering Physics","BEEE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asubject);
        l = findViewById(R.id.list);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,
                subjects);
        l.setAdapter(arr);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
//                Toast.makeText(asubject.this, selectedItem, Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getApplicationContext(),aupload.class);
//                String s = "MasterKey";
                intent.putExtra("id",selectedItem);
                startActivity(intent);


            }
        });




    }
}