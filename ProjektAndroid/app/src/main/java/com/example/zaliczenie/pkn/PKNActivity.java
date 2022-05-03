package com.example.zaliczenie.pkn;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zaliczenie.R;

import java.util.Random;

public class PKNActivity extends AppCompatActivity {
    private ImageView papierkamiennozyce;
    private Random rng = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_k_n);

        papierkamiennozyce = findViewById(R.id.imageView);
        papierkamiennozyce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        int randomNumber = rng.nextInt(3) + 1;

        switch (randomNumber) {
            case 1:
                papierkamiennozyce.setImageResource(R.drawable.pkn1);
                break;
            case 2:
                papierkamiennozyce.setImageResource(R.drawable.pkn2);
                break;
            case 3:
                papierkamiennozyce.setImageResource(R.drawable.pkn3);
                break;

        }
    }
}