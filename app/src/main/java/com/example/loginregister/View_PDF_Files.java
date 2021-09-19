package com.example.loginregister;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class View_PDF_Files extends AppCompatActivity {
    ListView myPDfListView;
    DatabaseReference databaseReference;
    String message1;
    List<uploadPDF> uploadPDFS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__p_d_f__files);
        myPDfListView = findViewById(R.id.myListView);
        uploadPDFS = new ArrayList<>();
        Intent in = getIntent();
        message1 = in.getStringExtra("id1");

        viewAllFiles();
        myPDfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                uploadPDF uploadPDF = uploadPDFS.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(Uri.parse(uploadPDF.getUrl()));
//                Toast.makeText(View_PDF_Files.this, "Clicked", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    private void viewAllFiles() {


        databaseReference = FirebaseDatabase.getInstance().getReference(message1);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot postSnapshot: snapshot.getChildren()){
                    uploadPDF uploadPDF = postSnapshot.getValue(com.example.loginregister.uploadPDF.class);
                    uploadPDFS.add(uploadPDF);

                }
                String[] uploads = new String[uploadPDFS.size()];
                for(int i=0;i<uploads.length;i++){
                    uploads[i] = uploadPDFS.get(i).getName();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,uploads);
                myPDfListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}