package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Button mesButton = findViewById(R.id.mesButton);
        Button heartButton = findViewById(R.id.heartButton);
        Button searchButton = findViewById(R.id.searchButton);
        Button accButton = findViewById(R.id.accButton);
        ImageButton backButton = findViewById(R.id.backButton);

        Button newButton = findViewById(R.id.newButton);

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, NewActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Завершаем текущую активность и возвращаемся на предыдущую
                finish();
            }
        });

        mesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, ChatsActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });
        heartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, FavoriteActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });

        accButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, AccountActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });
    }
}