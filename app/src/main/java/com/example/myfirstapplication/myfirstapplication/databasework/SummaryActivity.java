package com.example.myfirstapplication.myfirstapplication.databasework;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SummaryActivity extends AppCompatActivity {

    String buffer;
    Button view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        view = findViewById(R.id.btnView);





        Intent intent = getIntent();

        buffer = intent.getStringExtra("buffer");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SummaryActivity.this);
                builder.setCancelable(true);
                builder.setTitle("SUMMARY");
                builder.setMessage(buffer);
                builder.show();

            }        });


    }
}