package com.coverdev.vstore.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coverdev.vstore.ArticleActivity;
import com.coverdev.vstore.Models.Article;
import com.coverdev.vstore.R;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private List<Article> articleList;
    private Context context;

    public ArticleAdapter(List<Article> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.articleTitleTextView.setText(article.getTitle());
        holder.articleImageView.setImageResource(article.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ArticleActivity.class);
            intent.putExtra("imageResId", article.getImageResId());
            intent.putExtra("title", article.getTitle());
            intent.putExtra("body", article.getBody());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {

        ImageView articleImageView;
        TextView articleTitleTextView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            articleImageView = itemView.findViewById(R.id.articleImageView);
            articleTitleTextView = itemView.findViewById(R.id.articleTitleTextView);
        }
    }
}
