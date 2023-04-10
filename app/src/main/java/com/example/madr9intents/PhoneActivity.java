package com.example.madr9intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhoneActivity extends AppCompatActivity {

    EditText etPhone;
    Button btnCancel, btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        init();



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = etPhone.getText().toString().trim();
                if(!phone.isEmpty())
                {
                    Intent i = new Intent();
                    i.putExtra("phone", phone);
                    setResult(RESULT_OK, i);
                    finish();
                }

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    private void init()
    {
        etPhone = findViewById(R.id.etPhone);
        btnCancel = findViewById(R.id.btnCancel);
        btnSubmit = findViewById(R.id.btnSubmit);
    }
}