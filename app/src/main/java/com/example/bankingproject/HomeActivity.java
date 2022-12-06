package com.example.bankingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

   private Button BalanceButton,DebitButton,CreditButton,CashoutButton,SendMoneyButton,HistoryButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BalanceButton= findViewById(R.id.balanceButton);
        DebitButton= findViewById(R.id.debitButton);
        CreditButton= findViewById(R.id.creditButton);
        CashoutButton= findViewById(R.id.CashoutButton);
        SendMoneyButton= findViewById(R.id.SendMoneyButton);
        HistoryButton= findViewById(R.id.HistoryButton);


        BalanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }




}