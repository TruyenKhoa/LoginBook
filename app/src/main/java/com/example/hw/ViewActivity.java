package com.example.hw;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;

public class ViewActivity extends AppCompatActivity {

    int position = -1;
    ListView listView;
    Button btnClose, btnView;
    EditText contentView;
    String[] titleList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        listView = findViewById(R.id.listview_titles);
        btnClose = findViewById(R.id.btn_close);
        btnView = findViewById(R.id.btn_save); // This acts as "View" in your logic
        contentView = findViewById(R.id.view_contents); // This ID must be added in XML (see below)

        titleList = fileList();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                titleList
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                position = i;
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == -1) return; // nothing selected
                String filename = titleList[position];
                try {
                    FileInputStream fin = openFileInput(filename);
                    byte[] bytes = new byte[fin.available()];
                    fin.read(bytes);
                    fin.close();
                    contentView.setText(new String(bytes));
                } catch (Exception e) {
                    contentView.setText("Error reading file.");
                }
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewActivity.this, MainAppActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}