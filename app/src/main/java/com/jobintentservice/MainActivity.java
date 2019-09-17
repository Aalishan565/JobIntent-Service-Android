package com.jobintentservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etData;
    private TextView tvResult;
    private Button btnStart;
    private Button btnStop;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etData = findViewById(R.id.etData);
        tvResult = findViewById(R.id.tvResult);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                intent = new Intent(this, MyJobIntentService.class);
                intent.putExtra("data", etData.getText().toString());
                MyJobIntentService.enqueue(this, intent);
                break;
            case R.id.btnStop:
              //  stopService(intent);
                break;
        }
    }
}
