package com.example.zaliczenie.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class PaintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PaintView paintView = new PaintView (this);
        setContentView(paintView);
    }

}