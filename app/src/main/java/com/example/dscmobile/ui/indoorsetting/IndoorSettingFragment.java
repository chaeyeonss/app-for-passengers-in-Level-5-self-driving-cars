package com.example.dscmobile.ui.indoorsetting;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dscmobile.databinding.FragmentHomeBinding;
import com.example.dscmobile.databinding.FragmentIndoorsettingBinding;

public class IndoorSettingFragment extends Fragment {

    private FragmentIndoorsettingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        IndoorSettingViewModel indoorSettingViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(IndoorSettingViewModel.class);

        binding = FragmentIndoorsettingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textIndoorsetting;
        indoorSettingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}