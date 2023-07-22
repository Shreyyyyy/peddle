package com.example.phase_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.phase_1.databinding.ActivityMainBinding;
import com.example.phase_1.databinding.ActivityRegistrationBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Registration extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    ActivityRegistrationBinding binding;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = firebaseAuth.getInstance();
        firebaseFirestore = firebaseFirestore.getInstance();
        progressDialog = new ProgressDialog(this);


        binding.signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String firstn = binding.firstName.getText().toString();
                String lastn = binding.lastName.getText().toString();
                String phonen = binding.phoneNum.getText().toString();
                String usern = binding.username1.getText().toString();
                String passw = binding.password.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                String passwordVal = "^" +
                        //"(?=.*[0-9])" +         //at least 1 digit
                        //"(?=.*[a-z])" +         //at least 1 lower case letter
                        //"(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z])" +      //any letter
                        "(?=.*[@#$%^&+=])" +    //at least 1 special character
                        "(?=\\S+$)" +           //no white spaces
                        ".{4,}" +               //at least 4 characters
                        "$";
                String val1 = binding.firstName.getText().toString();
                String val2 = binding.lastName.getText().toString();
                String val3 = binding.phoneNum.getText().toString();
                String val4 = binding.username1.getText().toString();
                String val5 = binding.password.getText().toString();

                if (val4.isEmpty()) {
                    binding.username1.setError("Field cannot be empty");
                } else if (!val4.matches(emailPattern)) {
                    binding.username1.setError("Invalid email address");
                }

                if (val5.isEmpty()) {
                    binding.password.setError("Field cannot be empty");
                } else if (!val5.matches(passwordVal)) {
                    binding.password.setError("Password is too weak");
                }

                if (val1.isEmpty() || val2.isEmpty() || val3.isEmpty() || val5.isEmpty()) {
                    binding.firstName.setError("Field cannot be empty");
                    binding.lastName.setError("Field cannot be empty");
                    binding.phoneNum.setError("Field cannot be empty");
                    binding.password.setError("Field cannot be empty");
                } else {


                    progressDialog.show();
                    firebaseAuth.createUserWithEmailAndPassword(usern, passw)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    startActivity(new Intent(Registration.this, phase_3.class));
                                    progressDialog.cancel();
                                    firebaseFirestore.collection("User")
                                            .document(FirebaseAuth.getInstance().getUid())
                                            .set(new UserModel(firstn, lastn, phonen, usern));

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Toast.makeText(Registration.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    progressDialog.cancel();
                                }
                            });
                }
            }
        });

        binding.gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, phase_4.class));
            }
        });

        binding.showPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                    binding.showPassBtn.setImageResource(R.drawable.hiddeneye);

                    //Show Password
                    binding.password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    binding.showPassBtn.setImageResource(R.drawable.eye);
                    //Hide Password
                    binding.password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
    public void home(View view){
        Intent intent = new Intent(Registration.this , MainActivity.class);
        startActivity(intent);
    }

    public void back(View view){
        Intent intent = new Intent(Registration.this , phase_2.class);
        startActivity(intent);
    }
}


