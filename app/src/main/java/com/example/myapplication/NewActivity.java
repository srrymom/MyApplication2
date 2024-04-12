package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.mapview.MapView;

import java.util.ArrayList;

public class NewActivity extends AppCompatActivity {

    MapView mapview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_new);





        Button mesButton = findViewById(R.id.mesButton);
        Button heartButton = findViewById(R.id.heartButton);
        Button searchButton = findViewById(R.id.searchButton);
        Button accButton = findViewById(R.id.accButton);

        ImageButton backButton = findViewById(R.id.backButton);
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
                Intent intent = new Intent(NewActivity.this, ChatsActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });
        heartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewActivity.this, FavoriteActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });

        accButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewActivity.this, AccountActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewActivity.this, MainActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });

        mapview = findViewById(R.id.mapView);

    }

    @Override
    protected void onStop() {
        mapview.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }


    @Override
    protected void onStart() {

        mapview.onStart();
        MapKitFactory.getInstance().onStart();


        super.onStart();
    }



}