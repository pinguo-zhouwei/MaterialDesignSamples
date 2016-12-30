package com.zhouwei.md.materialdesignsamples.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import com.zhouwei.md.materialdesignsamples.R;

/**
 * Created by zhouwei on 16/12/23.
 */

public class BottomNavigationActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNavigationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation_view_layout);

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);

    }
}
