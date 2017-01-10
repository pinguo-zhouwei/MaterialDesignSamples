package com.zhouwei.md.materialdesignsamples.cardview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.zhouwei.md.materialdesignsamples.R;

/**
 * Created by zhouwei on 17/1/10.
 */

public class CardViewSimpleActivity extends AppCompatActivity {
    private CardView mCardView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view_layout);

        mCardView = (CardView) findViewById(R.id.card_view);
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //设置背景
        /*mCardView.setCardBackgroundColor(getColor(R.color.colorPrimary));
        //设置圆角
        mCardView.setRadius(5);
        //设置阴影
        mCardView.setCardElevation(3);
        //设置 padding
        mCardView.setUseCompatPadding(true);
        //
        mCardView.setPreventCornerOverlap(true);*/
    }
}
