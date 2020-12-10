package com.example.naya12.MyUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.naya12.R;

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
        PhoneCallbtn=findViewById(R.id.PhoneCallbtn);
        Gobtn=findViewById(R.id.Gobtn);
    }
}