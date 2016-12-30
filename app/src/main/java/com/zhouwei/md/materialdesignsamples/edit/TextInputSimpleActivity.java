package com.zhouwei.md.materialdesignsamples.edit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhouwei.md.materialdesignsamples.R;

/**
 * Created by zhouwei on 16/12/29.
 */

public class TextInputSimpleActivity extends AppCompatActivity{
    private TextInputLayout mTextInputLayoutUser,mTextInputLayoutPassword;
    private TextInputEditText mInputEditTextUser,mInputEditTextPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_input_layout_ac);

        initView();
    }

    private void initView() {
        mTextInputLayoutUser = (TextInputLayout) findViewById(R.id.text_input_layout_user);
        mTextInputLayoutPassword = (TextInputLayout) findViewById(R.id.text_input_layout_password);
        mInputEditTextUser = (TextInputEditText) findViewById(R.id.text_input_user);
        mInputEditTextPassword = (TextInputEditText) findViewById(R.id.text_input_password);
        //设置可以计数
        mTextInputLayoutUser.setCounterEnabled(true);
        //计数的最大值
        mTextInputLayoutUser.setCounterMaxLength(20);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextInputLayoutPassword.setError("密码错误，请重试");

            }
        });
    }
}
