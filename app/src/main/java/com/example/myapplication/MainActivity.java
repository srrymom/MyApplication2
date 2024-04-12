package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.yandex.mapkit.MapKit;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.mapview.MapView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MapView mapview;
    ArrayList<Book> books = new ArrayList<>();
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button mesButton = findViewById(R.id.mesButton);
        Button heartButton = findViewById(R.id.heartButton);
        Button searchButton = findViewById(R.id.searchButton);
        Button accButton = findViewById(R.id.accButton);
        Button newButton = findViewById(R.id.newButton);

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });

        mesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChatsActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });
        heartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavoriteActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });

        accButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AccountActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });

//        searchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                startActivity(intent); // Запускаем активность
//            }
//        });

        mapview = findViewById(R.id.mapView);

        RecyclerView recyclerView = findViewById(R.id.mainView);

        setUpBooks();

        SearchRecycleViewAdapter adapter = new SearchRecycleViewAdapter(this, books);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new

                GridLayoutManager(this, 2));
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

    private void setUpBooks() {
        String[] titles = getResources().getStringArray(R.array.book_titles);
        String[] places = getResources().getStringArray(R.array.book_places);
        String[] dates = getResources().getStringArray(R.array.book_dates);

        for (int i = 0; i < titles.length; i++) {
            Book book = new Book(0, titles[i], dates[i], places[i]);
            books.add(book);
        }
    }

}