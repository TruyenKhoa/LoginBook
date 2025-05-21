package com.example.hw;

import android.annotation.SuppressLint;
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

public class CreatAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_account);

        EditText et_newusername = (EditText) findViewById(R.id.new_username);
        EditText et_newpassword = (EditText) findViewById(R.id.new_password);
        EditText et_confirm_password = (EditText) findViewById(R.id.edit_new_confirm_password);
        Button bt_newregister = (Button) findViewById(R.id.btn_new_register);
        Button bt_cancel = (Button) findViewById(R.id.btn_cancel);

        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        bt_newregister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("myfile", 0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("username", et_newusername.getText().toString());
                editor.putString("password", et_newpassword.getText().toString());
                editor.apply();
                Intent intent = new Intent(CreatAccountActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    }
