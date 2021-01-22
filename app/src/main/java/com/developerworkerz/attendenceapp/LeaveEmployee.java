package com.developerworkerz.attendenceapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LeaveEmployee extends AppCompatActivity {

    protected static final int REQUEST_CAMERA = 111;
    Spinner leaveType;
    TextView reasonText;
    ImageView imageView;
    Button capture, submit;

    public  static final int RequestPermissionCode  = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leave_employee);
        getSupportActionBar().hide();


        leaveType = findViewById(R.id.leaveType);

        leaveType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // do something upon option selection
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }
        });
        ArrayAdapter s1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.leave_type));
        s1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        leaveType.setAdapter(s1);

        reasonText = (TextView) findViewById(R.id.reasontext);

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Submit Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        capture = (Button) findViewById(R.id.capture);
        imageView = (ImageView) findViewById(R.id.imageView);

        EnableRuntimePermission();

        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 7);

            }
        });
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 7 && resultCode == RESULT_OK) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            imageView.setImageBitmap(bitmap);
        }
    }

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(LeaveEmployee.this,
                Manifest.permission.CAMERA))
        {

            Toast.makeText(LeaveEmployee.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(LeaveEmployee.this,new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);

        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(LeaveEmployee.this,"Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(LeaveEmployee.this,"Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }

}




