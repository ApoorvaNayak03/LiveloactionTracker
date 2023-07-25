package com.example.livelocationtracker;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class studentpage extends AppCompatActivity {
    DatabaseReference reference;
    Button b1,b2,b3;
    DatabaseReference reference1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_page);
        b1=findViewById(R.id.bus1);
        b2=findViewById(R.id.bus2);
        b3=findViewById(R.id.bus3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readData("mng01");

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readData("mng04");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readData("udp01");
            }
        });

    }

   /* private void readData(String mng) {
        reference1= FirebaseDatabase.getInstance().getReference("Admin");
        reference1.child(mng).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    DataSnapshot dataSnapshot = task.getResult();
                    if (dataSnapshot.exists()) {
                        Toast.makeText(studentpage.this, "Success!", Toast.LENGTH_SHORT).show();
                        String link = String.valueOf(dataSnapshot.child("mng01").getValue());
                        Toast.makeText(studentpage.this, link, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(studentpage.this, "Data not found.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(studentpage.this, "Data Retrieval failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }*/
   private void readData(String mng) {
       DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference("Admin").child(mng);
       reference1.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               if (dataSnapshot.exists()) {
                   Toast.makeText(studentpage.this, "Success!", Toast.LENGTH_SHORT).show();
                   String link = dataSnapshot.child("link").getValue(String.class);
                   Toast.makeText(studentpage.this, link, Toast.LENGTH_SHORT).show();
               } else {
                   Toast.makeText(studentpage.this, "Data not found.", Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {
               Toast.makeText(studentpage.this, "Data Retrieval failed", Toast.LENGTH_SHORT).show();
           }
       });
   }

}