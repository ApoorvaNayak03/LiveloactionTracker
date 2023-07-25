package com.example.livelocationtracker;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Select extends AppCompatActivity {
    Button dr,st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        dr=findViewById(R.id.Driver);
        st=findViewById(R.id.Student);

        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next=new Intent(Select.this, MainActivity.class);
                startActivity(next);
                finish();

            }
        });
        dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next=new Intent(Select.this, driverl.class);
                startActivity(next);
                finish();
            }
        });

    }
}
