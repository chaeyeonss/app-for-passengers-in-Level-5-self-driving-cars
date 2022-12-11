package com.example.dscmobile.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dscmobile.R;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private int[] cardDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView cardContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardContent = (ImageView) itemView.findViewById(R.id.cardContentTextView);
        }

        public ImageView getCardContent(){
            return cardContent;
        }
    }

    public CardAdapter(int index) {
        switch (index){
            case 0:
                cardDataSet = new int[]{R.drawable.rest1, R.drawable.rest2, R.drawable.rest3, R.drawable.rest1};
                break;
            case 1:
                cardDataSet = new int[]{R.drawable.cafe1, R.drawable.cafe2, R.drawable.cafe3, R.drawable.cafe1, R.drawable.cafe2, R.drawable.cafe3};
                break;
            case 2:
                cardDataSet = new int[]{R.drawable.bread1, R.drawable.bread2, R.drawable.bread3, R.drawable.bread1, R.drawable.bread2};
                break;
            case 3:
                cardDataSet = new int[]{R.drawable.bar1, R.drawable.bar2, R.drawable.bar3};
                break;
            case 4:
                cardDataSet = new int[]{R.drawable.cafe1, R.drawable.cafe2, R.drawable.cafe3, R.drawable.bread2, R.drawable.bar3};
                break;
            default:
                cardDataSet = new int[]{};
                break;
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
        holder.getCardContent().setBackgroundResource(cardDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return cardDataSet.length;
    }
}
