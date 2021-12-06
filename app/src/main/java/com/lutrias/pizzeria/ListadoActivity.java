package com.lutrias.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.lutrias.pizzeria.context.pizza.application.DeletePizza;
import com.lutrias.pizzeria.context.pizza.domain.PizzaRepository;
import com.lutrias.pizzeria.context.pizza.domain.PizzaTypeDTO;
import com.lutrias.pizzeria.context.pizza.infrastructure.InMemoryPizzaRepository;

import java.util.List;

public class ListadoActivity extends AppCompatActivity {

    private ListView listView;
    private Button btnPizzaDelete;

    private PizzaRepository repository;
    private PizzaTypeDTO selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        repository = (PizzaRepository) getIntent().getSerializableExtra("repository");

        obtainComponents();
        fillList();
        setButtons();
    }


    private void obtainComponents() {
        listView = findViewById(R.id.listView);
        btnPizzaDelete = findViewById(R.id.btnPizzaDelete);
    }

    private void fillList() {
        List<PizzaTypeDTO> pizzas = repository.getAll();

        ArrayAdapter<String> adapter = new ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            pizzas
        );

        listView.setAdapter(adapter);
    }

    private void setButtons() {
        listView.setOnItemClickListener(this::pizzaClicked);
        btnPizzaDelete.setOnClickListener(this::delete);
    }

    private void pizzaClicked(AdapterView<?> adapterView, View view, int i, long l) {
        selected = (PizzaTypeDTO) adapterView.getItemAtPosition(i);
    }

    private void delete(View view) {
        if (selected == null) {
            Toast.makeText(getBaseContext(), "Ninguna pizza seleccionada", Toast.LENGTH_SHORT).show();
            return;
        }

        DeletePizza deleter = new DeletePizza(repository);
        deleter.delete(selected);

        fillList();

        Toast.makeText(getBaseContext(), "Delete a " + selected, Toast.LENGTH_SHORT).show();
    }
}