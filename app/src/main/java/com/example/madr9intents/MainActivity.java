package com.example.madr9intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etFname, etSname;
    Button btnSubmit, btnGetPhone;
    TextView tvPhoneNumber;

    final int OPEN_PHONE_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this, "OnCreate()", Toast.LENGTH_SHORT).show();

        init();

        tvPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+tvPhoneNumber.getText().toString().trim()));
                startActivity(i);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = etFname.getText().toString().trim();
                String sname = etSname.getText().toString().trim();

                if(!fname.isEmpty() && !sname.isEmpty())
                {
                    Intent i = new Intent(MainActivity.this, WelcomeActivity.class);
                    i.putExtra("firstname", fname);
                    i.putExtra("lastname", sname);

                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Fields cant be empty", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnGetPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PhoneActivity.class);
                startActivityForResult(i, OPEN_PHONE_ACTIVITY);
            }
        });
    }

    private void init()
    {
        etFname = findViewById(R.id.etFname);
        etSname = findViewById(R.id.etSname);
        btnGetPhone = findViewById(R.id.btnGetPhone);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvPhoneNumber = findViewById(R.id.tvPhoneNumber);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == OPEN_PHONE_ACTIVITY)
        {
            if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this, "Give Phone Number", Toast.LENGTH_SHORT).show();
            }
            else
            {
                String ph = data.getStringExtra("phone");
                tvPhoneNumber.setText(ph);
            }
        }
    }
}