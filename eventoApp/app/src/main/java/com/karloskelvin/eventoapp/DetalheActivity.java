package com.karloskelvin.eventoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Intent intent = getIntent();
        ItemVideo itemVideo = (ItemVideo) intent.getSerializableExtra("AULA");
        
        TextView textView = (TextView) findViewById(R.id.descricao);
        textView.setText(itemVideo.getTitulo());
    }
}
