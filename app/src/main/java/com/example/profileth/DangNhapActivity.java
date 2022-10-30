package com.example.profileth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class DangNhapActivity extends AppCompatActivity {
            FirebaseAuth fAuth;

            Button dangnhap;
            TextView dangky;
            EditText Email,Password ;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.dangnhap);
                fAuth =FirebaseAuth.getInstance();

                dangnhap = (Button) findViewById(R.id.dangnhap);
                dangky =(TextView) findViewById(R.id.dangky);
                Email =(EditText) findViewById(R.id.Email);
                Password = (EditText) findViewById(R.id.password);
                if(fAuth.getCurrentUser()!=null){
                    startActivity(new Intent(getApplicationContext(),DangNhapActivity.class));
                    finish();
                }
                dangnhap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String email = Email.getText().toString().trim();
                        String password = Password.getText().toString().trim();
                        Intent i = new Intent(DangNhapActivity.this,Profile2Activity.class);
                        if(Email.getText().toString().equals("") || Password.getText().toString().equals("")){
                            Toast.makeText(DangNhapActivity.this, "Không được để trống!!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        if (Email.getText().toString().equals("voanhtu.cr7@gmail.com") && Password.getText().toString().equals("Bi12345678")){
                            Toast.makeText(DangNhapActivity.this, "Đăng nhập thành công!!", Toast.LENGTH_SHORT).show();
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(DangNhapActivity.this, "Thông tin đăng nhập sai!!", Toast.LENGTH_SHORT).show();
                        }
                        fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                             if(task.isSuccessful()){
                                 Toast.makeText(DangNhapActivity.this, "Đăng nhập thành công!!", Toast.LENGTH_SHORT).show();
                                 startActivity(i);
                             }else{
                                 Toast.makeText(DangNhapActivity.this, "Thông tin đăng nhập sai!!", Toast.LENGTH_SHORT).show();
                             }
                            }
                        });

                    }
                });
                dangky.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent in = new Intent(DangNhapActivity.this, DangkyActivity.class);

                        startActivity(in);
                    }
                });
            }
        };

