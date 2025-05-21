package com.example.hw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileOutputStream;

public class InputActivity extends AppCompatActivity {

    EditText et_title;
    EditText et_author;
    EditText et_contents;
    Button bt_save;
    Button bt_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        et_title = findViewById(R.id.title);
        et_author = findViewById(R.id.author);
        et_contents = findViewById(R.id.contents);
        bt_save = findViewById(R.id.btn_save);
        bt_close = findViewById(R.id.btn_close);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = et_title.getText().toString();
                String data = "Author: " + et_author.getText().toString();
                data += "\nContents: " + et_contents.getText().toString();

                if (filename.isEmpty()) {
                    Toast.makeText(InputActivity.this, "Please enter Title", Toast.LENGTH_LONG).show();
                    return;
                }

                try {
                    FileOutputStream fout = openFileOutput(filename, MODE_PRIVATE);
                    fout.write(data.getBytes());
                    fout.close();
                    Toast.makeText(InputActivity.this, "Save Successfully", Toast.LENGTH_LONG).show();
                    finish();
                } catch (Exception e) {
                    Toast.makeText(InputActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InputActivity.this, MainAppActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}