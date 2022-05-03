package com.example.zaliczenie.maps;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.zaliczenie.FrameActivity;
import com.example.zaliczenie.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button button16,button17;
    private EditText editaddaddress;
    private ListView list;
    private ArrayAdapter adapter;

    public ListaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaFragment newInstance(String param1, String param2) {
        ListaFragment fragment = new ListaFragment();
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


        return inflater.inflate(R.layout.fragment_lista, container, false);
    }
    public void onViewCreated(View view,Bundle saved) {
        list= view.findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(view.getContext(),
                R.layout.support_simple_spinner_dropdown_item, FrameActivity.places);
        list.setAdapter(adapter);


        button16 = view.findViewById(R.id.button16);
        editaddaddress = view.findViewById(R.id.editaddaddress);

        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameActivity.places.add(editaddaddress.getText().toString());
                editaddaddress.setText("");
                list.invalidateViews();
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                FrameActivity.places.remove(position);
                list.invalidateViews();
                return false;
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MapsFragment mf = new MapsFragment();
                Bundle args = new Bundle();
                String data = FrameActivity.places.get(position);
                args.putString("geoadr",data);
                mf.setArguments(args);
                getFragmentManager().beginTransaction().replace(R.id.frameLayout, mf).commit();
            }
        });
    }
}