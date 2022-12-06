package com.example.bankingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class LoginActivity extends AppCompatActivity {

    EditText textInputEditTextPhone_number, textInputEditTextpinnumber;
    Button logbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditTextPhone_number = findViewById(R.id.phone);
        textInputEditTextpinnumber = findViewById(R.id.pinno);
        logbutton = findViewById(R.id.loginbutton);

        logbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone_number,pin;
                phone_number = String.valueOf(textInputEditTextPhone_number.getText());

                pin = String.valueOf(textInputEditTextpinnumber.getText());

                if (!phone_number.equals("") && !pin.equals("")) {
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler;
                    handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];

                            field[0] = "phone_number";
                            field[1] = "pin";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = phone_number;
                            data[1] = pin;

                            PutData putData;
                            putData = new PutData("http://192.168.1.105/bank/index.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Login Success"))
                                    {
                                     Intent intent= new Intent(LoginActivity.this,HomeActivity.class);
                                     startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                       /* Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                                        startActivity(intent);
                                        finish();*/

                                    }

                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"All field required",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}