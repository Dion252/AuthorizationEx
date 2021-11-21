package com.example.authorizationex;

import static com.example.authorizationex.Utile.getViewByStringId;
import static com.example.authorizationex.Utile.readData;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.HashMap;

public class EnterInProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_in_profile);

        ((Button) findViewById(R.id.profile_start_auth_btn)).setOnClickListener((View v)->{
            Intent intent = new Intent(this, AuthorizationActivity.class);
            startActivity(intent);
        });

        ((Button) findViewById(R.id.profile_start_reg_btn)).setOnClickListener((View v)->{
            Intent intent = new Intent(this, RegActivity.class);
            startActivity(intent);
        });

        Intent oldIntent = getIntent();

        HashMap<String, String> data = new HashMap<>();

        try{
            data = (HashMap<String, String>)oldIntent.getSerializableExtra("data");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] keys = new String[]{"email", "name", "phone"};

        if(data==null || data.size()==0){
            data = readData(this, keys);
        }


        for (String key : keys) {
            String value = data.get(key);

            TextView label = (TextView) getViewByStringId(this, key+"_lbl");

            label.setText(" "+value);

        }


    }
}
