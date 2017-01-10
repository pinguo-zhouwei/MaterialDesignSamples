package com.zhouwei.md.materialdesignsamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhouwei.md.materialdesignsamples.behavoir.BehaviorSimpleActivity;
import com.zhouwei.md.materialdesignsamples.behavoir.BottomSheetBehaviorActivity;
import com.zhouwei.md.materialdesignsamples.behavoir.CustomBehaviorActivity;
import com.zhouwei.md.materialdesignsamples.behavoir.CustomBehaviorActivity2;
import com.zhouwei.md.materialdesignsamples.behavoir.FABSimpleActivity;
import com.zhouwei.md.materialdesignsamples.bottomsheetdialog.BottomSheetDialogActivity;
import com.zhouwei.md.materialdesignsamples.cardview.CardViewSimpleActivity;
import com.zhouwei.md.materialdesignsamples.edit.TextInputSimpleActivity;
import com.zhouwei.md.materialdesignsamples.navigation.BottomNavigationActivity;
import com.zhouwei.md.materialdesignsamples.navigation.TabActivity;
import com.zhouwei.md.materialdesignsamples.navigation.TabActivity2;
import com.zhouwei.md.materialdesignsamples.toolbar.AppbarLayoutActivity;
import com.zhouwei.md.materialdesignsamples.toolbar.JanshuActivity;
import com.zhouwei.md.materialdesignsamples.toolbar.ToolbarActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_bottom_sheet).setOnClickListener(this);
        findViewById(R.id.btn_toolbar).setOnClickListener(this);
        findViewById(R.id.btn_appbar_layout).setOnClickListener(this);
        findViewById(R.id.btn_appbar_layout1).setOnClickListener(this);
        findViewById(R.id.swipe_btn).setOnClickListener(this);
        findViewById(R.id.custom_behavior).setOnClickListener(this);
        findViewById(R.id.custom_behavior2).setOnClickListener(this);
        findViewById(R.id.fab_snack_btn).setOnClickListener(this);
        findViewById(R.id.bottom_sheet_demo).setOnClickListener(this);
        findViewById(R.id.tab_layout_simple1).setOnClickListener(this);
        findViewById(R.id.tab_layout_simple2).setOnClickListener(this);
        findViewById(R.id.bottom_navigaiton_simple).setOnClickListener(this);
        findViewById(R.id.text_input_simple).setOnClickListener(this);
        findViewById(R.id.card_view_simple).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case  R.id.btn_bottom_sheet:
                intent = new Intent(this, BottomSheetDialogActivity.class);
                startActivity(intent);
                break;
            case  R.id.btn_toolbar:
                intent = new Intent(this, ToolbarActivity.class);
                startActivity(intent);
                break;
            case  R.id.btn_appbar_layout:
                intent = new Intent(this, AppbarLayoutActivity.class);
                startActivity(intent);
                break;
            case  R.id.btn_appbar_layout1:
                intent = new Intent(this, JanshuActivity.class);
                startActivity(intent);
                break;
            case  R.id.swipe_btn:
                intent = new Intent(this, BehaviorSimpleActivity.class);
                startActivity(intent);
                break;
            case  R.id.custom_behavior:
                intent = new Intent(this, CustomBehaviorActivity.class);
                startActivity(intent);
                break;
            case  R.id.custom_behavior2:
                intent = new Intent(this, CustomBehaviorActivity2.class);
                startActivity(intent);
                break;
            case  R.id.fab_snack_btn:
                intent = new Intent(this, FABSimpleActivity.class);
                startActivity(intent);
                break;
            case  R.id.bottom_sheet_demo:
                intent = new Intent(this, BottomSheetBehaviorActivity.class);
                startActivity(intent);
                break;
            case  R.id.tab_layout_simple1:
                intent = new Intent(this, TabActivity2.class);
                startActivity(intent);
                break;
            case  R.id.tab_layout_simple2:
                intent = new Intent(this, TabActivity.class);
                startActivity(intent);
                break;
            case  R.id.bottom_navigaiton_simple:
                intent = new Intent(this, BottomNavigationActivity.class);
                startActivity(intent);
                break;
            case  R.id.text_input_simple:
                intent = new Intent(this, TextInputSimpleActivity.class);
                startActivity(intent);
                break;
            case  R.id.card_view_simple:
                intent = new Intent(this, CardViewSimpleActivity.class);
                startActivity(intent);
                break;
        }
    }
}
