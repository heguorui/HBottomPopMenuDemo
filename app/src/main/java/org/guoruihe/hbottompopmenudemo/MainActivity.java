package org.guoruihe.hbottompopmenudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.guoruihe.hbottompopmenudemo.bottompopfragmentmenu.BottomMenuFragment;
import org.guoruihe.hbottompopmenudemo.bottompopfragmentmenu.MenuItem;
import org.guoruihe.hbottompopmenudemo.bottompopfragmentmenu.MenuItemOnClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_bottom_pop_fragment_menu = (Button) this.findViewById(R.id.btn_bottom_pop_fragment_menu);
        btn_bottom_pop_fragment_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();

                List<MenuItem> menuItemList = new ArrayList<MenuItem>();
                MenuItem menuItem1 = new MenuItem();
                menuItem1.setText("Hello World");
                menuItem1.setStyle(MenuItem.MenuItemStyle.COMMON);
                MenuItem menuItem2 = new MenuItem();
                menuItem2.setText("Menu Btn 2");
                MenuItem menuItem3 = new MenuItem();
                menuItem3.setText("点击！");
                menuItem3.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem3) {
                    @Override
                    public void onClickMenuItem(View v, MenuItem menuItem) {
                        Log.i("", "onClickMenuItem: ");
                    }
                });
                menuItemList.add(menuItem1);
                menuItemList.add(menuItem2);
                menuItemList.add(menuItem3);

                bottomMenuFragment.setMenuItems(menuItemList);

                bottomMenuFragment.show(getFragmentManager(), "BottomMenuFragment");
            }
        });


    }
}
