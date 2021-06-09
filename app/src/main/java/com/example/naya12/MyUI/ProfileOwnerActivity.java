package com.example.naya12.MyUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.naya12.R;
import com.example.naya12.data.MyClient;
import com.example.naya12.data.MyItem;
import com.example.naya12.data.MyOwner;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileOwnerActivity extends AppCompatActivity {
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
    private void validateForm ()
    {
        String type = "";
        String fN = etFirstNamePr.getText().toString();
        String lN = etLastNamePr.getText().toString();
        String ph = etPhonePr.getText().toString();

        boolean isOK = true;
        if (fN.length() < 2 || lN.length() < 2)
            isOK = false;
        if (ph.length() < 10)
            isOK = false;
        if (isOK == true) {
            String email = getIntent().getStringExtra("Email");

            MyOwner owner = new MyOwner(ph, fN, lN, email);

            saveOwner(owner);
        }
    }
    private void saveOwner(MyOwner myOwner) {
        //1.
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //2.
        DatabaseReference reference = database.getReference();
        //3. user id
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String uid = auth.getCurrentUser().getUid();
        //4. My Object Key
        String key = reference.child("AllClients").push().getKey();
        //5. Update Your Object
        myOwner.setFirstn(uid);
        myOwner.setPhone(key);
        //6. Actual Stroring
        reference.child("AllOwners").child(key).setValue(myOwner).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ProfileOwnerActivity.this,"add Successful",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(ProfileOwnerActivity.this,"add Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }
}
