package com.example.aula5dispositivosmoveis;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.view.menu.ActionMenuItemView;

import java.util.Arrays;

public class Aula5Ex1Activity extends ListActivity {

    String[] nomes = {"Lamb Ari", "Beto Neira", "Brita Deira", "Gil Lete", "Astolfo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula5_ex1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Arrays.asList(nomes));
        ListView listView = getListView();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String selecao = nomes[i];
                Intent intent = new Intent(getApplicationContext(), Aula5Ex2Activity.class);
                intent.putExtra("nome", selecao);
                startActivity(intent);
            }
        });
    }
}