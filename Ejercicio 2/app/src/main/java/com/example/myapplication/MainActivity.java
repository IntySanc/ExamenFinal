package com.example.myapplication;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Chronometer cronometro;
    private boolean corriendo;
    private long pausaOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cronometro = findViewById(R.id.cronometro);
        Button btnIniciar = findViewById(R.id.btnIniciar);
        Button btnParar = findViewById(R.id.btnParar);
        Button btnReiniciar = findViewById(R.id.btnReiniciar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!corriendo) {
                    cronometro.setBase(SystemClock.elapsedRealtime() - pausaOffset);
                    cronometro.start();
                    corriendo = true;
                }
            }
        });

        btnParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (corriendo) {
                    cronometro.stop();
                    pausaOffset = SystemClock.elapsedRealtime() - cronometro.getBase();
                    corriendo = false;
                }
            }
        });

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cronometro.setBase(SystemClock.elapsedRealtime());
                pausaOffset = 0;
            }
        });
    }
}