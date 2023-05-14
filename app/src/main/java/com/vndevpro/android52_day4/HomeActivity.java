package com.vndevpro.android52_day4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        tvInfo = findViewById(R.id.tvInfo);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(Constants.USER_NAME);
        String userName2 = intent.getExtras().getString("PASSWORDSS", "password default");
        String passwords = intent.getStringExtra(Constants.PASSWORDS);
        tvInfo.setText(" user name : " + userName + " passwords : " + passwords);

        UserModel userModel = (UserModel) intent.getSerializableExtra(Constants.USER);
        Log.d(TAG, "initView: " + userModel.toString());

    }
}