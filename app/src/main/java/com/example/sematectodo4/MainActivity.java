package com.example.sematectodo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle", "onCreate");


        Button btnSave = findViewById(R.id.btnSave);
        EditText edtAge = findViewById(R.id.edtAge);
        EditText edtName = findViewById(R.id.edtName);
        TextView txtAgeRes = findViewById(R.id.txtAgeRes);
        TextView txtNameRes = findViewById(R.id.txtNameRes);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String age = edtAge.getText().toString();
                String name = edtName.getText().toString();
                Intent intent = new Intent(MainActivity.this, AgeActivity.class);
                intent.putExtra("age", age);
                intent.putExtra("name", name);
                startActivityForResult(intent, 256);
            }
        });

        String ageRes = "Age is " + getSharedPreferences("userInfo", Context.MODE_PRIVATE).getString("age", "No Age Available");
        txtAgeRes.setText(ageRes);

        String nameRes = "Name is " + getSharedPreferences("userInfo", Context.MODE_PRIVATE).getString("name", "No Age Available");
        txtNameRes.setText(nameRes);
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView txtAgeRes = findViewById(R.id.txtAgeRes);
        TextView txtNameRes = findViewById(R.id.txtNameRes);

        String ageRes = "Age is " + getSharedPreferences("userInfo", Context.MODE_PRIVATE).getString("age", "Not Available");
        txtAgeRes.setText(ageRes);

        String nameRes = "Name is " + getSharedPreferences("userInfo", Context.MODE_PRIVATE).getString("name", "Not Available");
        txtNameRes.setText(nameRes);

        Log.d("lifecycle", "onStart");
    }


}