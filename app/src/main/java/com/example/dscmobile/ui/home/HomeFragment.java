package com.example.dscmobile.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    ListView cardListView;
    RecyclerView cardsView;
    HomeAdapter adapter;
    CardAdapter cardAdapter;

    String[] cardSample;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        cardListView = root.findViewById(R.id.card_list);
        cardsView = root.findViewById(R.id.home_card);
        adapter = new HomeAdapter();
        cardSample = getResources().getStringArray(R.array.home_cards_row1);


        adapter.addItem(new CardItem("카카오 평점이 높은 음식점", new String[]{"카드1", "카드2"}));
        adapter.addItem(new CardItem("안락한 분위기의 카페", new String[]{"카드1", "카드2", "카드3", "카드4", "카드5"}));
        adapter.addItem(new CardItem("빵순이 빵도리를 위한 추천", new String[]{"카드1", "카드2", "카드3", "카드4", "카드5", "카드6", "카드7"}));
        adapter.addItem(new CardItem("센치한 날에 가기 좋은 곳", new String[]{"카드1", "카드2", "카드3"}));
        cardListView.setAdapter(adapter);


        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}