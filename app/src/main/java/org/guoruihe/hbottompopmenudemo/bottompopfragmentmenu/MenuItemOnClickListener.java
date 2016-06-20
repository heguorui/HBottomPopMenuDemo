package org.guoruihe.hbottompopmenudemo.bottompopfragmentmenu;

import android.util.Log;
import android.view.View;

/**
 * Created by guorui.he on 2016/6/20.
 */
public abstract class MenuItemOnClickListener implements View.OnClickListener{

    public MenuItemOnClickListener(BottomMenuFragment _bottomMenuFragment, MenuItem _menuItem) {
        this.bottomMenuFragment = _bottomMenuFragment;
        this.menuItem = _menuItem;
    }
    private final String TAG = "MenuItemOnClickListener";

    public BottomMenuFragment getBottomMenuFragment() {
        return bottomMenuFragment;
    }

    public void setBottomMenuFragment(BottomMenuFragment bottomMenuFragment) {
        this.bottomMenuFragment = bottomMenuFragment;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    private BottomMenuFragment bottomMenuFragment;
    private MenuItem menuItem;

    @Override
    public void onClick(View v){

        Log.i(TAG, "onClick: ");

        if(bottomMenuFragment != null && bottomMenuFragment.isVisible()) {
            bottomMenuFragment.dismiss();
        }

        this.onClickMenuItem(v, this.menuItem);
    }
    public abstract void onClickMenuItem(View v, MenuItem menuItem);
}
