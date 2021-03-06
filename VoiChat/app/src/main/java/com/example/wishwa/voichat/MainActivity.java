package com.example.wishwa.voichat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void textToSpeech(View view){
        Intent k = new Intent(MainActivity.this,TextSpeech.class);
        startActivity(k);
    }

    public void speechToText(View view){
        Intent i = new Intent(MainActivity.this,SpeechToText.class);
        startActivity(i);
    }
}
