package com.tubb.tabswitch.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tubb.tabswitch.TabIndicator;
import com.tubb.tabswitch.TabSwitcher;

import java.util.ArrayList;
import java.util.List;


public class WeChatTabSwitchTestActivity extends AppCompatActivity{
    
    private ViewPager pager;
    private List<TabIndicator> indicators = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabswitch);
        initView();

        TabSwitcher tabSwitcher = new TabSwitcher(indicators);
        pager.addOnPageChangeListener(new TabSwitcher.OnPageChangeListener(tabSwitcher) {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.pager);

        ImageView imgWXSelect = (ImageView) findViewById(R.id.img_wx_select);
        ImageView imgWXUnSelect = (ImageView) findViewById(R.id.img_wx_unselect);
        ImageView imgFXSelect = (ImageView) findViewById(R.id.img_fx_select);
        ImageView imgFXUnSelect = (ImageView) findViewById(R.id.img_fx_unselect);
        ImageView imgWSelect = (ImageView) findViewById(R.id.img_w_select);
        ImageView imgWUnSelect = (ImageView) findViewById(R.id.img_w_unselect);

        TextView tvWXSelect = (TextView) findViewById(R.id.tv_wx_select);
        TextView tvWXUnSelect = (TextView) findViewById(R.id.tv_wx_unselect);
        TextView tvFXSelect = (TextView) findViewById(R.id.tv_fx_select);
        TextView tvFXUnSelect = (TextView) findViewById(R.id.tv_fx_unselect);
        TextView tvWSelect = (TextView) findViewById(R.id.tv_w_select);
        TextView tvWUnSelect = (TextView) findViewById(R.id.tv_w_unselect);

        TabIndicator wxIndicator = new TabIndicator(imgWXUnSelect, tvWXUnSelect, imgWXSelect, tvWXSelect);
        TabIndicator fxIndicator = new TabIndicator(imgFXUnSelect, tvFXUnSelect, imgFXSelect, tvFXSelect);
        TabIndicator wIndicator = new TabIndicator(imgWUnSelect, tvWUnSelect, imgWSelect, tvWSelect);
        indicators.add(wxIndicator);
        indicators.add(fxIndicator);
        indicators.add(wIndicator);

        List<Fragment> frgs = new ArrayList<>(3);
        frgs.add(MyFragment.newInstance(0));
        frgs.add(MyFragment.newInstance(1));
        frgs.add(MyFragment.newInstance(2));
        pager.setAdapter(new MyAdapter(getSupportFragmentManager(), frgs));
    }

    public void viewClick(View v) {
        switch (v.getId()) {
            case R.id.bottom_wx:
                pager.setCurrentItem(0, false);
                break;
            case R.id.bottom_fx:
                pager.setCurrentItem(1, false);
                break;
            case R.id.bottom_w:
                pager.setCurrentItem(2, false);
                break;
        }
    }


    private class MyAdapter extends FragmentPagerAdapter {

        private List<Fragment> frgs;
        public MyAdapter(FragmentManager fm, List<Fragment> frgs) {
            super(fm);
            this.frgs = frgs;
        }

        @Override
        public Fragment getItem(int position) {
            return frgs.get(position);
        }

        @Override
        public int getCount() {
            return frgs.size();
        }

    }

}
