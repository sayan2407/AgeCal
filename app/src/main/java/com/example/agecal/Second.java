package com.example.agecal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;




public class Second extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    EditText dob,tday;
    int year,year1,month,month1,day,day1,flag, y1,y2,y,m1,m2,m,d1,d2,d;
    Button result,reset;
    TextView age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        dob=findViewById(R.id.dob1);
        tday=findViewById(R.id.tday1);
        result=findViewById(R.id.cal);
        reset=findViewById(R.id.res);
        age=findViewById(R.id.age);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dobshow();
            }
        });
        tday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dobshow1();
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yourage();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(getApplicationContext(),Second.class));
             finish();
            }
        });

    }
    public void dobshow()
    {
        flag=0;
        Calendar calendar=Calendar.getInstance();
         year=calendar.get(Calendar.YEAR);

         month=calendar.get((Calendar.MONTH));

         day=calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog=new DatePickerDialog(this,this,year,month,day);
        datePickerDialog.show();
    }
    public void dobshow1()
    {
        flag=1;
        Calendar calendar=Calendar.getInstance();
        year1=calendar.get(Calendar.YEAR);

        month1=calendar.get(Calendar.MONTH);

        day1=calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this,this,year1,month1,day1);
        datePickerDialog.show();
    }
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


        month=month+1;

        switch (flag) {

            case 0:
                y1=year;
                m1=month;
                d1=dayOfMonth;
                String date=dayOfMonth+"/"+month+"/"+year ;
                dob.setText(date);
                break;
            case 1:
                y2=year;
                m2=month;
                d2=dayOfMonth;
                String date1=dayOfMonth+"/"+month+"/"+year ;
                tday.setText(date1);
                break;
        }



    }

    public void yourage()
    {

        if(d2>=d1){
            d=d2-d1;
        }
        else{

            switch (m2){
                case 1:
                    d2+=31;
                    d=d2-d1;
                    break;
                case 2:
                    d2+=28;
                    d=d2-d1;
                    break;
                case 3:
                    d2+=31;
                    d=d2-d1;
                    break;
                case 4:
                    d2+=30;
                    d=d2-d1;
                    break;
                case 5:
                    d2+=31;
                    d=d2-d1;
                    break;
                case 6:
                    d2+=30;
                    d=d2-d1;
                    break;
                case 7:
                    d2+=31;
                    d=d2-d1;
                    break;
                case 8:
                    d2+=31;
                    d=d2-d1;
                    break;
                case 9:
                    d2+=30;
                    d=d2-d1;
                    break;
                case 10:
                    d2+=31;
                    d=d2-d1;
                    break;
                case 11:
                    d2+=30;
                    d=d2-d1;
                    break;
                case 12:
                    d2+=31;
                    d=d2-d1;
                    break;
            }
            m2-=1;
        }
        if(m2>=m1){
            m=m2-m1;
        }
        else{
            y2-=1;
            m2+=12;
            m=m2-m1;
        }
        y=y2-y1;
        String a=Integer.toString(y);
        String b=Integer.toString(m);
        String c=Integer.toString(d);

       age.setText("Your age is "+a+" years "+b+" months "+c+" days");




    }













}
