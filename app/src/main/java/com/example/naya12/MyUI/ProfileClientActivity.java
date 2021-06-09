package com.example.naya12.MyUI;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.naya12.R;

public class ProfileClientActivity  extends AppCompatActivity
{
    private EditText etNamePrCl,etEmailPrCl,etPhoneOwPr,etPhoneClPrCl;
    private RadioButton radioPersonPrCl,radioPetPrCl,radioItemPrCl;
    private Button SavebtnPrCl;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_profile_client);


        etNamePrCl=findViewById(R.id.etNamePrCl);
        etEmailPrCl=findViewById(R.id.etEmailPrCl);
        etPhoneOwPr=findViewById(R.id.etPhoneOwPr);
        etPhoneClPrCl=findViewById(R.id.etPhoneClPrCl);
        radioPersonPrCl=findViewById(R.id.radioPersonPrCl);
        radioPetPrCl=findViewById(R.id.radioPetPrCl);
        radioItemPrCl=findViewById(R.id.radioItemPrCl);
        SavebtnPrCl=findViewById(R.id.SavebtnPrCl);


    }
}
