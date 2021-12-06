package com.lutrias.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.lutrias.pizzeria.context.pizza.application.CalcTotalPrice;
import com.lutrias.pizzeria.context.pizza.domain.PizzaIngredient;
import com.lutrias.pizzeria.context.pizza.domain.PizzaRepository;
import com.lutrias.pizzeria.context.pizza.domain.PizzaType;
import com.lutrias.pizzeria.context.pizza.domain.PizzaTypeDTO;
import com.lutrias.pizzeria.context.pizza.infrastructure.InMemoryPizzaRepository;

import java.util.List;
import java.util.UUID;

public class ArmaPizzaActivity extends AppCompatActivity {

    private Spinner spnPizzaType, spnPizzaIngredient;
    private Button btnProcessCalc;
    private TextView lblPrice;

    private PizzaRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arma_pizza);

        repository = (PizzaRepository) getIntent().getSerializableExtra("repository");

        obtainComponents();
        fillSpinners();
        setButtons();
    }

    private void obtainComponents() {
        spnPizzaType = findViewById(R.id.spnPizzaType);
        spnPizzaIngredient = findViewById(R.id.spnPizzaIngredient);
        lblPrice = findViewById(R.id.lblPrice);
        btnProcessCalc = findViewById(R.id.btnProcessCalc);
    }

    private void fillSpinners() {
        List<PizzaTypeDTO> pizzaTypes = repository.getAll();

        SpinnerAdapter adapterTypes = new ArrayAdapter<>(
            getBaseContext(),
            android.R.layout.simple_list_item_1,
            pizzaTypes
        );
        spnPizzaType.setAdapter(adapterTypes);

        PizzaIngredient[] pizzaIngredients = new PizzaIngredient[]{
                new PizzaIngredient(UUID.randomUUID().toString(), "Tocino", 350),
                new PizzaIngredient(UUID.randomUUID().toString(), "Extra Queso", 500),
                new PizzaIngredient(UUID.randomUUID().toString(), "Champiñon", 250),
        };

        SpinnerAdapter adapterIngredients = new ArrayAdapter<>(
                getBaseContext(),
                android.R.layout.simple_list_item_1,
                pizzaIngredients
        );
        spnPizzaIngredient.setAdapter(adapterIngredients);
    }

    private void setButtons() {
        btnProcessCalc.setOnClickListener(this::calc);
    }

    private void calc(View view) {
        PizzaTypeDTO pizzaType = (PizzaTypeDTO) spnPizzaType.getSelectedItem();
        PizzaIngredient pizzaIngredient = (PizzaIngredient) spnPizzaIngredient.getSelectedItem();

        CalcTotalPrice processor = new CalcTotalPrice(pizzaType, pizzaIngredient);

        lblPrice.setText(
            String.valueOf(
                processor.process()
            )
        );
    }
}