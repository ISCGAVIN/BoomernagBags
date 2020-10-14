package com.example.boomerangbags;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity
{
    EditText myUserName, myPassword;
    Button myRegisterbtn;
    TextView myLoginbtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myUserName = findViewById(R.id.UserNameRegister);
        myPassword = findViewById(R.id.PasswordRegister);
        myRegisterbtn = findViewById(R.id.btnRegister);
        myLoginbtn = findViewById(R.id.linkLogin2);

        fAuth = FirebaseAuth.getInstance();

        /*
        if(fAuth.getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        */

        myRegisterbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String UserName = myUserName.getText().toString().trim();
                String Password = myPassword.getText().toString().trim();

                if(TextUtils.isEmpty(UserName))
                {
                    myUserName.setError("User Name is Required.");
                    return;
                }

                if(TextUtils.isEmpty(Password))
                {
                    myPassword.setError("Password is Required.");
                }

                if(Password.length() < 6)
                {
                    myPassword.setError("Password Must be > 6 Characters");
                }

                fAuth.createUserWithEmailAndPassword(UserName,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else{
                            Toast.makeText(Register.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT). show();
                        }
                    }
                });
            }
        });

        myLoginbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

    }
}