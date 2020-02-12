package com.example.newsviewsdemo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsviewsdemo.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_row,parent,false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView authorTV,titleTV,descripTV, publishTV,urlTV;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageurlID);
            authorTV = itemView.findViewById(R.id.authorID);
            titleTV = itemView.findViewById(R.id.titleID);
            descripTV = itemView.findViewById(R.id.descriptionID);
            publishTV = itemView.findViewById(R.id.publishDateID);
            urlTV = itemView.findViewById(R.id.urlID);
        }
    }
}
