package com.example.dscmobile.ui.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dscmobile.R;

import java.util.ArrayList;

public class HomeAdapter extends ArrayAdapter {
    Context context;
    String[] phrases;

    public HomeAdapter(Context context, String[] phrases) {
        super(context, 0, phrases);
        this.context = context;
        this.phrases = phrases;
    }

    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
        final MyViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.layout_home_card_row, parent, false);
        }

        viewHolder = new MyViewHolder();
        viewHolder.themePhrase = (TextView) convertView.findViewById(R.id.homeThemePhraseTextView);
        viewHolder.cards = (RecyclerView) convertView.findViewById(R.id.homeCardRecyclerView);

        viewHolder.themePhrase.setText(phrases[position]);
        viewHolder.cards.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));

        viewHolder.cards.setAdapter(new CardAdapter(position));
        Log.e("홈 어댑터에서 얻는 position 값", position+"");

        return convertView;
    }
}
