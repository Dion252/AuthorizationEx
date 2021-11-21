package com.example.authorizationex;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Utile {
    public static void addEditTextValueToMap(AppCompatActivity activity, HashMap<String, String> map, String idStr){
        EditText textView = (EditText) getViewByStringId(activity, idStr);

        String text = textView.getText().toString();

        map.put(idStr, text);
    }

    public static View getViewByStringId(AppCompatActivity activity, String idStr){
        int id = activity.getResources().getIdentifier(idStr, "id", activity.getPackageName());

        return activity.findViewById(id);
    }

    public static String get_SHA_512_SecurePassword(String passwordToHash, String salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static void writeData(AppCompatActivity activity, HashMap<String, String> data){
        SharedPreferences sPref = activity.getSharedPreferences("DATA", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();

        for (Map.Entry<String, String> entry : data.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            ed.putString(key, value);
        }

        ed.apply();
    }

    public static HashMap<String, String> readData(AppCompatActivity activity, String[] keys){
        HashMap<String, String> data = new HashMap<>();
        SharedPreferences sPref = activity.getSharedPreferences("DATA", MODE_PRIVATE);
        for(String key: keys) {
            data.put(key, sPref.getString(key, ""));
        }
        return data;
    }

}
