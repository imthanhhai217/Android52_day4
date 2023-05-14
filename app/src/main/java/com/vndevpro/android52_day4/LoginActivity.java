package com.vndevpro.android52_day4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "ActivityLifeCycle " + LoginActivity.class.getName();
    private Button btnSignUp;
    private Button btnLogin;
    private EditText edtUserName;
    private EditText edtPasswords;

    public static final int REQUEST_CODE_SIGNUP = 123;
    public static final int REQUEST_CODE_HOME = 122;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");
        initView();

    }

    private void initView() {
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);
        edtUserName = findViewById(R.id.edtUserName);
        edtPasswords = findViewById(R.id.edtPasswords);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
//                startActivity(intent);
//                startActivityForResult(intent, REQUEST_CODE_SIGNUP);
                activityResultLauncher.launch(intent);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                String userName = edtUserName.getText().toString();
                String passwords = edtPasswords.getText().toString();

                UserModel userModel = new UserModel();
                userModel.setUserName(userName);
                userModel.setPasswords(passwords);

//                intent.putExtra(Constants.USER_NAME, userName);
//                intent.putExtra(Constants.PASSWORDS, passwords);

                intent.putExtra(Constants.USER, userModel);

                Bundle bundle = new Bundle();
                bundle.putString(Constants.USER_NAME, userName);
                bundle.putString(Constants.PASSWORDS, passwords);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
        Log.d(TAG, "onActivityResult: " + result.getResultCode());
        if (result.getResultCode() == RESULT_OK) {
            Intent intent = result.getData();
            UserModel userModel = (UserModel) intent.getSerializableExtra(Constants.USER);
            Log.d(TAG, "onActivityResult: " + userModel.toString());
        }
    });

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SIGNUP) {
            if (resultCode == RESULT_OK) {
                UserModel userModel = (UserModel) data.getSerializableExtra(Constants.USER);
                Log.d(TAG, "onActivityResult: " + userModel.toString());
                edtUserName.setText(userModel.getUserName());
                edtPasswords.setText(userModel.getPasswords());
            }
            if (resultCode == RESULT_CANCELED) {
                Log.d(TAG, "onActivityResult: User cancel");
            }
        }
        if (requestCode == REQUEST_CODE_HOME) {

        }
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
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}