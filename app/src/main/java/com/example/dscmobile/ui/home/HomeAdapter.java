package com.example.dscmobile.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dscmobile.R;

import java.util.ArrayList;

public class HomeAdapter extends BaseAdapter {

    ArrayList<CardItem> items = new ArrayList<>();
    Context context;

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        CardItem cardItem = items.get(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_home_card_row, parent, false);
        }

        TextView sectionPhraseText = convertView.findViewById(R.id.section_phrase);
        sectionPhraseText.setText(cardItem.getSectionPhrase());

        RecyclerView cards = convertView.findViewById(R.id.home_card);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        cards.setLayoutManager(layoutManager);
        cards.scrollToPosition(0);
        cards.setItemAnimator(new DefaultItemAnimator());
        // 홈화면에 카드는 안 나오는 중 >>> todo!

        return convertView;
    }

    public void addItem(CardItem item){
        items.add(item);
    }

}
