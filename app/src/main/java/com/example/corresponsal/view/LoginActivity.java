package com.example.corresponsal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;

import com.example.corresponsal.R;

public class LoginActivity extends AppCompatActivity {

    ConstraintLayout interfazC, interfazB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        interfazC = (ConstraintLayout) findViewById(R.id.intCorresponsal);
        interfazB = (ConstraintLayout) findViewById(R.id.intBanco);
    }

    public void interfazCorresponsal(View v){
        interfazC.setVisibility(View.VISIBLE);
        interfazB.setVisibility(View.INVISIBLE);
    }

    public void interfazBanco(View v){
        interfazC.setVisibility(View.INVISIBLE);
        interfazB.setVisibility(View.VISIBLE);
    }
}