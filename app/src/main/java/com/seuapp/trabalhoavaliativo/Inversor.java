package com.seuapp.trabalhoavaliativo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Inversor extends AppCompatActivity {
    private Button Inverter;
    private TextView voltar;
    private EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inversor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Inverter = findViewById(R.id.btnInverter);
        voltar = findViewById(R.id.voltar);
        texto = findViewById(R.id.Texto);

        Inverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String original = texto.getText().toString();
                String invertido = new StringBuilder(original).reverse().toString();

                Intent i = new Intent(Inversor.this, Invertido.class);
                i.putExtra("TEXTO_INVERTIDO", invertido);
                startActivity(i);
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Inversor.this, EscolhaActivity.class);
                startActivity(i);
            }
        });
    }
}