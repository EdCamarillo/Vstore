package com.coverdev.vstore;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coverdev.vstore.Adapters.ArticleAdapter;
import com.coverdev.vstore.Models.Article;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    private List<Article> articleList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize list of articles
        articleList = new ArrayList<>();
        articleList.add(new Article(R.drawable.item_botannendo, "Shishiro Botan Nendoroid will be releasing in September 2024!", "This is the body of the Shishiro Botan Nendoroid article."));
        articleList.add(new Article(R.drawable.item_suiseiplushie, "Hoshimachi Suisei Plushie is out now!", "This is the body of the Hoshimachi Suisei Plushie article."));
        articleList.add(new Article(R.drawable.item_mikonendo, "Sakura Miko Nendoroid rerelease in July 2024! Stay tuned!", "This is the body of the Sakura Miko Nendoroid article."));
        // Add more articles as needed
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        // Set up RecyclerView with LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Set up adapter
        adapter = new ArticleAdapter(articleList, getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
