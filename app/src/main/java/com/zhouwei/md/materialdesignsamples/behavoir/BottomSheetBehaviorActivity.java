package com.zhouwei.md.materialdesignsamples.behavoir;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhouwei.md.materialdesignsamples.R;

/**
 * Created by zhouwei on 16/12/20.
 */

public class BottomSheetBehaviorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_behavior_ac);

        View shareView = findViewById(R.id.share_view);
        //获取BottomSheetBehavior
        final BottomSheetBehavior sheetBehavior = BottomSheetBehavior.from(shareView);

        //设置折叠时的高度
        //sheetBehavior.setPeekHeight(BottomSheetBehavior.PEEK_HEIGHT_AUTO);

        //监听BottomSheetBehavior 状态的变化
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        //下滑的时候是否可以隐藏
        sheetBehavior.setHideable(true);
        findViewById(R.id.btn_show_bottom_sheet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED){
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }else {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }

            }
        });
    }
}
