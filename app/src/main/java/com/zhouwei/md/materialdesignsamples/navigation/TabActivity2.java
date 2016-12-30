package com.zhouwei.md.materialdesignsamples.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.zhouwei.md.materialdesignsamples.R;

/**
 * Created by zhouwei on 16/12/29.
 */

public class TabActivity2 extends AppCompatActivity {
    private TabLayout mTabLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout_ac2);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout2);

        /*mTabLayout.addTab(mTabLayout.newTab().setText("个性推荐").setIcon(R.drawable.ic_favorite_border_black_24dp));
        mTabLayout.addTab(mTabLayout.newTab().setText("歌单"));
        mTabLayout.addTab(mTabLayout.newTab().setText("主播电台"));
        mTabLayout.addTab(mTabLayout.newTab().setText("排行榜"));*/

    }
}
