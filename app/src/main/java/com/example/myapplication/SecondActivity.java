package com.example.myapplication;

import static com.example.myapplication.R.*;

import androidx.annotation.Nullable;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class SecondActivity extends AppCompatActivity {
    TextView tv1,tv2;
    Button btnBack;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.relative_example);
        tv1 = findViewById(id.tv_text1);
        tv2 = findViewById(id.tv_text2);
        btnBack = findViewById(id.btn_back);

        if (getIntent().hasExtra("DATA")){
            tv1.setText(getIntent().getStringExtra("DATA"));
        }
        if(getIntent().hasExtra("INTEGER_VALUE")){
            int val = getIntent().getIntExtra("INTEGER_VALUE",0);
            tv2.setText(String.valueOf(val));
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("RESULT","SUCCESS");
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}