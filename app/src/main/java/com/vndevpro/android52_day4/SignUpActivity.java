package com.vndevpro.android52_day4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "ActivityLifeCycle " + SignUpActivity.class.getName();
    private Button btnSignUp;
    private EditText edtUserName;
    private EditText edtPasswords;
    private EditText edtAddress;
    private EditText edtEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        Log.d(TAG, "onCreate: ");

        initView();
    }

    private void initView() {
        btnSignUp = findViewById(R.id.btnSignUp);
        edtUserName = findViewById(R.id.edtUserName);
        edtPasswords = findViewById(R.id.edtPasswords);
        edtAddress = findViewById(R.id.edtAddress);
        edtEmail = findViewById(R.id.edtEmail);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                String userName = edtUserName.getText().toString();
                String passwords = edtPasswords.getText().toString();
                String address = edtAddress.getText().toString();
                String email = edtEmail.getText().toString();

                UserModel userModel = new UserModel();
                userModel.setUserName(userName);
                userModel.setPasswords(passwords);
                userModel.setAddress(address);
                userModel.setEmail(email);

                intent.putExtra(Constants.USER, userModel);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_CANCELED);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
