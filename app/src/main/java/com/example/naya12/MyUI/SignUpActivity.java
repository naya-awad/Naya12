package com.example.naya12.MyUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.naya12.MyUtils.MyValidation;
import com.example.naya12.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private TextView SignUptxt;
    private EditText etFirstName, etLastName, etUserName, etPassword, etVerPass, etEmail, etPhone;
    private Button SavebtnUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SignUptxt = findViewById(R.id.SignUptxt);
        etFirstName = findViewById(R.id.etFirstNameUp);
        etLastName = findViewById(R.id.etLastNameUp);
        etPassword = findViewById(R.id.etPasswordUp);
        etVerPass = findViewById(R.id.etVerPassUp);
        etEmail = findViewById(R.id.etEmailUp);
        etPhone = findViewById(R.id.etPhoneUp);
        SavebtnUp = findViewById(R.id.SavebtnUp);

        SavebtnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this, MainMapsActivity.class);
                startActivity(i);

            }


            private void checkForm()//hl 3bahn sa7(sign up)
            {
                String firstn = etFirstName.getText().toString();
                String lastn = etLastName.getText().toString();
                String username = etUserName.getText().toString();
                String pass = etPassword.getText().toString();
                String verPass = etVerPass.getText().toString();
                String email = etEmail.getText().toString();
                String phone = etPhone.getText().toString();
                String save = SavebtnUp.getText().toString();

                boolean isOK = true;

                if (firstn.length() < 2) {
                    isOK = false;
                    etFirstName.setError("at least two letter");
                }
                if (lastn.length() < 2)//בודק אם השם האחרון כתוב לא נכון(צריך להיות יותר משני אותיות)
                {
                    isOK = false;
                    etLastName.setError("at least two letter");
                }

                if (email.length() < 5 || (email.indexOf('@') == 0) || email.indexOf('@') >= email.length() - 2 || email.indexOf('.') == 0
                        || email.indexOf('.') >= email.length() - 1 || email.lastIndexOf('.') < email.indexOf('@')) {
                    isOK = false;
                    etEmail.setError("Wrong E-mail. Try again");
                }
                if (pass.equals(verPass) == false) {
                    isOK = false;
                    etVerPass.setError("Passwords must be the same!");

                } else {
                    MyValidation myValidation = new MyValidation();
                    if (myValidation.validatePasword(pass) == false) {
                        isOK = false;
                        etPassword.setError("Invalid Password");
                    }
                }
                if (isOK)// isOk = true
                {
                    // todo: create account and return to sign in screen/ close this screen
                    createNewAccount(firstn, lastn, username, pass, email, phone);
                }
            }

            private void createNewAccount(String firstn, String lastn, String username, final String pass, final String email, String phone) {

                //1
                FirebaseAuth auth = FirebaseAuth.getInstance();//אחראית על רישום וכניסת משתמשים
                //2
                OnCompleteListener<AuthResult> listener = new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())// ההרשמה הצליחה כמו שנדרש
                        {
                            Toast.makeText(SignUpActivity.this, "Successfully up", Toast.LENGTH_SHORT).show();
                            //next screen or close this screen
                            //get other data and save it in firebase

                            finish();//close this screen
                            //next screen
                            //Intent i= new Intent(getBaseContext(),MainActivity.class); startActivity(i);
                        } else {
                            Toast.makeText(SignUpActivity.this, "Signing up, Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            etEmail.setError("Signing up, Failed: " + task.getException().getMessage());

                        }
                    }
                };
                //3
                auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(listener);

            }

        });
    }
}
