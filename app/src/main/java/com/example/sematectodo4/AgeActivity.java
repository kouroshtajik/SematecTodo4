package com.example.sematectodo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        TextView txtAge = findViewById(R.id.txtAge);
        TextView txtName = findViewById(R.id.txtName);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnBack = findViewById(R.id.btnBack);


        Intent intent = getIntent();
        String age = intent.getStringExtra("age");
        txtAge.setText(age);
        String name = intent.getStringExtra("name");
        txtName.setText(name);
        //Toast.makeText(AgeActivity.this, age, Toast.LENGTH_SHORT).show();


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSharedPreferences("userInfo", Context.MODE_PRIVATE).edit().putString("name", name).apply();
                getSharedPreferences("userInfo", Context.MODE_PRIVATE).edit().putString("age", age).apply();
                if (name.isEmpty() || age.isEmpty()) {
                    Toast.makeText(AgeActivity.this, "Items Are EMPTY", Toast.LENGTH_LONG).show();
                }else Toast.makeText(AgeActivity.this, "Items Saved", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent();
                finish();


            }
        });


    }
}