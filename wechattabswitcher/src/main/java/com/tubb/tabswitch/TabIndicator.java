package com.tubb.tabswitch;

import android.view.View;

/**
 * Created by bingbing.tu
 * 2015/7/3.
 */
public class TabIndicator {

    private View icon;
    private View iconSelected;
    private View title;
    private View titleSelected;

    public TabIndicator(View icon, View title, View iconSelected, View titleSelected){
        this.setIcon(icon);
        this.setTitle(title);
        this.setIconSelected(iconSelected);
        this.setTitleSelected(titleSelected);
    }

    public View getIcon() {
        return icon;
    }

    public void setIcon(View icon) {
        this.icon = icon;
    }

    public View getIconSelected() {
        return iconSelected;
    }

    public void setIconSelected(View iconSelected) {
        this.iconSelected = iconSelected;
    }

    public View getTitle() {
        return title;
    }

    public void setTitle(View title) {
        this.title = title;
    }

    public View getTitleSelected() {
        return titleSelected;
    }

    public void setTitleSelected(View titleSelected) {
        this.titleSelected = titleSelected;
    }
}
