package com.example.dscmobile.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dscmobile.R;

public class CardAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    String[] cards;

    public CardAdapter(String[] cards) {
        this.cards = cards;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_home_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.cardContent.setText(cards[position]);
    }

    @Override
    public int getItemCount() {
        return cards.length;
    }
}
