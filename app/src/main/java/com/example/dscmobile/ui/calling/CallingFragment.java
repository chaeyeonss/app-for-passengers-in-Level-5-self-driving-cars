package com.example.dscmobile.ui.calling;

import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dscmobile.R;
import com.example.dscmobile.databinding.FragmentCallingBinding;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class CallingFragment extends Fragment {

    private FragmentCallingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CallingViewModel callingViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(CallingViewModel.class);

        binding = FragmentCallingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        MapView map = new MapView(getActivity());
        ViewGroup mapViewContainer = (ViewGroup) root.findViewById(R.id.mapView);
        mapViewContainer.addView(map);

        map.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.5, 126.97), true);
        map.setZoomLevel(4, true);
        MapPoint MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.54892296550104, 126.99089033876304);

        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("Default Marker");
        marker.setTag(0);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        map.addPOIItem(marker);

        final TextView departures = binding.departures;
        final TextView arrivals = binding.arrivals;
        callingViewModel.getText().observe(getViewLifecycleOwner(), departures::setText);
        callingViewModel.getText().observe(getViewLifecycleOwner(), arrivals::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}