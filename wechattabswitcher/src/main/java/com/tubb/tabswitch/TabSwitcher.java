package com.tubb.tabswitch;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by bingbing.tu
 * 2015/7/3.
 */
public class TabSwitcher {

    private List<TabIndicator> indicators;

    public TabSwitcher(List<TabIndicator> indicators){
        this.indicators = indicators;
        init();
        if(indicators.size() > 0) switchTo(0);
    }

    public void init(){
        for (TabIndicator indicator:indicators){
            ViewCompat.setAlpha(indicator.getIcon(), 1.0f);
            ViewCompat.setAlpha(indicator.getIconSelected(), 0.0f);
            ViewCompat.setAlpha(indicator.getTitle(), 1.0f);
            ViewCompat.setAlpha(indicator.getTitleSelected(), 0.0f);
        }
    }

    public void switchTo(int position){
        TabIndicator indicator = indicators.get(position);
        ViewCompat.setAlpha(indicator.getIcon(), 0.0f);
        ViewCompat.setAlpha(indicator.getIconSelected(), 1.0f);
        ViewCompat.setAlpha(indicator.getTitle(), 0.0f);
        ViewCompat.setAlpha(indicator.getTitleSelected(), 1.0f);
    }

    private void switchTo(int position, float positionOffset, int positionOffsetPixels) {
        int nextPosition;
        if (positionOffsetPixels > 0) {
            nextPosition = position + 1;
        } else {
            nextPosition = position - 1;
        }
        if(nextPosition < 0) return;
        TabIndicator nextTabIndicator = indicators.get(nextPosition);
        ViewCompat.setAlpha(nextTabIndicator.getIcon(), 1 - positionOffset);
        ViewCompat.setAlpha(nextTabIndicator.getIconSelected(), positionOffset);
        ViewCompat.setAlpha(nextTabIndicator.getTitle(), 1 - positionOffset);
        ViewCompat.setAlpha(nextTabIndicator.getTitleSelected(), positionOffset);

        TabIndicator preTabIndicator = indicators.get(position);
        ViewCompat.setAlpha(preTabIndicator.getIcon(), positionOffset);
        ViewCompat.setAlpha(preTabIndicator.getIconSelected(), 1 - positionOffset);
        ViewCompat.setAlpha(preTabIndicator.getTitle(), positionOffset);
        ViewCompat.setAlpha(preTabIndicator.getTitleSelected(), 1 - positionOffset);
    }

    public static class OnPageChangeListener implements ViewPager.OnPageChangeListener{

        private TabSwitcher tabSwitcher;

        public OnPageChangeListener(TabSwitcher tabSwitcher){
            this.tabSwitcher = tabSwitcher;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            tabSwitcher.switchTo(position, positionOffset, positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            tabSwitcher.init();
            tabSwitcher.switchTo(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {}
    }
}
