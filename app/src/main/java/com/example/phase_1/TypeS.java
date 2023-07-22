package com.example.phase_1;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TypeS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_s);

        ImageButton btnAdd1 = (ImageButton)findViewById(R.id.old_cycle);
        ImageButton btnAdd2 = (ImageButton)findViewById(R.id.modern_cycle);
        ImageButton btnAdd3 = (ImageButton)findViewById(R.id.stunt_cycle);
        ImageButton btnAdd4 = (ImageButton)findViewById(R.id.thick_cycle);


        btnAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent turn = new Intent(TypeS.this, old_cycle.class);
                startActivity(turn);

            }
        });

        btnAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent turn = new Intent(TypeS.this, modern_cycle.class);
                startActivity(turn);

            }
        });

        btnAdd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent turn = new Intent(TypeS.this, stunt_cycle.class);
                startActivity(turn);

            }
        });

        btnAdd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent turn = new Intent(TypeS.this, thick_cycle.class);
                startActivity(turn);

            }
        });

    }

    public void home(View view){
        Intent intent = new Intent(TypeS.this , MainActivity.class);
        startActivity(intent);
    }
}