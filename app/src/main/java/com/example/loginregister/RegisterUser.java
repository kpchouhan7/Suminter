package com.example.loginregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    EditText editFullname,editAge,editEmail,editPassword;
    Button registeruser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        mAuth = FirebaseAuth.getInstance();
        editFullname = findViewById(R.id.editFullName);
        editAge = findViewById(R.id.editAge);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        registeruser = findViewById(R.id.registeruser);

        registeruser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registeruser:
                registerUser();
                break;
        }

    }

    private void registerUser() {
        String email = editEmail.getText().toString().trim();
        String age  = editAge.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String fullname = editFullname.getText().toString().trim();
        if(fullname.isEmpty()){
            editFullname.setError("Full name required");
            editFullname.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editEmail.setError("Email required");
            editEmail.requestFocus();
            return;
        }
        if(age.isEmpty()){
            editAge.setError("Age required");
            editAge.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editEmail.setError("Invalid Email");
            editEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editPassword.setError("Password required");
            editPassword.requestFocus();
            return;
        }
        if(editPassword.length()<6){
            editPassword.setError("Password should have at least 6 character");
            editPassword.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User user = new User(fullname,age,email);
                    FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegisterUser.this, "User registered", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(RegisterUser.this, "Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
                else{
                    Toast.makeText(RegisterUser.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}