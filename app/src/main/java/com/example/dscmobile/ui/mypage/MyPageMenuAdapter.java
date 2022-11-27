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

    public static class MyPageMenuViewHolder extends RecyclerView.ViewHolder {
        public ImageView menuIcon;
        public TextView menuName;

        public MyPageMenuViewHolder(View view){
            super(view);
            menuIcon = (ImageView) view.findViewById(R.id.menu_icon);
            menuName = (TextView) view.findViewById(R.id.menu_name);
        }
    }

    private ArrayList mDataset;

    public MyPageMenuAdapter(MyPageFragment ct, ArrayList searchDataSet){
        mDataset = searchDataSet;
    }

    @NonNull
    @Override
    public MyPageMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_mypage_menu, parent, false);
        return new MyPageMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyPageMenuAdapter.MyPageMenuViewHolder holder, int position) {
        System.out.println(mDataset.get(position).getClass().getName());
        holder.menuName.setText(mDataset.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
