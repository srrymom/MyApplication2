package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchRecycleViewAdapter extends RecyclerView.Adapter<SearchRecycleViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<Book> books;
    public SearchRecycleViewAdapter(Context context, ArrayList<Book> books) {
        this.context = context;
        this.books = books;

    }
    @NonNull
    @Override
    public SearchRecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_cell, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchRecycleViewAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(books.get(position).getTitle());
        holder.tvDate.setText(books.get(position).getDate() );
        holder.tvPlace.setText(books.get(position).getPlace());
        holder.imageView.setImageResource(books.get(position).getCover());


    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvTitle, tvDate, tvPlace;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cover);
            tvTitle = itemView.findViewById(R.id.title);
            tvDate = itemView.findViewById(R.id.date);
            tvPlace = itemView.findViewById(R.id.place);

            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Intent intent = new Intent(v.getContext(), DetailActivity.class);
                        v.getContext().startActivity(intent);
                    }
                }
            };

            // Привязываем обработчик клика к каждому элементу
            imageView.setOnClickListener(onClickListener);
            tvTitle.setOnClickListener(onClickListener);
            tvDate.setOnClickListener(onClickListener);
            tvPlace.setOnClickListener(onClickListener);




        }
    }
}
