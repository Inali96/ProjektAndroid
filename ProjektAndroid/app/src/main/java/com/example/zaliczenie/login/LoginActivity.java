package com.example.zaliczenie.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.zaliczenie.MainActivity;
import com.example.zaliczenie.R;
import com.google.android.material.snackbar.Snackbar;


public class LoginActivity extends AppCompatActivity {

    private Button button8;
    private EditText name,pass;
    private ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button8 = findViewById(R.id.button8);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        imageButton = findViewById(R.id.imageButton);
        setTitle("My app");
    }
    public void signin(View view) {

        if(pass.getText().toString().equals("pwste")&&!name.getText().toString().equals(""))
        {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("Name",name.getText().toString());
            startActivity(intent);
        }else
        {
            Snackbar.make(view,"Niepoprawne dane logowania",Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
    }
}