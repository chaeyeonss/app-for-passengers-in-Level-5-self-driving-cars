package com.example.dscmobile.ui.indoorsetting;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class CarControlPageAdapter extends FragmentStateAdapter {
    ArrayList<Fragment> fragments = new ArrayList<>();

    public CarControlPageAdapter(@NonNull IndoorSettingFragment fragmentActivity, ArrayList<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new CarControlFragment();
            default:
                return new CarControlFragment2();
        }
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
