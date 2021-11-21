package com.example.authorizationex;

import static com.example.authorizationex.Utile.addEditTextValueToMap;
import static com.example.authorizationex.Utile.get_SHA_512_SecurePassword;
import static com.example.authorizationex.Utile.writeData;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        ((Button) findViewById(R.id.reg_start_auth_btn)).setOnClickListener((View v)->{
            Intent intent = new Intent(this, AuthorizationActivity.class);
            startActivity(intent);
        });

        ((Button) findViewById(R.id.reg_start_profile_btn)).setOnClickListener((View v)->{
            Intent intent = new Intent(this, EnterInProfile.class);
            startActivity(intent);
        });

        ((Button) findViewById(R.id.register_btn)).setOnClickListener((View v)->{
            Intent intent = new Intent(this, EnterInProfile.class);

            HashMap<String, String> data = new HashMap<>();

            addEditTextValueToMap(this, data, "email");
            addEditTextValueToMap(this, data, "name");
            addEditTextValueToMap(this, data, "phone");


            String password = ((EditText) findViewById(R.id.password)).getText().toString();

            String hashPassword = get_SHA_512_SecurePassword(password, "randomSalt");

            data.put("password", hashPassword);

            intent.putExtra("data", data);

            writeData(this, data);

            startActivity(intent);
        });
    }
}
