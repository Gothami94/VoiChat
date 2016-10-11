package com.example.wishwa.voichat;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

/**
 * Created by Wishwa on 03/10/2016.
 */

public class TextSpeech extends Activity implements TextToSpeech.OnInitListener {
    /** Called when the activity is first created. */

    private android.speech.tts.TextToSpeech tts;
    private Button btnSpeak;
    private EditText txtText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.texttospeech);

        tts = new android.speech.tts.TextToSpeech(this, this);

        btnSpeak = (Button) findViewById(R.id.button);

        txtText = (EditText) findViewById(R.id.editText);

        // button on click event
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                speakOut();
            }

        });
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == android.speech.tts.TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == android.speech.tts.TextToSpeech.LANG_MISSING_DATA
                    || result == android.speech.tts.TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                btnSpeak.setEnabled(true);
                tts.setSpeechRate(0);
                tts.setPitch(1);
                speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }

    private void speakOut() {

        String text = txtText.getText().toString();

        tts.speak(text, android.speech.tts.TextToSpeech.QUEUE_FLUSH, null);
    }
}
