package com.coverdev.vstore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private LinearLayout wishlistLayout;
    private LinearLayout collectionLayout;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        wishlistLayout = view.findViewById(R.id.wishlistLayout);
        collectionLayout = view.findViewById(R.id.collectionLayout);

        // Example: Add items to wishlist and collection
        addItemToWishlist("Shishiro Botan Nendoroid", "$10", R.drawable.item_botannendo);
        addItemToWishlist("Sakura Miko Nendoroid", "$15", R.drawable.item_mikonendo);

        addItemToCollection("Hoshimachi Suisei Plushie", R.drawable.item_suiseiplushie);

        return view;
    }

    private void addItemToWishlist(String name, String price, int imageResource) {
        View itemLayout = LayoutInflater.from(getContext()).inflate(R.layout.item_layout, wishlistLayout, false);
        ImageView imageView = itemLayout.findViewById(R.id.imageView);
        TextView nameTextView = itemLayout.findViewById(R.id.nameTextView);
        TextView priceTextView = itemLayout.findViewById(R.id.priceTextView);

        imageView.setImageResource(imageResource);
        nameTextView.setText(name);
        priceTextView.setText(price);

        wishlistLayout.addView(itemLayout);
    }

    private void addItemToCollection(String name, int imageResource) {
        View itemLayout = LayoutInflater.from(getContext()).inflate(R.layout.item_collection_layout, collectionLayout, false);
        ImageView imageView = itemLayout.findViewById(R.id.imageView);
        TextView nameTextView = itemLayout.findViewById(R.id.nameTextView);

        imageView.setImageResource(imageResource);
        nameTextView.setText(name);

        collectionLayout.addView(itemLayout);
    }
}
