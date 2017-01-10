package com.zhouwei.md.materialdesignsamples.behavoir;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zhouwei.md.materialdesignsamples.R;

import static android.support.design.widget.Snackbar.make;

/**
 * Created by zhouwei on 16/12/20.
 */

public class FABSimpleActivity extends AppCompatActivity {
    private static final String TAG = "FABSimpleActivity";
    private FloatingActionButton fab1,fab2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fab_simple_layout);

        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make(fab1,"点击fab1",Snackbar.LENGTH_LONG).show();
            }
        });

        fab1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));


        fab2.setImageResource(R.drawable.ic_book_list);

        fab2.setCompatElevation(6);

        fab2.setSize(FloatingActionButton.SIZE_NORMAL);
        fab2.hide(new FloatingActionButton.OnVisibilityChangedListener() {
            @Override
            public void onHidden(FloatingActionButton fab) {
                Log.i(TAG,"fab hidden...");
            }
        });
        fab2.show(new FloatingActionButton.OnVisibilityChangedListener() {
            @Override
            public void onShown(FloatingActionButton fab) {
                Log.i(TAG,"fab show...");
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showSnackbar();

            }
        });



    }

    private void showSnackbar(){
        Snackbar snackbar = Snackbar.make(fab2,"哈哈，我是Snackbar",Snackbar.LENGTH_SHORT);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FABSimpleActivity.this,"执行Undo操作",Toast.LENGTH_LONG).show();
            }
        });

        snackbar.setActionTextColor(getResources().getColor(R.color.DarkCyan));
        snackbar.setText("已经删除1张照片");
        snackbar.show();
    }
}
