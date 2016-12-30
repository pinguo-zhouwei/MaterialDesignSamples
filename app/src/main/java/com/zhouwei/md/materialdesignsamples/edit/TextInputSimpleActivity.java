package com.zhouwei.md.materialdesignsamples.edit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.zhouwei.md.materialdesignsamples.R;

/**
 * Created by zhouwei on 16/12/29.
 */

public class TextInputSimpleActivity extends AppCompatActivity{
    private TextInputLayout mTextInputLayoutUser,mTextInputLayoutPassword;
    private TextInputEditText mInputEditTextPassword;
    private EditText mInputEditTextUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_input_layout_ac);

        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mTextInputLayoutUser = (TextInputLayout) findViewById(R.id.text_input_layout_user);
        //设置可以计数
        mTextInputLayoutUser.setCounterEnabled(true);
        //计数的最大值
        mTextInputLayoutUser.setCounterMaxLength(20);

        mInputEditTextUser = (EditText) findViewById(R.id.text_input_user);

        mTextInputLayoutPassword = (TextInputLayout) findViewById(R.id.text_input_layout_password);
        mInputEditTextPassword = (TextInputEditText) findViewById(R.id.text_input_password);

        mInputEditTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTextInputLayoutPassword.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = mInputEditTextPassword.getText().toString();
                if(TextUtils.isEmpty(password)||password.length()<6){
                    mTextInputLayoutPassword.setError("密码错误不能少于6个字符");
                }

            }
        });
    }
}
