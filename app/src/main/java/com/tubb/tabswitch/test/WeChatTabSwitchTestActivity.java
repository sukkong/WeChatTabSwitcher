package com.tubb.tabswitch.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tubb.tabswitch.TabIndicator;
import com.tubb.tabswitch.TabSwitcher;

import java.util.ArrayList;
import java.util.List;


public class WeChatTabSwitchTestActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager pager;
    private LinearLayout bottomWX, bottomFX, bottomW;

    private List<TabIndicator> indicators = new ArrayList<>();

    private ImageView imgWXSelect, imgWXUnSelect, imgFXSelect, imgFXUnSelect, imgWSelect, imgWUnSelect;
    private TextView tvWXSelect, tvWXUnSelect, tvFXSelect, tvFXUnSelect, tvWSelect, tvWUnSelect;

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

            @Override
            public void onPageScrollStateChanged(int position) {
                super.onPageScrollStateChanged(position);
            }
        });
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.pager);
        bottomWX = (LinearLayout) findViewById(R.id.bottom_wx);
        bottomFX = (LinearLayout) findViewById(R.id.bottom_fx);
        bottomW = (LinearLayout) findViewById(R.id.bottom_w);

        bottomWX.setOnClickListener(this);
        bottomFX.setOnClickListener(this);
        bottomW.setOnClickListener(this);

        imgWXSelect = (ImageView) findViewById(R.id.img_wx_select);
        imgWXUnSelect = (ImageView) findViewById(R.id.img_wx_unselect);
        imgFXSelect = (ImageView) findViewById(R.id.img_fx_select);
        imgFXUnSelect = (ImageView) findViewById(R.id.img_fx_unselect);
        imgWSelect = (ImageView) findViewById(R.id.img_w_select);
        imgWUnSelect = (ImageView) findViewById(R.id.img_w_unselect);

        tvWXSelect = (TextView) findViewById(R.id.tv_wx_select);
        tvWXUnSelect = (TextView) findViewById(R.id.tv_wx_unselect);
        tvFXSelect = (TextView) findViewById(R.id.tv_fx_select);
        tvFXUnSelect = (TextView) findViewById(R.id.tv_fx_unselect);
        tvWSelect = (TextView) findViewById(R.id.tv_w_select);
        tvWUnSelect = (TextView) findViewById(R.id.tv_w_unselect);

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

    @Override
    public void onClick(View v) {
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
