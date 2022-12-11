package com.example.dscmobile.ui.indoorsetting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.example.dscmobile.R;

import java.io.Console;
import java.util.ArrayList;

public class ModeAdapter extends BaseAdapter {
    ArrayList<ModeItem> modeItems = new ArrayList<>();

    @Override
    public int getCount() {
        return modeItems.size();
    }

    public void addModeItem(ModeItem item) {
        modeItems.add(item);
    }

    @Override
    public Object getItem(int position) {
        return modeItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        final ModeItem modeItem = modeItems.get(position);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.mode_item, parent, false);
        }
        else {
            View view = new View(context);
            view = (View) convertView;
        }

        AppCompatButton modeButton = convertView.findViewById(R.id.mode);
        modeButton.setText(modeItem.getMode());
        Drawable img = ContextCompat.getDrawable(context, modeItem.getModeIcon());
        //Log.e("모드 아이콘", img.toString());
        modeButton.setCompoundDrawablesWithIntrinsicBounds(null, img,null,null);

        return convertView;
    }
}
