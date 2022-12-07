package com.example.dscmobile.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dscmobile.MainActivity;
import com.example.dscmobile.R;
import com.example.dscmobile.databinding.FragmentHomeBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    ArrayList<CardItem> cardItems;
    ListView homeCardListView; // 홈 화면에 있는 추천 카드 섹션들
    private static HomeAdapter adapter;

    RecyclerView cardRecyclerView; // 섹션마다 있는 카드들

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //View root = binding.getRoot();

        cardItems = new ArrayList<>();
        cardItems.add(new CardItem(new String[]{"카드1", "카드2"}));
        cardItems.add(new CardItem(new String[]{"카드1", "카드2", "카드3", "카드4", "카드5"}));
        cardItems.add(new CardItem(new String[]{"카드1", "카드2", "카드3", "카드4", "카드5", "카드6", "카드7"}));
        cardItems.add(new CardItem(new String[]{"카드1", "카드2", "카드3"}));

        homeCardListView = root.findViewById(R.id.homeCardListView);
        adapter = new HomeAdapter(getContext(), getResources().getStringArray(R.array.home_card_phrases));
        homeCardListView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}