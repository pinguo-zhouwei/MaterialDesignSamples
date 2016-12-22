package com.zhouwei.md.materialdesignsamples.behavoir;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.zhouwei.md.materialdesignsamples.R;

/**
 * Created by zhouwei on 16/12/13.
 */

public class BehaviorSimpleActivity extends AppCompatActivity {
    public static final String TAG = "BehaviorSimpleActivity";
    private View mSwipeLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.behavoir_simple_activity);

        initView();
    }

    private void initView() {
        mSwipeLayout = findViewById(R.id.swipe_layout);
        SwipeDismissBehavior swipe = new SwipeDismissBehavior();

        /**
         * //设置滑动的方向，有3个值
         *
         * 1，SWIPE_DIRECTION_ANY 表示向左像右滑动都可以，
         * 2，SWIPE_DIRECTION_START_TO_END，只能从左向右滑
         * 3，SWIPE_DIRECTION_END_TO_START，只能从右向左滑
         */
        swipe.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_START_TO_END);

        swipe.setStartAlphaSwipeDistance(0f);

        swipe.setSensitivity(0.2f);

        swipe.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override
            public void onDismiss(View view) {
                Log.e(TAG,"------>onDissmiss");
            }

            @Override
            public void onDragStateChanged(int state) {
                Log.e(TAG,"------>onDragStateChanged");
            }
        });

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) mSwipeLayout.getLayoutParams();
        if(layoutParams!=null){
            layoutParams.setBehavior(swipe);
        }
    }
}
