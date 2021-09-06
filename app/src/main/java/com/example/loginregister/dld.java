package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class dld extends AppCompatActivity {
  PDFView pdf1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dld);
        pdf1 = findViewById(R.id.pdf1);
        pdf1.fromAsset("pdf1.pdf").load();
    }
}