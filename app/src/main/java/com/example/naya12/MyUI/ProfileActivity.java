package com.example.naya12.MyUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.naya12.R;
import com.example.naya12.data.MyClient;
import com.example.naya12.data.MyOwner;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {
    private TextView OwProfile;
    private EditText etFirstNamePr, etLastNamePr, etPhoneOwPr,etPhoneClPr;
    private RadioButton radioPersonPrCl,radioPetPrCl,radioItemPrCl,radioOwner,radioClient;
    private RadioGroup radioGroupCO,radioGroupPPI;
    private Button SavebtnPr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        OwProfile = findViewById(R.id.Profiletxt);
        etFirstNamePr = findViewById(R.id.etFirstNamePr);
        etLastNamePr = findViewById(R.id.etLastNamePr);
        etPhoneOwPr = findViewById(R.id.etPhoneOwPr);
        etPhoneClPr = findViewById(R.id.etPhoneClPr);
        radioPersonPrCl = findViewById(R.id.radioPersonPrCl);
        radioPetPrCl = findViewById(R.id.radioPetPrCl);
        radioItemPrCl = findViewById(R.id.radioItemPrCl);
        SavebtnPr = findViewById(R.id.SavebtnPr);
        radioOwner = findViewById(R.id.radioOwner);
        radioClient = findViewById(R.id.radioClient);
        radioGroupCO=findViewById(R.id.radioGroupCO);
        radioGroupPPI=findViewById(R.id.radioGroupPPI);

        radioOwner.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    etFirstNamePr.setVisibility(View.VISIBLE);
                    etLastNamePr.setVisibility(View.VISIBLE);
                    etPhoneOwPr.setVisibility(View.VISIBLE);
                    SavebtnPr.setVisibility(View.VISIBLE);
                    etPhoneClPr.setVisibility(View.GONE);
                    radioGroupPPI.setVisibility(View.GONE);

                }
                if (b==false)
                {
                    etFirstNamePr.setVisibility(View.VISIBLE);
                    etLastNamePr.setVisibility(View.GONE);
                    etPhoneOwPr.setVisibility(View.VISIBLE);
                    SavebtnPr.setVisibility(View.VISIBLE);
                    etPhoneClPr.setVisibility(View.VISIBLE);
                    radioGroupPPI.setVisibility(View.VISIBLE);
                }
            }
        });
        SavebtnPr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();
            }
        });





    }
    private void validateForm ()
    {
        String type = "";
        String fN = etFirstNamePr.getText().toString();
        String lN = etLastNamePr.getText().toString();
        String phOw=etPhoneOwPr.getText().toString();
        String phCl=etPhoneClPr.getText().toString();

        if (radioOwner.isChecked())
        {
            boolean isOK = true;
            if (fN.length() < 2 || lN.length() < 2)
                isOK = false;
            if (phOw.length()<10)
                isOK=false;
            if (isOK==true)
            {
                MyOwner owner = new MyOwner(phOw, fN, lN);
                saveOwner(owner);
            }

        }
        if (radioClient.isChecked())
        {
            boolean isOK=true;
            if (radioItemPrCl.isSelected())
                type="Item";
            if (radioPersonPrCl.isSelected())
                type="Person";
            if (radioPetPrCl.isSelected())
                type="Pet";
            if (fN.length() < 2)
                isOK=false;
            if (phOw.length()<10 || phCl.length()<10)
                isOK=false;
            if (isOK==true)
            {
                MyClient client=new MyClient(fN,phCl,phOw,type);
                saveClient(client);
            }
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
        String key = reference.child("AllOwners").push().getKey();
        //5. Update Your Object
        myOwner.setKeyOw(uid);
        myOwner.setOwnerOw(key);
        //6. Actual Stroring
        reference.child("AllOwners").child(key).setValue(myOwner).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Intent i = new Intent(ProfileActivity.this, MainMapsActivity.class);
                    startActivity(i);
                    Toast.makeText(ProfileActivity.this,"add Successful",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(ProfileActivity.this,"add Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }
    private void saveClient(MyClient myClient) {
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
        myClient.setOwnerCl(uid);
        myClient.setKeyCl(key);
        //6. Actual Stroring
        reference.child("AllClients").child(key).setValue(myClient).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Intent i = new Intent(ProfileActivity.this, MainMapsActivity.class);
                    startActivity(i);
                    Toast.makeText(ProfileActivity.this,"add Successful",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(ProfileActivity.this,"add Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }
}
