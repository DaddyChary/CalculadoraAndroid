package com.example.lacalculadoraof;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Historial extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_historial);

        ListView listView = findViewById(R.id.lista_historial);
        Button btnVolver = findViewById(R.id.btnVolver);

        ArrayList<String> historial = getIntent().getStringArrayListExtra("historial");

        if (historial != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, historial);
            listView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No hay historial para mostrar", Toast.LENGTH_SHORT).show();
        }

        btnVolver.setOnClickListener(v -> finish());
    }

}
