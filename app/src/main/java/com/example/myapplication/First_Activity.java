package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class First_Activity extends AppCompatActivity {
    Button btn1, btn2, btn3;
    TextView tv1, tv2;
    private int str;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_example);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);

        tv1=findViewById(R.id.tv_text1);
        tv2=findViewById(R.id.tv_text2);

        tv1.setText("This is textview example");
        tv2.setText(R.string.app_name);
        String txtStr = getString(R.string.app_name);
        String tvStr = btn1.getText().toString();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(First_Activity.this,SecondActivity.class));

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                       Intent intent = new Intent(First_Activity.this,SecondActivity.class);
                        intent.putExtra("DATA","this is new activity");
                        intent.putExtra("INTEGER_VALUE",1);
                        startActivity(intent);


    }
});
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(First_Activity.this,SecondActivity.class);
                intent.putExtra("DATA","this is new activity for result");
                intent.putExtra("INTEGER_VALUE",400);
                startActivityForResult(intent,30);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data){
        if(resultCode== Activity.RESULT_OK){
            if (requestCode == 30){
                if(data != null){
                    if(data.hasExtra("RESULT")){
                        String str= data.getStringExtra("RESULT");
                        tv1.setText(str);
                    }
                }

            }

        }
        /*else if (resultCode==Activity.RESULT_CANCELED) {
            super.onActivityResult(requestCode, resultCode, data);
        }
         */
        super.onActivityResult(requestCode, resultCode,data);
    }
}