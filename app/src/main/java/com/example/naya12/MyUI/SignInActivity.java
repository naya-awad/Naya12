package com.example.naya12.MyUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.naya12.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    private TextView SignIntxt,txtCreateAccount;
    private EditText etEmailIn,etPasswordIn;
    private Button ForgotPassbtn,LogInbtn,btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        SignIntxt=findViewById(R.id.SignIntxt);
        etEmailIn=findViewById(R.id.etEmailIn);
        etPasswordIn=findViewById(R.id.etPasswordIn);
        ForgotPassbtn=findViewById(R.id.ForgotPassbtn);
        LogInbtn=findViewById(R.id.LogInbtn);
        txtCreateAccount=findViewById(R.id.txtCreateAccount);
        btnSignUp=findViewById(R.id.btnSignUp);
    }
    private void validateForm()
    {
        String email=etEmailIn.getText().toString();
        String pass=etPasswordIn.getText().toString();

        boolean isOK=true;



        if (email.length()<5 || (email.indexOf('@')==0 ) || email.indexOf('@')>=email.length()-2 || email.indexOf('.')==0
                ||email.indexOf('.')>=email.length()-1 ||email.lastIndexOf('.')<email.indexOf('@'))//בודק אם האימיל כתוב לא נכון
        {
            isOK=false;
            etEmail.setError("Wrong E-mail. Try again");
        }

        MyValidations myValidation=new MyValidations();
        if (myValidation.validatePasword(pass)==false){
            isOK= false;
            etPassword.setError("Invalid Password");
        }
        if(isOK)// isOk = true
        {
            signIn(email, pass);
        }
    }
    private void signIn(String email,String pass)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance().getInstance();
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Intent i=new Intent(SignInActivity.this, MainActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(SignInActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    etEmail.setError(task.getException().getMessage());
                }
            }
        });

    }

}
}