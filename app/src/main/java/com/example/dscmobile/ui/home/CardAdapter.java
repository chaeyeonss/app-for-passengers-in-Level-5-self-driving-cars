package com.example.dscmobile.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dscmobile.R;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private String[] cardDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView cardContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardContent = (TextView) itemView.findViewById(R.id.cardContentTextView);
        }

        public TextView getCardContent(){
            return cardContent;
        }
    }

    public CardAdapter(int index) {
        switch (index){
            case 0: cardDataSet = new String[]{"","","","","",""};
            case 1: cardDataSet = new String[]{"","","","","",""};
            case 2: cardDataSet = new String[]{"","","","","","","","",""};
            case 3: cardDataSet = new String[]{"","","","","","",""};
            case 4: cardDataSet = new String[]{"","","",""};
            //default: cardDataSet = new String[]{"카드1","카드2","카드3","카드4","카드5","카드6"};
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_card_content_text,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getCardContent().setText(cardDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return cardDataSet.length;
    }
}
