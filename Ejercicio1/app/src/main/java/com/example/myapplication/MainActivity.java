package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editTextCurrency;
    TextView textViewResult;
    Button buttonConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCurrency = findViewById(R.id.editTextCurrency);
        textViewResult = findViewById(R.id.textViewResult);
        buttonConvert = findViewById(R.id.buttonConvert);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        if (!editTextCurrency.getText().toString().equals("")) {
            float originalAmount = Float.parseFloat(editTextCurrency.getText().toString());
            // Suponiendo una tasa de conversión fija, por ejemplo: 1 USD = 0.85 EUR
            float conversionRate = 0.85f;
            float convertedAmount = originalAmount * conversionRate;
            textViewResult.setText(String.format(Locale.US, "%.2f", convertedAmount) + " EUR");
        } else {
            textViewResult.setText("Por favor, introduce una cantidad.");
        }
    }
}