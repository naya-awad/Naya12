package com.example.naya12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    private TextView SignUptxt;
    private EditText etFirstName,etLastName,etPassword,etVerPassword,etEmail,etPhone;
    private Button Savebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SignUptxt=findViewById(R.id.SignUptxt);
        etFirstName=findViewById(R.id.etFirstName);
        etLastName=findViewById(R.id.etLastName);
        etPassword=findViewById(R.id.etPassword);
        etVerPassword=findViewById(R.id.etVerPassword);
        etEmail=findViewById(R.id.etEmail);
        etPhone=findViewById(R.id.etPhone);
        Savebtn=findViewById(R.id.Savebtn);
    }

    private void checkForm()//hl 3bahn sa7(sign up)
    {
        String firstn=etFirstName.getText().toString();
        String lastn=etLastName.getText().toString();
        String pass=etPassword.getText().toString();
        String verPass=etVerPassword.getText().toString();
        String email=etEmail.getText().toString();
        String phone=etPhone.getText().toString();
        String save=Savebtn.getText().toString();

        boolean isOK=true;

        if(firstn.length()<2)
        {
            isOK=false;
            etFirstName.setError("at least two letter");
        }

        if (email.length()<5 || (email.indexOf('@')==0 ) || email.indexOf('@')>=email.length()-2 || email.indexOf('.')==0
                ||email.indexOf('.')>=email.length()-1 ||email.lastIndexOf('.')<email.indexOf('@'))
        {
            isOK=false;
           etEmail.setError("Wrong E-mail. Try again");
        }
    }
}