package com.coverdev.vstore;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        ImageView articleImageView = findViewById(R.id.articleImageView);
        TextView articleTitleTextView = findViewById(R.id.articleTitleTextView);
        TextView articleBodyTextView = findViewById(R.id.articleBodyTextView);

        // Get data from intent
        int imageResId = getIntent().getIntExtra("imageResId", 0);
        String title = getIntent().getStringExtra("title");
        String body = getIntent().getStringExtra("body");

        // Set data to views
        articleImageView.setImageResource(imageResId);
        articleTitleTextView.setText(title);
        articleBodyTextView.setText(body);
    }
}
