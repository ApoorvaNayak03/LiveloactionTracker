package com.example.livelocationtracker;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.BreakIterator;

public class driver_location extends AppCompatActivity {

    EditText url;
    RadioGroup rg;
    Button b;
    private DatabaseReference mDatabase;
    private Object view;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_location);
        rg = findViewById(R.id.radio);
        url = findViewById(R.id.locurl);
        b = findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            private String busNumber;

            @Override
            public void onClick(View view) {
                String busNumber = "";
                int i = rg.getCheckedRadioButtonId();
                if (i == R.id.b1)
                    busNumber = "mng01";
                else if (i == R.id.b2)
                    busNumber = "mng04";
                else
                    busNumber = "udp01";
                String locationLink = url.getText().toString().trim();

                if (busNumber.isEmpty() || locationLink.isEmpty()) {
                    Toast.makeText(driver_location.this, "Please enter both the bus number and URL", Toast.LENGTH_SHORT).show();
                }
                mDatabase = FirebaseDatabase.getInstance().getReference();
            }
            public void sendData(View view) {
                writeNewUser();
            }


            public void writeNewUser() {

                User user = new User(busNumber);

                mDatabase.child("user").child(user.getUserId()).setValue(user);
            }

    });
    }
}









/*package com.example.livelocationtracker;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class driver_location extends AppCompatActivity {

    EditText url;
    RadioGroup rg;
    Button b;

    DatabaseReference databaseReference;
    //ActivityDriverLocationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // binding = ActivityDriverLocationBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_driver_location);
        rg=findViewById(R.id.radio);
        url = findViewById(R.id.locurl);
        b = findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String busNumber="";
                int i=rg.getCheckedRadioButtonId();
                if(i==R.id.b1)
                    busNumber="mng01";
                else if(i==R.id.b2)
                    busNumber="mng04";
                else
                    busNumber="udp01";
                String locationLink = url.getText().toString().trim();

                if (busNumber.isEmpty() || locationLink.isEmpty()) {
                    Toast.makeText(driver_location.this, "Please enter both the bus number and URL", Toast.LENGTH_SHORT).show();
                } else {
//                    DriverLocationData user=new DriverLocationData(busNumber,locationLink);
//                    reference=FirebaseDatabase.getInstance().getReference().child("Admin");
//                    reference.child(busNumber).setValue(locationLink);
                    updateData(busNumber,locationLink);

                }

            }
        });
    }

  /*  private void updateData(String busNumber, String locationLink) {
        Toast.makeText(this, "Inside method", Toast.LENGTH_SHORT).show();
        HashMap User=new HashMap();
        //User.put("busNumber",busNumber);
        User.put("locationLink",locationLink);
        databaseReference=FirebaseDatabase.getInstance().getReference("Admin");
        databaseReference.child(busNumber).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isSuccessful()){
                    url.setText("");
                    Toast.makeText(driver_location.this, "Success", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(driver_location.this, "Update failed", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
/*
  private void updateData(String busNumber, String locationLink) {
      Log.d("TAG", "Inside updateData method");

      HashMap<String, Object> user = new HashMap<>();
      user.put("link", locationLink); // The key should be "link" to match the database structure

      databaseReference = FirebaseDatabase.getInstance().getReference("Admin");
      databaseReference.child(busNumber).updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
          @Override
          public void onComplete(@NonNull Task<Void> task) {
              if (task.isSuccessful()) {
                  Log.d("TAG", "Update successful");
                  runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          url.setText("");
                          Toast.makeText(driver_location.this, "Update Successful", Toast.LENGTH_SHORT).show();
                      }
                  });
              } else {
                  Log.d("TAG", "Update failed: " + task.getException());
                  runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          Toast.makeText(driver_location.this, "Update Failed", Toast.LENGTH_SHORT).show();
                      }
                  });
              }
          }
      });
  }

}



package com.example.livelocationtracker;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class driver_location extends AppCompatActivity {

    EditText url;
    RadioGroup rg;
    Button b;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_location);

        rg = findViewById(R.id.radio);
        url = findViewById(R.id.locurl);
        b = findViewById(R.id.b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String busNumber = "";
                int i = rg.getCheckedRadioButtonId();
                if (i == R.id.b1)
                    busNumber = "mng01";
                else if (i == R.id.b2)
                    busNumber = "mng04";
                else
                    busNumber = "udp01";

                String locationLink = url.getText().toString().trim();

                if (busNumber.isEmpty() || locationLink.isEmpty()) {
                    Toast.makeText(driver_location.this, "Please enter both the bus number and URL", Toast.LENGTH_SHORT).show();
                } else {
                    updateData(busNumber, locationLink);
                }
            }
        });
    }

    private void updateData(String busNumber, String locationLink) {
        Log.d("TAG", "Inside updateData method");

        HashMap<String, Object> user = new HashMap<>();
        user.put("link", locationLink); // The key should be "link" to match the database structure

        databaseReference = FirebaseDatabase.getInstance().getReference("Admin");
        databaseReference.child(busNumber).updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d("TAG", "Update successful");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            url.setText("");
                            Toast.makeText(driver_location.this, "Update Successful", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Log.d("TAG", "Update failed: " + task.getException());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(driver_location.this, "Update Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
/*


 */