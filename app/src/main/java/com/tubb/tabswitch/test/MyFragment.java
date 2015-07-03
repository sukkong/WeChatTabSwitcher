package com.tubb.tabswitch.test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bingbing.tu
 * 2015/7/3.
 */
public class MyFragment extends Fragment{

    private int index;

    public static Fragment newInstance(int index){
        MyFragment frg = new MyFragment();
        frg.index = index;
        return frg;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView tv = new TextView(getActivity());
        switch (index){
            case 0:
                tv.setText("微信界面");
                tv.setBackgroundColor(Color.YELLOW);
                tv.setTextColor(Color.WHITE);
                tv.setTextSize(35);
                break;
            case 1:
                tv = new TextView(getActivity());
                tv.setText("发现界面");
                tv.setBackgroundColor(Color.RED);
                tv.setTextColor(Color.WHITE);
                tv.setTextSize(35);
                break;
            case 2:
                tv = new TextView(getActivity());
                tv.setText("我界面");
                tv.setBackgroundColor(Color.GREEN);
                tv.setTextColor(Color.WHITE);
                tv.setTextSize(35);
                break;
        }

        return tv;
    }
}
