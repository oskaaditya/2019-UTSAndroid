package com.example.a2019_utsmobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a2019_utsmobile.R;

public class SaranActivity extends AppCompatActivity {

    private EditText nameInput;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saran);
        nameInput = findViewById(R.id.input_name);
        outputText = findViewById(R.id.text_output);
    }

    public void handleSubmit(View view) {
        String name = nameInput.getText().toString();
        outputText.setText("Terima Kasih Sarannya " + name);
    }

    public void handleKembali(View view) {
        startActivity(new Intent(SaranActivity.this,MainActivity.class));
        finish();
    }
}
