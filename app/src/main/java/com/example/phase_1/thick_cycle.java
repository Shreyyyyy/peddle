package com.example.phase_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class thick_cycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thick_cycle);


        Button b1 = (Button)findViewById(R.id.rent);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent turn = new Intent(thick_cycle.this, type_1.class);
                startActivity(turn);

            }
        });
    }
    public void home(View view){
        Intent intent = new Intent(thick_cycle.this , MainActivity.class);
        startActivity(intent);
    }

    public void back(View view){
        Intent intent = new Intent(thick_cycle.this , TypeS.class);
        startActivity(intent);
    }
}