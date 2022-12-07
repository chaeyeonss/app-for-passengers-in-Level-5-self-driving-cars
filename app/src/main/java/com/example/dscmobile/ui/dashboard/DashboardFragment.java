package com.example.dscmobile.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dscmobile.R;
import com.example.dscmobile.databinding.FragmentDashboardBinding;
import com.example.dscmobile.ui.indoorsetting.MonitoringAdapter;
import com.example.dscmobile.ui.indoorsetting.StateItem;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private GridView monitoringView;
    private MonitoringAdapter monitoringAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final GridView gridView = binding.monitoringState;
        //dashboardViewModel.getText().observe(getViewLifecycleOwner(), gridView::setAdapter);

        monitoringView = (GridView) root.findViewById(R.id.monitoringStateView);
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