package com.example.madr9intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView tvShowMessage;
    Button btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tvShowMessage = findViewById(R.id.tvShowMessage);
        btnGoBack = findViewById(R.id.btnGoBack);

        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        });

        Intent i = getIntent();
        String fname = i.getStringExtra("firstname");
        String sname = i.getStringExtra("lastname");
        String text = "Welcome "+fname+" "+sname;
        tvShowMessage.setText(text);


    }
}