package com.seuapp.trabalhoavaliativo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class RegistroData extends AppCompatActivity {
    private TextView voltar;
    private EditText Nome;
    private DatePicker data;
    private Button btnsalvar;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Nome = findViewById(R.id.NomeData);
        voltar = findViewById(R.id.voltar);
        data = findViewById(R.id.data);
        lista = findViewById(R.id.Lista);
        btnsalvar = findViewById(R.id.btnsalvar);

        ArrayList<Object> entradas = new ArrayList<>();
        ArrayAdapter<Object> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, entradas);
        lista.setAdapter(adapter);

        btnsalvar.setOnClickListener(v -> {
            String nome = Nome.getText().toString().trim();
            if (nome.isEmpty()) {
                Nome.setError("Informe um nome");
                return;
            }
            int dia   = data.getDayOfMonth();
            int mes   = data.getMonth() + 1; // janeiro = 0
            int ano   = data.getYear();
            String dataFormatada = String.format("%02d/%02d/%04d", dia, mes, ano);

            String item = nome + " — " + dataFormatada;
            entradas.add(item);
            adapter.notifyDataSetChanged();

            Nome.setText("");
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistroData.this, EscolhaActivity.class);
                startActivity(i);
            }
        });
    }
}