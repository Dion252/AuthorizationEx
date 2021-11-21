package com.example.authorizationex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AuthorizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization_main);

        ((Button) findViewById(R.id.auth_start_reg_btn)).setOnClickListener((View v)->{
            Intent intent = new Intent(this, RegActivity.class);
            startActivity(intent);
        });

        ((Button) findViewById(R.id.auth_start_profile_btn)).setOnClickListener((View v)->{
            Intent intent = new Intent(this, EnterInProfile.class);
            startActivity(intent);
        });

    }
}
