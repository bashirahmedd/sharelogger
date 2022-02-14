package com.ahmed.sharelogger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ahmed.sharelogger.utils.ApplicationInstance;

public class MainActivity2 extends AppCompatActivity {

    private ApplicationInstance applicationInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        final TextView urlTextView = (TextView) findViewById(R.id.text_url);
//        urlTextView.setText(R.string.initial_url_text);

        Log.i("MainActivity", "onCreate");
        applicationInstance = new ApplicationInstance(this);

    }
}