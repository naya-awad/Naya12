package com.example.naya12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    private TextView LostTitletxt;
    private ImageView thinkimg;
    private Button LogInbtn,SignUpbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        LostTitletxt=findViewById(R.id.LostTitletxt);
        thinkimg=findViewById(R.id.thinkimg);
        LogInbtn=findViewById(R.id.LogInbtn);
        SignUpbtn=findViewById(R.id.SignUpbtn);
    }
}