package com.example.phase_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class type_1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type1);
    }

    public void paytm(View view){
        Intent hehe1 = new Intent(type_1.this , payment_webview.class);
        startActivity(hehe1);
    }

    public void gpay(View view){
        Intent hehe2 = new Intent(type_1.this , gpay_webview.class);
        startActivity(hehe2);
    }

    public void phone_pay(View view){
        Intent hehe3 = new Intent(type_1.this , phonepay_webview.class);
        startActivity(hehe3);
    }

    public void home(View view){
        Intent intent = new Intent(type_1.this , MainActivity.class);
        startActivity(intent);
    }


    public void back(View view){
        Intent intent = new Intent(type_1.this , TypeS.class);
        startActivity(intent);
    }

}