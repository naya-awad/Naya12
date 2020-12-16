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

public class AddItemActivity extends AppCompatActivity {

    private TextView txtADD;
    private EditText etNameItem,etCodeGPS;
    private RadioButton radioPerson,radioPet,radioItem;
    private Button btnSaveItem,btnChooseImage;
    private ImageView imgWood;

    private static final int IMAGE_PICK_CODE=1000;
    private static final int PERMISSION_CODE=1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        txtADD=findViewById(R.id.txtADD);
        etNameItem=findViewById(R.id.etNameItem);
        etCodeGPS=findViewById(R.id.etCodeGPS);
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

}