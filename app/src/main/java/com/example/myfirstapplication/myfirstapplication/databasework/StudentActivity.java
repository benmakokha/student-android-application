package com.example.myfirstapplication.myfirstapplication.databasework;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class StudentActivity extends AppCompatActivity {
    EditText name, contact, dob;
    EditText contact1, balance;
    Button insert, update, delete, view;
    DBHelper1 DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);
        contact1 = findViewById(R.id.contacting);
        balance = findViewById(R.id.balance);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper1(this);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();
                String balanceTXT = balance.getText().toString();
                String contactsTXT = contact1.getText().toString();


                Boolean checkinsertdata = DB.insertuserdata(nameTXT, contactTXT, dobTXT, contactsTXT, balanceTXT /*, contactsTXT , feesBalanceTXT, contact1TXT */);
                    if(checkinsertdata==true)
                Toast.makeText(StudentActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                   else
                Toast.makeText(StudentActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });
         update.setOnClickListener(new View.OnClickListener() {

        @Override
         public void onClick(View view) {
            String nameTXT = name.getText().toString();
            String contactTXT = contact.getText().toString();
            String dobTXT = dob.getText().toString();
            String balanceTXT = balance.getText().toString();
            String contactsTXT = contact1.getText().toString();

        Boolean checkupdatedata = DB.updateuserdata(nameTXT, contactTXT, dobTXT, contactsTXT , balanceTXT /*, contactsTXT , feesBalanceTXT, contact1TXT */);
        if(checkupdatedata==true) {
            Toast.makeText(StudentActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(StudentActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
    }        });
        delete.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        String nameTXT = name.getText().toString();
        Boolean checkudeletedata = DB.deletedata(nameTXT);
    if(checkudeletedata==true) {
        Toast.makeText(StudentActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
    } else
        Toast.makeText(StudentActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
        }        });



        view.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {

        Cursor res = DB.getdata();

        if(res.getCount()==0){
        Toast.makeText(StudentActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
        return;
        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
        buffer.append("REGISTRATION NO :"+res.getString(0)+"\n");
        buffer.append("CONTACT :"+res.getString(3)+"\n");
        buffer.append("FEES BALANCE :"+res.getString(4)+"\n\n");

        }

        Intent intent = new Intent(getApplicationContext(), SummaryActivity.class);

        intent.putExtra("buffer", buffer.toString());

        startActivity(intent);


        }        });




        }}

