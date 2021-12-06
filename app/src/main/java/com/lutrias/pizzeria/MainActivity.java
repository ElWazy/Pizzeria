package com.lutrias.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton[] imageButtons;
    private Button btnPizzaMaintainer, btnPizzaList, btnPizzaMaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        obtainComponents();
        setButtonEvents();
    }

    private void obtainComponents() {
        imageButtons = new ImageButton[4];
        imageButtons[0] = findViewById(R.id.btnFacebook);
        imageButtons[1] = findViewById(R.id.btnInstagram);
        imageButtons[2] = findViewById(R.id.btnTwitter);
        imageButtons[3] = findViewById(R.id.btnYoutube);

        btnPizzaMaintainer = findViewById(R.id.btnPizzaMaintainer);
        btnPizzaList       = findViewById(R.id.btnPizzaList);
        btnPizzaMaker      = findViewById(R.id.btnPizzaMaker);
    }

    private void setButtonEvents() {
        String[] sites = new String[] {"facebook", "instagram", "twitter", "youtube"};
        for (int i = 0; i < imageButtons.length; i++) {
            int iterator = i;
            imageButtons[i].setOnClickListener(view -> {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://" + sites[iterator] + ".com"));
                startActivity(intent);
            });
        }

        btnPizzaMaintainer.setOnClickListener(this::goToPizzaMaintainer);
        btnPizzaList.setOnClickListener(this::goToPizzaList);
        btnPizzaMaker.setOnClickListener(this::goToPizzaMaker);
    }

    private void changeActivity(Class activity) {
        Intent intent = new Intent(getBaseContext(), activity);
        startActivity(intent);
    }

    private void goToPizzaMaintainer(View view) {
        changeActivity(GestionActivity.class);
    }

    private void goToPizzaList(View view) {
        changeActivity(ListadoActivity.class);
    }

    private void goToPizzaMaker(View view) {
        changeActivity(ArmaPizzaActivity.class);
    }
}
