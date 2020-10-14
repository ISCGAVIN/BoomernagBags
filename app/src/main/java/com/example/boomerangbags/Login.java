package com.example.boomerangbags;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

public class Login extends AppCompatActivity
{
    EditText myUserName, myPassword;
    Button myLoginBtn;
    TextView myCreateBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myUserName = findViewById(R.id.userNameLogin);
        myPassword = findViewById(R.id.passwordLogin);
        fAuth = FirebaseAuth.getInstance();
        myLoginBtn = findViewById(R.id.btnLogin);
        myCreateBtn = findViewById(R.id.linkLogin2);

        myCreateBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        myLoginBtn.setOnClickListener(new View.OnClickListener()
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

                fAuth.signInWithEmailAndPassword(UserName, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else{
                            Toast.makeText(Login.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT). show();
                        }
                    }
                });
            }
        });
    }
}