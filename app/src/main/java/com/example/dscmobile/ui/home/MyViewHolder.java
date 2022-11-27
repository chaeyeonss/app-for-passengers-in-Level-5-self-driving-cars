package com.example.dscmobile.ui.home;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dscmobile.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView cardContent;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        cardContent = itemView.findViewById(R.id.card_content);
    }
}
