package com.ahmed.sharelogger;

//import android.support.v4.content.LocalBroadcastManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
import android.os.Bundle;

import com.ahmed.sharelogger.R;
import com.ahmed.sharelogger.utils.Constants;
import com.ahmed.sharelogger.utils.SettingsManager;

public abstract class AbstractActivity extends AppCompatActivity {

    public SettingsManager settingsManagerInstance;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingsManagerInstance = SettingsManager.getInstance(this);
    }



    /**
     * toolbar
     */

//    @Override public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_activity, menu);
//        return true;
//    }
//
//    @Override public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menuItemInfo:
//                Intent intentStartInfoActivity = new Intent(AbstractActivity.this, InfoActivity.class);
//                startActivity(intentStartInfoActivity);
//                break;
//            default:
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }


    /**
     * pause and resume
     */

    @Override public void onPause() {
        super.onPause();
        // unregister broadcast receiver
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
    }

    @Override public void onResume() {
        super.onResume();
        // register broadcast receiver to listen to messages from dtPlayer
        LocalBroadcastManager.getInstance(this).registerReceiver(
                mMessageReceiver, new IntentFilter(Constants.CustomAction.RELOAD_UI));
    }


    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override public void onReceive(Context context, Intent intent) {
            if (Constants.CustomAction.RELOAD_UI.equals(intent.getAction())) {
                onPause();
                onResume();
            }
        }
    };

}
