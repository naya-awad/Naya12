package com.example.naya12.MyUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.naya12.R;

public class MainClientActivity extends AppCompatActivity
{

    private Button btnCall, btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_client);


        btnCall=findViewById(R.id.btnCall);
        btnSend=findViewById(R.id.btnSend);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneno="00000000";

                Intent i=new Intent(Intent.ACTION_CALL, Uri.parse(phoneno));
                startActivity(i);

            }
        });
    }
}