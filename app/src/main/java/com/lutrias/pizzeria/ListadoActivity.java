package com.lutrias.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListadoActivity extends AppCompatActivity {

    ListView listView;
    Button btnPizzaDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        obtainComponents();
        fillList();
        setButtons();
    }


    private void obtainComponents() {
        listView = findViewById(R.id.listView);
        btnPizzaDelete = findViewById(R.id.btnPizzaDelete);
    }

    private void fillList() {
        String[] pizzas = new String[] {
            "Pizza Napolitana",
            "Pizza Vegana",
            "Pizza Predilecta",
            "Pizza Selecta"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            pizzas
        );
    }

    private void setButtons() {
        btnPizzaDelete.setOnClickListener(this::delete);
    }

    private void delete(View view) {
        Toast.makeText(getBaseContext(), "Delete a Pizza", Toast.LENGTH_SHORT).show();
    }
}