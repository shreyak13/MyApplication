package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText username,password;
    private Button login;
    Switch active;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.user);
        password=findViewById(R.id.pass);
        login=findViewById(R.id.btn);
        active=findViewById(R.id.active);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
              databaseReference.child("login").addValueEventListener(new ValueEventListener() {
                  @Override
                  public void onDataChange(@NonNull DataSnapshot snapshot) {
                      String input1=username.getText().toString();
                      String input2=password.getText().toString();

                      if(snapshot.child(input1).exists()){
                          if(snapshot.child(input2).exists()){
                              if(active.isChecked()){
                                  if(snapshot.child("as").equals("admin")){
                                      prefrence.setDataLogin(MainActivity.this,true);
                                      prefrence.setData_AS(MainActivity.this,"admin");

                                  }else{
                                      prefrence.setDataLogin(MainActivity.this,true);
                                      prefrence.setData_AS(MainActivity.this,"user");
                                  }
                              }
                              else{
                                  if(snapshot.child("as").equals("admin")){
                                      prefrence.setDataLogin(MainActivity.this,false);


                                  }else{
                                      prefrence.setDataLogin(MainActivity.this,false);
                                  }

                              }


                          }
                          else{
                              Toast.makeText(MainActivity.this, "Data not found", Toast.LENGTH_SHORT).show();

                          }
                      }


                      else{
                          Toast.makeText(MainActivity.this, "Data not found", Toast.LENGTH_SHORT).show();
                      }
                  }

                  @Override
                  public void onCancelled(@NonNull DatabaseError error) {


                  }
              });


    }
});}}