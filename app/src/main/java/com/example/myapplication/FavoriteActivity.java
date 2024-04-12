package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {

    ArrayList<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Завершаем текущую активность и возвращаемся на предыдущую
                finish();
            }
        });

        Button mesButton = findViewById(R.id.mesButton);
        Button heartButton = findViewById(R.id.heartButton);
        Button searchButton = findViewById(R.id.searchButton);
        Button accButton = findViewById(R.id.accButton);
        Button newButton = findViewById(R.id.newButton);

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoriteActivity.this, NewActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });

        mesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoriteActivity.this, ChatsActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });
        heartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoriteActivity.this, FavoriteActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });

        accButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoriteActivity.this, AccountActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoriteActivity.this, MainActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });
        RecyclerView recyclerView = findViewById(R.id.mainView);

        setUpBooks();

        SearchRecycleViewAdapter adapter = new SearchRecycleViewAdapter(this, books);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new

                GridLayoutManager(this, 2));
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoriteActivity.this, ChatActivity.class);
                startActivity(intent); // Запускаем активность
            }
        });
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