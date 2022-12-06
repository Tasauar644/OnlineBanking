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

public class SignupActivity extends AppCompatActivity {

      EditText textInputEditTextname, textInputEditTextPhone_number, textInputEditTextnid, textInputEditTextpinnumber;
      Button signbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        textInputEditTextname = findViewById(R.id.name);
        textInputEditTextPhone_number= findViewById(R.id.Phone_number);
        textInputEditTextnid= findViewById(R.id.nid);
        textInputEditTextpinnumber = findViewById(R.id.pinnumber);

        signbutton = findViewById(R.id.signin);

        signbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name,phone_number,nid,pin;
                name = String.valueOf(textInputEditTextname.getText());
                phone_number = String.valueOf(textInputEditTextPhone_number.getText());
                nid = String.valueOf(textInputEditTextnid.getText());
                pin = String.valueOf(textInputEditTextpinnumber.getText());

               if (!name.equals("") && !phone_number.equals("") && !nid.equals("") && !pin.equals("")) {
                   //Start ProgressBar first (Set visibility VISIBLE)
                   Handler handler;
                   handler = new Handler(Looper.getMainLooper());
                   handler.post(new Runnable() {
                       @Override
                       public void run() {
                           //Starting Write and Read data with URL
                           //Creating array for parameters
                           String[] field = new String[4];
                           field[0] = "name";
                           field[1] = "phone_number";
                           field[2] = "pin";
                           field[3] = "nid";
                           //Creating array for data
                           String[] data = new String[4];
                           data[0] = name;
                           data[1] = phone_number;
                           data[2] = pin;
                           data[3] = nid;
                           PutData putData;
                           putData = new PutData("http://192.168.1.105/bank/signup.php", "POST", field, data);
                           if (putData.startPut()) {
                               if (putData.onComplete()) {
                                   String result = putData.getResult();
                                if (result.equals("Sign Up Success"))
                                {
                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();

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