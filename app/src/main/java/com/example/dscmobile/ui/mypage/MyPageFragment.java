package com.example.dscmobile.ui.mypage;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dscmobile.R;
import com.example.dscmobile.databinding.FragmentMypageBinding;

import java.util.ArrayList;

public class MyPageFragment extends Fragment {

    private FragmentMypageBinding binding;
    private ArrayList<MyPageMenuData> myPageMenuData;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MyPageViewModel myPageViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MyPageViewModel.class);

        binding = FragmentMypageBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView myPageMenu = (RecyclerView) root.findViewById(R.id.mypageMenuRecyclerView);
        myPageMenu.setHasFixedSize(true);

        myPageMenu.setLayoutManager(new LinearLayoutManager(getActivity()));
        myPageMenu.scrollToPosition(0);

        MyPageMenuAdapter myPageMenuAdapter = new MyPageMenuAdapter(myPageMenuData);
        myPageMenu.setAdapter(myPageMenuAdapter);
        myPageMenu.setItemAnimator(new DefaultItemAnimator());

        final TextView textView = binding.headerMypage;
        myPageViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void initDataset(){
        // 테스트용 데이터
        myPageMenuData = new ArrayList<>();
        myPageMenuData.add(new MyPageMenuData(R.drawable.ic_baseline_format_list_bulleted_24, "공지/ 이벤트"));
        myPageMenuData.add(new MyPageMenuData(R.drawable.ic_baseline_receipt_long_24, "이용 기록"));
        myPageMenuData.add(new MyPageMenuData(R.drawable.ic_baseline_account_balance_wallet_24, "결제수단 관리"));
        myPageMenuData.add(new MyPageMenuData(R.drawable.ic_baseline_monetization_on_24, "포인트"));
        myPageMenuData.add(new MyPageMenuData(R.drawable.ic_baseline_credit_card_24, "쿠폰함"));
        myPageMenuData.add(new MyPageMenuData(R.drawable.ic_baseline_message_24, "고객센터"));
    }
}