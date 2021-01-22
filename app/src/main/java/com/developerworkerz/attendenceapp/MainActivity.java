package com.developerworkerz.attendenceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    TextView officeTimeText,breakTimeText,nextHoliday;
    CardView checkinBtn,checkoutBtn,attendenceBtn,leaveBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        officeTimeText=(TextView)findViewById(R.id.officeTime);

        String ots = getColoredSpanned("OfficeTime : ", "#FFFFFFFF");
        String tm1s = getColoredSpanned("10AM to 4PM","#FFC107");
        officeTimeText.setText(Html.fromHtml(ots+" "+tm1s));

        breakTimeText=(TextView)findViewById(R.id.breakTime);

        String bts = getColoredSpanned("Break Time : ", "#FFFFFFFF");
        String tm2s = getColoredSpanned("1PM to 2PM","#FFC107");
        breakTimeText.setText(Html.fromHtml(bts+" "+tm2s));

        nextHoliday=(TextView)findViewById(R.id.nextHoliday);




        checkinBtn= (CardView)findViewById(R.id.checkinBtn);
        checkoutBtn= (CardView)findViewById(R.id.checkoutBtn);
        attendenceBtn= (CardView)findViewById(R.id.attendenceBtn);
        leaveBtn= (CardView)findViewById(R.id.leaveBtn);

        checkinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Check In Clicked",Toast.LENGTH_SHORT).show();

            }
        });

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Check Out Clicked",Toast.LENGTH_SHORT).show();

            }
        });

        attendenceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,AttendenceView.class);
                startActivity(i);

            }
        });
        leaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,LeaveEmployee.class);
                startActivity(i);

            }
        });



    }
    private String getColoredSpanned(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }
}