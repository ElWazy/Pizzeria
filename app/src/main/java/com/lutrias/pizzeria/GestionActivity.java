package com.lutrias.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GestionActivity extends AppCompatActivity {

    TextView txtName, txtPrice, txtLocation;
    Button btnPizzaAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);

        obtainComponents();
        setButtonEvents();
    }

    private void obtainComponents() {
        txtName = findViewById(R.id.txtName);
        txtPrice = findViewById(R.id.txtPrice);
        txtLocation = findViewById(R.id.txtLocation);

        btnPizzaAdd = findViewById(R.id.btnPizzaAdd);
    }

    private void setButtonEvents() {
        btnPizzaAdd.setOnClickListener(this::add);
    }

    private void add(View view) {
        Toast.makeText(
            getBaseContext(),
            "{Name: '" + txtName.getText().toString()
                    + "', Price: " + txtPrice.getText().toString()
                    + ", Location: '" + txtLocation.getText().toString()
                    + "'}",
            Toast.LENGTH_SHORT
        ).show();
    }
}