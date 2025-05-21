package com.example.hw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    Button bt_login;
    Button bt_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.edit_username);
        et_password = findViewById(R.id.edit_password);
        bt_login = findViewById(R.id.btn_login);
        bt_create = findViewById(R.id.btn_register);

        bt_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("myfile", 0);
                String name = pref.getString("username", "null");
                String pass = pref.getString("password", "null");

                if (name.equals(et_username.getText().toString()) && pass.equals(et_password.getText().toString())) {
                    Intent intent = new Intent(MainActivity.this, MainAppActivity.class);
                    startActivity(intent);
                }
            }
        });
        bt_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreatAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}