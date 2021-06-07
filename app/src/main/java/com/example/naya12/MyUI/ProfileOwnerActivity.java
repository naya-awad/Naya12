package com.example.naya12.MyUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        OwProfiletxt = findViewById(R.id.OwProfiletxt);
       etFirstNamePr = findViewById(R.id.etFirstNamePr);
        etLastNamePr = findViewById(R.id.etLastNamePr);
        etPhonePr = findViewById(R.id.etPhonePr);
        SavebtnPr = findViewById(R.id.SavebtnPr);

        SavebtnPr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileOwnerActivity.this, MainMapsActivity.class);
                startActivity(i);
            }
        });
    }

}
