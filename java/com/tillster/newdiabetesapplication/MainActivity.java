package com.tillster.newdiabetesapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button BtnLogin, BtnSignUp;
    EditText et_Email, et_Password;

    String email, password;

    FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Auth = FirebaseAuth.getInstance();

        BtnLogin = findViewById(R.id.BtnLogin);
        BtnSignUp = findViewById(R.id.BtnSignUp);

        et_Email= findViewById(R.id.et_Email);
        et_Password = findViewById(R.id.et_Password);


        BtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = et_Email.getText().toString();
                password = et_Password.getText().toString();
                //Only allows to connect to firebase once
                Auth = FirebaseAuth.getInstance();


                if(!email.isEmpty() && !password.isEmpty()){

                    Auth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if(task.isSuccessful()){
                                        //Message
                                        Toast.makeText(MainActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                    else{

                                        Toast.makeText(MainActivity.this, "Woops", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });


        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                et_Email= findViewById(R.id.et_Email);
                et_Password = findViewById(R.id.et_Password);


                 email = et_Email.getText().toString();
                 password = et_Password.getText().toString();


                Auth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){
                                    //Message
                                    Toast.makeText(MainActivity.this, "Welcome" + Auth.getCurrentUser().getEmail(),
                                            Toast.LENGTH_SHORT).show();

                                    Intent newIntent = new Intent(MainActivity.this,Order.class);
                                    startActivity(newIntent);
                                }
                                else{

                                    Toast.makeText(MainActivity.this, "Computer says NO", Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });



    }
}