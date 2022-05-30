package com.ashish.firebasepracto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editTextname;
    EditText  editTextsurname;
    FloatingActionButton floatingActionButton;
    Button button;


    private  FirebaseDatabase db =FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("ashish");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextname = findViewById(R.id.textViewname);
        editTextsurname = findViewById(R.id.textViewmessage);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        button = findViewById(R.id.button1);



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = editTextname.getText().toString();
                String surname = editTextsurname.getText().toString();

                HashMap<String, String> userMap = new HashMap<>();
                userMap.put("name", name);
                userMap.put("surname", surname);

                root.push().setValue(userMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "saved", Toast.LENGTH_SHORT).show();
                    }
                });




            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ShowActivity.class));
                Toast.makeText(MainActivity.this, "showing", Toast.LENGTH_SHORT).show();
            }
        });

    }
}