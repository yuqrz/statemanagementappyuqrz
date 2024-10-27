package com.example.statemanagementappyuqrz;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_COUNT = "count"; // klucz do przechowywania danych w bundle
    private int count = 0; // zmienna do przechowywania wartości licznika
    private TextView textViewCount; // element widoku do wyświetlania liczby
    private Switch switcher;
    private CheckBox checkbox;
    private LinearLayout main;
    private TextView textViewOpcjaZaznaczona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textt);
        Button buttonIncrement = findViewById(R.id.button);
        switcher = findViewById(R.id.switcher);
        main = findViewById(R.id.main_layout);
        checkbox = findViewById(R.id.check);
        textViewOpcjaZaznaczona = findViewById(R.id.inform);

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT);
        }
        updateCountText();

        buttonIncrement.setOnClickListener(v -> {
            count++;
            updateCountText();
        });

        switcher.setOnCheckedChangeListener((buttonView, isChecked) -> {
            main.setBackgroundColor(isChecked ? Color.GRAY : Color.WHITE);
        });
        
        checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            textViewOpcjaZaznaczona.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
    }

    private void updateCountText() {
        textViewCount.setText("Licznik: " + count);
    }
}
