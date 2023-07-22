package com.example.phase_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class phase_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase3);

        Button b1 = (Button) findViewById(R.id.student);
        Button b2 = (Button) findViewById(R.id.faculty);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(phase_3.this , phase_4.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(phase_3.this , phase_4.class);
                startActivity(intent);
            }
        });
    }

    public void home(View view){
        Intent intent = new Intent(phase_3.this , MainActivity.class);
        startActivity(intent);
    }

    public void back(View view){
        Intent intent = new Intent(phase_3.this , phase_2.class);
        startActivity(intent);
    }

}