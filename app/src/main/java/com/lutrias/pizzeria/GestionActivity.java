package com.lutrias.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lutrias.pizzeria.context.pizza.application.AddPizza;
import com.lutrias.pizzeria.context.pizza.domain.PizzaRepository;
import com.lutrias.pizzeria.context.pizza.domain.PizzaTypeDTO;

import java.util.UUID;

public class GestionActivity extends AppCompatActivity {

    private TextView txtName, txtPrice, txtLocation;
    private Button btnPizzaAdd;

    private PizzaRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);

        repository = (PizzaRepository) getIntent().getSerializableExtra("repository");

        obtainComponents();
        setButtonEvents();
    }

    private void obtainComponents() {
        txtName = findViewById(R.id.txtName);
        txtPrice = findViewById(R.id.txtPrice);
        txtLocation = findViewById(R.id.txtLocation);

        txtName.requestFocus();

        btnPizzaAdd = findViewById(R.id.btnPizzaAdd);
    }

    private void setButtonEvents() {
        btnPizzaAdd.setOnClickListener(this::add);
    }

    private void resetForm() {
        txtName.setText("");
        txtPrice.setText("");
        txtLocation.setText("");

        txtName.requestFocus();
    }

    private void add(View view) {
        PizzaTypeDTO pizza = new PizzaTypeDTO(
                UUID.randomUUID().toString().trim(),
                txtName.getText().toString(),
                Integer.parseInt(txtPrice.getText().toString()),
                txtLocation.getText().toString()
        );

        AddPizza adder = new AddPizza(repository);
        try {
            adder.add(pizza);
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(getBaseContext(), "Saved " + pizza, Toast.LENGTH_SHORT).show();
        resetForm();
    }
}