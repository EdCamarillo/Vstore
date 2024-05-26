//package com.coverdev.vstore;
//
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.coverdev.vstore.Adapters.CatalogAdapter;
//import com.coverdev.vstore.Models.Item;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link CatalogFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class CatalogFragment extends Fragment {
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//    private RecyclerView recyclerView;
//    private CatalogAdapter adapter;
//    private List<Item> itemList;
//
//    public CatalogFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment CatalogFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static CatalogFragment newInstance(String param1, String param2) {
//        CatalogFragment fragment = new CatalogFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // Initialize list of items
//        itemList = new ArrayList<>();
//        itemList.add(new Item(R.drawable.item_botannendo, "Shishiro Botan Nendoroid", "$10"));
//        itemList.add(new Item(R.drawable.item_suiseiplushie, "Hoshimachi Suisei Plushie", "$15"));
//        itemList.add(new Item(R.drawable.item_mikonendo, "Sakura Miko Nendoroid", "$15"));
//        // Add more items as needed
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_catalog, container, false);
//        recyclerView = view.findViewById(R.id.recyclerView);
//
//        // Set up RecyclerView with GridLayoutManager
//        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2); // 2 columns
//        recyclerView.setLayoutManager(layoutManager);
//
//        // Set up adapter
//        adapter = new CatalogAdapter(itemList);
//        recyclerView.setAdapter(adapter);
//
//        return view;
//    }
//}

package com.coverdev.vstore;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coverdev.vstore.Adapters.CatalogAdapter;
import com.coverdev.vstore.Models.Item;

import java.util.ArrayList;
import java.util.List;

public class CatalogFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private CatalogAdapter adapter;
    private List<Item> itemList;
    private List<Item> filteredItemList;
    private SearchView searchView;

    public CatalogFragment() {
        // Required empty public constructor
    }

    public static CatalogFragment newInstance(String param1, String param2) {
        CatalogFragment fragment = new CatalogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize list of items
        itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.item_botannendo, "Shishiro Botan Nendoroid", "$10"));
        itemList.add(new Item(R.drawable.item_suiseiplushie, "Hoshimachi Suisei Plushie", "$15"));
        itemList.add(new Item(R.drawable.item_mikonendo, "Sakura Miko Nendoroid", "$15"));
        itemList.add(new Item(R.drawable.item_lamynendo, "Yukihana Lamy Nendoroid", "$15"));
        itemList.add(new Item(R.drawable.item_botanpopup, "Shishiro Botan POP UP PARADE", "$15"));
        itemList.add(new Item(R.drawable.item_noelpopup, "Shirogane Noel POP UP PARADE", "$15"));
        itemList.add(new Item(R.drawable.item_pekoranendo, "Usada Pekora Nendoroid", "$15"));
        itemList.add(new Item(R.drawable.item_marinepopup, "Houshou Marine POP UP PARADE", "$15"));
        itemList.add(new Item(R.drawable.item_callipopup, "Mori Calliope POP UP PARADE", "$20"));
        // Add more items as needed

        // Initialize filtered list with all items
        filteredItemList = new ArrayList<>(itemList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        searchView = view.findViewById(R.id.searchView);

        // Set up RecyclerView with GridLayoutManager
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2); // 2 columns
        recyclerView.setLayoutManager(layoutManager);

        // Set up adapter with filtered list
        adapter = new CatalogAdapter(filteredItemList);
        recyclerView.setAdapter(adapter);

        // Set up SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

        return view;
    }

    private void filter(String text) {
        filteredItemList.clear();
        if (text.isEmpty()) {
            filteredItemList.addAll(itemList);
        } else {
            text = text.toLowerCase();
            for (Item item : itemList) {
                if (item.getName().toLowerCase().contains(text)) {
                    filteredItemList.add(item);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }
}
