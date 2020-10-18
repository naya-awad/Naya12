package com.example.naya12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class BuyingGPS extends AppCompatActivity {

    private TextView BuyGPStxt,Calltxt;
    private ImageView GPSimg;
    private Button PhoneCallbtn,Gobtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buying_g_p_s);

        BuyGPStxt=findViewById(R.id.BuyGPStxt);
        Calltxt=findViewById(R.id.Calltxt);
        GPSimg=findViewById(R.id.GPSimg);
        PhoneCallbtn=findViewById(R.id.PhoneCallbtn);
        Gobtn=findViewById(R.id.Gobtn);
    }
}