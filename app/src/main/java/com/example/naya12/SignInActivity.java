package com.example.naya12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    private TextView SignIntxt;
    private EditText etUser,etPass;
    private Button ForgotPassbtn,LogInbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        SignIntxt=findViewById(R.id.SignIntxt);
        etUser=findViewById(R.id.etUserName);
        etPass=findViewById(R.id.etPassword);
        ForgotPassbtn=findViewById(R.id.ForgotPassbtn);
        LogInbtn=findViewById(R.id.LogInbtn);
    }
}