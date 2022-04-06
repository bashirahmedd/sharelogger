package com.ahmed.sharelogger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.ahmed.sharelogger.utils.ApplicationInstance;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private ApplicationInstance applicationInstance;

    private  Button btn_start_service;
    private Button btn_stop_service;
    private Switch swt_yt_urls;
    private TextView tx_current_share;
    private EditText ed_current_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_start_service = (Button) findViewById(R.id.btn_start_service);
        btn_start_service.setOnClickListener(this);

        btn_stop_service = (Button) findViewById(R.id.btn_stop_service);
        btn_stop_service.setOnClickListener(this);

        swt_yt_urls = (Switch) findViewById(R.id.swt_yt_urls);
        swt_yt_urls.setOnCheckedChangeListener(this);

        tx_current_share = (TextView) findViewById(R.id.tx_current_share);
        ed_current_share = (EditText) findViewById(R.id.ed_current_share);

        Log.i("MainActivity", "onCreate");
        applicationInstance = new ApplicationInstance(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.btn_start_service: {
                Log.d("ButtonClick", "btn_start_service");
                break;
            }
            case R.id.btn_stop_service: {
                Log.d("ButtonClick", "btn_stop_service");
                break;
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch(compoundButton.getId()){
            case R.id.swt_yt_urls:{
                if (isChecked) {
                    // The switch enabled
                    ed_current_share.setText( "Switch on");
                } else {
                    // The switch disabled
                    ed_current_share.setText( "Switch off");
                }
                break;
            }
        }
    }
}