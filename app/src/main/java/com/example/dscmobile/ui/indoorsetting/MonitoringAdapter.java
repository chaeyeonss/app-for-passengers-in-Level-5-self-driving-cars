package com.example.dscmobile.ui.indoorsetting;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dscmobile.R;

import java.util.ArrayList;

public class MonitoringAdapter extends BaseAdapter {
    ArrayList<StateItem> monitoringItems = new ArrayList<>();

    @Override
    public int getCount() {
        return monitoringItems.size();
    }

    public void addMonitoringItem(StateItem item){
        monitoringItems.add(item);
    }

    @Override
    public Object getItem(int position) {
        return monitoringItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();
        final StateItem stateItem = monitoringItems.get(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.monitoring_state_item, viewGroup, false);
        }
        else {
            View view = new View(context);
            view = (View) convertView;
        }

        TextView stateTitle = convertView.findViewById(R.id.monitoring_title_text);
        TextView state = convertView.findViewById(R.id.monitoring_state_text);

        stateTitle.setText(stateItem.getTitle());
        state.setText(stateItem.getState());

        Log.d("모니터링 어댑터 getView 실행", "항목: "+stateTitle+"/ 상태값: "+state);
        Log.d("모니터링 어댑터 getView 실행", "항목: "+stateItem.getTitle()+"/ 상태값: "+stateItem.getState());

        return convertView;
    }
}
