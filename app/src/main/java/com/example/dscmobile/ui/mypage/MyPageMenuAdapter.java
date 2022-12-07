package com.example.dscmobile.ui.mypage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dscmobile.R;

import java.util.ArrayList;

public class MyPageMenuAdapter extends RecyclerView.Adapter<MyPageMenuAdapter.MyPageMenuViewHolder> {
    private ArrayList<MyPageMenuData> menuDataset;

    public static class MyPageMenuViewHolder extends RecyclerView.ViewHolder {
        private final ImageView menuIcon;
        private final TextView menuName;

        public MyPageMenuViewHolder(View view){
            super(view);
            menuIcon = (ImageView) view.findViewById(R.id.menu_icon);
            menuName = (TextView) view.findViewById(R.id.menu_name);
        }

        public ImageView getMenuIcon() {
            return menuIcon;
        }

        public TextView getMenuName() {
            return menuName;
        }
    }

    public MyPageMenuAdapter(ArrayList<MyPageMenuData> dataSet){
        menuDataset = dataSet;
    }

    @NonNull
    @Override
    public MyPageMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_mypage_menu, parent, false);
        return new MyPageMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyPageMenuViewHolder holder, int position) {
        holder.getMenuName().setText(menuDataset.get(position).getMenuName());
        holder.getMenuIcon().setImageResource(menuDataset.get(position).getMenuIconNum());
    }

    @Override
    public int getItemCount() {
        return menuDataset.size();
    }


}
