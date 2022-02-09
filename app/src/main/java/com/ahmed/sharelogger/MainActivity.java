package com.ahmed.sharelogger;

import android.os.Bundle;

import com.ahmed.sharelogger.ui.home.HomeViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.util.Log;

import com.ahmed.sharelogger.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private BottomNavigationView navView;
    private final String PLAIN_TEXT_MIME = "text/plain";
    private final String MEDIA_IMAGE_MIME = "image/";
    private final String MEDIA_Audio_MIME = "audio/";
    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("MainActivity", "onCreate");

        if (navView == null) {
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            navView = findViewById(R.id.nav_view);
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                    .build();
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            NavigationUI.setupWithNavController(binding.navView, navController);
        }

        Intent intent = getIntent();
        String action = getIntent().getAction();
        String type = getIntent().getType();

        if (action != null) {
            switch (action) {
                case Intent.ACTION_SEND: {
                    Log.i("MainActivity", action);
                    switch (type){
                        case PLAIN_TEXT_MIME:{
                            handleSendText(intent);
                            break;
                        }
                        default:{
                            Log.i("MainActivity",type);
                        }
                    }
                    break;
                }
                case Intent.ACTION_SEND_MULTIPLE: {
                    Log.i("MainActivity", action);
                    break;
                }
                default: {
                    Log.i("MainActivity", action);
                }
            }
        }

//        when {
//            intent?.action == Intent.ACTION_SEND -> {
//                when {
//                    intent.type == PLAIN_TEXT_MIME -> handleSendText(intent)
//                    intent.type?.startsWith(MEDIA_IMAGE_MIME) == true -> handleSendImage(intent)
//                    intent.type?.startsWith(MEDIA_Audio_MIME) == true -> handleSendAudio(intent)
//                }
//            }
//
//            intent?.action == Intent.ACTION_SEND_MULTIPLE -> {
//                when {
//                    intent.type?.startsWith(MEDIA_IMAGE_MIME) == true -> handleSendMultipleImages(intent)
//                    intent.type?.startsWith(MEDIA_Audio_MIME) == true -> handleSendMultipleAudios(intent)
//                }
//
//            }
//        }

    }

    private void handleSendText(Intent intent) {
        Log.i("MainActivity","bashir: " + intent.getAction());
        String it = intent.getStringExtra(Intent.EXTRA_TEXT);
        //homeViewModel.setmText(it);
    }


//    private fun handleSendText(intent:Intent) {
//        println("bashir: " + intent.action)
//        intent.getStringExtra(Intent.EXTRA_TEXT) ?.let {
//            textView.text = it
//        }
//    }

//    private fun handleSendImage(intent: Intent) {
//        (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let {
//            first_imageView.setImageURI(it)
//        }
//    }
//
//    @SuppressLint("SetTextI18n")
//    private fun handleSendAudio(intent: Intent) {
//        (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let {
//            textView.text = "Playing Audio"
//
//            MediaPlayer().apply {
//                setDataSource(applicationContext, it)
//                prepare()
//                start()
//            }
//        }
//    }
//
//    private fun handleSendMultipleImages(intent: Intent) {
//        intent.getParcelableArrayListExtra<Parcelable>(Intent.EXTRA_STREAM)?.let {
//            first_imageView.setImageURI(it[0] as? Uri)
//            second_imageView.setImageURI(it[1] as? Uri)
//        }
//    }
//
//    @SuppressLint("SetTextI18n")
//    private fun handleSendMultipleAudios(intent: Intent) {
//        intent.getParcelableArrayListExtra<Parcelable>(Intent.EXTRA_STREAM)?.let {
//            textView.text = "Playing Multiple Audios"
//
//            it.forEachIndexed { index, _ ->
//                    MediaPlayer().apply {
//                setDataSource(applicationContext, it[index] as Uri)
//                prepare()
//                start()
//            }
//            }
//        }
//    }

//    companion object {
//        private const val PLAIN_TEXT_MIME = "text/plain"
//        private const val MEDIA_IMAGE_MIME = "image/"
//        private const val MEDIA_Audio_MIME = "audio/"
//    }

}