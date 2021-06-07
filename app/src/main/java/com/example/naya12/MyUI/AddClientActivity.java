package com.example.naya12.MyUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.naya12.R;
import com.example.naya12.data.MyClient;
import com.example.naya12.data.MyItem;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddClientActivity extends AppCompatActivity {

    private TextView txtADD;
    private EditText etNameItem,phoneC;
    public RadioButton radioPerson,radioPet,radioItem;
    private Button btnSaveItem,btnChooseImage;
    private ImageView imgWood;

    private static final int IMAGE_PICK_CODE=1000;
    private static final int PERMISSION_CODE=1001;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        txtADD=findViewById(R.id.txtADD);
        etNameItem=findViewById(R.id.etNameItem);
        phoneC=findViewById(R.id.phoneC);
        radioPerson=findViewById(R.id.radioPerson);
        radioPet=findViewById(R.id.radioPet);
        radioItem=findViewById(R.id.radioItem);
        btnSaveItem=findViewById(R.id.btnSaveItem);
        btnChooseImage=findViewById(R.id.btnChooseImage);
        imgWood=findViewById(R.id.imgWood);
        imgWood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check runtime permission
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        //permission not granted, request it.
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        //show popup for runtime permission
                        requestPermissions(permissions, PERMISSION_CODE);
                    }
                    else{
                        //permission already granted
                        pickImageFromGallery();
                    }

                }
            }
        });
        btnSaveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();
            }
        });
    }


    private void pickImageFromGallery(){
        //intent to pick image
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,IMAGE_PICK_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        switch (requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    //permission was granted
                    pickImageFromGallery();
                }
                else {
                    //permission was denied
                    Toast.makeText(this,"Permission denied...!",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    //handle result of picked image
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode==RESULT_OK && requestCode== IMAGE_PICK_CODE){
            //set image to image view
            imgWood.setImageURI(data.getData());
        }
    }
    private void validateForm()
    {
        String type="";
        String name=etNameItem.getText().toString();
        String codeGPS=phoneC.getText().toString();

        boolean isOK=true;
        if(name.length()<2)
            isOK=false;
        if (phoneC.length()<10)
            isOK=false;
        if(isOK==true)
        {
            MyClient client = new MyClient();
            MyItem item = new MyItem();

            if (radioItem.isSelected())
                item.setTypeItem("Item");
            if (radioPerson.isSelected())
                item.setTypeItem("Person");
            if (radioPet.isSelected())
                item.setTypeItem("Pet");


            saveClient(client);
        }



    }

    private void saveClient(MyClient client) {
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
        client.setNameClient(uid);
        client.setPhoneClient(key);
        //6. Actual Stroring
        reference.child("AllTasks").child(uid).child(key).setValue(client).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(AddClientActivity.this,"add Successful",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(AddClientActivity.this,"add Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }

}