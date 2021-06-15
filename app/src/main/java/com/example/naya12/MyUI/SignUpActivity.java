package com.example.naya12.MyUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    private EditText  etPassword, etVerPass, etEmail;
    private Button SavebtnUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SignUptxt = findViewById(R.id.SignUptxt);
        etPassword = findViewById(R.id.etPasswordUp);
        etVerPass = findViewById(R.id.etVerPassUp);
        etEmail = findViewById(R.id.etEmailUp);
        SavebtnUp = findViewById(R.id.SavebtnUp);



        SavebtnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForm();



            }


            private void checkForm()//hl 3bahn sa7(sign up)
            {
                String pass = etPassword.getText().toString();
                String verPass = etVerPass.getText().toString();
                String email = etEmail.getText().toString();
                String save = SavebtnUp.getText().toString();

                boolean isOK = true;



//                if (email.length() < 5 || (email.indexOf('@') == 0) || email.indexOf('@') >= email.length() - 2 || email.indexOf('.') == 0
//                        || email.indexOf('.') >= email.length() - 1 || email.lastIndexOf('.') < email.indexOf('@')) {
//                    isOK = false;
//                    etEmail.setError("Wrong E-mail. Try again");
//                }
                if (pass.equals(verPass) == false) {
                    isOK = false;
                    etVerPass.setError("Passwords must be the same!");

                } else {
//                    MyValidation myValidation = new MyValidation();
//                    if (myValidation.validatePassword(pass) == false) {
//                        isOK = false;
//                        etPassword.setError("Invalid Password");
//                    }
                }
                //todo check rb
                if (isOK)// isOk = true
                {
                    // todo: create account and return to sign in screen/ close this screen
                    createNewAccount(pass, email);
                }
            }

            private void createNewAccount(final String pass, final String email) {

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

                            Intent i = new Intent(SignUpActivity.this, SignInActivity.class);
                            i.putExtra("Email",email);
                            startActivity(i);


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
