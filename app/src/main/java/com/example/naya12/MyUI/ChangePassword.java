package com.example.naya12.MyUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.naya12.R;

public class ChangePassword extends AppCompatActivity {

    private TextView ChangePasstxt;
    private EditText etPassChange,etVerPassChange;
    private Button SaveChangebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        ChangePasstxt=findViewById(R.id.ChangePasstxt);
        etPassChange=findViewById(R.id.etPassChange);
        etVerPassChange=findViewById(R.id.etVerPassUp);
        SaveChangebtn=findViewById(R.id.SaveChangebtn);
    }
}