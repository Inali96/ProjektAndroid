package com.example.zaliczenie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.zaliczenie.maps.ListaFragment;
import com.example.zaliczenie.maps.MapsFragment;

import java.util.ArrayList;
import java.util.Collections;

public class FrameActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private Button button11,button12,button13;
    public static ArrayList<String> places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);


        frameLayout = findViewById(R.id.frameLayout);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);

        places = new ArrayList<>();
        Collections.addAll(places,new String[]{"Kombatantów","Warszawa"});



        button11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MapsFragment mf = new MapsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("geoaddr","");
                mf.setArguments(bundle);
                loadfragment(mf);

            }
        });
        button12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                loadfragment(new ListaFragment());
            }
        });




    }
    public void loadfragment(Fragment fragment)
    {
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction fT=fm.beginTransaction();
        fT.replace(R.id.frameLayout,fragment);
        fT.commit();

    }

}