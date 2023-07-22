package com.example.phase_1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void welcome(View view) {
        Intent intent = new Intent(MainActivity.this , phase_2.class);
        startActivity(intent);
    }

    public void info(View view) {
        Intent intent = new Intent(MainActivity.this , your_detail.class);
        startActivity(intent);
    }

    public void order(View view) {
        Intent intent = new Intent(MainActivity.this , your_order.class);
        startActivity(intent);
    }

    public void scan(View view){
        startActivity(new Intent(MainActivity.this, scanner_page.class));
    }

}