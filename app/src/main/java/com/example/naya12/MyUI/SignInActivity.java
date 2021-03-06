package com.example.naya12.MyUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.naya12.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    private TextView SignIntxt, txtCreateAccount;
    private EditText etEmailIn, etPasswordIn;
    private Button nextbtn, btnSignUpIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null)
        {
            Intent i = new Intent(SignInActivity.this, MainMapsActivity.class);
            startActivity(i);
        }
        SignIntxt = findViewById(R.id.SignIntxt);
        etEmailIn = findViewById(R.id.etEmailIn);
        etPasswordIn = findViewById(R.id.etPasswordIn);
        nextbtn = findViewById(R.id.nextbtn);
        txtCreateAccount = findViewById(R.id.txtCreateAccount);
        btnSignUpIn = findViewById(R.id.btnSignUpIn);


        btnSignUpIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(i);

            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();


            }

            private void validateForm() {
                String email = etEmailIn.getText().toString();
                String pass = etPasswordIn.getText().toString();

                boolean isOK = true;


                if (email.length() < 5 || (email.indexOf('@') == 0) || email.indexOf('@') >= email.length() - 2 || email.indexOf('.') == 0
                        || email.indexOf('.') >= email.length() - 1 || email.lastIndexOf('.') < email.indexOf('@'))//בודק אם האימיל כתוב לא נכון
                {
                    isOK = false;
                    etEmailIn.setError("Wrong E-mail. Try again");
                }

                if (pass.length() < 8) {
                    etPasswordIn.setError("Invalid Password");
                }
                if (isOK)// isOk = true
                {
                    signIn(email, pass);
                }
            }

            private void signIn(final String email, String pass) {
                FirebaseAuth auth = FirebaseAuth.getInstance().getInstance();
                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                                Intent i = new Intent(SignInActivity.this, ProfileActivity.class);
                                i.putExtra("email",email);
                                startActivity(i);
                            }
                         else {
                            Toast.makeText(SignInActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                            etEmailIn.setError(task.getException().getMessage());
                        }
                    }
                });

            }

        });
    }
}