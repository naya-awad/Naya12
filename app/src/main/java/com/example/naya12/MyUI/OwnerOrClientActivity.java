package com.example.naya12.MyUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.naya12.ClientActivity;
import com.example.naya12.R;
import com.google.firebase.auth.FirebaseAuth;

public class OwnerOrClientActivity extends AppCompatActivity
{
    private Button ownerGo,clientGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_or_client);
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null)
        {
            Intent i = new Intent(getApplicationContext(), MainMapsActivity.class);
            startActivity(i);
        }

        ownerGo=findViewById(R.id.ownerGo);
        clientGo=findViewById(R.id.clientGo);

        ownerGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OwnerOrClientActivity.this, SignInActivity.class);
                startActivity(i);

            }
        });
        clientGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OwnerOrClientActivity.this, ClientActivity.class);
                startActivity(i);

            }
        });

    }
}