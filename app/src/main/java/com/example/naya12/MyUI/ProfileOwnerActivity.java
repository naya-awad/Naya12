package com.example.naya12.MyUI;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.naya12.R;

public class ProfileOwnerActivity extends AppCompatActivity
{
    private TextView OwProfiletxt;
    private EditText etFirstNamePr, etLastNamePr, etPhonePr;
    private Button SavebtnPr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_owner);

        OwProfiletxt=findViewById(R.id.OwProfiletxt);
}
