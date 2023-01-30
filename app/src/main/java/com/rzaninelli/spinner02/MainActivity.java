package com.rzaninelli.spinner02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerMarcas, spinnerModelos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerMarcas = findViewById(R.id.spinnerMarcas);
        spinnerModelos = findViewById(R.id.spinnerModelos);

        spinnerMarcas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                String marca = adapterView.getItemAtPosition(position).toString();

                if (marca.equals(getString(R.string.ford))) {
                    popularModelos(R.array.modelos_ford);
                }
                if (marca.equals(getString(R.string.fiat))) {
                    popularModelos(R.array.modelos_fiat);
                }
                if (marca.equals(getString(R.string.honda))) {
                    popularModelos(R.array.modelos_honda);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void popularModelos(int arrayId) {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, arrayId, android.R.layout.simple_spinner_dropdown_item);



        spinnerModelos.setAdapter(adapter);
    }

}