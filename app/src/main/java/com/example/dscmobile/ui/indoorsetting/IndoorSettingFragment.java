package com.example.dscmobile.ui.indoorsetting;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.dscmobile.R;
import com.example.dscmobile.databinding.FragmentIndoorsettingBinding;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;

public class IndoorSettingFragment extends Fragment {

    private FragmentIndoorsettingBinding binding;
    private GridView monitoringView;

    private CarControlPageAdapter pageAdapter;
    private ViewPager2 viewPager2;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        IndoorSettingViewModel indoorSettingViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(IndoorSettingViewModel.class);

        binding = FragmentIndoorsettingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textIndoorsetting;
        //indoorSettingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        final GridView monitoringView = binding.monitoringStateView;

        //monitoringView = binding.monitoringStateView;
        MonitoringAdapter monitoringAdapter = new MonitoringAdapter();

        monitoringAdapter.addMonitoringItem(new StateItem("현재 속도", "km/h", 32));
        monitoringAdapter.addMonitoringItem(new StateItem("공기 청정도", "㎛", 62));
        monitoringAdapter.addMonitoringItem(new StateItem("배터리", "%", 87));
        monitoringAdapter.addMonitoringItem(new StateItem("운행가능거리", "km", 285));

        monitoringView.setAdapter(monitoringAdapter);

        final GridView modeView = binding.selectModeGridView;

        ModeAdapter modeAdapter = new ModeAdapter();

        modeAdapter.addModeItem(new ModeItem(R.drawable.ic_meal_24, "식사"));
        modeAdapter.addModeItem(new ModeItem(R.drawable.ic_baseline_monitor_24, "영화 감상"));
        modeAdapter.addModeItem(new ModeItem(R.drawable.ic_book_24, "학습"));
        modeAdapter.addModeItem(new ModeItem(R.drawable.ic_rest_24, "휴식"));

        modeView.setAdapter(modeAdapter);

        viewPager2 = root.findViewById(R.id.viewpager);
        CarControlFragment fragment1 = new CarControlFragment();
        CarControlFragment2 fragment2 = new CarControlFragment2();

        fragments.add(fragment1);
        fragments.add(fragment2);

        pageAdapter = new CarControlPageAdapter(this, fragments);
        viewPager2.setAdapter(pageAdapter);
        DotsIndicator indicator = root.findViewById(R.id.dots_indicator);
        indicator.setViewPager2(viewPager2);

        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}