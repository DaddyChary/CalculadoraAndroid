package com.example.lacalculadoraof;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private TextView tvResultado;
    private Button btnSumar, btnRestar, btnMultiplicar, btnDividir, btnIgual;

    private ArrayList<Double> numeros = new ArrayList<>();
    private ArrayList<String> operaciones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero = findViewById(R.id.etNumero);
        tvResultado = findViewById(R.id.tvResultado);
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnIgual = findViewById(R.id.btnIgual);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                guardarNumeroYOperacion("+");
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                guardarNumeroYOperacion("-");
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                guardarNumeroYOperacion("*");
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                guardarNumeroYOperacion("/");
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcularResultado();
            }
        });

    }

    private void guardarNumeroYOperacion(String op) {
        String numeroIngresado = etNumero.getText().toString();
        if (!numeroIngresado.isEmpty()) {
            double numero = Double.parseDouble(numeroIngresado);
            numeros.add(numero);
            operaciones.add(op);
            etNumero.setText("");
        } else {
            Toast.makeText(this, "Por favor ingrese un número", Toast.LENGTH_SHORT).show();
        }
    }

    private void calcularResultado() {
        String numeroIngresado = etNumero.getText().toString();
        if (!numeroIngresado.isEmpty()) {
            double numero = Double.parseDouble(numeroIngresado);
            numeros.add(numero);

            double resultado = numeros.get(0);

            for (int i = 0; i < operaciones.size(); i++) {
                String operacion = operaciones.get(i);
                double numeroSiguiente = numeros.get(i + 1);

                switch (operacion) {
                    case "+":
                        resultado += numeroSiguiente;
                        break;
                    case "-":
                        resultado -= numeroSiguiente;
                        break;
                    case "*":
                        resultado *= numeroSiguiente;
                        break;
                    case "/":
                        if (numeroSiguiente != 0) {
                            resultado /= numeroSiguiente;
                        } else {
                            Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        break;
                }
            }
            if (resultado == (int) resultado) {
                tvResultado.setText("Resultado: " + (int) resultado);
            }
            else {
                tvResultado.setText("Resultado: " + resultado);
            }
            numeros.clear();
            operaciones.clear();
            etNumero.setText("");
        } else {
            Toast.makeText(this, "Por favor ingrese un número", Toast.LENGTH_SHORT).show();
        }
    }
}