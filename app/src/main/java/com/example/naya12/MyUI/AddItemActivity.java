package com.example.naya12.MyUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.naya12.R;

public class AddItemActivity extends AppCompatActivity {

    private TextView txtADD;
    private EditText etNameItem,etCodeGPS;
    private RadioButton radioPerson,radioPet,radioItem;
    private Button btnSaveItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        txtADD=findViewById(R.id.txtADD);
        etNameItem=findViewById(R.id.etNameItem);
        etCodeGPS=findViewById(R.id.etCodeGPS);
        radioPerson=findViewById(R.id.radioPerson);
        radioPet=findViewById(R.id.radioPet);
        radioItem=findViewById(R.id.radioItem);
        btnSaveItem=findViewById(R.id.btnSaveItem);
    }
}