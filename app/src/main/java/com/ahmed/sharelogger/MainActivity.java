package com.ahmed.sharelogger;

import android.os.Bundle;

import com.ahmed.sharelogger.ui.home.HomeViewModel;
import com.ahmed.sharelogger.utils.ApplicationInstance;
import com.ahmed.sharelogger.utils.SettingsManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.ClipboardManager;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
//import androidx.widget.Toolbar;

//import android.content.Intent;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ListView;

import com.ahmed.sharelogger.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private BottomNavigationView navView;
    private final String PLAIN_TEXT_MIME = "text/plain";
    private final String MEDIA_IMAGE_MIME = "image/";
    private final String MEDIA_Audio_MIME = "audio/";
    private HomeViewModel homeViewModel;

    //clipboard service
    private ClipboardManager clipboardManager;
    private Switch buttonEnableService;
    private ListView listViewClipboardHistory;

    private ApplicationInstance applicationInstance;
//    public SettingsManager settingsManagerInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("MainActivity", "onCreate");
        applicationInstance = new ApplicationInstance(this);
//        settingsManagerInstance = SettingsManager.getInstance(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_notifications, R.id.navigation_dashboard)
                        .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // toolbar
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        //setupService();
    }

//    private void setupService(){
//        clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//
//        // service switch
//        buttonEnableService = (Switch) findViewById(R.id.buttonEnableService);
//        buttonEnableService.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                settingsManagerInstance.setClipboardMonitorServiceEnabled(isChecked);
//            }
//        });
//
//    }
}
