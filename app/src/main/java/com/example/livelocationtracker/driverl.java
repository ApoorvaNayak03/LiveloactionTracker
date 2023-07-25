package com.example.livelocationtracker;

/*package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class driverl extends AppCompatActivity {

    Button b1;
    EditText ph, pass;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_driverlogin);
        b1 = findViewById(R.id.button);
        ph = findViewById(R.id.phone);
        pass = findViewById(R.id.password);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Phone;
                String Password;

                Phone = ph.getText().toString();
                Password = pass.getText().toString();
                Intent next = getIntent();
                if (TextUtils.isEmpty(Phone)) {
                    Toast.makeText(driverl.this, "Enter the email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Password)) {
                    Toast.makeText(driverl.this, "Enter the password", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });
    }
}
*/
//chatgpt code


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class driverl extends AppCompatActivity {

    Button b1;
    EditText em, pass;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);
        b1 = findViewById(R.id.button);
        em = findViewById(R.id.mail);
        pass = findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance(); // Initialize Firebase Authentication instance

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email;
                String Password;
                Intent intent = new Intent(driverl.this, driver_location.class);
                startActivity(intent);
                email = em.getText().toString();
                Password = pass.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(driverl.this, "Enter the email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Password)) {
                    Toast.makeText(driverl.this, "Enter the password", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Use Firebase Authentication to attempt login
                mAuth.signInWithEmailAndPassword(email, Password)
                        .addOnCompleteListener(driverl.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Login successful
                                    Toast.makeText(driverl.this, "Login Successful", Toast.LENGTH_SHORT).show();

                                    // Start the driverlocation activity

                                    // Intent intent = new Intent(driverl.this, driverlocation.class);
                                    //startActivity(intent);
                                    // Finish the current activity (optional)
                                    finish();
                                } else {
                                    // Login failed
                                    Toast.makeText(driverl.this, "Login Failed. Please check your credentials.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
