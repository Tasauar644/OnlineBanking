package com.example.bankingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

private Button button, signupbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.Login);
        signupbutton = (Button) findViewById(R.id.Signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

    }
    public void login()
    {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
    public void signup()
    {
        Intent intent2 = new Intent(this,SignupActivity.class);
        startActivity(intent2);
    }


}