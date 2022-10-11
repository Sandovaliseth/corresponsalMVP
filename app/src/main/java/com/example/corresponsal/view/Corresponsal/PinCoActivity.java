package com.example.corresponsal.view.Corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.corresponsal.R;

public class PinCoActivity extends AppCompatActivity {

    EditText pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_co);

        pin = findViewById(R.id.confirmarPin);
    }
}