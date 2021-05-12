package com.example.aula5dispositivosmoveis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class Aula5Ex2Activity extends AppCompatActivity {

    private TextView txtNome;
    private Spinner spinnerUF;
    private ListView listView;

    String[] Uf = {"Rio Grande do Sul", "Santa Catarina", "Paraná", "São Paulo", "Minas Gerais"};
    String[][] cidades = {
            new String[]{"Porto Alegre", "Santa Maria", "Caxias do Sul", "Santa Cruz do Sul", "Pelotas", "Rio Grande"},
            new String[]{"Florianópolis", "Joinville", "Criciúma", "Chapecó", "Blumenau"},
            new String[]{"Curitiba", "Londrina", "Foz do Iguaçu"},
            new String[]{"São Paulo", "Campinas", "Osasco"},
            new String[]{"Belo Horizonte", "Uberaba"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula5_ex2);

        TextView txtNome = findViewById(R.id.txtNome);
        Spinner spinnerUF = findViewById(R.id.spinnerUF);
        ListView listViewCidade = findViewById(R.id.listViewCidade);

        Intent intent = getIntent();
        txtNome.setText(intent.getStringExtra("nome"));

        ArrayAdapter<CharSequence> adapterSpinner = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, Uf);
        spinnerUF.setAdapter(adapterSpinner);
        spinnerUF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] selecao = getRow(position);
                ArrayAdapter<String> adapterListView = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Arrays.asList(selecao));
                listViewCidade.setAdapter(adapterListView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }

    public String[] getRow(int index) {
        String[] row = new String[cidades[index].length];
        for (int i = 0; i < row.length; i++) {
            row[i] = cidades[index][i];
        }
        return row;
    }
}