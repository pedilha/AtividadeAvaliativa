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

import java.util.concurrent.ThreadLocalRandom;

public class Gerador extends AppCompatActivity {
    private TextView voltar, resultado;
    private Button  gerar;
    private EditText valor1,valor2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gerador);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        voltar = findViewById(R.id.voltar);
        resultado = findViewById(R.id.tvResultado);
        gerar = findViewById(R.id.btnGerar);
        valor1 = findViewById(R.id.inicio);
        valor2 = findViewById(R.id.fim);

        gerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Min = valor1.getText().toString();
                String Max = valor2.getText().toString();

                if (Min.isEmpty() || Max.isEmpty()){
                    resultado.setText("Preencha ambos os campos");
                    return;
                }
                try{
                    int min = Integer.parseInt(Min);
                    int max = Integer.parseInt(Max);

                    if(min>max){
                        resultado.setText("Primeiro valor deve ser menor que o segundo!");
                        return;
                    }

                    int random = ThreadLocalRandom.current().nextInt(min,max+1);
                    resultado.setText(""+random);
                }catch (NumberFormatException e){
                    resultado.setText("digite apenas numeros inteiros");
                }
            }
        });


        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Gerador.this, EscolhaActivity.class);
                startActivity(i);
            }
        });

    }
}