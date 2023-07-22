package com.example.phase_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class phase_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase2);
    }

    public void login(View view){
        Intent intent = new Intent(phase_2.this , phase_3.class);
        startActivity(intent);

    }

    public void register(View view){
        Intent intent = new Intent(phase_2.this , Registration.class);
        startActivity(intent);
    }

    public void home(View view){
        Intent intent = new Intent(phase_2.this , MainActivity.class);
        startActivity(intent);
    }

    public void back(View view){
        Intent intent = new Intent(phase_2.this , MainActivity.class);
        startActivity(intent);
    }


}