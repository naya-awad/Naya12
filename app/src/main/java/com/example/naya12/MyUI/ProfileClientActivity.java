package com.example.naya12.MyUI;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.naya12.R;
import com.example.naya12.data.MyClient;
import com.example.naya12.data.MyOwner;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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


        SavebtnPrCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();
            }
        });




    }
    private void validateForm ()
    {
        String type = "";
        String name = etNamePrCl.getText().toString();
        String emaile = etEmailPrCl.getText().toString();
        String phOw = etPhoneOwPr.getText().toString();
        String phCl = etPhoneClPrCl.getText().toString();

        if ( radioItemPrCl.isSelected())
            type="Item";
        if (radioPersonPrCl.isSelected())
            type="Person";
        if (radioPetPrCl.isSelected())
            type="Pet";


        boolean isOK = true;

        if (name.length() < 2)
            isOK = false;
        if (phOw.length() < 10 || phCl.length() < 10)
            isOK = false;
        if (isOK == true) {
            String email = getIntent().getStringExtra("Email");

            MyClient client = new MyClient(name,phCl,phOw,emaile,type);

            saveClient(client);
        }





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
        myClient.setKeyCl(uid);
        myClient.setOwnerCl(key);
        //6. Actual Stroring
        reference.child("AllClients").child(key).setValue(myClient).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ProfileClientActivity.this,"add Successful",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(ProfileClientActivity.this,"add Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }

}
