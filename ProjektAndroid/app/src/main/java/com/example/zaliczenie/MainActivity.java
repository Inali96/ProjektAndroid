package com.example.zaliczenie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zaliczenie.email.EmailActivity;
import com.example.zaliczenie.galeria.GaleriaActivity;
import com.example.zaliczenie.kkgra.KolkokrzyzykActivity;
import com.example.zaliczenie.kostka.GraActivity;
import com.example.zaliczenie.maps.MapsFragment;
import com.example.zaliczenie.paint.PaintActivity;
import com.example.zaliczenie.pkn.PKNActivity;
import com.example.zaliczenie.tekstnamowe.TekstnamoweActivity;
import com.example.zaliczenie.wybieranienumeru.TelefonActivity;

public class MainActivity extends AppCompatActivity {

    private Button grab,kkb,tekstnamoweb,paintb,pknb;
    private ImageButton nrb,emailb,gallerybb,locb;
    private TextView twelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        twelcome = findViewById(R.id.twelcome);

        String name=getIntent().getStringExtra("Name");
        twelcome.setText("Witaj"+" "+ name +"!");

        setTitle("Aplikacja multimedialna");

        grab = findViewById(R.id.grab);
        grab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                Intent intent = new Intent ( MainActivity.this , GraActivity.class);
                startActivity(intent);

            }});

        kkb = findViewById(R.id.kkb);
        kkb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                Intent intent = new Intent ( MainActivity.this , KolkokrzyzykActivity.class);
                startActivity(intent);

            }});

        tekstnamoweb= findViewById(R.id.tekstnamoweb);
        tekstnamoweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                Intent intent = new Intent ( MainActivity.this , TekstnamoweActivity.class);
                startActivity(intent);

            }});

        paintb= findViewById(R.id.paintb);
        paintb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                Intent intent = new Intent ( MainActivity.this , PaintActivity.class);
                startActivity(intent);

            }});
        pknb= findViewById(R.id.pknb);
        pknb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                Intent intent = new Intent ( MainActivity.this , PKNActivity.class);
                startActivity(intent);

            }});
    }

    public void call(View view) {
        Intent intent = new Intent ( MainActivity.this , TelefonActivity.class);
        startActivity(intent);
    }
    public void email(View view) {
        Intent intent = new Intent ( MainActivity.this , EmailActivity.class);
        startActivity(intent);
    }
    public void galeria(View view) {
        Intent intent = new Intent ( MainActivity.this , GaleriaActivity.class);
        startActivity(intent);
    }
    public void mapy(View view) {
        Intent intent = new Intent ( MainActivity.this , FrameActivity.class);
        startActivity(intent);
    }

    public void onBackPressed()
    {
        finishAffinity();
        finish();
    }

}