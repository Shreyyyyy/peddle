package com.example.phase_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.phase_1.databinding.ActivityMainBinding;
import com.example.phase_1.databinding.ActivityPhase4Binding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class phase_4 extends AppCompatActivity {

    ActivityPhase4Binding binding;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityPhase4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String val1 = binding.username.getText().toString();
                String val2 = binding.password.getText().toString();
                String username = binding.username.getText().toString().trim();
                String pass = binding.password.getText().toString().trim();

                if (val1.isEmpty() || val2.isEmpty()) {
                    binding.username.setError("Field cannot be empty");
                    binding.password.setError("Field cannot be empty");
                }else{

                firebaseAuth.signInWithEmailAndPassword(username,pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                progressDialog.cancel();
                                Toast.makeText(phase_4.this, "Login Succesfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(phase_4.this,TypeS.class));
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.cancel();
                                Toast.makeText(phase_4.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }}
        });


        binding.btForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.username.getText().toString();
                progressDialog.setTitle("Sending Email");
                progressDialog.show();

                firebaseAuth.sendPasswordResetEmail(email)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                progressDialog.cancel();
                                Toast.makeText(phase_4.this, "Email Sent", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.cancel();
                                Toast.makeText(phase_4.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(phase_4.this,Registration.class));
            }
        });

        binding.showPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    binding.showPassBtn.setImageResource(R.drawable.hiddeneye);

                    //Show Password
                    binding.password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    binding.showPassBtn.setImageResource(R.drawable.eye);

                    //Hide Password
                    binding.password.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }
            }
        });

    }
    public void home(View view){
        Intent intent = new Intent(phase_4.this , MainActivity.class);
        startActivity(intent);
    }

    public void back(View view){
        Intent intent = new Intent(phase_4.this , phase_3.class);
        startActivity(intent);
    }

}