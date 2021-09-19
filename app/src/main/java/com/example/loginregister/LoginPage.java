package com.example.loginregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {
    TextView register,forgotpassword;
    EditText editemail,editpassword;
    private FirebaseAuth mAuth;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mAuth = FirebaseAuth.getInstance();
        register = findViewById(R.id.register);
        editemail = findViewById(R.id.editemail);
        editpassword = findViewById(R.id.editpassword);
        forgotpassword = findViewById(R.id.forgotpassword);
        forgotpassword.setOnClickListener(this);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                startActivity(new Intent(this,RegisterUser.class));
                break;
            case R.id.login:
                userLogin();
                break;
            case R.id.forgotpassword:
                startActivity(new Intent(this,ForgotPassword.class));
        }
    }

    private void userLogin() {
//        Toast.makeText(this, "Login clicked", Toast.LENGTH_SHORT).show();
        String email = editemail.getText().toString().trim();
        String password = editpassword.getText().toString().trim();
        if(email.isEmpty()){
            editemail.setError("Email required");
            editemail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editemail.setError("Invalid Email");
            editemail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editpassword.setError("Password is required");
            editpassword.requestFocus();
            return;
        }
        if(password.length()<6){
            editpassword.setError("Password should have at least 6 character");
            editpassword.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if(user.isEmailVerified()){
                        Toast.makeText(LoginPage.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),homeactivity.class);
                        startActivity(intent);
                    }
                    else{
                        user.sendEmailVerification();
                        Toast.makeText(LoginPage.this, "Check your email", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(LoginPage.this, "Invalid Credential", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}