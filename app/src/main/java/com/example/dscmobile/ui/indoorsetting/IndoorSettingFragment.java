package com.example.dscmobile.ui.indoorsetting;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.dscmobile.R;
import com.example.dscmobile.databinding.FragmentIndoorsettingBinding;

public class IndoorSettingFragment extends Fragment {

    private FragmentIndoorsettingBinding binding;
    private GridView monitoringView;
    private MonitoringAdapter monitoringAdapter;

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
        monitoringAdapter = new MonitoringAdapter();

        monitoringAdapter.addMonitoringItem(new StateItem("현재 속도", "km/h", 32));
        monitoringAdapter.addMonitoringItem(new StateItem("공기 청정도", "㎛", 62));
        monitoringAdapter.addMonitoringItem(new StateItem("배터리", "%", 87));
        monitoringAdapter.addMonitoringItem(new StateItem("운행가능거리", "km", 285));

        monitoringView.setAdapter(monitoringAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}