package com.example.zaliczenie.maps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.zaliczenie.R;
import com.google.android.gms.maps.MapFragment;

public class MapsFragment extends Fragment {



    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private Button button14,button15;
    private EditText editTextLat,editTextLong,editaddress;

    public MapsFragment() {

    }



    public static MapsFragment newInstance(String param1, String param2) {
        MapsFragment fragment = new MapsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view = inflater.inflate(R.layout.fragment_maps, container, false);
        return inflater.inflate(R.layout.fragment_maps, container, false);

    }
    @Override
    public void onViewCreated(View view,Bundle saved){
        button14 = view.findViewById(R.id.button14);
        button15 = view.findViewById(R.id.button15);
        editTextLat = view.findViewById(R.id.editTextLat);
        editTextLong = view.findViewById(R.id.editTextLong);
        editaddress = view.findViewById(R.id.editaddress);

        Bundle bundle=this.getArguments();
        String data = bundle.getString("geoadr");
        editaddress.setText(data);

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geodata = "geo:" + editTextLat.getText() + "," + editTextLong.getText();
                Uri gmmIntentUri = Uri.parse(geodata);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                Log.println(Log.ERROR,"cc",geodata);
            }
        });

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geodata = "geo:0,0?q=" + editaddress.getText();
                Uri gmmIntentUri = Uri.parse(geodata);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
