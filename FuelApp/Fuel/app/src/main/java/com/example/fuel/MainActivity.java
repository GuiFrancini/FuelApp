package com.example.fuel;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Button btnAlcool, btnGasolina, btnCalcular;
    EditText editValor;
    TextView txtResultado;

    String combustivelSelecionado = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlcool = findViewById(R.id.btnAlcool);
        btnGasolina = findViewById(R.id.btnGasolina);
        btnCalcular = findViewById(R.id.btnCalcular);
        editValor = findViewById(R.id.editValor);
        txtResultado = findViewById(R.id.txtResultado);


        btnAlcool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                combustivelSelecionado = "alcool";
                Toast.makeText(MainActivity.this, "Álcool selecionado", Toast.LENGTH_SHORT).show();
            }
        });

        btnGasolina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                combustivelSelecionado = "gasolina";
                Toast.makeText(MainActivity.this, "Gasolina selecionada", Toast.LENGTH_SHORT).show();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorTexto = editValor.getText().toString();

                if (combustivelSelecionado.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Escolha um combustível", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (valorTexto.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Digite um valor", Toast.LENGTH_SHORT).show();
                    return;
                }

                double valor = Double.parseDouble(valorTexto);
                calcularRecomendacao(valor);
            }
        });
    }

    private void calcularRecomendacao(double valorInformado) {
        double resultado;

        if (combustivelSelecionado.equals("alcool")) {
            resultado = valorInformado / 0.7;
            txtResultado.setText(String.format("A gasolina deve estar acima de R$ %.2f para o álcool valer a pena.", resultado));
        } else if (combustivelSelecionado.equals("gasolina")) {
            resultado = valorInformado * 0.7;
            txtResultado.setText(String.format("O álcool deve estar acima de R$ %.2f para a gasolina valer a pena.", resultado));
        }
    }
}