package com.karloskelvin.eventoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final String[] arrayAula = getResources().getStringArray(R.array.array_aulas);

        final List<ItemVideo> itemVideos = new ArrayList<>();
        itemVideos.add(new ItemVideo("Principais Erros", "26/09/2016", "http://"));
        itemVideos.add(new ItemVideo("Video Aula Pratica 1", "26/09/2016", "http://"));
        itemVideos.add(new ItemVideo("Video Aula Pratica 2", "26/09/2016", "http://"));
        itemVideos.add(new ItemVideo("Video Aula Pratica 3", "26/09/2016", "http://"));

        ListView lista = (ListView) findViewById(R.id.lista);

        ItemVideoAdapter adapter = new ItemVideoAdapter(this,  itemVideos);

        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
                ItemVideo aula = itemVideos.get(i);
                intent.putExtra("AULA", aula);
                startActivity(intent);
            }
        });
    }
}
