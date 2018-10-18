package com.example.gg.speeechproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    RadioButton rbTTS, rbSTT;
    Button btnStart;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbTTS = (RadioButton)findViewById(R.id.rbTTS);
        rbSTT= (RadioButton)findViewById(R.id.rbSTT);
        btnStart = (Button)findViewById(R.id.btnStart);
        spinner = (Spinner)findViewById(R.id.spinner);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedItem = spinner.getSelectedItem().toString();

                if(rbTTS.isChecked()){
                    Intent intent = new Intent(MainActivity.this, TextToSpeechActivity.class);
                    intent.putExtra("api_name", selectedItem);
                    startActivity(intent);
                }
                else if(rbSTT.isChecked()){
                    Intent intent = new Intent(MainActivity.this, SpeechToTextActivity.class);
                    intent.putExtra("api_name",selectedItem);
                    startActivity(intent);
                }
            }
        });
    }
}
