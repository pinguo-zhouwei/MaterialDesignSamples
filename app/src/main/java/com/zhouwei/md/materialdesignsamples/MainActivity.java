package com.zhouwei.md.materialdesignsamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhouwei.md.materialdesignsamples.bottomsheetdialog.BottomSheetDialogActivity;
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
        }
    }
}
